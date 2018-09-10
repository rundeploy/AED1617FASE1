package exceptions;
/**
 * 
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class ExistingGroupException  extends Exception {

	private static final long serialVersionUID = 0L;
	
	public ExistingGroupException(){
		super();
	}
	
	public ExistingGroupException(String message){
		super(message);
	}

}
