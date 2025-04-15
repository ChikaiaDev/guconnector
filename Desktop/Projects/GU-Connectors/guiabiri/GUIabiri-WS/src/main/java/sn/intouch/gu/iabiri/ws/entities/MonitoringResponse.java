package sn.intouch.gu.iabiri.ws.entities;

import java.util.Date;

public class MonitoringResponse {
	private String errorCode;
	private String errorMessage;
	private Date date;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MonitoringResponse(String errorCode, String errorMessage, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.date = date;
	}
	public MonitoringResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
