package com.startdemo.convpay.service;

import com.startdemo.convpay.type.*;

public class CardAdaptor implements PaymentInterface{
    // 1. 인증
    public void authorization() {
        System.out.println("authenticate.");
    }
    // 2. 승인
    public void approval() {
        System.out.println("approved.");
    }
    // 3. 매입
    public CardUseResult capture(Integer payAmount) {
        //실패
        if(payAmount > 100) {
            return CardUseResult.USE_FAIL;
        }
        //성공
        return CardUseResult.USE_SUCCESS;
    }
    // 4. 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount) {
        //실패
        if(cancelAmount < 1000){
            return CardUseCancelResult.USE_CANCEL_FAIL;
        }
        //성공
        return CardUseCancelResult.USE_CANCEL_SUCCESS;
    }


    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.CARD;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);
        if(cardUseResult == CardUseResult.USE_FAIL){
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(cancelAmount);
        if(cardUseCancelResult == CardUseCancelResult.USE_CANCEL_FAIL){
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }
        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
