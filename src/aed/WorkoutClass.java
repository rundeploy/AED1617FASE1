package aed;

/**
 * Creates a Workout object - physical exercice of an athlete
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public class WorkoutClass implements Workout{
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	/**
	 * Athlete type variable
	 */
	private Athlete athlete;
	/**
	 * Activity type variable
	 */
	private Activity activity;
	/**
	 * Time (in hours) spent by an athlete to perform a workout
	 */
	private int duration;
	
	/**
	 * Workout class constructor
	 * @param athelete associate an athlete to this workout
	 * @param activity associate an activity to this workout
	 * @param duration time spent in hours to perform this workout
	 */
	public WorkoutClass(Athlete athelete, Activity activity, int duration){
		this.athlete = athelete;
		this.activity = activity;
		this.duration = duration;
	}
	@Override
	public int getCalories(){
		return Calories.calculateCalories(athlete.getWeight(), athlete.getHeight(),
				athlete.getSexChar(), athlete.getAge(), activity.getMET(), duration);
	}
	@Override
	public String getName(){
		return activity.getName();
	}
	
	
}
