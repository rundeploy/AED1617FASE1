package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class InvalidNumberOfStepsException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	
	public InvalidNumberOfStepsException(){
		super();
	}
	
	public InvalidNumberOfStepsException(String message){
		super(message);
	}

}
