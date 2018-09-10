package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class ExistingAthleteException extends Exception {
	
	private static final long serialVersionUID = 0L;
	
	public ExistingAthleteException(){
		super();
	}
	
	public ExistingAthleteException(String message){
		super(message);
	}

}
