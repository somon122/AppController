package com.example.user.appscontroller;

public class RulesUpload {

    private String question;
    private String banglaAns;
    private String englishAns;

    public RulesUpload(String question, String banglaAns, String englishAns) {
        this.question = question;
        this.banglaAns = banglaAns;
        this.englishAns = englishAns;
    }

    public RulesUpload() {
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setBanglaAns(String banglaAns) {
        this.banglaAns = banglaAns;
    }

    public void setEnglishAns(String englishAns) {
        this.englishAns = englishAns;
    }

    public String getQuestion() {
        return question;
    }

    public String getBanglaAns() {
        return banglaAns;
    }

    public String getEnglishAns() {
        return englishAns;
    }
}
