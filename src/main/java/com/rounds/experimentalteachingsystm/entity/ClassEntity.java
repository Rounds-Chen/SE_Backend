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
 * @since 2021-12-04
 */
@TableName("class")
public class ClassEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "class_id", type = IdType.AUTO)
      private Integer classId;

    private Integer courseId;

    private String instructorId;

    private String assistantId;

    private Integer stuNum;

    private Integer expNum;

    
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
    
    public String getInstructorId() {
        return instructorId;
    }

      public void setInstructorId(String instructorId) {
          this.instructorId = instructorId;
      }
    
    public String getAssistantId() {
        return assistantId;
    }

      public void setAssistantId(String assistantId) {
          this.assistantId = assistantId;
      }
    
    public Integer getStuNum() {
        return stuNum;
    }

      public void setStuNum(Integer stuNum) {
          this.stuNum = stuNum;
      }
    
    public Integer getExpNum() {
        return expNum;
    }

      public void setExpNum(Integer expNum) {
          this.expNum = expNum;
      }

    @Override
    public String toString() {
        return "ClassEntity{" +
              ", classId=" + classId +
                  ", courseId=" + courseId +
                  ", instructorId=" + instructorId +
                  ", assistantId=" + assistantId +
                  ", stuNum=" + stuNum +
                  ", expNum=" + expNum +
              "}";
    }
}
