package com.view.anymo.anymotable;

import java.sql.Date;

public class User {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String Education;
    private Date creattime;

    public User() {
    }

    public User(String id, String name, String age, String gender, String education, Date creattime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        Education = education;
        this.creattime = creattime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", Education='" + Education + '\'' +
                ", creattime=" + creattime +
                '}';
    }
}
