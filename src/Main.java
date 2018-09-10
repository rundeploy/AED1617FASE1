import java.util.Scanner;
import java.io.*;

import aed.*;
import exceptions.*;
import dataStructures.*;
/**
 *@author CRISTIAN MITUL
 *@version AED Fase 1
 *@since 13.10.2016
 */

public class Main {
	
	private static final String ADD_ATHLETE = "IU";
	private static final String ATHLETE_ADDED = "Insercao de atleta com sucesso.\n";
	private static final String EXISTING_ATHLETE = "Atleta existente.\n";
	private static final String NOT_VALID_VALUES = "Valores invalidos.\n";
	
	private static final String UPDATE_INFO_ATHLETE = "UU";
	private static final String ATHLETE_UPDATED = "Atleta atualizado com sucesso.\n";
	private static final String NOT_EXISTING_ATHLETE = "Atleta inexistente.\n";
	
	private static final String REMOVE_ATHLETE = "RU";
	private static final String ATHLETE_REMOVED = "Atleta removido com sucesso.\n";
	
	private static final String GET_ATHLETE_INFO = "CU";
	
	private static final String ADD_ACTIVITY = "IA";
	private static final String ACTIVITY_CREATED = "Atividade criada com sucesso.\n";
	private static final String NOT_VALID_MET = "MET invalido.\n";
	private static final String EXISTING_ACTIVITY = "Atividade existente.\n";
	
	private static final String ADD_WORKOUT = "AW";
	private static final String WORKOUT_ADDED = "Treino adicionado com sucesso.\n";
	private static final String NOT_VALID_TIME = "Tempo invalido.\n";
	private static final String NOT_EXISTING_ACTIVITY = "Atividade inexistente.\n";
	
	private static final String GET_WORKOUT_INFO = "CW";
	private static final String NOT_VALID_OPTION = "Opcao invalida.\n";
	private static final String ATHLETE_HAS_NO_WORKOUTS = "Atleta sem treinos.\n";
	
	
	private static final String ADD_STEPS = "AS";
	private static final String STEPS_UPDATED = "Atualizacao de passos com sucesso.\n";
	private static final String NOT_VALID_STEPS = "Numero de passos invalido.\n";
	
	private static final String ADD_GROUP = "IG"; 
	private static final String GROUP_ADDED = "Grupo criado com sucesso.\n";
	private static final String EXISTING_GROUP = "Grupo existente.\n";
	
	private static final String ADD_ATHLETE_TO_GROUP = "AG";
	private static final String ATHLETE_ENROLLED_TO_GROUP = "Adesao realizada com sucesso.\n";
	private static final String NOT_EXISTING_GROUP = "Grupo inexistente.\n";
	private static final String ATHLETE_ALREADY_ENROLLED = "Atleta ja tem grupo.\n";
	
	private static final String REMOVE_ATHLETE_FROM_GROUP = "DG";
	private static final String ATHLETE_GIVED_UP = "Desistencia realizada com sucesso.\n";
	private static final String NOT_ENROLLED_ATHLETE = "Atleta nao pertence ao grupo.\n";
	
	private static final String GET_GROUP_INFO = "CG";
	private static final String CAL = "cal";
	private static final String PS = "ps";
	private static final String KG = "kg";
	private static final String ANOS = "anos";
	
	private static final String GRUPO = "Grupo";
	
	/*private static final String LIST_GROUP = "LG";
	private static final String NOBODY_ENROLLED = "Grupo nao tem adesoes.\n";*/
	
	private static final String LIST_WALKERS = "LC";
	private static final String NOT_EXISTING_GROUPS = "Nao existem grupos.\n";
	
	private static final String LIST_WARRIORS = "LW";
	
	private static final String EXIT = "XS";
	private static final String EXITTING_MESSAGE = "Gravando e terminando...\n";
	

