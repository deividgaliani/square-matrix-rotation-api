package com.example.squarematrixrotationapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;

public interface ISquareMatrixRotationController {

	@ApiOperation(value="Rotaciona os dados de uma matriz quadrada", response = ResponseEntity.class)
	public ResponseEntity<List<Integer>> rotateMatrix(@RequestBody MatrixVo vo);
}
