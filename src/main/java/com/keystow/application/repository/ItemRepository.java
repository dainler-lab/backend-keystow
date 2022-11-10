package com.keystow.application.repository;

import com.keystow.application.model.item.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository - POR SER INTERFACE NAO PRECISA DA ANOTAÇÃO PQ O SPRING JÁ ENCONTRA
public interface ItemRepository extends JpaRepository<ItemModel, Long> {

}
