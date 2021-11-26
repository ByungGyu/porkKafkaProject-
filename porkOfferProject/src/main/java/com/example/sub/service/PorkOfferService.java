package com.example.sub.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sub.repository.PorkOfferMapper;
import com.example.sub.vo.PorkOfferVO;
import com.example.sub.vo.SubPorkRcptVO;

@Service
public class PorkOfferService {
		
	
	@Autowired
	private PorkOfferMapper porkMapper;
	
	@Autowired
	private KafkaTemplate<String, PorkOfferVO> kafkaTemplate;
	
	
	/**
	 * PORK 추가되는 케이스 
	 */
	@Transactional
	public void insertOfferPork(Message<SubPorkRcptVO> porkRcptMessage) {
				
		System.out.println("insertOfferPork : " + porkRcptMessage);
		SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		PorkOfferVO porkOfferVO = new PorkOfferVO();
		
		/*
		 * 
		 * 접수된 Pork 정보 셋팅
		 * 
		 * */
		SubPorkRcptVO porkRcptVO = porkRcptMessage.getPayload();
		
		porkOfferVO.setPorkId(porkRcptVO.getPorkId());
		porkOfferVO.setPorkNm(porkRcptVO.getPorkNm());
		porkOfferVO.setPorkDetail(porkRcptVO.getPorkDetail());
		
		/*
		 * 
		 * Pork 주문하는 로직
		 * 
		 * */
		
		
      

        Date dateObj = calendar.getTime();
        String now = dtf.format(dateObj);
		
		porkOfferVO.setPorkOfferDetail("offer complete");
		porkOfferVO.setPorkOfferYn("Y");
		porkOfferVO.setPorkOfferTime(now);
		
		//1.pub서버의 비즈니스 로직 처리
		porkMapper.insertOfferPork(porkOfferVO);
		
					
		//2.Kafka pub
		this.kafkaTemplate.send("pork_offer_from_porkOfferProject", porkOfferVO);
	}
			
}
