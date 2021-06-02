package com.example.demo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping(path="profile/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProject(@RequestParam(required = false) String sort,@RequestParam(required = false) String type){
        if(sort != null && type != null){
            return projectService.getsortProject(sort,type);
        }
        return projectService.getProject();
    }

    @PostMapping
    public void registerNewProject(@RequestBody Project project){
        projectService.addNewproject(project);
    }
    @DeleteMapping
    public void deleteproject(@RequestParam Long projectId){
        projectService.deleteproject(projectId);
    }

    @PutMapping
    public void updateproject(@RequestParam Long projectId,@RequestBody Project project){
        projectService.updateproject(projectId,project);
    }
}
