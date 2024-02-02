package com.dmadev.spring.listener.entity;

import lombok.Getter;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.EventObject;

@Component
public class EntityListener {

    @EventListener(condition = "#p0.accessType.name() == 'READ'")
    @Order(10)
    public void acceptEntityRead(EntityEvent entityEvent) {
        System.out.println("Entity: " + entityEvent);
    }
}