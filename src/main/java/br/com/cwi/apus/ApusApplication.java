package br.com.cwi.apus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ApusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApusApplication.class, args);
	}

}
