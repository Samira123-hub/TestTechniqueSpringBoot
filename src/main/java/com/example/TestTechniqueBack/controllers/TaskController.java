package com.example.TestTechniqueBack.controllers;

import com.example.TestTechniqueBack.entities.Project;
import com.example.TestTechniqueBack.entities.Task;
import com.example.TestTechniqueBack.services.ProjectService;
import com.example.TestTechniqueBack.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;

    public TaskController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id,  @ModelAttribute Task task){

        Task updatedTask = taskService.updateTask(id,task);
        return "redirect:/projects";
    }


    @PostMapping("/tasks")
    public String AddNewTask(@ModelAttribute Task task, Model model){
        Task savedProject = taskService.addNewTask(task);
        return "redirect:/projects";
    }


    @GetMapping("/searchByStatus/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status){
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    @GetMapping("/searchByTitle/{title}")
    public ResponseEntity<List<Task>> getTasksByTitle(@PathVariable String title){
        return ResponseEntity.ok(taskService.getTasksByTitle(title));
    }


    @GetMapping("/tasks/edit/{id}")
    public String afficherFormModification(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("project", task.getProject()); // ← indispensable ici
        model.addAttribute("mode", "Modifier");
        return "form-modif";
    }




}
