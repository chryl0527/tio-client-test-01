package com.sdsoon;

import com.sdsoon.client.ClientStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TioClientTest01Application extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {

		ClientStarter.start();
//		ClientStarter.main(args);


		SpringApplication.run(TioClientTest01Application.class, args);
	}
	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
