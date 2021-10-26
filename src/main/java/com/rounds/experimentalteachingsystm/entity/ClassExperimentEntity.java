package com.rounds.experimentalteachingsystm.entity;

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
@TableName("class_experiment")
public class ClassExperimentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer classId;

      private Integer experId;

    
    public Integer getClassId() {
        return classId;
    }

      public void setClassId(Integer classId) {
          this.classId = classId;
      }
    
    public Integer getExperId() {
        return experId;
    }

      public void setExperId(Integer experId) {
          this.experId = experId;
      }

    @Override
    public String toString() {
        return "ClassExperimentEntity{" +
              ", classId=" + classId +
                  ", experId=" + experId +
              "}";
    }
}
