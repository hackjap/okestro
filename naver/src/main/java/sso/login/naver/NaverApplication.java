package sso.login.naver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class NaverApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverApplication.class, args);

		System.out.println("hello world");
	}

}
