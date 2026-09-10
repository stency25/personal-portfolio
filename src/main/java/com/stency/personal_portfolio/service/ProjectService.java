package com.stency.personal_portfolio.service;


import com.stency.personal_portfolio.entity.ProjectEntity;
import com.stency.personal_portfolio.repository.ProjectRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    //constructor
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();

    }
    public Optional<ProjectEntity> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
    public ProjectEntity createProject(ProjectEntity project) {
        return projectRepository.save(project);
    }

    public ProjectEntity updateProject(Long id, ProjectEntity updateProject) {
        return projectRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updateProject.getTitle());
                    existing.setDescription(updateProject.getDescription());
                    existing.setTechStack(updateProject.getTechStack());
                    existing.setGithubUrl(updateProject.getGithubUrl());
                    existing.setLiveUrl(updateProject.getLiveUrl());
                    existing.setImageUrl(updateProject.getImageUrl());
                    return projectRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }



}