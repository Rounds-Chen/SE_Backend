package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@TableName("course")
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "course_id", type = IdType.AUTO)
      private Integer courseId;

    private String courseName;

    private String teacherInChargeId;

    
    public Integer getCourseId() {
        return courseId;
    }

      public void setCourseId(Integer courseId) {
          this.courseId = courseId;
      }
    
    public String getCourseName() {
        return courseName;
    }

      public void setCourseName(String courseName) {
          this.courseName = courseName;
      }
    
    public String getTeacherInChargeId() {
        return teacherInChargeId;
    }

      public void setTeacherInChargeId(String teacherInChargeId) {
          this.teacherInChargeId = teacherInChargeId;
      }

    @Override
    public String toString() {
        return "CourseEntity{" +
              ", courseId=" + courseId +
                  ", courseName=" + courseName +
                  ", teacherInChargeId=" + teacherInChargeId +
              "}";
    }
}