	public static void main(String[] args) {
		
		Fitness fit = load(); //Loads data from file into the system
		Scanner in = new Scanner(System.in);
		
		if (fit == null)
			fit = new FitnessClass();//if data from file is empty, creates new system
		String command = "";
		
		while ( !command.equalsIgnoreCase(EXIT)){
			command = in.next();
			
			if(command.equalsIgnoreCase(ADD_ATHLETE))
				addAthlete(fit, in);
			
			else if (command.equalsIgnoreCase(UPDATE_INFO_ATHLETE))
				updateInfoAthelte(fit, in);
			
			else if (command.equalsIgnoreCase(REMOVE_ATHLETE))
				removeAthlete(fit, in);
			
			else if (command.equalsIgnoreCase(GET_ATHLETE_INFO))
				getInfoAthlete(fit, in);
			
			else if (command.equalsIgnoreCase(ADD_ACTIVITY))
				addActivity(fit, in);
			
			else if (command.equalsIgnoreCase(ADD_WORKOUT))
				addWorkout(fit, in);
			
			else if (command.equalsIgnoreCase(GET_WORKOUT_INFO))
				getWourkoutInfo(fit, in);
			
			else if (command.equalsIgnoreCase(ADD_STEPS))
				addSteps(fit, in);
			
			else if (command.equalsIgnoreCase(ADD_GROUP))
				addGroup(fit, in);
			
			else if (command.equalsIgnoreCase(ADD_ATHLETE_TO_GROUP))
				addAthleteToGroup(fit, in);
			
			else if (command.equalsIgnoreCase(REMOVE_ATHLETE_FROM_GROUP))
				removeAthleteFromGroup(fit, in);
			
			else if (command.equalsIgnoreCase(GET_GROUP_INFO))
				getGroupInfo(fit, in);
			
			/*else if ( command.equalsIgnoreCase(LIST_GROUP))
				listGroup(fit, in);*/
							
			else if (command.equalsIgnoreCase(LIST_WALKERS))
				listWalkers(fit, in);

			else if (command.equalsIgnoreCase(LIST_WARRIORS))
				listWarriors(fit, in);
		}
		System.out.println(EXITTING_MESSAGE);
		store(fit); // stores the data to file if successfully exited
	}
	//List groups of athletes which has the most calories burned in decreasing order
	private static void listWarriors(Fitness fit, Scanner in) {
		try{
			Group gr = fit.getGroupWarriors();
			System.out.println(GRUPO + " " + gr.getName() + ":" + " " + gr.getCaloriesOfGroup() + " " + CAL + "," + " " + 
			gr.getStepsOfGroup() + " " + PS + "\n");
		}catch(NotExistingGroupException e){
			System.out.println(NOT_EXISTING_GROUPS);
		}
		
	}
	//List groups of athletes which has made the most steps in decreasing order
	private static void listWalkers(Fitness fit, Scanner in) {
		
		try{
			Group gr = fit.getGroupWalkers();
			System.out.println(GRUPO + " " + gr.getName() + ":" + " " + gr.getCaloriesOfGroup() + " " + CAL + "," + " " + 
			gr.getStepsOfGroup() + " " + PS + "\n");
		}catch(NotExistingGroupException e){
			System.out.println(NOT_EXISTING_GROUPS);
		}
		
	}

