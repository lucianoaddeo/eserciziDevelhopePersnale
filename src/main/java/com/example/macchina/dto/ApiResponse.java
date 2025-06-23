package com.example.macchina.dto;

import org.springframework.validation.ObjectError;
import java.util.List;

import java.time.LocalDateTime;

public class ApiResponse {
    private LocalDateTime currentTime = LocalDateTime.now();
    private boolean success;
    private String message;
    private Object content;
    private List<ObjectError> errorList;

    public ApiResponse(String message){
        success = false;
        this.message = message;
    }

    public ApiResponse(Object content){
        success = true;
        this.content = content;
    }

    public ApiResponse(List<ObjectError> errorList){
        success = false;
        this.errorList = errorList;
    }

    public ApiResponse(String message, Boolean success){
        this.success = success;
        this.message = message;
    }

    //getter & setter

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public List<ObjectError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ObjectError> errorList) {
        this.errorList = errorList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
