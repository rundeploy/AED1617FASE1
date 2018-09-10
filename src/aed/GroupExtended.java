package aed;
/**
 * Extends the creation of a Group object (setters)
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public interface GroupExtended extends Group{
	/**
	 * Enroll an athlete to a Group.
	 * @param a athlete to enroll to Group.
	 */
	public void addAthleteToGroup(Athlete a);
	/**
	 * Remove an athlete from Group.
	 */
	public void removeAthleteFromGroup();

}
