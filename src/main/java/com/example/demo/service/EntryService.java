package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Entry;

import java.util.List;

public interface EntryService {

    List<Entry> getAllEntry(List<Entry> entryList);

    void save(Entry entry);

    Entry getbyId(Long id);

    Employee getbyEmployeeId(Long employeeId);

    void deleteViaId(long id);
}
