package model;

enum Team{

	SCUDERIA_FERRARI, MCLAREN_F1_TEAM, RED_BULL_RACING, MERCEDES_AMG, RACING_POINT, ALFA_ROMEO, RENAULT, WILLIAMS;  
}

public class Pilot{

	//Atributes

	private String name;
	private int age;
	private String team;
	private int[] scores;

	//Methods

	//Builder method
	public Pilot(String pName, int pAge, String pTeam, int[] pScores){
		name = pName;
		age = pAge;
		scores = pScores;
		team = pTeam;
	}
	//End builder method

	//Getters & Setters

	public String getName(){
		return name;
	}

	public void setName(String pName){
		name = pName;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int pAge){
		age =  pAge; 
	}

	public String getTeam(){
		return team;
	}

	public void setTeam(String pTeam){
		team = pTeam;
	}

	public int[] getScores(){
		return scores;
	}

	public void setScores(int[] pScores){
		scores = pScores;
	}

	//Methods

	public double calculateAverage(){
		double sumScores = 0;
		for(int k=0;k<scores.length;k++){
			sumScores += scores[k];
		}
		double averagePilot = (sumScores/scores.length);
		return averagePilot;
	}

	public void addTeam(){
		Team teamX = null;
		if(getTeam().equalsIgnoreCase("Scuderia Ferrari")){
			teamX = Team.SCUDERIA_FERRARI; 
		} 
		if(getTeam().equalsIgnoreCase("Mclaren F1 Team")){
			teamX = Team.MCLAREN_F1_TEAM;
		}
		if(getTeam().equalsIgnoreCase("Red Bull Racing")){
			teamX = Team.RED_BULL_RACING;
		}
		if(getTeam().equalsIgnoreCase("Mercedes Amg")){
			teamX = Team.MERCEDES_AMG;
		} 
		if(getTeam().equalsIgnoreCase("Racing Point")){
			teamX = Team.RACING_POINT;
		} 
		if(getTeam().equalsIgnoreCase("Alfa Romeo")){
			teamX = Team.ALFA_ROMEO;
		} 
		if(getTeam().equalsIgnoreCase("Renault")){
			teamX = Team.RENAULT;
		}
		if(getTeam().equalsIgnoreCase("Williams")){
			teamX = Team.WILLIAMS;
		}
	}

}