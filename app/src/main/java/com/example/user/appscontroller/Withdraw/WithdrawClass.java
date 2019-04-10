package com.example.user.appscontroller.Withdraw;

public class WithdrawClass {

    private String withDrawDate;
    private String userNumber;
    private String paymentMethod;
    private String requestNumber;
    private String Amount;

    public WithdrawClass(String withDrawDate, String userNumber, String paymentMethod, String requestNumber, String amount) {
        this.withDrawDate = withDrawDate;
        this.userNumber = userNumber;
        this.paymentMethod = paymentMethod;
        this.requestNumber = requestNumber;
        this.Amount = amount;
    }

    public WithdrawClass() {
    }

    public String getWithDrawDate() {
        return withDrawDate;
    }

    public void setWithDrawDate(String withDrawDate) {
        this.withDrawDate = withDrawDate;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        this.Amount = amount;
    }
}
