package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class NotExistingActivityException extends Exception {
	
	private static final long serialVersionUID = 0L;
	
	public NotExistingActivityException(){
		super();
	}
	
	public NotExistingActivityException(String message){
		super(message);
	}


}
