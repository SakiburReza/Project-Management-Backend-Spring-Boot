package java_assignment.Application.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java_assignment.Application.Project.Project;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService pService; 

    @PostMapping("/add-user")
    public User addPerson(@RequestBody User person){
        return pService.savePerson(person);
        
    }

    @PostMapping("/authenticate-user")
    public ObjectNode authenticateUser(@RequestBody Map<String, String> userMap) {
   
        String username = userMap.get("username");
        String password = userMap.get("password");

        return pService.authenticateUser(username, password);
    }
    @GetMapping("/get-all-user")
    public ArrayList<User> getAllUser(){
        return pService.getAllUser();
    }

    @GetMapping("/get-by-username/{username}")
    public User getUser(@PathVariable String username){
        return pService.getUser(username);
    }
    @GetMapping("/get-user-by-id/{id}")
    public Optional<User> getUserbyId(@PathVariable int id){
        System.out.println("id:   "+ id);
        return pService.getUserById(id);
    }




















    @GetMapping("/test")
    public String f(){
        System.out.println("In f()");
        return "Testing";
    }
     
     @GetMapping({"/","/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    @GetMapping("/sign-up")
    public ModelAndView SignUp(Model model) {
        System.out.println("In sign updddddddddddddddddddddddd");
        ModelAndView page = new ModelAndView("SignUp");
        return page;

    }
    


}
