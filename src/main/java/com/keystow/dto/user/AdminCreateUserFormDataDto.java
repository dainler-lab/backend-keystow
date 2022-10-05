package com.keystow.dto.user;

import com.keystow.model.user.UserRole;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AdminCreateUserFormDataDto extends AbstractUserFormDataDto {

	@NotNull
	private UserRole userRole;

}
