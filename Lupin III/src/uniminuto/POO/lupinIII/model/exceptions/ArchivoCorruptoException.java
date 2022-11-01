package uniminuto.POO.lupinIII.model.exceptions;

import java.io.IOException;

public class ArchivoCorruptoException extends IOException {

	private static final long serialVersionUID = 6202157402936681228L;

	public ArchivoCorruptoException(){
		super("Archivo Corrupto");
	}
	
	public ArchivoCorruptoException(String msg){
		super(msg);
	}
	
}
