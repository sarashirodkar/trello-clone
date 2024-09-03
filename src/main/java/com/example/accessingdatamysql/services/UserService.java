package com.example.accessingdatamysql.services;

import com.example.accessingdatamysql.model.User;

public interface UserService {
    Iterable<User> getAllUsers();

    String addNewTask(User n);
}
