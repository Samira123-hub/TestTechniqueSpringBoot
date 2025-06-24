package com.example.TestTechniqueBack.repositories;

import com.example.TestTechniqueBack.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.project.id=:id")
    List<Task> findByProjectId(@Param("id") Long id);

    @Query("select t from Task t where t.status=:status")
    List<Task> findByStatus(@Param("status") String status);


    @Query("select t from Task t where t.title=:title")
    List<Task> findByTitle(@Param("title") String title);
}
