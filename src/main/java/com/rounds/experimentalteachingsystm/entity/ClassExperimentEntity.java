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
 * @since 2021-10-25
 */
@TableName("class_experiment")
public class ClassExperimentEntity implements Serializable {

      @MppMultiId
      @TableField(value = "class_id")
      private Integer classId;

      @MppMultiId
      @TableField(value = "exper_id")
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
