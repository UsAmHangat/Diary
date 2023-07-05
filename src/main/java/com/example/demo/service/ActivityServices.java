package com.example.demo.service;

import com.example.demo.model.Activity;

import java.util.List;

public interface ActivityServices {
    List<Activity> getAllActivities();
    void save(Activity activity);
    Activity getById(Long id);
    void deleteViaId(long id);
}
