package com.drinkio.drinkio.core;


import lombok.SneakyThrows;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Preconditions {

    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkArgument(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNotNull(Object obj, String errorMessage) {
        if (obj == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }


    public static <T extends Exception> void checkArgument(boolean expression, Class<T> exClass) throws T {
        checkArgument(expression, exClass, null);
    }

    public static <T extends Exception> void checkArgument(boolean expression, Class<T> exClass, String errorMessage, Object... args) throws T {
        if (!expression) {
            generateException(exClass, errorMessage, args);
        }
    }

    public static <T extends Exception> void checkNotNull(Object reference, Class<T> exClass) throws T {
        checkNotNull(reference, exClass, null);
    }

    public static <T extends Exception> void checkNotNull(Object reference, Class<T> exClass, String errorMessage, Object... args) throws T {
        if (reference == null) {
            generateException(exClass, errorMessage, args);
        }
    }

    private static <T extends Exception> void generateException(Class<T> exClass, String errorMessage, Object... args) throws T {
        try {
            if (errorMessage == null) {
                throw exClass.getDeclaredConstructor().newInstance();
            } else {
                throw exClass.getDeclaredConstructor(String.class, Object[].class).newInstance(errorMessage, args);
            }
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void checkObjectFields(@NotNull Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            Object value = f.get(obj);
            if (value == null) {
                throw new IllegalArgumentException("Object fields cannot be null.");
            }
        }
    }
}

