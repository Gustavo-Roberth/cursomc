package com.gustavo.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer msg;
	private String status;
	private Long timeStamp;
	
	
	
	public StandardError(Integer msg, String status, Long timeStamp) {
		super();
		this.msg = msg;
		this.status = status;
		this.timeStamp = timeStamp;
	}

	public Integer getMsg() {
		return msg;
	}
	
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
