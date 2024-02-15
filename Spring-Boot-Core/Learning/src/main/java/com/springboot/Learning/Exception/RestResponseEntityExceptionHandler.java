package com.springboot.Learning.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.Learning.Constant.ErrorConstantCode;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ExceptionTemplate> departmentNotFoundException(DepartmentNotFoundException dnfe,WebRequest webrequest){
		ExceptionTemplate  exceptionObject = new ExceptionTemplate(HttpStatus.NOT_FOUND, dnfe.getMessage(),ErrorConstantCode.DEPARTMENT_NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionObject);
		
	}
}
