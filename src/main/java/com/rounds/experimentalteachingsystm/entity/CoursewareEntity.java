package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@TableName("courseware")
public class CoursewareEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer coursewareId;

    private String coursewareName;

    private LocalDateTime time;

    private String type;

    private String link;

    
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

    @Override
    public String toString() {
        return "CoursewareEntity{" +
              ", coursewareId=" + coursewareId +
                  ", coursewareName=" + coursewareName +
                  ", time=" + time +
                  ", type=" + type +
                  ", link=" + link +
              "}";
    }
}
