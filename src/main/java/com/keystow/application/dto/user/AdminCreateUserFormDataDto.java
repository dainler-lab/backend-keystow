package com.keystow.application.dto.user;

import com.keystow.application.model.user.UserRole;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AdminCreateUserFormDataDto extends AbstractUserFormDataDto {

	@NotNull
	private UserRole userRole;

}
