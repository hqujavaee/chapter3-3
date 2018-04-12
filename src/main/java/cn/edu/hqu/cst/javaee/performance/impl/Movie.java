package cn.edu.hqu.cst.javaee.performance.impl;

import org.springframework.stereotype.Component;

import cn.edu.hqu.cst.javaee.performance.Performance;
@Component
public class Movie implements Performance {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("正在播放中.....");

	}

}
