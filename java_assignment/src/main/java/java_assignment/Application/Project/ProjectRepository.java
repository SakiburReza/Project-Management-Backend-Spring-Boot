package java_assignment.Application.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

    Project findByName(String p_name);


    //Project updateProject(Project p);
    
}
