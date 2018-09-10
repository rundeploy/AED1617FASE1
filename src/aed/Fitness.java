package aed;
import java.io.Serializable;

import dataStructures.Iterator;
import exceptions.*;

/**
 * Create a Fitness to manage all the athletes, groups, workouts and activities
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */
public interface Fitness extends Serializable{
	/**
	 * Creates a new athlete
	 * @param idTracker unique identifier of an athlete
	 * @param weight number in kilograms representing body weight of the athlete 
	 * @param height number in centimeters representing how tall is the athlete
	 * @param age number in years representing how tall is the athlete
	 * @param sex represents if the athlete is F - woman or a M - man
	 * @param name name of the athlete
	 * @throws ExistingAthleteException if athlete with <code>idTracker</code> already exists in system
	 * @throws InvalidValuesException if <code>weight</code>, <code>height</code>, <code>age</code> inserted are smaller than 0 
	 * and if sex type is not <code>F</code> for woman or is not <code>M</code> for man
	 */
	public void createAthlete(String idTracker,int weight, int height, int age, 
			char sex, String name) throws ExistingAthleteException,InvalidValuesException;
	/**
	 * Modify athletes data
	 * @param idTracker unique identifier of an athlete
	 * @param weight number in kilograms representing body weight of the athlete
	 * @param height number in centimeters representing how tall is the athlete
	 * @param age number in years representing how tall is the athlete
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 * @throws InvalidValuesException if <code>weight</code>, <code>height</code>, <code>age</code> inserted are smaller than 0
	 */
	public void modInfoAthlete(String idTracker,int weight, int height, int age) 
			throws NotExistingAthleteException, InvalidValuesException;
	/**
	 * Insert new Steps performed by the athlete
	 * @param idTracker unique identifier of an athlete
	 * @param steps number of steps to be added
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 * @throws InvalidNumberOfStepsException if number of <code>steps</code> inserted are smaller than 0
	 */
	public void updateSteps(String idTracker, int steps) 
			throws NotExistingAthleteException, InvalidNumberOfStepsException;
	/**
	 * Create a new activity
	 * @param idActivity unique identifier of an activity
	 * @param met metabolic equivalent for this type of activity
	 * @param name name of the activity
	 * @throws InvalidMETException if number of <code>met</code> inserted are smaller than 0
	 * @throws ExistingActivityException if activity with <code>idActivity</code> already exists in system
	 */
	public void addActivity( String idActivity,int met, String name) 
			throws InvalidMETException, ExistingActivityException;
	/**
	 * Create a new Group of athletes
	 * @param idGroup unique identifier of a group
	 * @param name name of the group
	 * @throws ExistingGroupException if group with <code>idGroup</code> already exists in system
	 */
	public void addGroup(String idGroup, String name)throws ExistingGroupException;
	/**
	 * Enroll an athlete to a group
	 * @param idTracker unique identifier of an athlete
	 * @param idGroup unique identifier of a group
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 * @throws NotExistingGroupException if group with <code>idGroup</code> does not exists in system
	 * @throws AthleteEnrolledInGroupException if the athlete with <code>idTracker</code> is already enrolled to a group
	 */
	public void addAthleteToGroup(String idTracker, String idGroup) 
			throws NotExistingAthleteException, NotExistingGroupException, AthleteEnrolledInGroupException;
	/**
	 * Remove the athlete with <code>idTracker</code> from group <code>idGroup</code>
	 * @param idTracker unique identifier of an athlete
	 * @param idGroup unique identifier of a group
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 * @throws NotExistingGroupException if group with <code>idGroup</code> does not exists in system
	 * @throws NotEnrolledAthleteException if the athlete with <code>idTracker</code> is not enrolled to a group <code>idGroup</code>
	 */
	public void removeAthleteFromGroup(String idTracker,String idGroup) 
			throws NotExistingAthleteException, NotExistingGroupException, NotEnrolledAthleteException;
	/**
	 * Remove the athlete <code>idTracker</code> from system
	 * @param idTracker unique identifier of an athlete
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 */
	public void removeAthlete(String idTracker) throws NotExistingAthleteException;
	/**
	 * Gets the athlete object
	 * @param idTracker unique identifier of an athlete
	 * @return athlete object that has the <code>idTracker</code> identifier
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 */
	public Athlete getAthlete (String idTracker) throws NotExistingAthleteException;
	/**
	 * Add a new workout to athlete workouts list
	 * @param idTracker unique identifier of an athlete
	 * @param idActivity unique identifier of an activity
	 * @param duration times in hours spend to perform a workout by an athlete
	 * @throws InvalidTimeException if <code>duration</code> inserted is smaller than 0
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 * @throws NotExistingActivityException if activity with <code>idActivity</code> does not exists in system
	 */
	public void addWorkout(String idTracker,String idActivity,int duration) 
			throws InvalidTimeException, NotExistingAthleteException, NotExistingActivityException;
	/**
	 * Iterate through a workout list of an athlete and returns it
	 * @param idTracker unique identifier of an athlete
	 * @param type if type T then lists workouts in chronological order 
	 * @return gets an iterator of workouts list
	 * @throws InvalidOptionException if <code>type</code> inserted is different that T
	 * @throws NotExistingAthleteException if athlete with <code>idTracker</code> does not exists in system
	 * @throws AtheleteHasNoWorkoutsExceptionif athlete with <code>idTracker</code> does not has workouts performed
	 */
	public Iterator<Workout> getWourkoutInfo(String idTracker, char type) 
			throws InvalidOptionException,NotExistingAthleteException, AtheleteHasNoWorkoutsException;
	/**
	 * Gets a Group with <code>idGroup</code> identifier
	 * @param idGroup unique identifier of a group
	 * @return a Group with <code>idGroup</code> identifier
	 * @throws NotExistingGroupException if group with <code>idGroup</code> does not exists in system
	 */
	public Group getGroup(String idGroup) throws NotExistingGroupException;
	/**
	 * Gets the Groups that has the most number of steps made by his athletes in decreasing order
	 * @return in decreasing order the groups with most steps 
	 * @throws NotExistingGroupException if group with <code>idGroup</code> does not exists in system
	 */
	public Group getGroupWalkers() throws NotExistingGroupException;
	/**
	 * Gets the Groups that has the biggest number of burned calories by athletes in decreasing order
	 * @return in decreasing order the groups with most burned calories
	 * @throws NotExistingGroupException if group with <code>idGroup</code> does not exists in system
	 */
	public Group getGroupWarriors() throws NotExistingGroupException;
	
	
}
