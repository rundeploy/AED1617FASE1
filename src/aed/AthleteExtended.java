package aed;

/**
 * Extends the creation of an Athlete object (setters)
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public interface AthleteExtended extends Athlete{

	
	/**
	 * Sets the new weight of an athlete.
	 * @param newWeight This athlete new weight. 
	 */
	public void setNewWeight(int newWeight);
	/**
	 * Sets the new height of an athlete.
	 * @param newHeight This athlete new height. 
	 */
	public void setNewHeight(int newHeight);
	/**
	 * Sums more steps made by an athlete.
	 * @param newSteps This athlete new steps.
	 */
	public void addSteps ( int newSteps);
	/**
	 * Sets the new age of an athlete.
	 * @param newAge This athlete new age. 
	 */
	public void setNewAge( int newAge);
	/**
	 * Enrolls an athlete to group
	 * @param group This athlete group
	 */
	public void addAthleteToGroup(Group group);
	/**
	 * Removes this athlete from the group he belongs to
	 */
	public void removeFromGroup();
	/**
	 * Add new workout in the list of workouts of this athlete
	 * @param activity the type of workout athlete would perform
	 * @param duration time (in hours) spent by athlete to perform a workout
	 */
	public void addWorkout( Activity activity, int duration);
}
