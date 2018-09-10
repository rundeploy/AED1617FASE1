package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class InvalidMETException extends Exception {
	
	private static final long serialVersionUID = 0L;
	
	public InvalidMETException(){
		super();
	}
	
	public InvalidMETException(String message){
		super(message);
	}

}
