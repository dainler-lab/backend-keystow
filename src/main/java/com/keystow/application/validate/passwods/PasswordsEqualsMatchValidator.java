package com.keystow.application.validate.passwods;

import com.keystow.application.dto.user.CreateUserFormDataDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualsMatchValidator implements ConstraintValidator<PasswordsEqualsMatch, CreateUserFormDataDto> {

	@Override
	public void initialize(PasswordsEqualsMatch constraint) {
		//
	}

	@Override
	public boolean isValid(CreateUserFormDataDto userDto, ConstraintValidatorContext context) {
		// @formatter:off
		if (!userDto.getPassword().equals(userDto.getPasswordRepeated())) {
			context.disableDefaultConstraintViolation();
			context
					.buildConstraintViolationWithTemplate("{PasswordsEqualsMatchMessage}")
					.addPropertyNode("passwordRepeated")
					.addConstraintViolation();
			return false;
		}
		// @formatter:on

		return true;
	}

}
