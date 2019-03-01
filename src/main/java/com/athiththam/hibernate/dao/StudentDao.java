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

    /**
     * data access service to save a student object on postgreSQL using hibernate
     * 
     * @return true if saved; false if any exception occured
     */
    public boolean saveStudent(Student student) {

        boolean saved = true;
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }

            saved = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return saved;
    }

}