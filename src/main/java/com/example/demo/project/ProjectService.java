package com.example.demo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProject(){
        return projectRepository.findAll();
    }

    public List<Project> getsortProject(String sort,String type){
        if(sort.equals("ratigs")){
            if (type.equals("asc")){
                return projectRepository.findByorderASCRate();
            }else if (type.equals("desc")){
                return projectRepository.findByorderDescRate();
            }
        }else if(sort.equals("date")){
            if (type.equals("asc")){
                return projectRepository.findByorderASCdate();
            }else if (type.equals("desc")){
                return projectRepository.findByorderDescdate();
            }
        }return projectRepository.findAll();
    }

    public void addNewproject(Project project) {
        Optional<Project> projectByName = projectRepository.findProjectByName(project.getName());
        if(projectByName.isPresent()){
            throw new IllegalStateException("has name in database");

        }
        projectRepository.save(project);
//        System.out.println(project);
    }

    public void deleteproject(Long projectId) {
        boolean exist = projectRepository.existsById(projectId);
        if(!exist){
            throw new IllegalStateException("project id "+projectId+"dose not exist");
        }
        projectRepository.deleteById(projectId);
    }
    @Transactional
    public void updateproject(Long projectId, Project temp) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalStateException("project id" + projectId + "dose exist"));
        if(temp.getName() != null && temp.getName().length() > 0 && !Objects.equals(temp.getName(),project.getName())){
            project.setName(temp.getName());
        }
        if(temp.getDescription() != null && temp.getDescription().length() > 0 && !Objects.equals(temp.getDescription(),project.getDescription())){
            project.setDescription(temp.getDescription());
        }
        if(temp.getDate()!=null){
            project.setDate(temp.getDate());
        }
        if(temp.getRating()!=null){
            project.setRating(temp.getRating());
        }
    }
}
