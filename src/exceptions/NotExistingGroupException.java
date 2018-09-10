package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class NotExistingGroupException extends Exception {
	
	private static final long serialVersionUID = 0L;
	
	public NotExistingGroupException(){
		super();
	}
	
	public NotExistingGroupException(String message){
		super(message);
	}

}
