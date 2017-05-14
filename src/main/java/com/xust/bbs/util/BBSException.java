package com.xust.bbs.util;

public class BBSException extends RuntimeException{
	
	public BBSException(String msg,Throwable t){
		super(msg,t);
	}
}
