package com.hitesh.proj2.crudjpa;

import com.hitesh.proj2.crudjpa.DAO.StudentDAO;
import com.hitesh.proj2.crudjpa.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.util.List;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.hitesh.proj2")
})

public class CrudJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runnner -> {
            //createStudent(studentDAO);

            createMultipleStudents(studentDAO);
            //findStudentById(studentDAO,1);
            //getAllStudents(studentDAO);
            //getStudentByLastName(studentDAO, "Jha");
            //updateStudent(studentDAO,"Omar ","Essam"," fuckme@gmail.com");
            //deleteStudent(studentDAO,1);
            //deleteAllStudent(studentDAO);

        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        Student student = studentDAO.deleteAllStudent();
        System.out.println("All students successfully deleted..");
    }


    private List<Student> getAllStudents(StudentDAO studentDAO) {
        List<Student> student = studentDAO.getAllStudentsList();
        for (Student students : student){
            System.out.println("All students: "+ students);
        }
        return student;
    }

    private List<Student> getStudentByLastName(StudentDAO studentDAO, String lName) {
        List<Student> students = studentDAO.getStudentByLastName(lName);
        System.out.println("Students with name: "+students);
        return students;
    }


    private void findStudentById(StudentDAO studentDAO, Integer id) {
        Student student = studentDAO.findStudentById(id);
        System.out.println("Gotcha student: "+student.toString());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student student2 = new Student("Amit", "Jha", "hitesh.shridhar@informatik.hs-fulda.de");
        Student student3 = new Student("Amlan", "B", "hitesh.shridhar@informatik.hs-fulda.de");
        Student student4 = new Student("Souwmya", "R", "hitesh.shridhar@informatik.hs-fulda.de");

        studentDAO.saveStudent(student2);
        studentDAO.saveStudent(student3);
        studentDAO.saveStudent(student4);
    }

    private void createStudent(StudentDAO studentDAO){
        //create student Object
        System.out.println("Creating the new student");
        Student student = new Student("Hitesh", "Shridhar", "hitesh.shridhar@informatik.hs-fulda.de");

        //save student object
        System.out.println("Saving the student Object");
        studentDAO.saveStudent(student);
    }

    private Student updateStudent(StudentDAO studentDAO, String fName, String lName, String eMail) {
        Student student = studentDAO.updateStudent(4, fName, lName, eMail);
        return student;
    }

    private Student deleteStudent(StudentDAO studentDAO, int id) {
        Student student = studentDAO.deleteStudentById(id);
        System.out.println("Student deleted..");
        return student;
    }


}


