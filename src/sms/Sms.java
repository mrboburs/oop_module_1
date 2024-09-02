package sms;

import java.time.LocalDateTime;

public class Sms {
    private  Integer id;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    private String phone;
    private   String text;
    private LocalDateTime createdDate;

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
//
//    public Sms(String phone, String text) {
//        this.phone = phone;
//        this.text = text;
//    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
