package com.example.sub.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sub.repository.PorkEncnMapper;
import com.example.sub.vo.PorkEncnVO;
import com.example.sub.vo.SubPorkRcptVO;

@Service
public class PorkEncnService {
	
	@Autowired
	private PorkEncnMapper porkMapper;
	
	@Autowired
	private KafkaTemplate<String, PorkEncnVO> kafkaTemplate;
	
	
	/**
	 * PORK 추가되는 케이스 
	 */
	@Transactional
	public void insertEncnPork(Message<SubPorkRcptVO> porkRcptMessage) {
				
		System.out.println("insertEncnPork : " + porkRcptMessage);
		SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		
		PorkEncnVO porkEncnVO = new PorkEncnVO();
		
		/*
		 * 
		 * 접수된 Pork 정보 셋팅
		 * 
		 * */
		SubPorkRcptVO porkRcptVO = porkRcptMessage.getPayload();
		
		porkEncnVO.setPorkId(porkRcptVO.getPorkId());
		porkEncnVO.setPorkNm(porkRcptVO.getPorkNm());
		porkEncnVO.setPorkDetail(porkRcptVO.getPorkDetail());
		
		/*
		 * 
		 * Pork 계약하는 로직 
		 * 
		 * */
        Date dateObj = calendar.getTime();
        String now = dtf.format(dateObj);
        
		porkEncnVO.setPorkEncnDetail("encn complete");
		porkEncnVO.setPorkEncnYn("Y");
		porkEncnVO.setPorkEncnTime(now);
		
		//1.pub서버의 비즈니스 로직 처리
		porkMapper.insertEncnPork(porkEncnVO);
		
					
		//2.Kafka pub
		this.kafkaTemplate.send("pork_encn_from_porkEncnProject", porkEncnVO);
	}
			
}
