package com.startdemo.convpay.service;

import com.startdemo.convpay.dto.*;
import com.startdemo.convpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService {
    // 구현체를 직접 넣어주지 않음
    private final Map<PayMethodType,PaymentInterface> paymentInterfaceMap = new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet, DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(),paymentInterface
                )
        );

        this.discountInterface = discountInterface;
    }

    // 요청을 받아서 응답을 전달
    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());
        
        //인터페이스를 통해서 결제 실시
        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        //실패케이스
        if(paymentResult == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL,0);
        }
        //예외케이스

        //성공케이스
        return new PayResponse(PayResult.SUCESS, discountedAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequset payCancelRequset) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequset.getPayMethodType());

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequset.getPayCancelAmount());

        //실패케이스
        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL,0);
        }
        //성공케이스
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,payCancelRequset.getPayCancelAmount());
    }

}
