package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //reading the configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //create sessionFactory object from configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //create new session
        Session session = sessionFactory.openSession();

        //declaring transaction object
        Transaction tx = null;

        //creating Scanner object to read input from console
        Scanner scanner = new Scanner(System.in);

        //creating object for three classes

        Teacher teacher = new Teacher();
        Student student = new Student();
        //read the four Subject data from console and inserting to Subject table

        System.out.println("enter four Subject data: ");
        for (int i = 0; i < 4; i++) {
            Subject subject = new Subject();
            System.out.println("enter subject id");
            int subjectId = scanner.nextInt();
            scanner.nextLine();
            subject.setSubjectId(subjectId);
            System.out.println("enter subject name");
            String subjectName = scanner.nextLine();
            subject.setSubjectName(subjectName);
            session.save(subject);

        }
        session.getTransaction().commit();
        //read the teacher data from console and inserting to teacher table

        System.out.println("enter teacher data:");
        System.out.println("enter teacher id");
        int teacherId = scanner.nextInt();
        scanner.nextLine();
        teacher.setTeacherId(teacherId);
        System.out.println("enter teacher name");
        String teacherName = scanner.nextLine();
        teacher.setTeacherName(teacherName);


        //read the student data from console and inserting to student table
        System.out.println("enter student data:");
        System.out.println("enter student id");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        student.setStudentId(studentId);
        System.out.println("enter student name");
        String studentName = scanner.nextLine();
        student.setStudentName(studentName);
        System.out.println("Enter student roll number:");
        String studentRollNumber = scanner.nextLine();
        List<Subject> subjects = session.createQuery("FROM Subject", Subject.class).list();
        for (int i = 0; i < subjects.size(); i++) {

        }


        try {
            tx = session.beginTransaction();
            session.persist(teacher);
            session.persist(student);
            for (Subject subject : subjects) {
                session.persist(subject);
            }
            tx.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        //select all the records like students, teacher and Subject and show them into console

        session = sessionFactory.openSession();
        try {
            // Fetch all records and show them in console
            System.out.println("All Subjects:");
            List<Subject> subjectList = session.createQuery("FROM Subject", Subject.class).list();
            for (Subject subject : subjectList) {
                System.out.println(subject.getSubjectId() + ": " + subject.getSubjectName());
            }

            System.out.println("All Students:");
            List<Student> studentList = session.createQuery("FROM Student", Student.class).list();
            for (Student s : studentList) {
                System.out.println(s.getStudentId() + ": " + s.getStudentName() + ", " + s.getStudentRollNumber() + ", " + s.getSubject().getSubjectName());
            }

            System.out.println("All Teachers:");
            List<Teacher> teacherList = session.createQuery("FROM Teacher", Teacher.class).list();
            for (Teacher t : teacherList) {
                System.out.println(t.getTeacherId() + ": " + t.getTeacherName() + ", " + t.getTeacherQualification() + ", " + t.getExperienceOfTeaching() + " years, Subject: " + t.getSubject().getSubjectName());
            }
        //update records
            // Update the subject name from Mathematics to Astronomy
            tx = session.beginTransaction();
            Subject mathSubject = session.createQuery("FROM Subject WHERE subjectName = 'Mathematics'", Subject.class).uniqueResult();
            if (mathSubject != null) {
                mathSubject.setSubjectName("Astronomy");
                session.update(mathSubject);
            }
            tx.commit();
        //Update the subject name to Astronomy which is Mathematics.
            // Delete records of students who have chosen subject as Physics
            tx = session.beginTransaction();
            Subject physicsSubject = session.createQuery("FROM Subject WHERE subjectName = 'Physics'", Subject.class).uniqueResult();
            if (physicsSubject != null) {
                List<Student> physicsStudents = session.createQuery("FROM Student WHERE subject = :subject", Student.class)
                        .setParameter("subject", physicsSubject)
                        .list();
                for (Student s : physicsStudents) {
                    session.delete(s);
                }
            }
            tx.commit();
        //Delete records of student who has chosen subject as Physics.

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
            scanner.close();
        }
    }
}

