package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class InvalidOptionException extends Exception {

private static final long serialVersionUID = 0L;
	
	public InvalidOptionException(){
		super();
	}
	
	public InvalidOptionException(String message){
		super(message);
	}

}
