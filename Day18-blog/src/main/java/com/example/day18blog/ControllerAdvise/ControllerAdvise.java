package com.example.day18blog.ControllerAdvise;

import com.example.day18blog.ApiException.ApiException;
import com.example.day18blog.ApiResponse.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = ApiException.class)//من نوع

    public ResponseEntity<ApiResponse> ApiException(ApiException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }



}
