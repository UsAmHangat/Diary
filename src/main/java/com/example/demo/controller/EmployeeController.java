package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private EntryServiceImpl entryServiceImpl;

    @GetMapping("/employee/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", employeeServiceImpl.getAllEmployee());
        return "index";
    }

    @GetMapping("/employee/addnew")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeServiceImpl.save(employee);
        return "redirect:/employee/";
    }

    @GetMapping("/employee/updateEmployee/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeServiceImpl.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/employee/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        employeeServiceImpl.deleteViaId(id);
        return "redirect:/employee/";

    }
    @GetMapping("/employee/showEmployee/{id}")
    public String showEmployee(Model model, @PathVariable(value = "id") long id) {
        Employee employee = employeeServiceImpl.getById(id);
        model.addAttribute("employee", employee);
        return "employeeIndex";
    }
}
