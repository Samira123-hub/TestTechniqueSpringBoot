package com.example.TestTechniqueBack.services;


import com.example.TestTechniqueBack.entities.Task;
import com.example.TestTechniqueBack.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addNewTask(Task task){
        return (Task) taskRepository.save(task);
    }

    public List<Task> getTasksByStatus (String status){
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByTitle (String title){
        return taskRepository.findByTitle(title);
    }

    public Task updateTask (Long id, Task task){
            return taskRepository.findById(id)
                .map(p -> {
                        p.setTitle(task.getTitle());
                        p.setDescription(task.getDescription());
                        p.setStatus(task.getStatus());
                        p.setDueDate(task.getDueDate());
                        return taskRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Projet introuvable"));
    }

    public Task getTaskById (Long id){
        return taskRepository.findById(id).orElse(null);
    }



}
