package com.keystow.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

	private final Long id;

	private final String username;

	private final String displayName;

	private final String password;

	private final Set<GrantedAuthority> authorities;

	public CustomUserDetails(UserModel userModel) {

		// @formatter:off
		this.id = userModel.getId();
		this.username = userModel.getEmail();
		this.displayName = userModel.getUserModelName();
		this.password = userModel.getPassword();
		this.authorities = userModel
				.getRoles()
				.stream()
				.map(
						userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.name())
				)
				.collect(Collectors.toSet());
		// @formatter:on

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}

}
