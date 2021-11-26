package com.example.pub.sink;


import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.example.pub.service.PorkRcptService;
import com.example.pub.vo.SubPorkEncnVO;
import com.example.pub.vo.SubPorkOfferVO;

@Configuration
public class PorkRcptSink {
	
	@Autowired
	private PorkRcptService porkRcptService;
	
	/*
	 * 예전 방식
    @StreamListener(SubChannel.INPUT)
    public void receive(Message<String> message) {
        System.out.println("Received : " + message);
    }
    */
	 
	
	/**
	 * porkEncnProject로 부터 계약된 PORK를 SUB하는 메소드
	 * 
	 */
	@Bean
    public Consumer<Message<SubPorkEncnVO>> updateEncnPork() {
        return (porkRcptVO) -> {        	
        	porkRcptService.updateEncnPork(porkRcptVO);
        };
    }	
	
	
	/**
	 * porkOfferProject로 부터 오퍼된 PORK를 SUB하는 메소드
	 * 
	 */
	@Bean
    public Consumer<Message<SubPorkOfferVO>> updateOfferPork() {
        return (porkRcptVO) -> {        	
        	porkRcptService.updateOfferPork(porkRcptVO);
        };
    }	
	
}
