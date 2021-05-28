package com.example.service;

import java.util.concurrent.TimeUnit;

public interface UserManagement {

    void set(String key, Object value);

    void set(String key, Object value, Long time, TimeUnit t);

    Object get(String key);

}
