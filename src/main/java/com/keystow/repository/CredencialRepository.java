package com.keystow.repository;

import com.keystow.model.credential.CredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<CredentialModel, Long> {

}
