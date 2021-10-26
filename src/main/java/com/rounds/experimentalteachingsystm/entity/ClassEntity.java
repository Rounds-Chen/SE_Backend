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
@TableName("class")
public class ClassEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "class_id", type = IdType.AUTO)
      private Integer classId;

    private Integer courseId;

    
    public Integer getClassId() {
        return classId;
    }

      public void setClassId(Integer classId) {
          this.classId = classId;
      }
    
    public Integer getCourseId() {
        return courseId;
    }

      public void setCourseId(Integer courseId) {
          this.courseId = courseId;
      }

    @Override
    public String toString() {
        return "ClassEntity{" +
              ", classId=" + classId +
                  ", courseId=" + courseId +
              "}";
    }
}
