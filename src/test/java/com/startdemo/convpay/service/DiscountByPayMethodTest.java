package com.startdemo.convpay.service;

import com.startdemo.convpay.dto.PayRequest;
import com.startdemo.convpay.type.ConvenienceType;
import com.startdemo.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountTest() {
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25,1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD, ConvenienceType.G25,1000);
        //when
        Integer discountedAmountMoney = discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCard = discountByPayMethod.getDiscountedAmount(payRequestCard);
        //then
        assertEquals(700,discountedAmountMoney);
        assertEquals(1000,discountedAmountCard);
    }

}