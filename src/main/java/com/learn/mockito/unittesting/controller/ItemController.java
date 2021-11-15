package com.learn.mockito.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.mockito.unittesting.business.ItemBusinessService;
import com.learn.mockito.unittesting.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Bob", 100, 200);
	}

	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {

		Item item = businessService.retreiveHardcodedItem();
		return item;
	}

	@GetMapping("/all-items-from-business-service")
	public List<Item> allitemsFromBusinessService() {

		return businessService.retreiveAllItems();

	}
}
