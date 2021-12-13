package com.rounds.experimentalteachingsystm.entity;


public class StuClassCoursEntity {
    private String studentId;
    private String studentName;
    private Integer classId;
    private Integer courseId;

    public Integer getCourse_name() {
        return courseId;
    }

    public void setCourse_name(Integer course_name) {
        this.courseId = course_name;
    }

    public String getStu_name() {
        return studentName;
    }

    public void setStu_name(String stu_name) {
        this.studentName = stu_name;
    }

    public Integer getClass_id() {
        return classId;
    }

    public void setClass_id(Integer class_id) {
        this.classId = class_id;
    }

    public String getStudent_id() {
        return studentId;
    }

    public void setStudent_id(String student_id) {
        this.studentId = student_id;
    }
}
