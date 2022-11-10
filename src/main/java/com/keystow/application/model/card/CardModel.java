package com.keystow.application.model.card;

import com.keystow.application.model.item.ItemModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TB_CARDS")
public class CardModel extends ItemModel {

	private String titularDoCartao;

	private String numero;

	private String bandeira;

	private String mesDoVencimento;

	private String anoDoVencimento;

	private String codigoDeSeguranca;

}
