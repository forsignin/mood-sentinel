package com.mood.demo.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoodSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodSentinelApplication.class, args);
		// 配置规则.
//		initFlowRules();

//		while (true) {
//			// 1.5.0 版本开始可以直接利用 try-with-resources 特性
//			try (Entry entry = SphU.entry("HelloWorld")) {
//				// 被保护的逻辑
//				System.out.println("hello world");
//			} catch (BlockException ex) {
//				// 处理被流控的逻辑
//				System.out.println("blocked!");
//			}
//		}

	}
	private static void initFlowRules(){
		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("mood_sentinel");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 20.
		rule.setCount(1);
		rules.add(rule);
		FlowRuleManager.loadRules(rules);
	}

}
