package cn.edu.hqu.cst.javaee.performance.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceManager {
	@Pointcut("execution(** cn.edu.hqu.cst.javaee.performance.Performance.perform())")
	public void perform() {
		
	}
	@Before("perform()")
	public void silenceCellPhones() {
		System.out.println("电影即将开始，请将手机调为静音！");
	}
	
	@Before("perform()")
	public void takeSeats() {
		System.out.println("请坐在自己位置上，不要到处走动");
	}
	@AfterReturning("perform()")
	public void orderlyRetreat() {
		System.out.println("电影播放完毕，请大家有序退场");
	}
	@AfterThrowing("perform()")
	public void refound() {
		System.out.println("到售票处退票");
	}
	@Around("perform()")
	public void checkSecurity(ProceedingJoinPoint jp) {
		try {
			System.out.println("表演前安全检查");
			jp.proceed();
			System.out.println("表演后安全检查");
		}catch(Throwable e){
			System.out.println("播放出现问题");
		}
		
	}
	
}
