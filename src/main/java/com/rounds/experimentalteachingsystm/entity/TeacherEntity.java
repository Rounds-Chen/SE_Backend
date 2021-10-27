package com.rounds.experimentalteachingsystm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@TableName("teacher")
public class TeacherEntity implements Serializable {

    @TableId(value = "teacher_id")
    private String teacherId;

    private String teacherName;

    private String mailAddr;

    private String teacherPwd;

    private String identity;

    private Boolean authority;

    private Boolean gender;

    
    public String getTeacherId() {
        return teacherId;
    }

      public void setTeacherId(String teacherId) {
          this.teacherId = teacherId;
      }
    
    public String getTeacherName() {
        return teacherName;
    }

      public void setTeacherName(String teacherName) {
          this.teacherName = teacherName;
      }
    
    public String getMailAddr() {
        return mailAddr;
    }

      public void setMailAddr(String mailAddr) {
          this.mailAddr = mailAddr;
      }
    
    public String getTeacherPwd() {
        return teacherPwd;
    }

      public void setTeacherPwd(String teacherPwd) {
          this.teacherPwd = teacherPwd;
      }
    
    public String getIdentity() {
        return identity;
    }

      public void setIdentity(String identity) {
          this.identity = identity;
      }
    
    public Boolean getAuthority() {
        return authority;
    }

      public void setAuthority(Boolean authority) {
          this.authority = authority;
      }
    
    public Boolean getGender() {
        return gender;
    }

      public void setGender(Boolean gender) {
          this.gender = gender;
      }

    @Override
    public String toString() {
        return "TeacherEntity{" +
              ", teacherId=" + teacherId +
                  ", teacherName=" + teacherName +
                  ", mailAddr=" + mailAddr +
                  ", teacherPwd=" + teacherPwd +
                  ", identity=" + identity +
                  ", authority=" + authority +
                  ", gender=" + gender +
              "}";
    }
}
