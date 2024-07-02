package com.startdemo.convpay.service;

import com.startdemo.convpay.type.CardUseCancelResult;
import com.startdemo.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdaptorTest {
    private CardAdaptor cardAdaptor = new CardAdaptor();

    @Test
    void capture_success() {
        //given
        Integer payAmount = 99;
        //when
        CardUseResult cardUseResult = cardAdaptor.capture(payAmount);
        //then
        assertEquals(CardUseResult.USE_SUCCESS,cardUseResult);
    }

    @Test
    void capture_fail() {
        //given
        Integer payAmount = 101;
        //when
        CardUseResult cardUseResult = cardAdaptor.capture(payAmount);
        //then
        assertEquals(CardUseResult.USE_FAIL,cardUseResult);
    }

    @Test
    void cancel_capture_success() {
        //given
        Integer cancelAmount = 1001;
        //when
        CardUseCancelResult cardUseCancelResult = cardAdaptor.cancelCapture(cancelAmount);
        //then
        assertEquals(CardUseCancelResult.USE_CANCEL_SUCCESS,cardUseCancelResult);
    }

    @Test
    void cancel_capture_fail() {
        //given
        Integer cancelAmount = 999;
        //when
        CardUseCancelResult cardUseCancelResult = cardAdaptor.cancelCapture(cancelAmount);
        //then
        assertEquals(CardUseCancelResult.USE_CANCEL_FAIL,cardUseCancelResult);
    }

}