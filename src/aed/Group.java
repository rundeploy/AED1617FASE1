package aed;
import java.io.Serializable;
/**
 * Group of athletes
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public interface Group extends Serializable{
	/**
	 * Gets unique identifier of a group
	 * @return id of a group
	 */
	public String getIdGroup();
	/**
	 * Gets the group name
	 * @return group name
	 */
	public String getName();
	/**
	 * Gets total amount of calories of the athletes that belong to this group
	 * @return total calories burned by athletes of this group
	 */
	public int getCaloriesOfGroup();
	/**
	 * Gets total number of steps performed by the athletes of this group
	 * @return total number of steps made by the athletes of this group
	 */
	public int getStepsOfGroup();

}
