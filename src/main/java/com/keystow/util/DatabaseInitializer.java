package com.keystow.util;

import com.github.javafaker.Faker;
import com.keystow.dto.UserDto;
import com.keystow.service.AdminUserService;
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
	public void run(String... args) throws Exception {

		UserDto userDtoAdmin = new UserDto();
		userDtoAdmin.setUserModelName("Administrador");
		userDtoAdmin.setEmail("admin@email.com");
		userDtoAdmin.setPassword("&35D479!&e8SW*4&$$3A*P");
		userDtoAdmin.setTipPassword("Generate Password...");
		adminUserService.createUsersToRoleAdmin(userDtoAdmin);

		for (int i = 0; i < 20; i++) {
			UserDto userDto = newRandomUserDtoParameters();
			adminUserService.createUsersToRoleUser(userDto);
		}
	}

	private UserDto newRandomUserDtoParameters() {

		String firstName = randomUserModelFirstName();
		String lastName = randomUserModelLastName();
		String fullName = firstName + " " + lastName;

		String username = firstName.toLowerCase() + "." + lastName.toLowerCase();
		String email = randomUserModelEmail(username);
		String password = username + "@pass";

		UserDto userDto = new UserDto();
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