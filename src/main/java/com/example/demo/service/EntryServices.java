package com.example.demo.service;

import com.example.demo.model.Entry;

import java.util.List;

public interface EntryServices{
    List<Entry> getAllEntrys();
    void save(Entry entry);
    Entry getById(Long id);
    void deleteViaId(Long id);
}
