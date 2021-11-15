package com.learn.mockito.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.mockito.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
