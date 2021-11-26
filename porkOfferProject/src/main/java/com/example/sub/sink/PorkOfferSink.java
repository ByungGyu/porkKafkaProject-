package com.example.sub.sink;


import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;

import com.example.sub.service.PorkOfferService;
import com.example.sub.vo.SubPorkRcptVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class PorkOfferSink {
	
	@Autowired
	private PorkOfferService porkOfferService;
	
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
        	porkOfferService.insertOfferPork(porkRcptVO);
        };
    }	
	
	
}
