package com.startdemo.convpay.config;

import com.startdemo.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration // DI 컨테이너 설정
public class ApplicationConfig {

    @Bean // 스프링 컨테이너에 의해서 관리되는 메소드
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(
                new HashSet<>(Arrays.asList(MoneyAdaptor(), CardAdaptor())), discountByConvenience()
        );
    }

    @Bean
    public CardAdaptor CardAdaptor() {
        return new CardAdaptor();
    }

    @Bean
    public MoneyAdaptor MoneyAdaptor() {
        return new MoneyAdaptor();
    }

    @Bean
    public DiscountByConvenience discountByConvenience() {
        return new DiscountByConvenience();
    }
}
