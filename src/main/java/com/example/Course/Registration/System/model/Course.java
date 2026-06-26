package com.example.Course.Registration.System.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private String course_id;
    private String course_name;
    private String trainer;
    private int duration;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Course(String course_name, String trainer, int duration) {
        this.course_name = course_name;
        this.trainer = trainer;
        this.duration = duration;
    }

    public Course(){

    }
}
