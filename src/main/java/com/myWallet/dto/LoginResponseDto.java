package com.myWallet.dto;

public class LoginResponseDto {
	
	private String token;
	private boolean reportValue;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean getReportValue() {
		return reportValue;
	}
	
	public void setReportValue(boolean reportValue) {
		this.reportValue = reportValue;
	}

}
