package com.mood.demo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mood on 20/10/29.
 */
@RestController()
@RequestMapping("/demo")
public class DemoController {
	Logger logger = LoggerFactory.getLogger(DemoController.class);
	@SentinelResource(value = "mood_sentinel",blockHandler = "errorResult")
	@GetMapping("/getDemo")
	public String getDemo() {
		logger.info("demo");
		return "demo";
	}
	public String errorResult( BlockException ex) {
		logger.error("error");
		return "error";
	}
}
