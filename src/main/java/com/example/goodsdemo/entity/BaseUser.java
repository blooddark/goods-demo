package com.example.goodsdemo.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * @author 崔诗新Eddy
 * @date 2019-3-20
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseUser {
    @Id
    @GeneratedValue
    private String id;
    private String password;
    private String state;
    private String img;
    private String name;
    private String mobile;
    private String gender;
    private java.sql.Date birthday;
    private String role;
    private java.sql.Timestamp time;
    private Integer isDelete;
    private Double balanceAmount;
    private String company;
    private Double consumeAmount;
    private String email;
    private String interest;
    private String nickname;
    private String pid;
    private String realname;
    private String remark;
    private String roleId;
    private String signature;
    private Integer sort;
}
