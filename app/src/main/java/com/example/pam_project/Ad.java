package com.example.pam_project;

public class Ad {
    String title;
    String content;
    String phone;
    String UserId;

    public Ad(String title, String content, String phone, String userId) {
        this.title = title;
        this.content = content;
        this.phone = phone;
        UserId = userId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
