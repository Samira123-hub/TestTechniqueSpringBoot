package com.example.TestTechniqueBack.controllers;


import com.example.TestTechniqueBack.entities.Project;
import com.example.TestTechniqueBack.entities.Task;
import com.example.TestTechniqueBack.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String getAllProjects(Model model){
        List<Project> projectsList = projectService.getAllProjects();
        model.addAttribute("projects", projectsList);
        return "project-list";
    }



    @PostMapping("/projects")
    public ResponseEntity<String> AddNewProject(@RequestBody Project project){
        if(project == null){
            return ResponseEntity.badRequest().build();
        }
        Project savedProject = projectService.addNewProject(project);
        return new ResponseEntity<>("le projet est enregistre avec succes", HttpStatus.CREATED);
    }



    @PutMapping("/projects/{id}")
    public ResponseEntity<String> updateProject(@PathVariable Long id,  @RequestBody Project project){

        Project updatedProject = projectService.updateProject(id,project);
        return ResponseEntity.ok("le projet est modifie avec succes");
    }



    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Le projet est supprime avec succes");
    }


    @GetMapping("/projects/{id}/tasks")
    public String getTasksByProject(@PathVariable long id, Model model) {
        List<Task> listTasks = projectService.getTasksByProject(id);
        Project project = projectService.getProjectById(id);
        model.addAttribute("tasks", listTasks);
        model.addAttribute("project", project);
        return "task-list";
    }


    @GetMapping("/projects/{projectId}/tasks/new")
    public String afficherFormAjout(@PathVariable Long projectId, Model model) {
        Task task = new Task();
        Project project = projectService.getProjectById(projectId); // ← charge le vrai projet

        task.setProject(project);

        model.addAttribute("task", task);
        model.addAttribute("project", project);
        return "task-form";
    }




}
