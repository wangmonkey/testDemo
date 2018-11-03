package com.entity.user;

import java.util.Date;

/**
 * @version ： 1.0.0
 * @package : com.entity.user
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月12日下午2:33
 */
public class User {
    private String userName;
    private String sex;
    private Date birthday;
    private Integer age;

    public User(String userName,String sex,Integer age, Date birthday){
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals( Object obj ) {

        if (obj == null){
            return false;
        }
        User user = (User) obj;
        return (getAge().equals(user.getAge()) && getBirthday().equals(user.getBirthday()) && getSex().equals(user.getSex()) && getUserName().equals(user.getUserName()));
    }

    public int hasCode() {
        return this.userName.hashCode() + this.birthday.hashCode() + this.sex.hashCode() + this.age.hashCode();
    }


}
