package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class AtheleteHasNoWorkoutsException extends Exception {

private static final long serialVersionUID = 0L;
	
	public AtheleteHasNoWorkoutsException(){
		super();
	}
	
	public AtheleteHasNoWorkoutsException(String message){
		super(message);
	}

}
