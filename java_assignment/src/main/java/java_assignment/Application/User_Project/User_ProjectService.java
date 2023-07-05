package java_assignment.Application.User_Project;

import org.springframework.stereotype.Service;

@Service
public class User_ProjectService {

    private User_ProjectRepository user_ProjectRepository;

    public User_Project save(User_Project up) {
        return user_ProjectRepository.save(up);
    }
    
}
