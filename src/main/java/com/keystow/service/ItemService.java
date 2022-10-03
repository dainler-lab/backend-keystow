package com.keystow.service;

import com.keystow.model.item.ItemModel;
import com.keystow.repository.CredencialRepository;
import com.keystow.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemService {

	private final ItemRepository itemRepository;

	private final CredencialRepository credencialRepository;

	public ItemModel verificarItemCredencial(Long id) {
		Optional<ItemModel> item = (itemRepository.findById(id));
		if (!item.isPresent()) {
			return null;
		}
		return item.get();
	}

	/*
	 * public ItemDto buscarItemCredencial(Long id) { return new
	 * ItemDto(verificarItemCredencial(id)); }
	 */

	/*
	 * public List<ItemDto> buscarItensCredenciais() { List<Item> itens =
	 * itemRepository.findAll(); return ItemDto.converter(itens); }
	 */

	/*
	 * @Transactional public ItemDto salvarItemCredencial(ItemFormCredencialCadastro
	 * itemFormCredencialCadastro) {
	 *
	 *
	 *
	 * return new ItemDto(item); }
	 */

	/*
	 * @Transactional public ItemDto alterarItemCredencial(Long id,
	 * ItemFormCredencialAtualizar itemFormCredencialAtualizar) {
	 *
	 * Item item = verificarItemCredencial(id);
	 *
	 * return new ItemDto(item); }
	 *
	 * @Transactional public void removerItemCredencial(Long id) {
	 * itemRepository.deleteById(id); }
	 */

}
