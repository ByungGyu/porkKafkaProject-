package com.example.pub.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.example.pub.vo.PorkRcptVO;

@Mapper
public interface PorkMapper {
	
	@Insert("INSERT INTO PORK(PORK_ID,PORK_NM,PORK_DETAIL,PORK_RCPT_TIME,PORK_ENCN_YN,PORK_OFFER_YN)"
			+ " VALUES(#{porkId},#{porkNm},#{porkDetail},SYSDATE,'N','N')")
    void insertPork(PorkRcptVO porkRcptVO);
	
	
	@Update("UPDATE PORK SET PORK_ENCN_YN=#{porkEncnYn}, PORK_ENCN_TIME = TO_DATE(#{porkEncnTime}, 'yyyyMMddHH24miss')"
			+ " WHERE PORK_ID=#{porkId}")
	void updateEncnPork(PorkRcptVO porkRcptVO);
	
	
	@Update("UPDATE PORK SET PORK_OFFER_YN=#{porkOfferYn}, PORK_OFFER_TIME = TO_DATE(#{porkOfferTime}, 'yyyyMMddHH24miss')"
			+ " WHERE PORK_ID=#{porkId}")
	void updateOfferPork(PorkRcptVO porkRcptVO);
	
	
	@Update("UPDATE PORK SET PORK_DATAIL=#{porkDetail} WHERE PORK_ID=#{porkId}")
	void updatePorkDetail(PorkRcptVO porkVO);
}