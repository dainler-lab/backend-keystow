package com.keystow.dto;

import com.keystow.model.credential.CredentialModel;
import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class CredencialDto {

	private String campoDeUsuario;

	private String senha;

	private String uri;

	public CredencialDto(CredentialModel credentialModel) {
		if (credentialModel != null) {
			BeanUtils.copyProperties(credentialModel, this);
		}
	}

}
