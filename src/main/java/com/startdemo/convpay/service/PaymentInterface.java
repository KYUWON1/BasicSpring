package com.startdemo.convpay.service;

import com.startdemo.convpay.type.CancelPaymentResult;
import com.startdemo.convpay.type.PayMethodType;
import com.startdemo.convpay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
