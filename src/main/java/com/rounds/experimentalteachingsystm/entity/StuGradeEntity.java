package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-11-02
 */
@TableName("stu_grade")
public class StuGradeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      private String studentId;

      private Integer courseId;

    private Float score;

    private String grade;

    
    public String getStudentId() {
        return studentId;
    }

      public void setStudentId(String studentId) {
          this.studentId = studentId;
      }
    
    public Integer getCourseId() {
        return courseId;
    }

      public void setCourseId(Integer courseId) {
          this.courseId = courseId;
      }
    
    public Float getScore() {
        return score;
    }

      public void setScore(Float score) {
          this.score = score;
      }
    
    public String getGrade() {
        return grade;
    }

      public void setGrade(String grade) {
          this.grade = grade;
      }

    @Override
    public String toString() {
        return "StuGradeEntity{" +
              ", studentId=" + studentId +
                  ", courseId=" + courseId +
                  ", score=" + score +
                  ", grade=" + grade +
              "}";
    }
}
