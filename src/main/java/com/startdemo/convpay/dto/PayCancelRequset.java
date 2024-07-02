package com.startdemo.convpay.dto;

import com.startdemo.convpay.type.ConvenienceType;
import com.startdemo.convpay.type.PayMethodType;

public class PayCancelRequset {
    //결제 수단
    PayMethodType payMethodType;
    //편의점 종류
    ConvenienceType convenienceType;
    //취소 금액
    Integer payCancelAmount;

    public PayCancelRequset(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payCancelAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
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

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }
}
