package br.dazzi.AM53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

@SpringBootApplication
public class Am53Application {

	public static void main(String[] args) {
		SpringApplication.run(Am53Application.class, args);
	}


}
