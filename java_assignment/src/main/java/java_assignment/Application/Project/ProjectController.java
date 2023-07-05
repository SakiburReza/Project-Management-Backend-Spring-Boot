package java_assignment.Application.Project;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService pService;

    @PostMapping("/create-project")
    Project saveProject(@RequestBody Project p){
        System.out.println("Hellooooooooooooo");
        return pService.save(p);
    }

    @PostMapping("/delete-project")
    void deleteProject(@RequestBody Project p){
             pService.deleteProject(p);
    }

    @PostMapping("/delete-project-by-id/{id}")
    void deleteProjectById(@PathVariable int id){
        pService.deleteProjectById(id);
    }

    @GetMapping("/view-a-project/{project_name}")
    public Project viewProject(@PathVariable String p_name ){
        return pService.getProjectByProjectName(p_name);
    }

    @GetMapping("/get-project-by-id/{id}")
    public Optional<Project> getProjectById(@PathVariable int id){
        return pService.getProjectByProjectId(id);
    }

    @PostMapping("/update-project")
    Project updateProject(@RequestBody Project p){
        return pService.updateProject(p);
    }

    @GetMapping("/get-all-project")
    public ArrayList<Project> viewAllProject(){
        System.out.println("Hiiiiiiiiiiiiii");
        return pService.viewAllProject();
    }
}
