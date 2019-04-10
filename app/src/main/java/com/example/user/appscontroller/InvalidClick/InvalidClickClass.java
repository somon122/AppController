package com.example.user.appscontroller.InvalidClick;

public class InvalidClickClass {

    private String phoneNo;
    private String invalidClic;

    public InvalidClickClass(String phoneNo, String invalidClic) {
        this.phoneNo = phoneNo;
        this.invalidClic = invalidClic;
    }

    public InvalidClickClass() {
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getInvalidClic() {
        return invalidClic;
    }

    public void setInvalidClic(String invalidClic) {
        this.invalidClic = invalidClic;
    }
}

