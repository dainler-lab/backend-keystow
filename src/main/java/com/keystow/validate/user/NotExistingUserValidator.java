package com.keystow.validate.user;

import com.keystow.dto.UserDto;
import com.keystow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotExistingUserValidator implements ConstraintValidator<NotExistingUser, UserDto> {

	private final UserService userService;

	@Autowired
	public NotExistingUserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void initialize(NotExistingUser constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		// @formatter:off
        if (userService.userWithEmailExists(userDto.getEmail())) {
            context.disableDefaultConstraintViolation();
            context
                    .buildConstraintViolationWithTemplate("{MsgUserAlreadyExisting}")
                    .addPropertyNode("email")
                    .addConstraintViolation();

            return false;
        }

        return true;
        // @formatter:on
	}

}