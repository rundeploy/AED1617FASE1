package aed;
import java.io.Serializable;
/**
 * Activity specifies the type of workout that athlete can perform
 *@author CRISTIAN MITUL 
 *@version AED Fase 1
 *@since 13.10.2016
 */
public interface Activity extends Serializable{
	/**
	 * This activity unique identifier
	 * @return gets the unique identifier of this activity
	 */
	public String getIdActivity();
	/**
	 * Metabolic equivalent for this activity
	 * @return number which is a metabolic equivalent for this activity
	 */
	public int getMET();
	/**
	 * Gets the name of the activity
	 * @return the name of the activity
	 */
	public String getName();

}
