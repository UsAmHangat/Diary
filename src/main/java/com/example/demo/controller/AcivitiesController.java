package com.example.demo.controller;

import com.example.demo.service.ActivityServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AcivitiesController {

    @Autowired private ActivityServicelmpl acitvitiyServicelmpl;


}
