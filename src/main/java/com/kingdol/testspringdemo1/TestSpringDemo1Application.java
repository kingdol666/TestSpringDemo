package com.kingdol.testspringdemo1;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringDemo1Application.class, args);
		System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
		System.out.println("http://localhost:8081");
	}

}
