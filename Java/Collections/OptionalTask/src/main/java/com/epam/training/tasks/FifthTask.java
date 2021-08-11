package com.epam.training.tasks;

import java.util.List;

public class FifthTask {
	private List<Integer> integerList;

	public FifthTask(List<Integer> integerList) {
		this.integerList = integerList;
	}

	public List<Integer> getIntegerList() {
		return integerList;
	}

	public void placeNegativeNumbersAtTheEndAndPositiveNumbersAtTheBeginning() {
		for (int i = 1, j = 0; i < integerList.size(); i++) {
			if (integerList.get(i) >= 0) {
				int temp = integerList.get(i);
				integerList.set(i, integerList.get(j));
				integerList.set(j, temp);
				j++;
			}
		}
	}
}
