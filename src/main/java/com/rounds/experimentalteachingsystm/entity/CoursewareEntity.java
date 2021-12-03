package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-11-08
 */
@TableName("courseware")
public class CoursewareEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "courseware_id", type = IdType.AUTO)
      private Integer coursewareId;

    private String coursewareName;

    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime time;

    private String type;

    private String link;

    private Integer courseId;

    
    public Integer getCoursewareId() {
        return coursewareId;
    }

      public void setCoursewareId(Integer coursewareId) {
          this.coursewareId = coursewareId;
      }
    
    public String getCoursewareName() {
        return coursewareName;
    }

      public void setCoursewareName(String coursewareName) {
          this.coursewareName = coursewareName;
      }
    
    public LocalDateTime getTime() {
        return time;
    }

      public void setTime(LocalDateTime time) {
          this.time = time;
      }
    
    public String getType() {
        return type;
    }

      public void setType(String type) {
          this.type = type;
      }
    
    public String getLink() {
        return link;
    }

      public void setLink(String link) {
          this.link = link;
      }
    
    public Integer getCourseId() {
        return courseId;
    }

      public void setCourseId(Integer courseId) {
          this.courseId = courseId;
      }

    @Override
    public String toString() {
        return "CoursewareEntity{" +
              ", coursewareId=" + coursewareId +
                  ", coursewareName=" + coursewareName +
                  ", time=" + time +
                  ", type=" + type +
                  ", link=" + link +
                  ", courseId=" + courseId +
              "}";
    }
}
