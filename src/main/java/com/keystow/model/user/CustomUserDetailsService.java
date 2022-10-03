package com.keystow.model.user;

import com.keystow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) {

		// @formatter:off
		UserModel userModel = userRepository
				.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(
						String.format("O usuário com o e-mail %s não foi encontrado.", email))
				);
		// @formatter:on
		return new CustomUserDetails(userModel);

	}

}
