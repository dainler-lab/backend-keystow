package com.keystow.dto;

import com.keystow.model.item.TypeItem;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ItemDto {

	private Long id;

	@NotBlank
	@NotNull
	private TypeItem tipo;

	private String nome;

	private LocalDateTime dataDaOperacao;

	private Boolean favorito;

	private Boolean lixeira;

	private CredencialDto credencialDto;

	private CartaoDto cartaoDto;

	/*
	 * public ItemDto(Item item) { BeanUtils.copyProperties(item, this);
	 * this.credencialDto = new CredencialDto(item.getCredencial()); this.cartaoDto = new
	 * CartaoDto(item.getCartao()); }
	 *
	 * public static List<ItemDto> converter(List<Item> itens) { return
	 * itens.stream().map(ItemDto::new).collect(Collectors.toList()); }
	 */

}
