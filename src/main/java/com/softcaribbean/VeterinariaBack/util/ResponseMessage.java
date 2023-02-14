package com.softcaribbean.VeterinariaBack.util;

public class ResponseMessage<T> {

    public ResponseMessage(){
        //Default constructor
    }

	//Constructor parameters
    public ResponseMessage(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
	
	private int code;
	private String message;
	private T data;
	
	public int getCode() {
		return code;
	}
	public void setCodigo(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
