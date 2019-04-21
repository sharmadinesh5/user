/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.hcl.cloud.user.DTO.ExceptionResponseDTO;

/**
 * com.hcl.cloud.user.exception
 * abhishek_sin
 */
@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
	public ResponseEntity<ExceptionResponseDTO> handleError(HttpServletRequest request,Exception exception) {
		ExceptionResponseDTO exceptionResponse=new ExceptionResponseDTO();
		exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setDescription(exception.getMessage());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
