package com.mood.demo.sentinel.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mood on 20/10/29.
 */
@Configuration
public class SentinelConfig {
	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}

	@PostConstruct
	private void initRules() throws Exception {
		FlowRule rule1 = new FlowRule();
		rule1.setResource("mood_sentinel");
		rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
		rule1.setCount(1);   // 每秒调用最大次数为 1 次

		List<FlowRule> rules = new ArrayList<>();
		rules.add(rule1);

		// 将控制规则载入到 Sentinel
		FlowRuleManager.loadRules(rules);
	}
}
