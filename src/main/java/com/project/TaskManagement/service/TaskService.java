package com.project.TaskManagement.service;

import com.project.TaskManagement.entity.Task;
import com.project.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void createTask(Task task){
        taskRepository.save(task);
    }


    public Page<Task> getAllTaskWithPagination(int currentPage , int offset) {
        Pageable sortedByDate= PageRequest.of(currentPage,offset, Sort.by("deadline"));
        Page<Task> taskList=taskRepository.findAll(sortedByDate);
        return taskList;
    }
}
