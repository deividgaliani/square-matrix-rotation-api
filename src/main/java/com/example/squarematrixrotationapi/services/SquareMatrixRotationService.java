package com.example.squarematrixrotationapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.squarematrixrotationapi.exceptions.InvalidMatrixException;
import com.example.squarematrixrotationapi.utils.Utils;

@Service
public class SquareMatrixRotationService implements ISquareMatrixRotationService {

	@Override
	public List<Integer> rotateMatrixClockwise(List<Integer> list) throws Exception {
		int[][] matrix = listToMatrix(list);
				
		return null;
	}
	
	private int[][] listToMatrix(List<Integer> list) throws Exception {
		try {
			int[][] matrix;
			double squareRoot = Math.sqrt(list.size());
			if(Utils.isInt(squareRoot)) {
				matrix = populateMatrix(list, (int) squareRoot);
			}else {
				throw new InvalidMatrixException();
			}
			return matrix;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private int [][] populateMatrix (List<Integer> list, int squareRoot)
	{
		int[][] matrix = new int [squareRoot][squareRoot] ;
	    int listIndex = 0;
	    //percorre cada linha
	    for (int row=0; row < squareRoot; row++)
	    {
	        //percorre cada coluna
	        for (int col=0; col < squareRoot; col++)
	        {
	            //popula matriz com valores da lista
	            matrix[row][col] = list.get(listIndex++);
	        }
	    }
	    return matrix;
	}

}
