package com.mobile.class4;

/**
 * Created by MiguelAngel on 09/02/2016.
 */
public class Student {

    public Student(String name, String major, float grade){
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    private String name;
    private String major;
    private float grade;




}
