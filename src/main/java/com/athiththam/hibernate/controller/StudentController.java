package com.athiththam.hibernate.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.athiththam.hibernate.dao.StudentDao;
import com.athiththam.hibernate.model.Student;

@Path("/students")
public class StudentController {

    // student data access object service
    private StudentDao studentDao = new StudentDao();

    /**
     * method to get all declared students from database
     * 
     * @return {@link List} of {@link Student}
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    /**
     * method to get a particular student object form database using its student_id
     * 
     * @param student_id
     * @return if exists {@link Student}; else null
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int student_id) {
        return studentDao.getStudent(student_id);
    }

    /**
     * method to save a student inside the database
     * 
     * @param student {@link Student} Student object
     * @return true if success; false if failed
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    /**
     * method to update a student object existing inside the database
     * 
     * @param student_id
     * @param student    {@link Student} object
     * @return true if success; false if failed
     */
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateStudent(@PathParam("id") int student_id, Student student) {
        return studentDao.updateStudent(student_id, student);
    }

    /**
     * method to delete a student object from the database
     * 
     * @param student_id
     * @return true if success; false if failed
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteStudent(@PathParam("id") int student_id) {
        return studentDao.deleteStudent(student_id);
    }
}