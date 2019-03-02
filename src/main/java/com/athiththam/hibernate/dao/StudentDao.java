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

        List<Student> students = null;
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            students = session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return students;
    }

    /**
     * data access service to retrieve a particular student object from postgreSQL
     * using student_id
     * 
     * @param student_id
     * @return if exits {@link Student}; else null
     */
    public Student getStudent(int student_id) {

        Student student = null;
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            student = (Student) session.createQuery("from Student where student_id = " + student_id).list().get(0);
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return student;
    }

    /**
     * data access service to save a student object on postgreSQL using hibernate
     * 
     * @param student {@link Student} object
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

    /**
     * data access service to update a student object on postgreSQL using hibernate
     * 
     * @param student_id
     * @param student    {@link Student} object
     * @return true if updated; false if failed
     */
    public boolean updateStudent(int student_id, Student student) {

        boolean updated = true;
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Student studentObj = (Student) session.get(Student.class, student_id);

            studentObj.setEmail(student.getEmail());
            studentObj.setName(student.getName());
            studentObj.setUsername(student.getUsername());

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }

            updated = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return updated;
    }

    /**
     * data access service to delete a student object from postgreSQL using
     * hibernate
     * 
     * @param student_id
     * @return
     */
    public boolean deleteStudent(int student_id) {

        boolean deleted = true;
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            Student student = getStudent(student_id);
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }

            deleted = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return deleted;
    }

}