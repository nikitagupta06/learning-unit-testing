package com.learn.mockito.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.learn.mockito.unittesting.data.ItemRepository;
import com.learn.mockito.unittesting.data.SomeDataService;
import com.learn.mockito.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessMockTest {

	@InjectMocks
	private ItemBusinessService business;

	@Mock
	private ItemRepository repository;

	@Test
	public void retreiveAllItems_basic() {
		when(repository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "apple", 100, 100), new Item(3, "banana", 50, 50)));
		
		List<Item> items = business.retreiveAllItems();

		assertEquals(10000, items.get(0).getValue());
		assertEquals(2500, items.get(1).getValue());

	}
}
