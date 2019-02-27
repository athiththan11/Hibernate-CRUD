package com.athiththam.hibernate;

import java.util.List;

import com.athiththam.hibernate.dao.StudentDao;
import com.athiththam.hibernate.model.Student;

public class Application {
    public static void main(String[] args) {

        // simple usage of hibernate to display all students' name
        StudentDao userDao = new StudentDao();
        List<Student> students = userDao.getStudents();
        students.forEach(u -> System.out.println(u.getName()));
    }
}