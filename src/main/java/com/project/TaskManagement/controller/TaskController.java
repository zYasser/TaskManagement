package com.project.TaskManagement.controller;
import com.project.TaskManagement.entity.Priority;
import com.project.TaskManagement.entity.Task;
import com.project.TaskManagement.repository.TaskRepository;
import com.project.TaskManagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

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
    public String tasks(Model model , @RequestParam(defaultValue = "0") int page){
        Page<Task> taskList=taskService.getAllTaskWithPagination(page , 4);
        System.out.println("taskList.getTotalPages() = " + taskList.getTotalPages());
        model.addAttribute("tasks" , taskList.getContent());
        model.addAttribute("totalPages", taskList.getTotalPages());
        model.addAttribute("currentPage" , page);

        return "my-tasks";
    }
    @PostMapping("/tasks/save")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("task" , task);
            return "task-create";

        }
        taskService.createTask(task);
        return "redirect:/tasks";
    }


}
