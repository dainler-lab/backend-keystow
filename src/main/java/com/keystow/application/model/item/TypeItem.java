package com.keystow.application.model.item;

public enum TypeItem {

	CREDENCIAL("Credencial"), CARTAO("Cartão");

	private String descricao;

	private TypeItem(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
