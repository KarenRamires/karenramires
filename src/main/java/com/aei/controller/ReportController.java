package com.aei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aei.config.Messages;
import com.aei.service.ClassPlanService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/report")
public class ReportController {
	
	@GetMapping("/report")
	public String print() {
		return "report/report";
	}

}
