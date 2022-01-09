package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Blob;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2022-01-08
 */
@TableName("auc_report_2")
public class AucReport2Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

      private String id;

    private Blob content;

    private Integer score;

    private String aucTitle;

    public String getAucTitle() {
        return aucTitle;
    }

    public void setAucTitle(String aucTitle) {
        this.aucTitle = aucTitle;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

      public void setName(String name) {
          this.name = name;
      }
    
    public String getId() {
        return id;
    }

      public void setId(String id) {
          this.id = id;
      }
    
    public Blob getContent() {
        return content;
    }

      public void setContent(Blob content) {
          this.content = content;
      }

    @Override
    public String toString() {
        return "AucReport2Entity{" +
              ", name=" + name +
                  ", id=" + id +
                  ", content=" + content +
              "}";
    }
}
