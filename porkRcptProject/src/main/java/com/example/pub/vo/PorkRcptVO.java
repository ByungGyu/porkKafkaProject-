package com.example.pub.vo;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Alias("PorkRcptVO")
@Data
public class PorkRcptVO {
	
	private String porkId;
	private String porkNm;
	private String porkDetail;
	private String porkEncnYn;
	private String porkEncnTime;
	private String porkOfferYn;
	private String porkOfferTime;
	
	
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
	public String getPorkEncnYn() {
		return porkEncnYn;
	}
	public void setPorkEncnYn(String porkEncnYn) {
		this.porkEncnYn = porkEncnYn;
	}
	public String getPorkEncnTime() {
		return porkEncnTime;
	}
	public void setPorkEncnTime(String porkEncnTime) {
		this.porkEncnTime = porkEncnTime;
	}
	public String getPorkOfferYn() {
		return porkOfferYn;
	}
	public void setPorkOfferYn(String porkOfferYn) {
		this.porkOfferYn = porkOfferYn;
	}
	public String getPorkOfferTime() {
		return porkOfferTime;
	}
	public void setPorkOfferTime(String porkOfferTime) {
		this.porkOfferTime = porkOfferTime;
	}
	
	
}
