package com.keystow.application.repository;

import com.keystow.application.model.credential.CredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<CredentialModel, Long> {

}
