package com.example.squarematrixrotationapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.squarematrixrotationapi.exceptions.InvalidMatrixException;
import com.example.squarematrixrotationapi.utils.Utils;

@Service
public class SquareMatrixRotationService implements ISquareMatrixRotationService {

	@Override
	public List<Integer> rotateMatrix(List<Integer> list) throws InvalidMatrixException {
		int[][] matrix = listToSquareMatrix(list);
		matrix = rotateMatrixClockwise(matrix);
		printMatrix(matrix);
		return matrixToList(matrix);
	}
	
	/**
	 * retorna uma matriz em uma lista
	 * @param matrix
	 * @return
	 */
	private List<Integer> matrixToList(int[][] matrix){
		int size = matrix[0].length;
		List<Integer> list = new ArrayList<Integer>();
		int listIndex = 0;
		
		for(int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				list.add(listIndex++, matrix[row][col]);
			}
		}
		return list;
	}
	
	/**
	 * retorna uma matriz quadrada com os valores da list
	 * @param list
	 * @return
	 * @throws InvalidMatrixException
	 */
	private int[][] listToSquareMatrix(List<Integer> list) throws InvalidMatrixException {
			int[][] matrix;
			double squareRoot = Math.sqrt(list.size());
			
			if(Utils.isInt(squareRoot)) {
				matrix = populateMatrix(list);
			}else {
				throw new InvalidMatrixException();
			}
			return matrix;
	}
	
	/**
	 * retorna uma matriz com os dados recebidos na list
	 * @param list
	 * @param size
	 * @return
	 */
	private int [][] populateMatrix (List<Integer> list) {
		int size = (int) Math.sqrt(list.size());
		int[][] matrix = new int [size][size] ;
	    int listIndex = 0;
	    //percorre cada linha
	    for (int row=0; row < size; row++)
	    {
	        //percorre cada coluna
	        for (int col=0; col < size; col++)
	        {
	            //popula matriz com valores da list
	            matrix[row][col] = list.get(listIndex++);
	        }
	    }
	    return matrix;
	}
	
	/**
	 * percorre todos elementos da matriz no sentido horario
	 * e troca com valor anterior
	 * @param matrix
	 * @param size
	 * @return
	 */
	private int[][] rotateMatrixClockwise(int[][] matrix){
		int size = matrix[0].length;
		int layer = 0;
		int limit = (int) size / 2;
		int pivot = 0;
		
		while (layer < limit) {
			
			//linha superior da esquerda para direita
			for (int col = layer; col < (size - layer); col++) {
				int row = layer;
				pivot = swap(matrix, row, col, pivot);
			}
			
			//coluna da direita de cima para baixo
			for (int row = layer + 1; row < (size - layer); row++) {
				int col = (size - 1) - layer;
				pivot = swap(matrix, row, col, pivot);
			}
			
			//linha inferior da direita para a esquerda
			for (int col = (size - 2 - layer); col >= (layer); col--) {
				int row = (size - 1) - layer;
				pivot = swap(matrix, row, col, pivot);
			}
			
			//coluna da esquerda de baixo pra cima
			for (int row = (size - 2 - layer); row >= (layer); row--) {
				int col = 0 + layer;
				pivot = swap(matrix, row, col, pivot);
			}
			
			layer++;
		}
		
		return matrix;
	}
	
	private int swap(int[][] matrix, int row, int col, int pivot) {
		int aux = pivot;
		pivot = matrix[row][col];
		matrix[row][col] = aux;
		return pivot;
	}
	
	@SuppressWarnings("unused")
	private void printMatrix(int[][] matrix) {
		int size = matrix[0].length;
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		System.out.println();
	}

}
