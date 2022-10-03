package com.keystow.validate.passwods;

import com.keystow.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualsPasswordsValidator implements ConstraintValidator<EqualsPasswords, UserDto> {

	@Override
	public void initialize(EqualsPasswords constraint) {
		//
	}

	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {

		if (!userDto.getPassword().equals(userDto.getConfirmedPassword())) {
			// @formatter:off
			context.disableDefaultConstraintViolation();
			context
					.buildConstraintViolationWithTemplate("{MsgEqualsPasswords}")
					.addPropertyNode("confirmedPassword")
					.addConstraintViolation();
			return false;
			// @formatter:on
		}

		return true;
	}

}
