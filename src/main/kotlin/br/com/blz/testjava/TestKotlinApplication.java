package br.com.blz.testjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = TestKotlinApplication.class)
public class TestKotlinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestKotlinApplication.class, args);
	}
}
