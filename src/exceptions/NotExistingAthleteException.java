package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class NotExistingAthleteException extends Exception {
	
	private static final long serialVersionUID = 0L;
	
	public NotExistingAthleteException(){
		super();
	}
	
	public NotExistingAthleteException(String message){
		super(message);
	}

}
