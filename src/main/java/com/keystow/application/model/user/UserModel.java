package com.keystow.application.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_users")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userModelName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	private String tipPassword;

	private Boolean enabled;

	private LocalDateTime createdAt;

	@ElementCollection(targetClass = UserRole.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "tb_user_roles")
	@Column(name = "role")
	private Set<UserRole> roles;

}
