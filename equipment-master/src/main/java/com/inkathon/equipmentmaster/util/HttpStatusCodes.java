package com.inkathon.equipmentmaster.util;

import org.springframework.http.HttpStatus;

public class HttpStatusCodes {
	public static void main(String[] args){
		System.out.println();
	}
	
	public static final boolean trueStatus=Boolean.TRUE;
	public static final boolean falseStatus=Boolean.FALSE;
	public static final String ok=HttpStatus.OK.name();
	
	public static final String successMsg="SUCCESS";
	public static final int  successCode=HttpStatus.OK.value();
	public static final String createdMsg=HttpStatus.OK.CREATED.name().toString();
	public static final int  createdCode=HttpStatus.OK.CREATED.value();
	public static final String acceptedMsg=HttpStatus.ACCEPTED.name();
	public static final int acceptedCode=HttpStatus.ACCEPTED.value();
	public static final String foundMsg=HttpStatus.OK.FOUND.name();
	public static final int foundcode=HttpStatus.OK.FOUND.value();
	public static final String notFoundMsg=HttpStatus.OK.NOT_FOUND.name();
	public static final int  notFoundCode=HttpStatus.OK.NOT_FOUND.value();
	
	public static final String newUpdateMsg=HttpStatus.OK.NOT_IMPLEMENTED.name();
	public static final int  newUpdateCode=HttpStatus.OK.NOT_IMPLEMENTED.value();

	
	public static final String serverUnavailableMsg=HttpStatus.SERVICE_UNAVAILABLE.name();
	public static final int  serverUnavailableCode=HttpStatus.SERVICE_UNAVAILABLE.value();
	
	public static final String internalServerErrorMsg=HttpStatus.SERVICE_UNAVAILABLE.INTERNAL_SERVER_ERROR.name();
	public static final int  internalServerErrorCode=HttpStatus.SERVICE_UNAVAILABLE.INTERNAL_SERVER_ERROR.value();
	
}
