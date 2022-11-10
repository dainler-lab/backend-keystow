package com.keystow.application.dto.user;

import com.keystow.application.validate.group.ValidationGroupTwo;
import com.keystow.application.validate.passwods.PasswordsEqualsMatch;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@PasswordsEqualsMatch(groups = ValidationGroupTwo.class)
public class CreateUserFormDataDto extends AbstractUserFormDataDto {

	@NotBlank
	private String passwordRepeated;

}
