package com.example.pub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pub.service.PorkRcptService;
import com.example.pub.vo.PorkRcptVO;


@RestController
public class PorkRcptController {
		
	@Autowired
	private PorkRcptService porkRcptService;
	
	@PostMapping(value = "/insertPork")
	public void insertPork(@RequestBody PorkRcptVO porkRcptVO) {	
		porkRcptService.insertPork(porkRcptVO);
	}
	
	@PostMapping(value = "/updatePorkDetail")
	public void updatePorkDetail(@RequestBody PorkRcptVO porkRcptVO) {	
		porkRcptService.updatePorkDetail(porkRcptVO);
	}	
	
}
