package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Company;
import peaksoft.entity.Task;
import peaksoft.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @ModelAttribute("taskList")
    public List<Task> allTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping
    public String getAll(){
        return "taskPage";
    }
}
