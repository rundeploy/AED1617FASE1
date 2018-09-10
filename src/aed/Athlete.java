package aed;

import dataStructures.Iterator;
import java.io.Serializable;
/**
 * Creates an Athlete object (getters)
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */
public interface Athlete extends Serializable{
	
	/**
	 * Gets unique identifier of an athlete.
	 * @return this athlete identifier
	 */
	public String getIdTracker();
	/**
	 * Gets athlete name.
	 * @return this athlete name.
	 */
	public String getName();
	/**
	 * Gets athlete weight.
	 * @return this athlete weight.
	 */
	public int getWeight();
	/**
	 * Gets athlete height.
	 * @return this athlete height.
	 */
	public int getHeight();
	/**
	 * Gets athlete age.
	 * @return this athlete age.
	 */
	public int getAge();
	/**
	 * Gets athlete type
	 * @return this athlete type
	 */
	public String getSex();
	/**
	 * Gets athlete calories.
	 * @return this athlete calories.
	 */
	public int getCalories();
	/**
	 * Gets athlete steps.
	 * @return this athlete steps.
	 */
	public int getSteps();
	/**
	 * Checks if an athlete is enrolled to any group
	 * @return true iff athlete is enrolled to any group, false otherwise
	 */
	public boolean isEnrolled();
	/**
	 * Gets the group name that this athlete is enrolled
	 * @return group name that this athlete is enrolled
	 */
	public String getGroupName();
	/**
	 * Checks if an athlete is: <code>M</code> - Man or <code>F</code> - Woman
	 * @return <code>M</code> if athlete is a Man or <code>F</code> -if a Woman
	 */
	public char getSexChar();
	/**
	 * Checks if an athlete has no workouts
	 * @return true if list of workouts isEmpty(), false otherwise
	 */
	public boolean hasNoWorkouts();
	/**
	 * Returns an iterator of the workouts of the athlete in the list (in proper sequence).
	 * @return Iterator of workouts in the list
	 */
	public Iterator<Workout> listWorkouts();
	
	
	
	
}
