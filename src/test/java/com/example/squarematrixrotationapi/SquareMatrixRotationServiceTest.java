package com.example.squarematrixrotationapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.example.squarematrixrotationapi.exceptions.InvalidMatrixException;
import com.example.squarematrixrotationapi.services.SquareMatrixRotationService;

class SquareMatrixRotationServiceTest {

	@InjectMocks
	private SquareMatrixRotationService squareMatrixRotationService;
	
	@Test
	void sholdReturnSuccessRotatedList() throws InvalidMatrixException {
		MockitoAnnotations.initMocks(this);
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer[] expectedArray = {4, 1, 2, 7, 5, 3, 8, 9, 6};
		
		List<Integer> list = Arrays.asList(array);
		List<Integer> expectedList = Arrays.asList(expectedArray);
		
		final List<Integer> returnedList = squareMatrixRotationService.rotateMatrix(list);
		assertEquals(expectedList, returnedList);
	}
	
	@Test
	void sholdReturnErrorRotatedInvalidList() throws InvalidMatrixException {
		MockitoAnnotations.initMocks(this);
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		List<Integer> list = Arrays.asList(array);
		
		assertThrows(InvalidMatrixException.class,
	            ()->{
	            	squareMatrixRotationService.rotateMatrix(list);
                });
	}

}
