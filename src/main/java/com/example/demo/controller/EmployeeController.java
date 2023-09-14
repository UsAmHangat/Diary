package com.example.demo.controller;

import com.example.demo.SecurityConfig;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Date;

@Controller
public class EmployeeController {
    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", employeeRepository.findAll());
        return "redirect:/login";
    }

    @GetMapping("/")
    public String getHomepage(){
        return "redirect:/login";
    }



    @GetMapping("/registration")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/newemployee";
    }

    @PostMapping("/registration")
    public String registerEmployee(@ModelAttribute("employee") Employee employee) {
        employee.setPassword(securityConfig.passwordEncoder().encode(employee.getPassword()));
        employeeRepository.save(employee);
        return "redirect:/login";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/login";
    }

    @GetMapping("/employee/showEmployee")
    public String showEmployee(Model model, Principal principal) {
        System.out.println("WAAAG: "+principal.getName());
        Employee employee = employeeRepository.findByEmail(principal.getName());
        model.addAttribute("employee", employee);
        return "employee/employeeIndex";
    }

    @GetMapping("/employee/showEmployee/{id}")
    public String showEmployee(Model model, @PathVariable(value = "id") long id) {
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("employee", employee);
        return "employee/employeeIndex";
    }

    @GetMapping("/employee/updateEmployee/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("employee", employee);
        return "employee/employeeUpdate";
    }

    @GetMapping("/employee/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        employeeRepository.deleteById(id);
        return "redirect:/login";

    }
}
