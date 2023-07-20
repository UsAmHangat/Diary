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
public class EntryServiceImpl
        implements EntryServices {

    @Autowired
    private EntryRepository entRepo;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Entry> getAllEntrys() {
        return entRepo.findAll();
    }

//    @Override
//    public List<Entry> getAllEntrysByEmployeeId(Long id) {
//        employeeRepository.
//        return employeeRepository.findById(id);
//    }

    @Override
    public void save(Entry entry) {
        entRepo.save(entry);
    }

    @Override
    public Entry getById(Long id) {
        Optional<Entry> optional = entRepo.findById(id);
        Entry entry = null;
        if (optional.isPresent()) {
            entry = optional.get();
        } else {
            throw new RuntimeException(
                    "Entry not found for id : " + id);
        }
        return entry;
    }

    @Override
    public void deleteViaId(Long id) {
        entRepo.deleteById(id);
    }
}
