package com.keystow.application;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.keystow.application.user.CreateUserParameters;
import com.keystow.application.user.Email;
import com.keystow.application.user.UserName;
import com.keystow.application.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {

	private final Faker faker = new Faker();

	private final UserService userService;

	public DatabaseInitializer(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(String... args) {
		for (int i = 0; i < 10; i++) {
			CreateUserParameters parameters = newRandomUserParameters();
			userService.createUser(parameters);
		}
	}

	private CreateUserParameters newRandomUserParameters() {
		Name name = faker.name();
		UserName userName = new UserName(name.firstName(), name.lastName());
		Email email = new Email(faker.internet().emailAddress(generateEmailLocalPart(userName)));
		String password = "password@22";
		Boolean enabled = true;
		LocalDateTime createdAt = LocalDateTime.now();
		return new CreateUserParameters(userName, email, password, enabled, createdAt);
	}

	private String generateEmailLocalPart(UserName userName) {
		return String.format("%s.%s", StringUtils.remove(userName.getFirstName().toLowerCase(), "'"),
				StringUtils.remove(userName.getLastName().toLowerCase(), "'"));
	}

}
