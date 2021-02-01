package com.moon.trackingsystem.entity;

public class ThrowawayAuth {
    private String phone;
    private String tempPass;

    public ThrowawayAuth(String phone, String tempPass) {
        this.phone = phone;
        this.tempPass = tempPass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTempPass() {
        return tempPass;
    }

    public void setTempPass(String tempPass) {
        this.tempPass = tempPass;
    }
}
