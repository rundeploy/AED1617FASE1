package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class InvalidTimeException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	
	public InvalidTimeException(){
		super();
	}
	
	public InvalidTimeException(String message){
		super(message);
	}

}
