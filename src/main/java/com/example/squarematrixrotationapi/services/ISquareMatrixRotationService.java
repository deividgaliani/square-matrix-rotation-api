package com.example.squarematrixrotationapi.services;

import java.util.List;

import com.example.squarematrixrotationapi.exceptions.InvalidMatrixException;

public interface ISquareMatrixRotationService {
	
	/**
	 * metodo responsavel por rotacionar os valores recebidos
	 * em uma matriz e retornar os valores em uma lista de inteiros
	 * @param list
	 * @return
	 * @throws InvalidMatrixException
	 */
	List<Integer> rotateMatrix(List<Integer> list) throws InvalidMatrixException;
	
}
