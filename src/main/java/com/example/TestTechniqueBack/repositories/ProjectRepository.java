package com.example.TestTechniqueBack.repositories;

import com.example.TestTechniqueBack.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
