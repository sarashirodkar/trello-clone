package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Integer> {
}
