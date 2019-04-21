package com.hcl.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//@EnableMongoRepositories("com.hcl.cloud.user.repository")
public class UsermoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermoduleApplication.class, args);
	}

}
