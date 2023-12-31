package com.example.demo.controller;

import com.example.demo.model.Activity;
import com.example.demo.model.Employee;
import com.example.demo.model.Entry;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EntryRepository;
import com.example.demo.service.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EntryController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityServiceImpl activityServiceImpl;

    // URL and what they are doing
    @GetMapping("/employee/{employeeId}/entrys/")
    public String getEntry(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("allEntryList", entryRepository.findByEmployee(employee));
        return "entrys";
    }

    @PostMapping("/employee/{employeeId}/entrys/createEntry/")
    public String createEntry(@PathVariable(value = "employeeId") long id) {
        Employee employee = employeeRepository.findById(id).get();

        Entry entry = new Entry();
        entry.setEmployee(employee);
        entryRepository.save(entry);
        return "redirect:/employee/{employeeId}/entry/entryEdit/" + entry.getId();
    }

    @GetMapping("/employee/{employeeId}/entry/entryEdit/{entryId}")
    public String editEntry(@PathVariable(value = "entryId") long entryId,@PathVariable(value = "employeeId") long employeeId, Model model) {
        Entry entry = entryRepository.findById(entryId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        List<Activity> activities = activityRepository.findByEntryId(entryId);
        String tmp = "";
        for(Activity activity : activities) {
            tmp += activity.getName()+";";
        }
        model.addAttribute("entry", entry);
        model.addAttribute("employee",employee);
        model.addAttribute("activities", tmp);
        return "entrys";
    }

    @PostMapping("/employee/{employeeId}/entry/entryEdit/{entryId}/save")
    public String saveEntry(@PathVariable(value = "entryId") long entryId,@PathVariable(value = "employeeId") long employeeId, @ModelAttribute("entry") Entry entry, @ModelAttribute("activitiesHolder") String activitiesHolder) {
        entry.setId(entryId);
        entry.setEmployee(employeeRepository.findById(employeeId).get());
        entryRepository.save(entry);
        activityRepository.removeByEntry(entry);
        for(String activityName : activitiesHolder.split(";")) {
            if(!activityName.isEmpty()) {
                Activity newActivity = new Activity();
                newActivity.setEntry(entry);
                newActivity.setName(activityName);
                activityRepository.save(newActivity);
            }
        }
        return "redirect:/employee/showEmployee/" + entry.getEmployee().getId();
    }
    @GetMapping("/employee/{employeeId}/entry/{entryId}/deleteEntry/")
    public String deleteEntry(@PathVariable(value = "employeeId") long employeeId,@PathVariable(value = "entryId") long entryId){
        entryRepository.deleteById(entryId);
        return "redirect:/employee/showEmployee/" + employeeId;
    }
}
