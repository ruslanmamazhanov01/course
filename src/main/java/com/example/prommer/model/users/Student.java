package com.example.prommer.model.users;

import com.example.prommer.model.enums.Formatlearning;
import com.example.prommer.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.language.bm.Lang;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long studentID;

    private String nameStudent;

    private int age;

    @Email(message = "you must define '@' in email address")
    private String email;

    private String phoneNumber;

    private LocalDate dateOfRegistration;

    private String address;

    private Language language;

    private String group;

    private Formatlearning formatlearning;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AuthenticationInfo authenticationInfo;


}
