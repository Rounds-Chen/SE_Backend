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
 * @since 2021-12-01
 */
@TableName("auc_report")
public class AucReportEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 报告id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 拍卖id
     */
      private Integer auctionId;

      /**
     * 学生id
     */
      private String studentId;

      /**
     * 批改人id
     */
      private String markerId;

      /**
     * 得分
     */
      private Integer score;

      /**
     * 提交时间
     */
      @TableField(value = "submit_time",fill= FieldFill.INSERT)
      private LocalDateTime submitTime;

      /**
     * 批改状态
     */
      private Boolean status;

      /**
     * 存储url
     */
      private String fileUrl;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public Integer getAuctionId() {
        return auctionId;
    }

      public void setAuctionId(Integer auctionId) {
          this.auctionId = auctionId;
      }
    
    public String getStudentId() {
        return studentId;
    }

      public void setStudentId(String studentId) {
          this.studentId = studentId;
      }
    
    public String getMarkerId() {
        return markerId;
    }

      public void setMarkerId(String markerId) {
          this.markerId = markerId;
      }
    
    public Integer getScore() {
        return score;
    }

      public void setScore(Integer score) {
          this.score = score;
      }
    
    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

      public void setSubmitTime(LocalDateTime submitTime) {
          this.submitTime = submitTime;
      }
    
    public Boolean getStatus() {
        return status;
    }

      public void setStatus(Boolean status) {
          this.status = status;
      }
    
    public String getFileUrl() {
        return fileUrl;
    }

      public void setFileUrl(String fileUrl) {
          this.fileUrl = fileUrl;
      }

    @Override
    public String toString() {
        return "AucReportEntity{" +
              ", id=" + id +
                  ", auctionId=" + auctionId +
                  ", studentId=" + studentId +
                  ", markerId=" + markerId +
                  ", score=" + score +
                  ", submitTime=" + submitTime +
                  ", status=" + status +
                  ", fileUrl=" + fileUrl +
              "}";
    }
}
