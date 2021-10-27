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
 * @since 2021-10-26
 */
@TableName("stu_class")
public class StuClassEntity implements Serializable {
      @MppMultiId
      @TableField(value="student_id")
      private String studentId;

      @MppMultiId
      @TableField(value = "class_id")
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
