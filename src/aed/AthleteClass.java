package aed;

import dataStructures.List;
import dataStructures.Iterator;
import dataStructures.DoublyLinkedList;

/**
 * Represents an athlete and his data
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */
public class AthleteClass implements AthleteExtended{
	/**
	 * Constant for serialization
	 */
	static final long serialVersionUID = 0L;
	/**
	 * Unique identifier of an athlete
	 */
	protected String idTracker;
	/**
	 * The name of an athlete
	 */
	protected String nome;
	/**
	 * The weight of an athlete 
	 */
	protected int peso;
	/**
	 * The height of an athlete
	 */
	protected int altura;
	/**
	 * The age of an athlete
	 */
	protected int idade;
	/**
	 * The sex type of an athlete
	 */
	protected char sexo;
	/**
	 * The calories burned by an athlete
	 */
	protected int calorias;
	/**
	 * The number of steps made by an athlete
	 */
	protected int  passos;
	/**
	 * An object of Group type
	 */
	protected Group groupOfThisAthlete;

	/**
	 * Constant defining a MAN athlete type to send to output for printing
	 */
	private static final String MASCULINE = "Masculino";
	/**
	 * Constant defining a WOMAN athlete type to send to output for printing
	 */
	private static final String FEMININE = "Feminino";
	/**
	 * Constant defining a WOMAN athlete type to calculate the calories
	 */
	private static final char F = 'F';
	/**
	 * Constant defining a MAN athlete type to calculate the calories
	 */
	private static final char M = 'M';
	
	/**
	 * List of workouts of the athlete
	 */
	protected List<Workout> workout;
	
	/**
	 * Athlete class constructor
	 */
	public AthleteClass(String idTracker, int weight, int height, int age, char sex, String name){
		this.idTracker = idTracker;
		peso = weight;
		altura = height;
		idade = age;
		sexo = sex;
		nome = name;
		calorias = 0;
		passos = 0;
		
		groupOfThisAthlete = null;
		workout = new DoublyLinkedList<Workout>();
		
	}
	@Override
	public String getIdTracker(){
		return idTracker;
	}
	@Override
	public String getName(){
		return nome;
	}
	@Override
	public int getWeight(){
		return peso;
	}
	@Override
	public int getHeight(){
		return altura;
	}
	@Override
	public String getSex(){
		if(sexo == 'F')
			return FEMININE;
		
		return MASCULINE;
	}
	@Override
	public char getSexChar(){
		if(sexo == 'F')
			return F;
		
		return M;
	}
	@Override
	public int getAge(){
		return idade;
	}
	@Override
	public int getCalories(){
		return calorias;
	}
	@Override
	public int getSteps(){
		return passos;	
	}
	@Override
	public boolean isEnrolled(){
		if (groupOfThisAthlete != null)
			return true;
		return false;
	}
	@Override
	public String getGroupName(){
		return groupOfThisAthlete.getName();
	}
	@Override
	public boolean hasNoWorkouts(){
		return workout.isEmpty();
	}
	@Override
	public void setNewWeight(int newWeight){
				peso = newWeight;
			}
	@Override		
	public void setNewHeight(int newHeight){
				altura = newHeight;
	}
	@Override		
	public void setNewAge(int newAge){
				idade = newAge;
	}
	@Override		
	public void addSteps (int newSteps){
				passos += newSteps;
	}
	@Override		
	public void addAthleteToGroup(Group group){
				groupOfThisAthlete = group;
	}
	@Override		
	public void removeFromGroup(){
				groupOfThisAthlete = null;
	}
	@Override		
	public void addWorkout(Activity activity, int duration){
				Workout workoutDLL = new WorkoutClass(this, activity, duration);
				calorias += workoutDLL.getCalories();  
				workout.addFirst(workoutDLL);
	}
	@Override		
	public Iterator<Workout> listWorkouts(){
				return workout.iterator();
	}
}
