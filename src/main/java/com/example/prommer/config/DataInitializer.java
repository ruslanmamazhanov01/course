package com.example.prommer.config;

import com.example.prommer.model.course.Course;
import com.example.prommer.model.enums.Authority;
import com.example.prommer.model.enums.Language;
import com.example.prommer.model.users.Admin;
import com.example.prommer.model.users.AuthenticationInfo;
import com.example.prommer.model.users.Student;
import com.example.prommer.model.users.Teacher;
import com.example.prommer.repository.AdminRepository;
import com.example.prommer.repository.StudentRepository;
import com.example.prommer.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Component
public class DataInitializer {

//    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository,
                                        StudentRepository studentRepository,
                                        AdminRepository adminRepository) {
        return args -> {
            Course course = new Course();
            course.setCourseName("Peaksoft house");
            course.setAddressCourse("Grazhdanskaya-99");
            course.setPrice(new BigDecimal(8000));
            course.setLanguage(Language.KYRGYZ);
            course.setInfo("Courses learning java and javaScript and softSkill and English");

            Course course2 = new Course();
            course2.setCourseName("CodiFy house");
            course2.setAddressCourse("Grazhdanskaya-99");
            course2.setPrice(new BigDecimal(8000));
            course2.setLanguage(Language.RUSSION);
            course2.setInfo("Courses learning java and javaScript and softSkill and English");

            Course course3 = new Course();
            course3.setCourseName("Makers house");
            course3.setAddressCourse("Manas-99");
            course3.setPrice(new BigDecimal(6000));
            course3.setLanguage(Language.ENGLISH);
            course3.setInfo("Courses learning java and javaScript and softSkill and English");

            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setEmail("ruslanmamazhanov@gmail.com");
            authenticationInfo.setAuthority(Authority.TEACHER);
            authenticationInfo.setPassword("teacher");

            AuthenticationInfo authenticationInfo2 = new AuthenticationInfo();
            authenticationInfo2.setEmail("chopa@gmail.com");
            authenticationInfo2.setAuthority(Authority.STUDENT);
            authenticationInfo2.setPassword("student");

            AuthenticationInfo authenticationInfo3 = new AuthenticationInfo();
            authenticationInfo3.setEmail("admin@gmail.com");
            authenticationInfo3.setAuthority(Authority.ADMIN);
            authenticationInfo3.setPassword("admin");

            Teacher teacher = new Teacher();
            teacher.setName("Ruslanbek");
            teacher.setAddress("vostok 5");
            teacher.setAge(20);
            teacher.setLanguage(Language.KYRGYZ);
            teacher.setEmail("ruslanmamazhanov01@gmail.com");
            teacher.setAuthenticationInfo(authenticationInfo);
            teacher.setCourse(Arrays.asList(course));


            Student student = new Student();
            student.setNameStudent("Cholponai");
            student.setAge(19);
            student.setLanguage(Language.RUSSION);
            student.setEmail("chopa@gmail.com");
            student.setDateOfRegistration(LocalDate.of(2022, Month.MARCH, 12));
            student.setPhoneNumber("0773015901");
            student.setAddress("Osh");
            student.setAuthenticationInfo(authenticationInfo2);

            Admin admin = new Admin();
            admin.setLastName("Admin");
            admin.setFirstName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setCourses(Arrays.asList(course3,course2));
            admin.setAuthenticationInfo(authenticationInfo3);

            System.out.println(teacherRepository.save(teacher));
            System.out.println(studentRepository.save(student));
            System.out.println(adminRepository.save(admin));
        };
    }
}
