package com.startdemo.convpay;

import com.startdemo.convpay.config.ApplicationConfig;
import com.startdemo.convpay.dto.PayCancelRequset;
import com.startdemo.convpay.dto.PayCancelResponse;
import com.startdemo.convpay.dto.PayRequest;
import com.startdemo.convpay.dto.PayResponse;
import com.startdemo.convpay.service.ConveniencePayService;
import com.startdemo.convpay.type.ConvenienceType;
import com.startdemo.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // AppContext를 만들면서, 이전에 만든 AppConfig를 참조해서 만듬
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // Bean으로 등록할 클래스를 가져와서 사용, 등록된 Bean의 함수 이름과 동일해야한다.
        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService",ConveniencePayService.class);

        // 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);
        // 취소 500원
        PayCancelRequset payCancelRequest = new PayCancelRequset(PayMethodType.MONEY,ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
