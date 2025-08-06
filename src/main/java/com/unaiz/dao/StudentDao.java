package com.unaiz.dao;

import com.unaiz.entity.Student;
import com.unaiz.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public void savedStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            System.out.println("Student saved with address!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, id);
            return student;
        }
    }

    public void deleteStudent(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, id);
            if (student != null) {
                tx = session.beginTransaction();
                session.delete(student);
                tx.commit();
                System.out.println("🗑️ Student deleted successfully");
            } else {
                System.out.println("❌ Student not found");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
