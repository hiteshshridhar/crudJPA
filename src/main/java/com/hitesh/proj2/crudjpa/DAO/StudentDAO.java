package com.hitesh.proj2.crudjpa.DAO;


import com.hitesh.proj2.crudjpa.Entity.Student;

import java.util.List;


public interface StudentDAO {

    // add transactional annotation. @Transactional handles the operations for us automatically. It starts and ends the transaction for the DB automagically.
    void saveStudent(Student student);

    Student findStudentById(Integer id);

    List<Student> getAllStudentsList();

    List<Student> getStudentByLastName(String lastName);

    Student updateStudent(Integer id, String fName, String lName, String eMail);

    Student deleteStudentById(Integer id);

    Student deleteAllStudent() throws RuntimeException;
}




