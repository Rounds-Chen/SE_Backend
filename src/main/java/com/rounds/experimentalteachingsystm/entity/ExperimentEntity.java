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
@TableName("experiment")
public class ExperimentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "exper_id", type = IdType.AUTO)
      private Integer experId;

    private String experName;

    private String demonds;

    private LocalDateTime deadline;

    private Float weight;

    private Float fullmark;

    
    public Integer getExperId() {
        return experId;
    }

      public void setExperId(Integer experId) {
          this.experId = experId;
      }
    
    public String getExperName() {
        return experName;
    }

      public void setExperName(String experName) {
          this.experName = experName;
      }
    
    public String getDemonds() {
        return demonds;
    }

      public void setDemonds(String demonds) {
          this.demonds = demonds;
      }
    
    public LocalDateTime getDeadline() {
        return deadline;
    }

      public void setDeadline(LocalDateTime deadline) {
          this.deadline = deadline;
      }
    
    public Float getWeight() {
        return weight;
    }

      public void setWeight(Float weight) {
          this.weight = weight;
      }
    
    public Float getFullmark() {
        return fullmark;
    }

      public void setFullmark(Float fullmark) {
          this.fullmark = fullmark;
      }

    @Override
    public String toString() {
        return "ExperimentEntity{" +
              ", experId=" + experId +
                  ", experName=" + experName +
                  ", demonds=" + demonds +
                  ", deadline=" + deadline +
                  ", weight=" + weight +
                  ", fullmark=" + fullmark +
              "}";
    }
}
