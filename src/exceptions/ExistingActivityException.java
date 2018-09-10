package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class ExistingActivityException extends Exception {

	private static final long serialVersionUID = 0L;
	
	public ExistingActivityException(){
		super();
	}
	
	public ExistingActivityException(String message){
		super(message);
	}
	
}
