package aed;
import dataStructures.Iterator;
import exceptions.*;
/**
 *Create a Fitness class to manage all the athletes, groups, workouts and activities
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public class FitnessClass implements Fitness{
	
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	/**
	 * Athlete object
	 */
	private AthleteExtended athlete;
	/**
	 * Group object
	 */
	private GroupExtended group;
	/**
	 * Activity object
	 */
	private Activity activity;
	
	/**
	 * Fitness class constructor
	 */
	public void Fitness (){
		athlete = null;
		group = null;
		activity = null;
	}
	@Override
	public void createAthlete(String idTracker,int weight, int height, int age, 
			char sex, String name) throws ExistingAthleteException,InvalidValuesException{
		if(existAthlete(idTracker))
			throw new ExistingAthleteException();
		else if(weight < 0 || height < 0 || age < 0 || (sex !='M' && sex !='F'))
			throw new InvalidValuesException();

		athlete = new AthleteClass(idTracker, weight, height, age, sex, name);	
		
	}
	/**
	 * Checks if an athlete with <code>idTracker</code> exist in system
	 * @param idTracker unique identifier if an athlete
	 * @return true if athlete with <code>idTracker</code> exist in system, false otherwise
	 */
	private boolean existAthlete(String idTracker){
		if (athlete == null)
			return false;
		else if (!athlete.getIdTracker().equalsIgnoreCase(idTracker))
			return false;
		
		return true;
	}
	@Override
	public void modInfoAthlete(String idTracker,int weight, int height, int age) 
			throws NotExistingAthleteException, InvalidValuesException{
		if (!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		else if (weight < 0 || height < 0 || age < 0)
			throw new InvalidValuesException();
		
		athlete.setNewWeight(weight);
		athlete.setNewHeight(height);
		athlete.setNewAge(age);
	}
	@Override
	public void updateSteps(String idTracker, int steps) 
			throws NotExistingAthleteException, InvalidNumberOfStepsException{
		if (!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		else if (steps < 0)
			throw new InvalidNumberOfStepsException();
		
		athlete.addSteps(steps);
	}
	@Override
	public void addActivity( String idActivity,int met, String name) 
			throws InvalidMETException, ExistingActivityException{
		if (existActivity(idActivity))
			throw new ExistingActivityException();
		else if (met < 0)
			throw new InvalidMETException();
		
		
		activity = new ActivityClass(idActivity, met, name);
	}
	/**
	 * Checks if a activity with <code>idActivity</code> exist in system
	 * @param idActivity unique identifier if an activity
	 * @return true if activity with <code>idActivity</code> exist in system, false otherwise
	 */
	private boolean existActivity(String idActivity){
		if (activity == null)
			return false;
		else if (!activity.getIdActivity().equals(idActivity))
			return false;
		
		return true;
	}
	@Override
	public void addGroup(String idGroup, String name)throws ExistingGroupException {
		if (existGroup(idGroup))
			throw new ExistingGroupException();
		
		group = new GroupClass(idGroup, name);
	}
	/**
	 * Checks if a group with <code>idGroup</code> exist in system
	 * @param idGroup unique identifier if a group
	 * @return true if group with <code>idGroup</code> exist in system, false otherwise
	 */
	private boolean existGroup(String idGroup){
		if (group == null)
			return false;
		else if (!group.getIdGroup().equals(idGroup))
			return false;
		
		return true;
	}
	@Override
	public void addAthleteToGroup(String idTracker, String idGroup) 
			throws NotExistingAthleteException, NotExistingGroupException, AthleteEnrolledInGroupException{
		if(!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		else if (!existGroup(idGroup))
			throw new NotExistingGroupException();
		else if(athlete.isEnrolled())
			throw new AthleteEnrolledInGroupException();
		
		group.addAthleteToGroup(athlete);
		athlete.addAthleteToGroup(group);
	}
	
	@Override
	public void removeAthleteFromGroup(String idTracker,String idGroup) 
			throws NotExistingAthleteException, NotExistingGroupException, NotEnrolledAthleteException{
		if(!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		else if (!existGroup(idGroup))
			throw new NotExistingGroupException();
		else if(!athlete.isEnrolled())
			throw new NotEnrolledAthleteException();
		
		group.removeAthleteFromGroup();
		athlete.removeFromGroup();
	}
	@Override
	public void removeAthlete(String idTracker) throws NotExistingAthleteException{
		if(!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		
		athlete = null;
	}
	
	@Override
	public Athlete getAthlete (String idTracker) throws NotExistingAthleteException{
		if(!existAthlete(idTracker))
			throw new NotExistingAthleteException();
			
		return athlete;
	}
	@Override
	public void addWorkout(String idTracker,String idActivity,int duration) 
			throws InvalidTimeException, NotExistingAthleteException, NotExistingActivityException{
		if(duration < 0)
			throw new InvalidTimeException();
		else if(!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		else if (!existActivity(idActivity))
			throw new NotExistingActivityException();
		
		athlete.addWorkout(activity, duration);
	}
	@Override
	public Iterator<Workout> getWourkoutInfo(String idTracker, char type) 
			throws InvalidOptionException,NotExistingAthleteException, AtheleteHasNoWorkoutsException{
		if(type != 'T')
			throw new InvalidOptionException();
		else if (!existAthlete(idTracker))
			throw new NotExistingAthleteException();
		else if (athlete.hasNoWorkouts())
			throw new AtheleteHasNoWorkoutsException();
		
		return athlete.listWorkouts();
	}
	@Override
	public Group getGroup(String idGroup) throws NotExistingGroupException{
		if (!existGroup(idGroup)){
			throw new NotExistingGroupException();
		}
		return group;
	}
	
	@Override
	public Group getGroupWalkers() throws NotExistingGroupException{
		if (group == null){
			throw new NotExistingGroupException();
		}
		return group;
	}
	@Override
	public Group getGroupWarriors() throws NotExistingGroupException{
		if (group == null){
			throw new NotExistingGroupException();
		}
		return group;
	}
	
}
