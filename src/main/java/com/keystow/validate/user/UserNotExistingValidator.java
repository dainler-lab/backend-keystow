package com.keystow.validate.user;

import com.keystow.dto.user.AbstractUserFormDataDto;
import com.keystow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNotExistingValidator implements ConstraintValidator<UserNotExisting, AbstractUserFormDataDto> {

	private final UserService userService;

	@Autowired
	public UserNotExistingValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void initialize(UserNotExisting constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(AbstractUserFormDataDto userDto, ConstraintValidatorContext context) {
		// @formatter:off
        if (userService.userWithEmailExists(userDto.getEmail())) {
            context.disableDefaultConstraintViolation();
            context
                    .buildConstraintViolationWithTemplate("{UserNotExistingMessage}")
                    .addPropertyNode("email")
                    .addConstraintViolation();

            return false;
        }
		// @formatter:on

		return true;
	}

}