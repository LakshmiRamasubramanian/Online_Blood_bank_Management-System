package com.obbs.exception;

//This is used to catch the user defined exception.
public class ApplicationException extends Exception {

	String exceptionerror;

	public ApplicationException(String error) {
		this.exceptionerror = error;
	}

	public String toString() {
		return " There is some problem due to " + exceptionerror;
	}
}
