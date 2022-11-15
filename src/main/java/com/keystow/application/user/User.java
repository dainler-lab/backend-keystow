package com.keystow.application.user;

import io.github.wimdeblauwe.jpearl.AbstractEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tt_user")
public class User extends AbstractEntity<UserId> {

	@NotNull
	private UserName userName;

	@Column(nullable = false, unique = true)
	private Email email;

	@NotNull
	private String password;

	private String tipPassword;

	private Boolean enabled;

	private LocalDateTime createdAt;

	/**
	 * Default constructor for JPA
	 */
	protected User() {
		//
	}

	public User(UserId id, UserName userName, Email email, String password, Boolean enabled, LocalDateTime createdAt) {
		super(id);
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
	}

}