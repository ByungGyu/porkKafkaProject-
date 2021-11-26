package com.example.sub.vo;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Alias("SubPorkRcptVO")
@Data
public class SubPorkRcptVO {
	
	private String porkId;
	private String porkNm;
	private String porkDetail;
	
		
	public String getPorkId() {
		return porkId;
	}
	public void setPorkId(String porkId) {
		this.porkId = porkId;
	}
	public String getPorkNm() {
		return porkNm;
	}
	public void setPorkNm(String porkNm) {
		this.porkNm = porkNm;
	}
	public String getPorkDetail() {
		return porkDetail;
	}
	public void setPorkDetail(String porkDetail) {
		this.porkDetail = porkDetail;
	}
	
	
}
