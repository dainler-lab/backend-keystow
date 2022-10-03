package com.keystow.repository;

import com.keystow.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	// UserModel findByEmail(String email);

	Optional<UserModel> findByEmail(String email);

	boolean existsByEmail(String email);

}
