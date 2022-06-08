package com.example.squarematrixrotationapi.controllers;

import java.util.ArrayList;
import java.util.List;

public class MatrixVo {

	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		if (numbers == null) {
			numbers = new ArrayList<Integer>();
		}
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	
}
