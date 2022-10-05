package com.keystow.dto.user;

import com.keystow.validate.group.ValidationGroupTwo;
import com.keystow.validate.passwods.PasswordsEqualsMatch;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@PasswordsEqualsMatch(groups = ValidationGroupTwo.class)
public class CreateUserFormDataDto extends AbstractUserFormDataDto {

	@NotBlank
	private String passwordRepeated;

}
