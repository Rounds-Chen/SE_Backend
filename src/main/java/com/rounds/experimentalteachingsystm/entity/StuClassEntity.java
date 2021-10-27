package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@TableName("stu_class")
public class StuClassEntity implements Serializable {

      @TableId(value="student_id")
      private String studentId;

      private Integer classId;

    
    public String getStudentId() {
        return studentId;
    }

      public void setStudentId(String studentId) {
          this.studentId = studentId;
      }
    
    public Integer getClassId() {
        return classId;
    }

      public void setClassId(Integer classId) {
          this.classId = classId;
      }

    @Override
    public String toString() {
        return "StuClassEntity{" +
              ", studentId=" + studentId +
                  ", classId=" + classId +
              "}";
    }
}
