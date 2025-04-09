package org.example.demo.util;

import org.example.demo.config.SimpleJwtFilter;
import org.example.demo.controller.PaymentCodeController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class JaxRsConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(SimpleJwtFilter.class);
        classes.add(PaymentCodeController.class);
        return classes;
    }}
