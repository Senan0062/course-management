package org.example.course.utility.exception;

import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDatabaseException(DataAccessException ex) {
        logger.error("Database error: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Database error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSQLException(SQLException ex) {
        logger.error("SQL Exception: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("SQL error: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Bad Request");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.UNAUTHORIZED.value());
        errorDetails.put("error", "Unauthorized");
        errorDetails.put("message", "Invalid username or password");
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.FORBIDDEN.value());
        errorDetails.put("error", "Forbidden");
        errorDetails.put("message", "You don't have permission to access this resource");
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ConfigDataResourceNotFoundException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
        errorDetails.put("error", "Not Found");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.put("error", "Internal Server Error");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.NOT_FOUND.value()); // 404 Not Found
        errorDetails.put("error", "Not Found");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
//        Map<String, Object> errorDetails = new HashMap<>();
//        errorDetails.put("timestamp", new Date());
//        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
//        errorDetails.put("error", "Bad Request");
//        errorDetails.put("message", ex.getBindingResult().getFieldError().getDefaultMessage());
//        errorDetails.put("path", request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Bad Request");

        StringBuilder errorMessage = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
        });

        errorDetails.put("message", errorMessage.toString()); // Bütün xəta mesajlarını birləşdiririk
        errorDetails.put("path", request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
