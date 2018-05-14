package com.example.test_physical_strength;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Controller
@EnableSwagger2
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = "com.example.test_physical_strength.mapper")
public class TestPhysicalStrengthApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestPhysicalStrengthApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "redirect:/swagger-ui.html";
	}
}
