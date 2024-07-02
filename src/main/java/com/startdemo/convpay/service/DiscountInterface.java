package com.startdemo.convpay.service;

import com.startdemo.convpay.dto.PayRequest;

public interface DiscountInterface {
    //할인된 금액을 받는다.
    Integer getDiscountedAmount(PayRequest payRequest);
}
