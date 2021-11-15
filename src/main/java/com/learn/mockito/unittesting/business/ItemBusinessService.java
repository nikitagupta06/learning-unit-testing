package com.learn.mockito.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.mockito.unittesting.data.ItemRepository;
import com.learn.mockito.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;

	public Item retreiveHardcodedItem() {
		
		return  new Item(1, "Bob", 100, 200);
	}
	
	public List<Item> retreiveAllItems(){
		List<Item> items = repository.findAll();
		for(Item item :items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		
		return items;
	}

}
