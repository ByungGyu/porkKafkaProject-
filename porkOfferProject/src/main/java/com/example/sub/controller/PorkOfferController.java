package com.example.sub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sub.service.PorkOfferService;
import com.example.sub.vo.SubPorkRcptVO;


@RestController
public class PorkOfferController {
		
	@Autowired
	private PorkOfferService porkOfferService;
	
	@PostMapping(value = "/insertPork222")
	public void insertPork(@RequestBody SubPorkRcptVO porkRcptVO) {	
		System.out.println();
	}
	
	
}
