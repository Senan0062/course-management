package org.example.course.core.service;

import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Slf4j
public class JpaAuditingListener {

    @PostPersist
    public void onPostPersist(Object entity) {
        log.info("New entity persisted: {} with ID: {}",
                entity.getClass().getSimpleName(),
                getEntityId(entity));
    }

    @PostUpdate
    public void onPostUpdate(Object entity) {
        log.info("Entity updated: {} with ID: {}",
                entity.getClass().getSimpleName(),
                getEntityId(entity));
    }

    @PostRemove
    public void onPostRemove(Object entity) {
        log.info("Entity deleted: {} with ID: {}",
                entity.getClass().getSimpleName(),
                getEntityId(entity));
    }

    private String getEntityId(Object entity) {
        try {
            for (Field field : entity.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    return String.valueOf(field.get(entity));
                }
            }
        } catch (Exception e) {
            log.error("Error getting entity ID", e);
        }
        return "unknown";
    }
}
