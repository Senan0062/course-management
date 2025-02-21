package org.example.course.erp.teachers.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/erp/teachers")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class TeacherController {

}
