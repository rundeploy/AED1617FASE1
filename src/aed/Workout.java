package aed;
import java.io.Serializable;
/**
 * Creates a Workout interface - physical exercice of an athlete
 *@author CRISTIAN MITUL 
 *@version AED Fase 1
 *@since 13.10.2016
 */
public interface Workout extends Serializable {
	
	/**
	 * Gets number of calories burned by an athlete
	 * @return number of calories burned
	 */
	public int getCalories();
	/**
	 * Gets the name of the activity that was chosen for workout
	 * @return activity name 
	 */
	public String getName();

}
