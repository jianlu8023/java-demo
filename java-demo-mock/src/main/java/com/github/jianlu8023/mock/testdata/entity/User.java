package com.github.jianlu8023.mock.testdata.entity;

import java.io.*;
import java.util.*;

public class User implements Serializable {


    private Long uid;

    /**
     * 用户名
     */

    private String userName;

    /**
     * 用户昵称
     */

    private String userNick;

    /**
     * 用户年龄
     */

    private Integer userAge;

    /**
     * 用户emial
     */

    private String userEmail;

    /**
     * 用户性别
     */

    private Integer userGender;

    /**
     * 用户身份证号
     */
    private String userId;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 更新信息时间
     */
    private Date updateTime;

    private String address;

    public User() {
    }


    public User(Long uid, String userName, String userNick, Integer userAge, String userEmail, Integer userGender, String userId, Date createTime, Date updateTime, String address) {
        this.uid = uid;
        this.userName = userName;
        this.userNick = userNick;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.address = address;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(userName, user.userName) && Objects.equals(userNick, user.userNick) && Objects.equals(userAge, user.userAge) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userGender, user.userGender) && Objects.equals(userId, user.userId) && Objects.equals(createTime, user.createTime) && Objects.equals(updateTime, user.updateTime) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, userName, userNick, userAge, userEmail, userGender, userId, createTime, updateTime, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                ", userGender=" + userGender +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", address='" + address + '\'' +
                '}';
    }
}
