package com.keystow.model.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 200)
	@Enumerated(EnumType.STRING)
	private TypeItem tipo;

	private String nome;

	private LocalDateTime dataDaOperacao;

	private Boolean favorito;

	private Boolean lixeira;

}
