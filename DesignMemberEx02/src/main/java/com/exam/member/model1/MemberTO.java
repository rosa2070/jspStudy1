package com.exam.member.model1;

import java.time.LocalDate;

public class MemberTO {
    private String id;
    private String password;
    private String name;
    private String gender;
    private String birth;
    private String mail;
    private String phone;
    private String address;
    private String registDay; // 이 필드는 문자열로 사용하거나 필요에 따라 LocalDateTime으로 변경할 수 있습니다.

    // getter, setter 메서드 예시
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistDay() {
        return registDay;
    }

    public void setRegistDay(String registDay) {
        this.registDay = registDay;
    }
}
