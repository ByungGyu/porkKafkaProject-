package com.example.sub.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.example.sub.vo.PorkEncnVO;

@Mapper
public interface PorkEncnMapper {
	
	@Insert("INSERT INTO PORK_ENCN"
			+ "(PORK_ID,PORK_NM,PORK_DETAIL,PORK_ENCN_DETAIL,PORK_ENCN_YN,PORK_ENCN_TIME) "
			+ "VALUES(#{porkId},#{porkNm},#{porkDetail},#{porkEncnDetail},#{porkEncnYn},TO_DATE(#{porkEncnTime}, 'yyyyMMddHH24miss'))")
    void insertEncnPork(PorkEncnVO porkVO);
	
}