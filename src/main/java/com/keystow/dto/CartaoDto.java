package com.keystow.dto;

import org.springframework.beans.BeanUtils;

import com.keystow.model.card.CardModel;
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
