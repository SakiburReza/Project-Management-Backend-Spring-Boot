package java_assignment.Application.User_Project;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java_assignment.Application.Project.Project;
import java_assignment.Application.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table

public class User_Project {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="project_id",referencedColumnName = "id", nullable = true)
    private Project project;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id",referencedColumnName = "id", nullable = true)
    private User user;
}
