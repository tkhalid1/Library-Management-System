package com.library.management.common;

public class ApiResponse {

	private Integer statusCode;
	private String message;
	private String error;
	private String success;
	private Object data;

	public Integer getStatusCode() {
		return statusCode;
	}

	public ApiResponse setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ApiResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getError() {
		return error;
	}

	public ApiResponse setError(String error) {
		this.error = error;
		return this;
	}

	public String getSuccess() {
		return success;
	}

	public ApiResponse setSuccess(String success) {
		this.success = success;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ApiResponse setData(Object data) {
		this.data = data;
		return this;
	}
}
