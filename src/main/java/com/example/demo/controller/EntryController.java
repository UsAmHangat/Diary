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


    @GetMapping("/sandbox")
    public String getSandbox(Model model){
        return "sandbox";
    }
    @GetMapping("/sandbox/create")
    public String createSandbox(Model model) {
        return "create";
    }

    @GetMapping("/entry/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", entryServiceImpl.getAllEntrys());
        return "redirect:entry/entryIndex";
    }

    @GetMapping("/entry/create")
    public String createEntry(Model model, @RequestParam String employeeId) {
        System.out.println("createEntry for: " + employeeId);
        return "redirect:/";
    }
}
