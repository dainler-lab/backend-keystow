package com.keystow.application.dto;

import org.springframework.beans.BeanUtils;

import com.keystow.application.model.card.CardModel;
import lombok.Data;

@Data
public class CartaoDto {

	private String titularDoCartao;

	private String numero;

	private String bandeira;

	private String mesDoVencimento;

	private String anoDoVencimento;

	private String codigoDeSeguranca;

	public CartaoDto(CardModel cardModel) {
		if (cardModel != null) {
			BeanUtils.copyProperties(cardModel, this);
		}
	}

}
