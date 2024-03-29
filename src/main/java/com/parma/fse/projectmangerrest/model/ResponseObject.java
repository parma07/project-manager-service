package com.parma.fse.projectmangerrest.model;

public class ResponseObject<T> {
	
	private T outData;
	private String status;
	private String errCode;

	public ResponseObject() {		

	}
	
	public ResponseObject(T outData,String status,String erroCode) {
		this.outData = outData;
		this.status = status;
		this.errCode = erroCode;
	}
	
	public T getOutData() {
		return outData;
	}

	public void setOutData(T outData) {
		this.outData = outData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
