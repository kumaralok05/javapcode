package com.quespro.exception;

public class ApiResponse {
	private int status;
	private String message;
	private String timestamp;

	public ApiResponse(int status, String message) {
		this.status = status;
		this.message = message;
		this.timestamp = java.time.LocalDateTime.now().toString();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
