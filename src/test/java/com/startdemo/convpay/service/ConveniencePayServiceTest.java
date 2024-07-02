package com.startdemo.convpay.service;

import com.startdemo.convpay.dto.PayCancelRequset;
import com.startdemo.convpay.dto.PayCancelResponse;
import com.startdemo.convpay.type.ConvenienceType;
import com.startdemo.convpay.dto.PayRequest;
import com.startdemo.convpay.dto.PayResponse;
import com.startdemo.convpay.type.PayCancelResult;
import com.startdemo.convpay.type.PayMethodType;
import com.startdemo.convpay.type.PayResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService(
            new HashSet<>(
                    Arrays.asList(new MoneyAdaptor(),new CardAdaptor())
            ),
            new DiscountByConvenience()
    );

    @Test
    void pay_success() {
        //given
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,ConvenienceType.G25, 50);

        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then
        assertEquals(PayResult.SUCESS,payResponse.getPayResult());
        assertEquals(40,payResponse.getPaidAmount());
    }

    @Test
    void pay_fail() {
        //given
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,ConvenienceType.G25, 1500_001);

        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then
        assertEquals(PayResult.FAIL,payResponse.getPayResult());
        assertEquals(0,payResponse.getPaidAmount());
    }

    @Test
    void pay_cancel_success() {
        //given
        PayCancelRequset payCancelRequset = new PayCancelRequset(PayMethodType.MONEY,ConvenienceType.G25,1000);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequset);
        //then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS,payCancelResponse.getPayCancelResult());
        assertEquals(1000,payCancelResponse.getPayCancelAmount());
    }

    @Test
    void pay_cancel_fail() {
        //given
        PayCancelRequset payCancelRequset = new PayCancelRequset(PayMethodType.MONEY,ConvenienceType.G25,99);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequset);
        //then
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL,payCancelResponse.getPayCancelResult());
        assertEquals(0,payCancelResponse.getPayCancelAmount());
    }
}