package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class NotEnrolledAthleteException extends Exception {

private static final long serialVersionUID = 0L;
	
	public NotEnrolledAthleteException(){
		super();
	}
	
	public NotEnrolledAthleteException(String message){
		super(message);
	}

}
