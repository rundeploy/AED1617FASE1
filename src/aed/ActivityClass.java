package aed;


/**
 * Activity implementation for workouts of an athlete
 *@author CRISTIAN MITUL
 *@version Fase 1 (2016)
 */

public class ActivityClass implements Activity{
	
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	/**
	 * Unique identifier of the activity
	 */
	private String idAtividade;
	/**
	 * Number which is a metabolic equivalent for this activity
	 */
	private int met;
	/**
	 * Name of the activity
	 */
	private String nome;
	/**
	 * Activity class constructor
	 * @param idActivity identifier of the activity
	 * @param met metabolic equivalent
	 * @param name name of this activity
	 */
	public ActivityClass(String idActivity, int met, String name){
		idAtividade = idActivity;
		this.met  =  met;
		nome = name;
	}
	@Override
	public String getIdActivity(){
		return idAtividade;
	}
	@Override
	public int getMET(){
		return met;
	}
	@Override
	public String getName(){
		return nome;
	}
	

}
