package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class AthleteEnrolledInGroupException extends Exception {

	private static final long serialVersionUID = 0L;
	
	public AthleteEnrolledInGroupException(){
		super();
	}
	
	public AthleteEnrolledInGroupException(String message){
		super(message);
	}
}
