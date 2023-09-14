package com.example.demo.repository;

import com.example.demo.model.Activity;
import com.example.demo.model.Entry;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ActivityRepository  extends CrudRepository<Activity,Long> {

   List<Activity> findByEntryId(long id);

   void removeByEntry(Entry entry);
}
