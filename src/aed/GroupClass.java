package aed;

/**
 * Implementation of the Group object 
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public class GroupClass implements GroupExtended{
	
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	/**
	 *  Unique identifier of a Group
	 */
	private String idGrupo;
	/**
	 * tha name of the Group
	 */
	private String nome;
	/**
	 * An object of Athlete
	 */
	private Athlete athlete;
	/**
	 * Group class constructor
	 * @param idGroup identifier of the Group
	 * @param name name of the Group
	 */
	public GroupClass(String idGroup, String name){
		idGrupo = idGroup;
		nome = name;
		athlete = null;
	
	}
	@Override
	public String getName(){
		return nome;
	}
	@Override
	public String getIdGroup(){
		return idGrupo;
	}
	@Override
	public void addAthleteToGroup(Athlete a){
		athlete = a;
	}
	@Override
	public void removeAthleteFromGroup(){
		athlete = null;
	}
	@Override
	public int getCaloriesOfGroup(){
		if(athlete == null)
			return 0;
		return athlete.getCalories();
	}
	@Override
	public int getStepsOfGroup(){
		if(athlete == null)
			return 0;
		return athlete.getSteps();
	}
}
