package com.unaiz;

import com.unaiz.dao.StudentDao;
import com.unaiz.entity.Address;
import com.unaiz.entity.Student;

public class Main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        //  Create
        Student student = new Student("Unaiz", "unaiz@gmail.com");
        Address address = new Address("Nagpur", "Maharashtra");
        student.setAddress(address);
        dao.savedStudent(student);

        //  Read
        Student fetched = dao.getStudentById(1);
        if (fetched != null) {
            System.out.println("Student: " + fetched.getName());
            System.out.println("City: " + fetched.getAddress().getCity());
        }

        // ️ Delete
        // dao.deleteStudent(1);
    }
}