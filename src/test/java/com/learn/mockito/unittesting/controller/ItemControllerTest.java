package com.learn.mockito.unittesting.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.learn.mockito.unittesting.business.ItemBusinessService;
import com.learn.mockito.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Bob\",\"price\":100,\"quantity\":200}")).andReturn();

		// JSONAssert.assertEquals("{\"id\":1,\"name\":\"Bob\",\"price\":100,\"quantity\":200}",
		// 				result.getResponse().getContentAsString, strict);

	}

	@Test
	public void itemFromBusinessService_basic() throws Exception {

		when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2, "apple", 100, 300));

		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:apple,price:100}")).andReturn();

	}
	
	@Test
	public void allItemsFromBusinessService_basic() throws Exception {

		when(businessService.retreiveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "apple", 100, 100),
							  new Item(3, "banana", 50, 50)));

		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-business-service")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:apple,price:100},{id:3,name:banana,price:50}]")).andReturn();

	}
	
//	@Test
//	public void post_basic() throws Exception {
//
//		RequestBuilder request = MockMvcRequestBuilders.get("/items")
//				.accept(MediaType.APPLICATION_JSON)
//				.content("{\"id\":4,\"name\":\"Ball\",\"price\":100,\"quantity\":200}")
//				.contentType(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isCreated())
//				.andExpect(header().string("location",containsString("/item/")))
//				.andReturn();
//
//	}

}
