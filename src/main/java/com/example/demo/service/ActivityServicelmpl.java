package com.example.demo.service;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServicelmpl implements ActivityServices {
    @Autowired private ActivityRepository actRep;

    @Override
    public List<Activity> getAllActivities(){return actRep.findAll();}

    @Override
    public void save(Activity activity) {
        actRep.save(activity);
    }

    @Override
    public Activity getById(Long id) {
        Optional<Activity> optional = actRep.findById(id);
        Activity activity = null;
        if (optional.isPresent()){
            activity = optional.get();
        }else{
            throw new RuntimeException("Activity not found for id : " + id);
        }
        return activity;
    }

    @Override
    public void deleteViaId(long id) {
        actRep.deleteById(id);
    }

}
