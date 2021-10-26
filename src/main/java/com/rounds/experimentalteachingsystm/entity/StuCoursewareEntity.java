package com.rounds.experimentalteachingsystm.entity;

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
@TableName("stu_courseware")
public class StuCoursewareEntity implements Serializable {
    @TableId(value = "student_id")
    private String studentId;

    private String coursewareId;

    
    public String getStudentId() {
        return studentId;
    }

      public void setStudentId(String studentId) {
          this.studentId = studentId;
      }
    
    public String getCoursewareId() {
        return coursewareId;
    }

      public void setCoursewareId(String coursewareId) {
          this.coursewareId = coursewareId;
      }

    @Override
    public String toString() {
        return "StuCoursewareEntity{" +
              ", studentId=" + studentId +
                  ", coursewareId=" + coursewareId +
              "}";
    }
}
