package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends CrudRepository<Entry,Long> {

    List<Entry> findByEmployee(Employee employee);
}
