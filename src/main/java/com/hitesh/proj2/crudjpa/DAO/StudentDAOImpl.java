package com.hitesh.proj2.crudjpa.DAO;

import com.hitesh.proj2.crudjpa.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * entity manager methods:
 * entityManager.persist() -> to save something in DB;
 * entityManager.find() -> to find some record from DB;
 * entityManager.createQuery() -> to create a new query from entity, which in return will talk to DB;
 * entityManager.merge() -> to update something;
 *
 */

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entityManager
    private final EntityManager entityManager;

    //Inject the entityManager using constructor Injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // add transactional annotation. @Transactional handles the operations for us automatically. It starts and ends the transaction for the DB automagically.
    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        return entityManager.find(Student.class ,id);
    }

    @Override
    public List<Student> getAllStudentsList() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("from Student order by lastName asc", Student.class);
        System.out.println(typedQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> getStudentByLastName(String lastName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("from Student where lastName=:thisData", Student.class);
        typedQuery.setParameter("thisData",lastName);
        System.out.println(typedQuery);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Integer id, String fName, String lName, String eMail) {
        Student student = entityManager.find(Student.class, id);
        if(fName !=null){student.setFirstName(fName);}
        if (lName != null){student.setLastName(lName);}
        if(eMail !=null){
            student.setEmail(eMail);
        }
        entityManager.merge(student);
        System.out.println(student);
        return student;
    }

    @Override
    @Transactional
    public Student deleteStudentById(Integer id) {
        Student delQuery = entityManager.find(Student.class,id);
        entityManager.remove(delQuery);
        return null;
    }

    @Override
    @Transactional
    public Student deleteAllStudent() throws RuntimeException {
        try{
            entityManager.createQuery("delete from Student ").executeUpdate();
        }catch (RuntimeException runtimeException){
            throw new RuntimeException(runtimeException);
        }
        return null;
    }
}
