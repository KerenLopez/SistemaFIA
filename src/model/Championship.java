package model;

public class Championship{

	//Constants
	public final static int NUM_PILOTS = 15;

	//Atributes
	private int year;
	private int races;
	/*private String team;*/

	//Relationships
	private Pilot[] pilots;

	//Methods

	//Builder method
	public Championship(int pYear, int pRaces){
		year = pYear;
		races = pRaces;
		pilots = new Pilot[NUM_PILOTS];
	}
	//End builder method

	public void addPilot(String pName, int pAge, /*int pTeam*/ int[] scores){
		boolean find = findPilot(pName);
		boolean stop = true;
		if(find==false){
			for(int k=0;k<pilots.length && stop;k++){
				if(pilots[k]==null){
					stop = false;
					pilots[k]= new Pilot(pName,pAge,/*pTeam*/scores);
				}
			}
		}
	}

	public boolean findPilot(String pilotName){
		boolean encontro=false;
		for(int k=0;k<pilots.length && !encontro;k++){
			if(pilots[k]!=null && pilots[k].getName().equalsIgnoreCase(pilotName)){
				encontro=true;
			}
		}
		return encontro;
	}

	public String showAverageTimes(){
		String message ="";
		double average, residuo, hours, min, seg;
		for(int k=0;k<pilots.length;k++){
			if(pilots[k]!=null){
				average = pilots[k].calculateAverage();
				residuo = (average % 3600);
				hours = (average-residuo)/3600;
				min = (residuo-hours)/60;
				seg = residuo % 60;
				message += "El promedio del piloto "+pilots[k].getName()+" es "+(int)hours+" horas "+(int)min+" minutos "+seg+" segundos\n";
			} 		
		} return message;
	}

	/*public String verifyTeam(){

	} */

	//Getters & Setters

	public int getYear(){
		return year;
	}

	public void setYear(int pYear){
		year = pYear;
	}

	public int getRaces(){
		return races;
	}

	public void setRaces(int pRaces){
		races = pRaces;
	}

	/*public String getTeam(){
		return team;
	}

	public void setTeam(pTeam){
		team = pTeam;
	}*/

	public Pilot[] getPilots(){
		return pilots;
	}

	public void setPilots(Pilot[] pPilots){
		pilots = pPilots;
	}
}