package com.example.sub.sink;


import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.example.sub.service.PorkEncnService;
import com.example.sub.vo.SubPorkRcptVO;

@Configuration
public class PorkEncnSink {
	
	@Autowired
	private PorkEncnService porkEncnService;
	
	/*
	 * 예전 방식
    @StreamListener(SubChannel.INPUT)
    public void receive(Message<String> message) {
        System.out.println("Received : " + message);
    }
    */
	 
	
	/**
	 * porkRcptProject로 부터 접수받은 PORK를 SUB하는 메소드
	 * 
	 */
	@Bean
    public Consumer<Message<SubPorkRcptVO>> porkInsert() {
        return (porkRcptVO) -> {        	
        	porkEncnService.insertEncnPork(porkRcptVO);        	
        };
    }	
	
	
}
