package com.example.pub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.example.pub.repository.PorkMapper;
import com.example.pub.vo.PorkRcptVO;
import com.example.pub.vo.SubPorkEncnVO;
import com.example.pub.vo.SubPorkOfferVO;

@Service
public class PorkRcptService {
	
	@Autowired
	private PorkMapper porkMapper;
	
	@Autowired
	private KafkaTemplate<String, PorkRcptVO> kafkaTemplate;
		
	/**
	 * PORK 추가되는 케이스 
	 */
	public void insertPork(PorkRcptVO porkRcptVO) {
		System.out.println("insertPork : " + porkRcptVO);
		

		/*
		 * 
		 * Pork 접수하는 로직 
		 * 
		 * */
		porkMapper.insertPork(porkRcptVO);
					
		
		
		//2.Kafka pub
		this.kafkaTemplate.send("pork_insert_from_porkRcptProject", porkRcptVO);
	}
	
	/**
	 * 계약된 Pork정보 반영
	 */
	public void updateEncnPork(Message<SubPorkEncnVO> subPorkEncnMessage) {
				
		System.out.println("updateEncnPork : " + subPorkEncnMessage);
		
		
		/*
		 * 
		 * 계약된 Pork 정보 셋팅
		 * 
		 * */
		SubPorkEncnVO subPorkEncnVO = subPorkEncnMessage.getPayload();
		
		
		PorkRcptVO porkRcptVO = new PorkRcptVO();
		porkRcptVO.setPorkId(subPorkEncnVO.getPorkId());
		porkRcptVO.setPorkEncnYn(subPorkEncnVO.getPorkEncnYn());
		porkRcptVO.setPorkEncnTime(subPorkEncnVO.getPorkEncnTime());
				
		//계약된 Pork 정보 update
		porkMapper.updateEncnPork(porkRcptVO);
						
	}
	
	/**
	 * 오퍼된 Pork정보 반영
	 */
	public void updateOfferPork(Message<SubPorkOfferVO> subPorkOfferMessage) {
				
		System.out.println("updateOfferPork : " + subPorkOfferMessage);
		
		
		/*
		 * 
		 * 계약된 Pork 정보 셋팅
		 * 
		 * */
		SubPorkOfferVO subPorkOfferVO = subPorkOfferMessage.getPayload();
		
		
		PorkRcptVO porkRcptVO = new PorkRcptVO();
		porkRcptVO.setPorkId(subPorkOfferVO.getPorkId());
		porkRcptVO.setPorkOfferYn(subPorkOfferVO.getPorkOfferYn());
		porkRcptVO.setPorkOfferTime(subPorkOfferVO.getPorkOfferTime());
				
		//오펀된 Pork 정보 update
		porkMapper.updateOfferPork(porkRcptVO);
						
	}
	

	/**
	 * PORK 세부사항 변경
	 */
	public void updatePorkDetail(PorkRcptVO porkRcptVO) {
		System.out.println("insertPork : " + porkRcptVO);
		
		//1.pubProject별 비즈니스 로직 처리
		porkMapper.updatePorkDetail(porkRcptVO);
					
		//2.Kafka pub
		this.kafkaTemplate.send("pork_update_from_porkRcptProject", porkRcptVO);						
	}
	
	
		
}
