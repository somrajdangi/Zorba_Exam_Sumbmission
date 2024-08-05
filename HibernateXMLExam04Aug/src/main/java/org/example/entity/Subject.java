package org.example.entity;

public class Subject {
    private int subjectId;
    private String subjectName;

    public int getSubjectId(){
        return  subjectId;
    }
    public void setSubjectId(int subjectId){
        this.subjectId=subjectId;
    }
    public String getSubjectName(String subjectName){
        return subjectName;
    }
    public void setSubjectName(String subjectName){
        this.subjectName=subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
