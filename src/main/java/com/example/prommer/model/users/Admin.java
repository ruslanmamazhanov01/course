package com.example.prommer.model.users;

import com.example.prommer.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long adminId;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = ALL)
    private AuthenticationInfo authenticationInfo;

}
