/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.hcl.cloud.user.DTO.ExceptionResponseDTO;

/**
 * com.hcl.cloud.user.exception abhishek_sin
 */
@ControllerAdvice
public class ExceptionHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     *
     *
     * @param request
     *            for HTTP.
     * @param exception
     *            for Exception .
     * @return tag for Response.
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleError(HttpServletRequest request, Exception exception) {
        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO();
        exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionResponse.setDescription(exception.getMessage());
        logger.error("Error " + exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
