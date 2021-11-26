package com.example.sub.vo;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Alias("SubPorkEncnVO")
@Data
public class SubPorkEncnVO {
	
	private String porkId;
	private String porkNm;
	private String porkDetail;
	private String porkEncnDetail;
	private String porkEncnYn;
	private String porkEncnTime;
	
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
	public String getPorkEncnDetail() {
		return porkEncnDetail;
	}
	public void setPorkEncnDetail(String porkEncnDetail) {
		this.porkEncnDetail = porkEncnDetail;
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
	
	
}
