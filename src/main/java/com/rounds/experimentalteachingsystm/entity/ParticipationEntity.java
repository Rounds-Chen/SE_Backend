package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@TableName("participation")
public class ParticipationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 参与id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 参与人id
     */
      private String userId;

      /**
     * 参与角色：0-供给 1-需求
     */
      private Boolean role;

      /**
     * 出价
     */
      private BigDecimal price;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getUserId() {
        return userId;
    }

      public void setUserId(String userId) {
          this.userId = userId;
      }
    
    public Boolean getRole() {
        return role;
    }

      public void setRole(Boolean role) {
          this.role = role;
      }
    
    public BigDecimal getPrice() {
        return price;
    }

      public void setPrice(BigDecimal price) {
          this.price = price;
      }

    @Override
    public String toString() {
        return "ParticipationEntity{" +
              ", id=" + id +
                  ", userId=" + userId +
                  ", role=" + role +
                  ", price=" + price +
              "}";
    }
}
