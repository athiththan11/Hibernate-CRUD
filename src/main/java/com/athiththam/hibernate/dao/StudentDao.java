package com.athiththam.hibernate.dao;

import java.util.List;

import com.athiththam.hibernate.model.Student;
import com.athiththam.hibernate.util.HibernateUtil;

import org.hibernate.Session;

/**
 * Data access service for Student class
 */
public class StudentDao {

    /**
     * data access service to retrieve all student objects (tuples) from postgreSQL
     * using hibernate
     * 
     * @return {@link List} of {@link Student}
     */
    public List<Student> getStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

}