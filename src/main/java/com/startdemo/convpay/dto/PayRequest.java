package com.startdemo.convpay.dto;

import com.startdemo.convpay.type.ConvenienceType;
import com.startdemo.convpay.type.PayMethodType;

public class PayRequest {
    //결제 수단
    PayMethodType payMethodType;

    //편의점 종류
    ConvenienceType convenienceType;

    //결제 금액
    Integer PayAmount;

    public PayRequest(PayMethodType payMethodType,ConvenienceType convenienceType, Integer payAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.PayAmount = payAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.PayAmount = payAmount;
    }
}
