package com.project.TaskManagement.controller;
import com.project.TaskManagement.entity.Priority;
import com.project.TaskManagement.entity.Task;
import com.project.TaskManagement.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository  taskRepository;

    @GetMapping("/")
    public String index(Model model) {
        LocalDateTime fakeCreatedAt = LocalDateTime.of(2023, 1, 1, 12, 0); // Use any desired date and time
        Task fakeTask = new Task(1, fakeCreatedAt, null, null, Priority.LOW, false, "Fake Task", "This is a fake task");
        model.addAttribute("task" , fakeTask);
        return "index";
    }


    @GetMapping("/create-task")
    public String showCreateTaskForm(Model model){
        Task task=new Task();
        model.addAttribute("task" , task);

        return "task-create";
    }


    @GetMapping("/tasks")
    public String tasks(Model model){
        List<Task> taskList=taskRepository.findAll();
        model.addAttribute("tasks" , taskList);
        return "my-tasks";
    }
    @PostMapping("/tasks/save")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("task" , task);
            return "task-create";

        }
        taskRepository.save(task);
        return "redirect:/tasks";
    }


}
