package java_assignment.Application.User;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class UserService {
    @Autowired
    private UserRepository uRepository;

     @Autowired
    private ObjectMapper mapper;

    public User savePerson(User person)
    {
        return uRepository.save(person);
    }

    public ObjectNode authenticateUser(String username,String password){
       ObjectNode node = mapper.createObjectNode();

       User user = getPersonByUsername(username);
       
       if(user == null){
        System.out.println(username+" pass: "+password);
            return node
                       .put("Unsuccess",false)
                       .put("message","User not found. Register first");}

        else if(!password.equals(user.getPassword()))
            return node
                       .put("Unsuccess",false)
                       .put("message","Password doesn't match");
        else if(password.equals(user.getPassword()))
            return node
                       .put("success",true)
                       .put("message","Login successful");
        else 
            return node 
                        .put("Unsuccess",false)
                        .put("message","Server error. Try again");
    }

    private User getPersonByUsername(String username) {
        return uRepository.findByUsername(username);
    }

    public ArrayList<User> getAllUser() {
        return (ArrayList<User>) uRepository.findAll();
    }

    public User getUser(String email) {
        return uRepository.findByUsername(email);
    }

    public Optional<User> getUserById(int id) {
        return uRepository.findById(id);
    }
}
