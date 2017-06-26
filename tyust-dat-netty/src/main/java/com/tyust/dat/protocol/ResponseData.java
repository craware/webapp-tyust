package com.tyust.dat.protocol;

import java.io.Serializable;

public class ResponseData implements Serializable {
	
	private static final long  SerialVersionUID = 1L;
	
	private String checkNo;
	
	private Boolean success;
	
	private String message;
	

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
