package com.keystow.application.util;

import com.github.javafaker.Faker;
import com.keystow.application.dto.user.AdminCreateUserFormDataDto;
import com.keystow.application.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {

	private final Faker faker = new Faker();

	private final AdminUserService adminUserService;

	@Autowired
	public DatabaseInitializer(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public void run(String... args) {

		AdminCreateUserFormDataDto adminDto = new AdminCreateUserFormDataDto();
		adminDto.setUserModelName("Administrador");
		adminDto.setEmail("admin@email.com");
		adminDto.setPassword("&35D479!&e8SW*4&$$3A*P");
		adminDto.setTipPassword("Generate Password...");
		adminUserService.createUsersToRoleAdmin(adminDto);

		for (int i = 0; i < 20; i++) {
			AdminCreateUserFormDataDto userDto = newRandomUserFormDataDtoParameters();
			adminUserService.createUsersToRoleUser(userDto);
		}
	}

	private AdminCreateUserFormDataDto newRandomUserFormDataDtoParameters() {

		String firstName = randomUserModelFirstName();
		String lastName = randomUserModelLastName();
		String fullName = firstName + " " + lastName;

		String username = firstName.toLowerCase() + "." + lastName.toLowerCase();
		String email = randomUserModelEmail(username);
		String password = username + "@password";

		AdminCreateUserFormDataDto userDto = new AdminCreateUserFormDataDto();
		userDto.setUserModelName(fullName);
		userDto.setEmail(email);
		userDto.setPassword(password);
		return userDto;

	}

	@NotNull
	private String randomUserModelEmail(String username) {
		return faker.internet().emailAddress(username);
	}

	@NotNull
	private String randomUserModelFirstName() {
		return faker.name().firstName();
	}

	@NotNull
	private String randomUserModelLastName() {
		return faker.name().lastName();
	}

}