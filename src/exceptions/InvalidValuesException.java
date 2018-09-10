package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class InvalidValuesException extends Exception{
	
	private static final long serialVersionUID = 0L;
	
	
	public InvalidValuesException(){
		super();
	}
	
	public InvalidValuesException(String message){
		super(message);
	}

}
