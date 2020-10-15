package org.fourstack.infomanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InfoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoManagementApplication.class, args);
	}

}
