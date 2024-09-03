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
public class TaskServiceImplementation implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskHistoryRepository taskHistoryRepository;

    // add new task
    @Override
    public String addNewTask(Task t) {
        TaskHistory taskHistory= new TaskHistory();
        try {
            t.setTaskState("TODO");
            t.setCreatetimestamp(new Timestamp(System.currentTimeMillis()));
            taskRepository.save(t);
            taskHistory.setComments(t.getComments().toString());
            taskHistory.setDescription(t.getDescription());
            taskHistory.setState(t.getTaskState());
            taskHistory.setTask_id(t);
            taskHistory.setCreationtime(t.getCreatetimestamp());
            taskHistory.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            taskHistoryRepository.save(taskHistory);
            return "Newly added Task ID : " + t.getId() + " Creation TimeStamp : " + t.getCreatetimestamp();
        }
        catch (Exception e)
        {
            return "Task not added!";
        }

    }

    //display all tasks
    @Override
    public List<Task> showBoard() {

            return (List<Task>) taskRepository.findAll();
    }


    // modify task
        @Override
        public String modifyTask(Task t, Integer id) {
            Task taskobj = taskRepository.findById(id).get();
            User u =new User();

            TaskHistory taskHistory= new TaskHistory();
            if (Objects.nonNull(t.getTaskState()) && !"".equalsIgnoreCase(t.getTaskState())) {
                taskobj.setTaskState(t.getTaskState());
            }
            if (Objects.nonNull(t.getDescription()) && !"".equalsIgnoreCase(t.getDescription())) {
                taskobj.setDescription(t.getDescription());
            }
            if (Objects.nonNull(t.getComments()) /*&& !"".equalsIgnoreCase(t.getComments())*/) {
                taskobj.getComments().add(t.getComments().toString());
            }

            if (Objects.nonNull(t.getAssignedTo().getUserid())) {
                u.setUserid(t.getAssignedTo().getUserid());
                taskobj.setAssignedTo(u);
            }
            try {
                 taskRepository.save(taskobj);
                 t.setCreatetimestamp(new Timestamp(System.currentTimeMillis()));
                 taskHistory.setComments(t.getComments().toString());
                 taskHistory.setDescription(t.getDescription());
                 taskHistory.setState(t.getTaskState());
                 taskHistory.setTask_id(taskobj);
                 taskHistory.setCreationtime(t.getCreatetimestamp());
                 taskHistory.setUpdatetime(new Timestamp(System.currentTimeMillis()));
                 taskHistoryRepository.save(taskHistory);
                 return "Successful!!";

            }
            catch (Exception e){
                e.printStackTrace();
                return "Failure!!";
            }

        }

        //delete task from task record
    @Override
    public void deleteTask(Integer id) {
        try{


            List<TaskHistory> historyrecord = new ArrayList<TaskHistory>();
            List<TaskHistory> allData = (List<TaskHistory>) taskHistoryRepository.findAll();
            for(int i=0;i<allData.size();i++) {
                if (allData.get(i).getTask_id().getId().equals(id));
                    taskHistoryRepository.deleteById(allData.get(i).getTaskhistoryid());
                }

            taskRepository.deleteById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    // show history records of passed taskid
    @Override
    public List<TaskHistory> showtaskhistory(Integer id) {
        try{
            List<TaskHistory> historyrecord = new ArrayList<TaskHistory>();
            List<TaskHistory> allData = (List<TaskHistory>) taskHistoryRepository.findAll();
            for(int i=0;i<allData.size();i++){
                if( allData.get(i).getTask_id().getId() == id){
                    historyrecord.add(allData.get(i));
                }
            }
            return historyrecord;
        }catch(Exception e) {
            return null;
        }
    }


}
