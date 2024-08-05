package org.example.entity;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherQualification;
    private int experienceOfTeaching;
    private Student student;
    public int getTeacherId(){
        return teacherId;
    }
    public void setTeacherId(int teacherId){
        this.teacherId=teacherId;
    }
    public String getTeacherName(){
        return teacherName;
    }
    public void setTeacherName(String teacherName){
        this.teacherName=teacherName;
    }
    public void setTeacherQualification(String teacherQualification){
        this.teacherQualification=teacherQualification;
    }
    public String getTeacherQualification(){
        return teacherQualification;
    }
    public void setExperienceOfTeaching(int experienceOfTeaching){
        this.experienceOfTeaching=experienceOfTeaching;
    }
    public void setStudent(Student student){
        this.student=student;
    }
    public Student getStudent(){
        return student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherQualification='" + teacherQualification + '\'' +
                ", experienceOfTeaching=" + experienceOfTeaching +
                ", student=" + student +
                '}';
    }
}
