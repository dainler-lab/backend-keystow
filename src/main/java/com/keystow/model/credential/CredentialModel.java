package com.keystow.model.credential;

import com.keystow.model.item.ItemModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_credentials")
public class CredentialModel extends ItemModel {

	@Column(length = 200)
	private String campoDeUsuario;

	@Column(length = 500)
	private String senha;

	private String uri;

}
