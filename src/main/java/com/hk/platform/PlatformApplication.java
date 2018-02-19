package com.hk.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.hk.impl.dao.BaseDaoImpl;

@SpringBootApplication
//,"com.hk.impl.dao.BaseDaoImpl"})
//@ImportResource({"classpath:spring/spring*.xml"})
//@ComponentScan({"com.hk"})
public class PlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformApplication.class, args);
	}
}
