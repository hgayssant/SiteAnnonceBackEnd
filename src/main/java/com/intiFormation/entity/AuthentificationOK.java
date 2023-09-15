package com.intiFormation.entity;

public class AuthentificationOK {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthentificationOK(String message) {
		super();
		this.message = message;
	}

	public AuthentificationOK() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthentificationOK [message=" + message + "]";
	}
	
	
}
