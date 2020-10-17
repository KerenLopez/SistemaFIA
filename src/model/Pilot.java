package model;

enum Team{

	SCUDERIA_FERRARI, MCLAREN_F1_TEAM, RED_BULL_RACING, MERCEDES_AMG, RACING_POINT, ALFA_ROMEO, RENAULT, WILLIAMS;  
}

public class Pilot{

	//Atributes

	private String name;
	private int age;
	private int[] scores;

	//Methods

	//Builder method
	public Pilot(String pName, int pAge, String pTeam, int[] pScores){
		name = pName;
		age = pAge;
		scores = pScores;
	}
	//End builder method

	public double calculateAverage(){
		double sumScores = 0;
		for(k=0;k<scores.length;k++){
			sumScores += scores[k];
		}
		double averagePilot = (sumScores/scores.length);
		return averagePilot;
	}

	//Getters & Setters

	public String getName(){
		return name;
	}

	public void setName(pName){
		name = pName;
	}

	public int getAge(){
		return age;
	}

	public void setAge(pAge){
		age =  pAge; 
	}

	public int[] getScores(){
		return scores;
	}

	public void setScores(int[] pScores){
		scores = pScores;
	}
}