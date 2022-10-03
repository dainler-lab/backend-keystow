package com.keystow.service;

import com.keystow.dto.UserDto;
import com.keystow.model.user.UserModel;
import com.keystow.model.user.UserRole;
import com.keystow.repository.UserRepository;
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

	public void createUsersToRoleUser(UserDto userDto) {
		LOGGER.debug("Creating user {} ({})", userDto.getUserModelName(), userDto.getEmail());
		UserModel userModel = modelMapper.map(userDto, UserModel.class);
		userModel.setEnabled(true);
		userModel.setCreatedAt(LocalDateTime.now());
		userModel.setRoles(Set.of(UserRole.USER));
		modelMapper.map(userRepository.save(userModel), UserDto.class);
	}

	public void createUsersToRoleAdmin(UserDto userDto) {
		LOGGER.debug("Creating user {} ({})", userDto.getUserModelName(), userDto.getEmail());
		UserModel userModel = modelMapper.map(userDto, UserModel.class);
		userModel.setEnabled(true);
		userModel.setCreatedAt(LocalDateTime.now());
		userModel.setRoles(Set.of(UserRole.USER, UserRole.ADMIN));
		modelMapper.map(userRepository.save(userModel), UserDto.class);
	}

}
