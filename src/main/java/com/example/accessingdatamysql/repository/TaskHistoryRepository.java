package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.TaskHistory;
import org.springframework.data.repository.CrudRepository;

public interface TaskHistoryRepository extends CrudRepository<TaskHistory,Integer> {
}
