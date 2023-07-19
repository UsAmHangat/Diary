package com.example.demo.controller;

import com.example.demo.model.Activity;
import com.example.demo.model.Employee;
import com.example.demo.model.Entry;
import com.example.demo.service.ActivityServiceImpl;
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

    @Autowired
    private ActivityServiceImpl activityServiceImpl;

    // URL and what they are doing
    @GetMapping("/employee/{employeeId}/entrys/")
    public String getEntry(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("allEntryList", entryServiceImpl.getAllEntrys());
        return "entrys";
    }

    @PostMapping("/employee/{employeeId}/entrys/createEntry/")
    public String createEntry(@ModelAttribute Employee employee) {
        Entry entry = new Entry();
        entryServiceImpl.save(entry);
        return "redirect:/entry/entryEdit/" + entry.getId();
    }

    @GetMapping("/entry/entryEdit/{entryId}")
    public String editEntry(@PathVariable(value = "entryId") long id,Model model) {
       Entry entry = entryServiceImpl.getById(id);
       model.addAttribute("entry", entry);
        return "entrys";
    }

    @PostMapping("/entry/save")
    public String saveEntry(@ModelAttribute("entry") Entry entry) {
        entryServiceImpl.save(entry);
        return "redirect:/entry/entryEdit/" + entry.getId();
    }


/*
    @GetMapping("/entry/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", entryServiceImpl.getAllEntrys());
        return "redirect:entry/entryIndex";
  */
/*
    @GetMapping("/employee/{employeeId}/entrys/{entryId}}/createActivity")
    public String addActivity(@RequestParam Long employeeId,
                              @RequestParam Long entryId,
                              @ModelAttribute("activity") Activity activity) {
        Entry entry = entryServiceImpl.getById(entryId);
        // Add activity to entry
        // save entry, save activity
        return "/saveActivity";
    }
    */
    /*
    @PostMapping("/saveActivity")
    public String saveActivity(@ModelAttribute("activity") Activity activity){
        activityServiceImpl.save(activity);
        return "redirect:/employee/{employeeId}/entrys/createEntry";
    }
    */
    //  Failed to convert value of type 'java.lang.String' to required type 'long'; For input string: "{employeeId}"

}
