package com.qfedu.feri.img;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //启用Swagger
public class QfferiimgApplication {

	public static void main(String[] args) {
		SpringApplication.run(QfferiimgApplication.class, args);
	}

}
