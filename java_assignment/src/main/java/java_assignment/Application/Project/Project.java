package java_assignment.Application.Project;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java_assignment.Application.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Project {
   
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String intro;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    private int status; // pre: 0, start: 1, end: 3
    private Date startDateTime;
    private Date endDateTime;
    
    
    
}
