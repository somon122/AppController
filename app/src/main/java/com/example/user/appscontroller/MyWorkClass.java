package com.example.user.appscontroller;

public class MyWorkClass {

    private String workImageUrl;
    private String workDescription;

    public MyWorkClass(String workImageUrl, String workDescription) {
        this.workImageUrl = workImageUrl;
        this.workDescription = workDescription;
    }

    public MyWorkClass() {
    }

    public String getWorkImageUrl() {
        return workImageUrl;
    }

    public void setWorkImageUrl(String workImageUrl) {
        this.workImageUrl = workImageUrl;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }
}
