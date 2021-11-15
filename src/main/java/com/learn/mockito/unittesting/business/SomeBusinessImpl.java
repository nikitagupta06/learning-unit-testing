package com.learn.mockito.unittesting.business;

import java.util.Arrays;
import java.util.OptionalInt;

import com.learn.mockito.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		//functional programming
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		int data[] = someDataService.retreiveAllData();
		for (int value : data) {
			sum += value;
		}

		// someDataService.storeSum(sum);
		return sum;
	}
}
