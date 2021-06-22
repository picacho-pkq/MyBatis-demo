package com.pikacho.entity;

import java.util.Date;

public class Student {
    private Integer student_id;
    private String name;
    private String phone;
    private String email;
    private Integer sex;
    private Integer locked;
    private Date gmt_created;
    private Date gmt_modified;
    private Integer delete;

    public Student() {
    }

    public Student(Integer student_id, String name, String phone, String email, Integer sex, Integer locked, Date gmt_created, Date gmt_modified, Integer delete) {
        this.student_id = student_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.locked = locked;
        this.gmt_created = gmt_created;
        this.gmt_modified = gmt_modified;
        this.delete = delete;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getLocked() {
        return locked;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public Integer getDelete() {
        return delete;
    }


    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", locked=" + locked +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
                ", delete=" + delete +
                '}';
    }
}
