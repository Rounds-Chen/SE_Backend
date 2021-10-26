package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@TableName("report")
public class ReportEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "report_id", type = IdType.AUTO)
      private Integer reportId;

    private String title;

    private Boolean status;

    private String experId;

    private String studentId;

    private LocalDateTime submitTime;

    private Integer score;

    private String marker;

    
    public Integer getReportId() {
        return reportId;
    }

      public void setReportId(Integer reportId) {
          this.reportId = reportId;
      }
    
    public String getTitle() {
        return title;
    }

      public void setTitle(String title) {
          this.title = title;
      }
    
    public Boolean getStatus() {
        return status;
    }

      public void setStatus(Boolean status) {
          this.status = status;
      }
    
    public String getExperId() {
        return experId;
    }

      public void setExperId(String experId) {
          this.experId = experId;
      }
    
    public String getStudentId() {
        return studentId;
    }

      public void setStudentId(String studentId) {
          this.studentId = studentId;
      }
    
    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

      public void setSubmitTime(LocalDateTime submitTime) {
          this.submitTime = submitTime;
      }
    
    public Integer getScore() {
        return score;
    }

      public void setScore(Integer score) {
          this.score = score;
      }
    
    public String getMarker() {
        return marker;
    }

      public void setMarker(String marker) {
          this.marker = marker;
      }

    @Override
    public String toString() {
        return "ReportEntity{" +
              ", reportId=" + reportId +
                  ", title=" + title +
                  ", status=" + status +
                  ", experId=" + experId +
                  ", studentId=" + studentId +
                  ", submitTime=" + submitTime +
                  ", score=" + score +
                  ", marker=" + marker +
              "}";
    }
}
