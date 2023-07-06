package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Entry;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EntryController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private EntryServiceImpl entryServiceImpl;


}
