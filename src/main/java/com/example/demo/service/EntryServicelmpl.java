package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Entry;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServicelmpl implements EntryService {

    @Autowired
    private EntryRepository entRepo;

    @Autowired
    private EmployeeRepository empRepo;


    @Override
    public List<Entry> getAllEntry(List<Entry> entryList) {
        return entRepo.findAll();
    }


    @Override
    public void save(Entry entry) {
        entRepo.save(entry);
    }

    @Override
    public Entry getbyId(Long id) {
        Optional<Entry> optional = entRepo.findById(id);
        Entry entry = null;
        if (optional.isPresent()) {
            entry = optional.get();
        } else {
            throw new RuntimeException("Entry not found for id : " + id);
        }
        return entry;
    }

    @Override
    public Employee getbyEmployeeId(Long employeeId) {
        {
            Optional<Employee> optional = empRepo.findById(employeeId);
            Employee employee = null;
            if (optional.isPresent())
                employee = optional.get();
            else
                throw new RuntimeException(
                        "Employee not found for id : " + employeeId);
            return employee;
        }
    }

    @Override
    public void deleteViaId(long id) {
        entRepo.deleteById(id);
    }
}
