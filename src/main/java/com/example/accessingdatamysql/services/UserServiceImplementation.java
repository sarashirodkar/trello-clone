package com.example.accessingdatamysql.services;

import com.example.accessingdatamysql.model.Task;
import com.example.accessingdatamysql.model.TaskHistory;
import com.example.accessingdatamysql.model.User;
import com.example.accessingdatamysql.repository.TaskRepository;
import com.example.accessingdatamysql.repository.TaskHistoryRepository;
import com.example.accessingdatamysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskHistoryRepository taskHistoryRepository;


    //display all users
    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    //add new user in user record
    @Override
    public String addNewTask(User n) {

        n.setName(n.getName());
        n.setEmail(n.getEmail());
        userRepository.save(n);
        return "New User Added";
    }
}
