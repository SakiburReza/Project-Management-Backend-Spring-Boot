package java_assignment.Application.Project;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository pRepository;

    public Project save(Project p) {
        return pRepository.save(p);
    }

    public void deleteProject(Project p) {
         pRepository.delete(p);;
    }

    public Project getProjectByProjectName(String p_name) {
        return pRepository.findByName(p_name);
    }

    public Project updateProject(Project p) {
         Project existingProject = pRepository.findById(p.getId())
                .orElseThrow(() -> new NoSuchElementException("Project not found with ID: " + p.getId()));
        existingProject.setName(p.getName());
        existingProject.setIntro(p.getIntro());
        existingProject.setOwner(p.getOwner());
        existingProject.setStatus(p.getStatus());
        existingProject.setStartDateTime(p.getStartDateTime());
        existingProject.setEndDateTime(p.getEndDateTime());

        return pRepository.save(existingProject);
    }

    public ArrayList<Project> viewAllProject() {
        return (ArrayList<Project>) pRepository.findAll();
    }

    public Optional<Project> getProjectByProjectId(int id) {
        return pRepository.findById(id);
    }

    public void deleteProjectById(int id) {
        pRepository.deleteById(id);
    }
    
}
