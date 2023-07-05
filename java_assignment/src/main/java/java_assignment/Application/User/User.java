package java_assignment.Application.User;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_User")

public class User{
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String email;
    
   
}
