package com.keystow.application.user;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@Getter
@Embeddable
public class UserName {

	private String firstName;

	private String lastName;

	protected UserName() {
		//
	}

	public UserName(String firstName, String lastName) {
		Assert.hasText(firstName, "firstName cannot be blank");
		Assert.hasText(lastName, "lastName cannot be blank");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		// @formatter:off
		return MoreObjects
				.toStringHelper(this)
				.add("firstName", firstName)
				.add("lastName", lastName)
				.toString();
		// @formatter:on
	}

}
