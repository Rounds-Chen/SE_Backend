package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;

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

    @MppMultiId
    @TableField(value = "student_id")
    private String studentId;

    @MppMultiId
    @TableField(value = "courseware_id")
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
