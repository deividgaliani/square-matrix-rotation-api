package com.example.squarematrixrotationapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.squarematrixrotationapi.services.ISquareMatrixRotationService;

@RestController
@Scope(value = "request")
@RequestMapping(value = "/rotate")
public class SquareMatrixRotationController implements ISquareMatrixRotationController {
	
	@Autowired
	private ISquareMatrixRotationService squareMatrixRotationService;

	@RequestMapping(value="/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Integer>> rotateMatrix(@RequestBody MatrixVo vo) {
		List<Integer> response = null;
		try {
			response = squareMatrixRotationService.rotateMatrixClockwise(vo.getNumbers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Integer>>(response, HttpStatus.OK);
	}

}
