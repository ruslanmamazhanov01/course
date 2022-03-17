package com.example.prommer.model.users;

import com.example.prommer.model.course.Course;
import com.example.prommer.model.enums.Formatlearning;
import com.example.prommer.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long teacherId;

    private String name;
    @Email(message = "you must define '@' in email address")
    private String email;

    private int age;
    //TODO
    private String address;

    private Language language;

    private Formatlearning formatlearning;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AuthenticationInfo authenticationInfo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> course = new ArrayList<>();

}
