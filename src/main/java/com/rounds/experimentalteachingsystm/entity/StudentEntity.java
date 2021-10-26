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
 * @since 2021-10-25
 */
@TableName("student")
public class StudentEntity implements Serializable {

    @TableId(value = "student_id")
    private String studentId;

    private String studentName;

    private String mailAddr;

    private String studentPwd;

    private Integer gender;

    
    public String getStudentId() {
        return studentId;
    }

      public void setStudentId(String studentId) {
          this.studentId = studentId;
      }
    
    public String getStudentName() {
        return studentName;
    }

      public void setStudentName(String studentName) {
          this.studentName = studentName;
      }
    
    public String getMailAddr() {
        return mailAddr;
    }

      public void setMailAddr(String mailAddr) {
          this.mailAddr = mailAddr;
      }
    
    public String getStudentPwd() {
        return studentPwd;
    }

      public void setStudentPwd(String studentPwd) {
          this.studentPwd = studentPwd;
      }
    
    public Integer getGender() {
        return gender;
    }

      public void setGender(Integer gender) {
          this.gender = gender;
      }

    @Override
    public String toString() {
        return "StudentEntity{" +
              ", studentId=" + studentId +
                  ", studentName=" + studentName +
                  ", mailAddr=" + mailAddr +
                  ", studentPwd=" + studentPwd +
                  ", gender=" + gender +
              "}";
    }
}
