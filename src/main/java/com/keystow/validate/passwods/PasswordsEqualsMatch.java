package com.keystow.validate.passwods;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { PasswordsEqualsMatchValidator.class })
public @interface PasswordsEqualsMatch {

	String message() default "{PasswordsEqualsMatchMessage}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
