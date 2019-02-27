package com.athiththam.hibernate.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}