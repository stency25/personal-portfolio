package com.stency.personal_portfolio.controller;


import com.stency.personal_portfolio.entity.ProjectEntity;
import com.stency.personal_portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

@Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //get all projects
    @GetMapping
    public List<ProjectEntity>getAllProjects(){
    return projectService.getAllProjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ProjectEntity createProject(@RequestBody ProjectEntity project) {
        return projectService.createProject(project);
    }
    @PutMapping("/{id}")
    public ProjectEntity updateProject(@PathVariable Long id, @RequestBody ProjectEntity project) {
        return projectService.updateProject(id, project);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }



}
