package com.pandevs.pandevs.exceptions;

public class UserNotFoundExceltion extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Método contructor va a recibir un parametro para poder evaluar y lanzar la Exception
	public UserNotFoundExceltion(Long id) {
		super("El usario con el Id: " + id + "no existe");
		
		
		
	}
}
