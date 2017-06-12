package com.hanbit.contactsapp.domain;

/**
 * Created by hb2000 on 2017-06-03.
 CREATE TABLE Member (
    seq int,
    name varchar(20),
    password varchar(10),
    email varchar(20),
    phone varchar(20),
    addr varchar(20),
    photo varchar(20)
 );
 */

public class Member {
    private int seq;
    private String name,password,email,phone,addr,photo;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "회원{" +
                "ID=" + seq +
                ", 이름='" + name + '\'' +
                ", 비번='" + password + '\'' +
                ", 이메일='" + email + '\'' +
                ", 전화번호='" + phone + '\'' +
                ", 주소='" + addr + '\'' +
                ", 프로필사진='" + photo + '\'' +
                '}';
    }
}
