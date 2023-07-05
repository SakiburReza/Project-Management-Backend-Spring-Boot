package java_assignment.Application.User_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class User_ProjectController {
    @Autowired
    private User_ProjectService user_ProjectService;

    @PostMapping("/add-user_project")
    public User_Project save_user_project(@RequestBody User_Project up){
        System.out.println("up:  "+up);
        return user_ProjectService.save(up);
    }

    

}
