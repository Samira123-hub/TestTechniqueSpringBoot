package com.example.TestTechniqueBack.services;


import com.example.TestTechniqueBack.entities.Project;
import com.example.TestTechniqueBack.entities.Task;
import com.example.TestTechniqueBack.repositories.ProjectRepository;
import com.example.TestTechniqueBack.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public Project getProjectById(Long id){
        return  projectRepository.findById(id).orElse(null);
    }



    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }



    public Project addNewProject(Project project){
        return (Project) projectRepository.save(project);
    }



    public Project updateProject(Long id, Project newProject) {
        return projectRepository.findById(id)
                .map(p -> {
                    p.setName(newProject.getName());
                    p.setDescription(newProject.getDescription());
                    p.setStartDate(newProject.getStartDate());
                    p.setEndDate(newProject.getEndDate());
                    return projectRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Projet introuvable"));
    }


    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

    public List<Task> getTasksByProject(Long id){
        return taskRepository.findByProjectId(id);
    }







}
