package com.example.accessingdatamysql.services;
import com.example.accessingdatamysql.model.Task;
import com.example.accessingdatamysql.model.TaskHistory;

import java.util.ArrayList;
import java.util.List;

public interface TaskService {
    //add task
    String addNewTask(Task t);

    //read task
    List<Task> showBoard();

    //modify task
   String modifyTask(Task t ,Integer id);

    //delete task
    void deleteTask(Integer id);


    List<TaskHistory> showtaskhistory(Integer id);
}
