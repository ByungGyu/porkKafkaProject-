package com.example.sub.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.sub.vo.PorkOfferVO;

@Mapper
public interface PorkOfferMapper {
	
	@Insert("INSERT INTO PORK_OFFER"
			+ "(PORK_ID,PORK_NM,PORK_DETAIL,PORK_OFFER_DETAIL,PORK_OFFER_YN,PORK_OFFER_TIME) "
			+ "VALUES(#{porkId},#{porkNm},#{porkDetail},#{porkOfferDetail},#{porkOfferYn},TO_DATE(#{porkOfferTime}, 'yyyyMMddHH24miss'))")
    void insertOfferPork(PorkOfferVO porkOfferVO);
	
}


