package org.example.entity;

public class Student {
    private int studentId;
    private String studentName;
    private String studentRollNumber;
    private Subject subject;
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId=studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }
    public void setStudentRollNumber(String studentRollNumber){
        this.studentRollNumber=studentRollNumber;
    }
    public String getStudentRollNumber(){
        return studentRollNumber;
    }
    public void setSubject(Subject subject){
        this.subject=subject;
    }
    public Subject getSubject(){
        return subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentRollNumber='" + studentRollNumber + '\'' +
                ", subject=" + subject +
                '}';
    }
}
