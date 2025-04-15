package sn.intouch.gu.iabiri.ws.models.gucore;

import java.io.Serializable;


public class ModelMonitoringApp implements Serializable {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	private String typeOfError;
	private String stacktrace;
	private String transactionRequest;
	private String ipAddress;
	private String source;
	private long date;
	private long responseDuration;
	private String	context;
	private String url;
	private String idProcess;
	private String idError;
	private String descriptionError;
	private String projectName;

	
	public ModelMonitoringApp() {
		super();
		//TODO Auto-generated constructor stub
	}
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
	public String getTypeOfError() {
		return typeOfError;
	}
	public void setTypeOfError(String typeOfError) {
		this.typeOfError = typeOfError;
	}
	public String getStacktrace() {
		return stacktrace;
	}
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
	public String getTransactionRequest() {
		return transactionRequest;
	}
	public void setTransactionRequest(String transactionRequest) {
		this.transactionRequest = transactionRequest;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public long getResponseDuration() {
		return responseDuration;
	}
	public void setResponseDuration(long responseDuration) {
		this.responseDuration = responseDuration;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIdProcess() {
		return idProcess;
	}
	public void setIdProcess(String idProcess) {
		this.idProcess = idProcess;
	}
	public String getIdError() {
		return idError;
	}
	public void setIdError(String idError) {
		this.idError = idError;
	}
	public String getDescriptionError() {
		return descriptionError;
	}
	public void setDescriptionError(String descriptionError) {
		this.descriptionError = descriptionError;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	
	
}