	/*private static void listGroup(Fitness fit, Scanner in) {
		Not applicable for fase 1 and fase 2
		
	}*/
	//Gets the data of the group
	private static void getGroupInfo(Fitness fit, Scanner in) {
		String idGroup = in.next();
		
		try{
			Group gr = fit.getGroup(idGroup);
			System.out.println(GRUPO + " " + gr.getName() + ":" + " " + gr.getCaloriesOfGroup() + " " + CAL + "," + " " + 
			gr.getStepsOfGroup() + " " + PS + "\n");
		}catch( NotExistingGroupException e){
			System.out.println(NOT_EXISTING_GROUP);
		}
		
	}
	//Removes an athlete from group
	private static void removeAthleteFromGroup(Fitness fit, Scanner in) {
		String idTracker = in.next();
		String idGroup = in.next();
		
		try{
			fit.removeAthleteFromGroup(idTracker, idGroup);
			System.out.println(ATHLETE_GIVED_UP);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}catch( NotExistingGroupException e){
			System.out.println(NOT_EXISTING_GROUP);
		}catch (NotEnrolledAthleteException e){
			System.out.println(NOT_ENROLLED_ATHLETE);
		}
		
	}
	//Adds an athlete to group
	private static void addAthleteToGroup(Fitness fit, Scanner in) {
		String idTracker = in.next();
		String idGroup = in.next();
		
		try{
			fit.addAthleteToGroup(idTracker, idGroup);
			System.out.println(ATHLETE_ENROLLED_TO_GROUP);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}catch( NotExistingGroupException e){
			System.out.println(NOT_EXISTING_GROUP);
		}catch (AthleteEnrolledInGroupException e){
			System.out.println(ATHLETE_ALREADY_ENROLLED);
		}
		
	}
	//Creates new group of athletes
	private static void addGroup(Fitness fit, Scanner in) {
		String idGroup = in.next();
		String name = in.next();
		
		try{
			fit.addGroup(idGroup, name);
			System.out.println(GROUP_ADDED);
			
		}catch(ExistingGroupException e){
			System.out.println(EXISTING_GROUP);
		}
		
	}
	//Adds new steps to an athlete
	private static void addSteps(Fitness fit, Scanner in) {
		String idTracker = in.next();
		int steps = in.nextInt();
		
		try{
			fit.updateSteps(idTracker, steps);
			System.out.println(STEPS_UPDATED);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}catch (InvalidNumberOfStepsException e){
			System.out.println(NOT_VALID_STEPS);
		}
		
	}
	//Gets a list of workouts of an athlete
	private static void getWourkoutInfo(Fitness fit, Scanner in) {
		String idTracker = in.next();
		char type = in.next().trim().charAt(0);
		
		try{
			Iterator<Workout> it = fit.getWourkoutInfo(idTracker, type);
			while (it.hasNext()){
				Workout wo = it.next();
				System.out.println(wo.getName() + " " + wo.getCalories() + " " + CAL);
			}System.out.println();
		}catch (InvalidOptionException e){
			System.out.println(NOT_VALID_OPTION);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}catch (AtheleteHasNoWorkoutsException e){
			System.out.println(ATHLETE_HAS_NO_WORKOUTS);
		}
		
	}
	//Add new workout to an athlete
	private static void addWorkout(Fitness fit, Scanner in) {
		String idTracker = in.next();
		String idActivity = in.next();
		int duration = in.nextInt();
		
		try{
			fit.addWorkout(idTracker, idActivity, duration);
			System.out.println(WORKOUT_ADDED);
		}catch (InvalidTimeException e ){
			System.out.println(NOT_VALID_TIME);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}catch (NotExistingActivityException e){
			System.out.println(NOT_EXISTING_ACTIVITY);
		}
		
		
	}
	//Add new activity in the system
	private static void addActivity(Fitness fit, Scanner in) {
		String idActivity = in.next();
		int met = in.nextInt();
		String name = in.nextLine().trim();
		
		try {
			fit.addActivity(idActivity, met, name);
			System.out.println(ACTIVITY_CREATED);
		}catch (InvalidMETException e){
			System.out.println(NOT_VALID_MET);
			
		}catch (ExistingActivityException e){
			System.out.println(EXISTING_ACTIVITY);
		}
		
	}
	//Gets the data of an athlete
	private static void getInfoAthlete(Fitness fit, Scanner in) {
		String idTracker = in.next();
		
		try{
			Athlete a = fit.getAthlete(idTracker);
			if(a.isEnrolled()){
				System.out.println(a.getName() + ": " + a.getSex() + ", " + a.getWeight() + " " + KG + ", " + 
			a.getAge() + " " + ANOS + ", " + a.getCalories() + " " + CAL + ", " + 
			a.getSteps() + " " + PS + " " + "(" + a.getGroupName() + ")\n");
			}else
				System.out.println(a.getName() + ": " + a.getSex() + ", " + a.getWeight() + " " + KG + ", " + 
						a.getAge() + " " + ANOS + ", " + a.getCalories() + " " + CAL + ", " + 
						a.getSteps() + " " + PS + "\n");
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}
	
	}
	//Remove an athlete from system
	private static void removeAthlete(Fitness fit, Scanner in) {
		String idTracker = in.next();
		
		try{
			fit.removeAthlete(idTracker);
			System.out.println(ATHLETE_REMOVED);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}
		
	}
	//Update information of an athlete
	private static void updateInfoAthelte(Fitness fit, Scanner in) {
		String idTracker = in.next();
		int weight = in.nextInt();
		int height = in.nextInt();
		int age = in.nextInt();
		
		try{
			fit.modInfoAthlete(idTracker, weight, height, age);
			System.out.println(ATHLETE_UPDATED);
		}catch (InvalidValuesException e){
			System.out.println(NOT_VALID_VALUES);
		}catch (NotExistingAthleteException e){
			System.out.println(NOT_EXISTING_ATHLETE);
		}
	}
	//Add an athlete to the system
	private static void addAthlete(Fitness fit, Scanner in){
		String idTracker = in.next();
		int weight = in.nextInt();
		int height = in.nextInt();
		int age = in.nextInt();
		char sex = in.next().trim().charAt(0); // Using trim to be sure there are no whitespace getting the char
		String name = in.nextLine().trim();
			
		try{
			fit.createAthlete(idTracker, weight, height, age, sex, name);
			System.out.println(ATHLETE_ADDED);
		}catch ( ExistingAthleteException e){
			System.out.println(EXISTING_ATHLETE);
		}catch (InvalidValuesException e){
			System.out.println(NOT_VALID_VALUES);
		}
	}
	/**
	 * Saves all the data from memory to a file to be used/loaded the next time the system will be initialized
	 * @param fit saves the all current system information
	 */
	private static void store(Fitness fit){
		try{
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("file"));
			file.writeObject(fit);
			file.flush();
			file.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Loads data from file into the memory of our system
	 * @return gets the data of the last system successfully exit
	 */
	private static Fitness load(){
		Fitness fit = null;
		try{
			ObjectInputStream file = new ObjectInputStream(new FileInputStream("file"));
			fit = (FitnessClass) file.readObject();
			file.close();
			
		}catch (IOException e){
			fit = new FitnessClass();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			System.exit(0);
		}
		return fit;
	}
	
	
	
	
	
	
	
	
	
	

}
