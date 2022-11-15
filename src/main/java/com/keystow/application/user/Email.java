package com.keystow.application.user;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

@EqualsAndHashCode
public class Email {

	private String email;

	protected Email() {
		//
	}

	public Email(String email) {
		Assert.hasText(email, "email cannot be blank");
		Assert.isTrue(email.contains("@"), "email should contain @ symbol");
		this.email = email;
	}

	public String asString() {
		return email;
	}

	@Override
	public String toString() {
		// @formatter:off
		return MoreObjects
				.toStringHelper(this)
				.add("email", email)
				.toString();
		// @formatter:on
	}

}
