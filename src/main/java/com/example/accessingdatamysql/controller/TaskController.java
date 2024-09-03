package com.example.accessingdatamysql.controller;
import com.example.accessingdatamysql.model.TaskHistory;
import com.example.accessingdatamysql.model.Task;
import com.example.accessingdatamysql.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.accessingdatamysql.repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class TaskController {


    @Autowired // This means to get the bean called TaskService
    private TaskService service;


    @PostMapping(path="/addtask")
    public @ResponseBody String addNewTask (@RequestBody Task t) {

        return service.addNewTask(t);

    }

    @PutMapping(path="/modifytask/{id}")
    public @ResponseBody String modifyTask (@RequestBody Task t,@PathVariable Integer id) {
        return service.modifyTask(t,id);
    }


    @DeleteMapping(path="/deletetask/{id}")
    public @ResponseBody String deleteTask (@PathVariable Integer id) {
        service.deleteTask(id);
        return "Deleted Successfully!";
    }

    @GetMapping(path="/showalltask")
    public @ResponseBody List<Task> showBoard () {
        return service.showBoard();
    }

    @GetMapping(path="/showtaskhistory/{id}")
    public @ResponseBody List<TaskHistory> showtaskhistory (@PathVariable Integer id) {
        return service.showtaskhistory(id);
    }
}

