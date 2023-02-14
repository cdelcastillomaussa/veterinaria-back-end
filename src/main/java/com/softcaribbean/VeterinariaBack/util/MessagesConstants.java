package com.softcaribbean.VeterinariaBack.util;

public class MessagesConstants {

	private MessagesConstants(){}

	public static final int ERROR_FIELD_VALIDATION_CODE = 1;
	public static final String MANDATORY_FIELD = "El campo %s es obligatorio";
	public static final String MAX_VALIDATION_FIELD = "El campo %s sobrepasa la cantidad permitida";
	
	public static final int ENTITY_ALREADY_EXISTS_CODE = 2;
	public static final String ENTITY_ALREADY_EXISTS = "ya existe un %s con ese id";
	public static final int ENTITY_NOT_EXISTS_CODE = 3;
	public static final String ENTITY_NOT_EXISTS = "No existe un %s con ese id";
	
	public static final int DEFAULT_ERROR_CODE = 99;
	public static final String DEFAULT_ERROR_MESSAGE = "Error realizando la operación";
}
