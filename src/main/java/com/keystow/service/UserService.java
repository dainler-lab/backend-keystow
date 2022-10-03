package com.keystow.service;

import com.keystow.dto.UserDto;
import com.keystow.model.user.UserModel;
import com.keystow.model.user.UserRole;
import com.keystow.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

@Transactional
@Service
public class UserService {

	private final UserRepository userRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	public UserDto saveUser(UserDto userDto) {

		UserModel userModel = modelMapper.map(userDto, UserModel.class);
		userModel.setEnabled(true);
		userModel.setCreatedAt(LocalDateTime.now());
		userModel.setRoles(Set.of(UserRole.USER));

		return modelMapper.map(userRepository.save(userModel), UserDto.class);
	}

	public boolean userWithEmailExists(String email) {
		return userRepository.existsByEmail(email);
	}

}
