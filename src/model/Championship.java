package model;

public class Championship{

	//Atributes
	private int year;
	private int races;
	private String team;

	//Relationships
	private Pilot[] pilots;

	//Methods

	//Builder method
	public Championship(int pYear, int pRaces){
		year = pYear;
		races = pRaces;
		pilots = new Pilot[15]
	}
	//End builder method

	public void addPilot(String pName, int pAge, String pTeam, int[] scores){
		boolean find = findPilot(pName);
		boolean stop = true;
		if(find==false){
			for(int k=0;k<pilots.length && !stop;k++){
				if(pilots[k]==null){
					stop = false;
					pilots[k]= new Pilot(pName,pAge,pTeam,scores);
				}
			}
		}
	}

	public boolean findPilot(String pilotName){
		boolean encontro=false;
		for(int k=0;k<pilots.length && encontro;k++){
			if(pilots[k]!=null && pilots[k].getName().equalsIgnorecase(pilotName)){
				encontro=true;
			}
		}
		return encontro;
	}

	public String showAverageTimes(){

	}

	public String verifyTeam(){

	} 

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

	public String getTeam(){
		return team;
	}

	public void setTeam(pTeam){
		team = pTeam;
	}

	public Pilot[] getPilots(){
		return pilots;
	}

	public void setPilots(Pilot[] pPilots){
		pilots = pPilots;
	}
}