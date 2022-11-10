package com.keystow.application.dto.user;

import com.keystow.application.validate.group.ValidationGroupOne;
import com.keystow.application.validate.group.ValidationGroupTwo;
import com.keystow.application.validate.user.UserNotExisting;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@UserNotExisting(groups = ValidationGroupTwo.class)
@Data
public class AbstractUserFormDataDto {

	private Long id;

	private String tipPassword;

	@Size(min = 1, max = 200, groups = ValidationGroupOne.class)
	@NotBlank
	private String userModelName;

	@Email(groups = ValidationGroupOne.class)
	@NotBlank
	private String email;

	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@$%^&*]).{8,200}$", groups = ValidationGroupTwo.class)
	@Size(min = 8, max = 200, groups = ValidationGroupOne.class)
	@NotBlank
	private String password;

}
