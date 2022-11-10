package com.keystow.application.service;

import com.keystow.application.dto.user.AdminCreateUserFormDataDto;
import com.keystow.application.model.user.UserModel;
import com.keystow.application.model.user.UserRole;
import com.keystow.application.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

@Transactional
@Service
public class AdminUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserService.class);

	private final UserRepository userRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public AdminUserService(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	public void createUsersToRoleUser(AdminCreateUserFormDataDto userFormDataDto) {
		LOGGER.debug("Creating user {} ({})", userFormDataDto.getUserModelName(), userFormDataDto.getEmail());
		UserModel userModel = modelMapper.map(userFormDataDto, UserModel.class);
		userModel.setEnabled(true);
		userModel.setCreatedAt(LocalDateTime.now());
		userModel.setRoles(Set.of(UserRole.USER));
		modelMapper.map(userRepository.save(userModel), AdminCreateUserFormDataDto.class);
	}

	public void createUsersToRoleAdmin(AdminCreateUserFormDataDto userFormDataDto) {
		LOGGER.debug("Creating user {} ({})", userFormDataDto.getUserModelName(), userFormDataDto.getEmail());
		UserModel userModel = modelMapper.map(userFormDataDto, UserModel.class);
		userModel.setEnabled(true);
		userModel.setCreatedAt(LocalDateTime.now());
		userModel.setRoles(Set.of(UserRole.USER, UserRole.ADMIN));
		modelMapper.map(userRepository.save(userModel), AdminCreateUserFormDataDto.class);
	}

	public void createUser(AdminCreateUserFormDataDto userFormDataDto) {

		if (userFormDataDto.getUserRole().equals(UserRole.ADMIN))
			createUsersToRoleAdmin(userFormDataDto);
		else
			createUsersToRoleUser(userFormDataDto);
	}

}
