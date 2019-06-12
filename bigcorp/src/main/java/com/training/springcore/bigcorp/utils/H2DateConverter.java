package com.training.springcore.bigcorp.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

    @Component
    public class H2DateConverter implements Converter<String,Instant> {

        private static SimpleDateFormat H2_INSTANT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX");

        @Override
        public Instant convert(String source) {
            try {
                return H2_INSTANT_FORMAT.parse(source).toInstant();
            } catch (ParseException e) {
                return null;
            }
        }

        @Override
        public JavaType getInputType(TypeFactory typeFactory) {
            return null;
        }

        @Override
        public JavaType getOutputType(TypeFactory typeFactory) {
            return null;
        }

    }


