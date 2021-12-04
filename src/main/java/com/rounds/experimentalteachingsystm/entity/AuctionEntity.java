package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@TableName("auction")
public class AuctionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 拍卖id	
     */
        @TableId(value = "auction_id", type = IdType.AUTO)
      private Integer auctionId;

      /**
     * 发起人id
     */
      private String initiatorId;

    /**
     * 拍卖详情
     */
    private String description;

    /**
     * 拍卖名称
     */
      private String auctionTitle;

      /**
     * 发起时间
     */
      private LocalDateTime startTime;

      /**
     * 结束时间
     */
      private LocalDateTime endTime;

      /**
     * 供给平衡价格点
     */
      private BigDecimal balancePrice;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

      public void setAuctionId(Integer auctionId) {
          this.auctionId = auctionId;
      }
    
    public String getInitiatorId() {
        return initiatorId;
    }

      public void setInitiatorId(String initiatorId) {
          this.initiatorId = initiatorId;
      }
    
    public String getAuctionTitle() {
        return auctionTitle;
    }

      public void setAuctionTitle(String auctionTitle) {
          this.auctionTitle = auctionTitle;
      }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }

      public void setStartTime(LocalDateTime startTime) {
          this.startTime = startTime;
      }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }

      public void setEndTime(LocalDateTime endTime) {
          this.endTime = endTime;
      }
    
    public BigDecimal getBalancePrice() {
        return balancePrice;
    }

      public void setBalancePrice(BigDecimal balancePrice) {
          this.balancePrice = balancePrice;
      }

    @Override
    public String toString() {
        return "AuctionEntity{" +
              ", auctionId=" + auctionId +
                  ", initiatorId=" + initiatorId +
                  ", auctionTitle=" + auctionTitle +
                  ", startTime=" + startTime +
                  ", endTime=" + endTime +
                  ", balancePrice=" + balancePrice +
              "}";
    }
}
