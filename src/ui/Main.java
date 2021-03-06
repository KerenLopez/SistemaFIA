package ui;
import model.Championship;
import java.util.Scanner;

public class Main{

	public Scanner lector;

	//Atributes
	private Championship mainChampionship;

	public Main(){
		lector = new Scanner(System.in);
		createChampionship();
	}
		
	public static void main(String[] args){

		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while (option!=3);	
	}

	public void createChampionship(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Bienvenido al sistema de la FIA");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		int year, quantity; 
		System.out.println("REGISTRAR LA INFORMACION DEL CAMPEONATO");
		System.out.println("\nIngrese el anio del campeonato: ");
		year = lector.nextInt();
		System.out.println("\nIngrese la cantidad de grandes premios: ");
		quantity = lector.nextInt();lector.nextLine();
		mainChampionship = new Championship(year, quantity);
	}

	public int menu(){
		int option = 0;
		boolean menu = true;
		while (menu){
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\nSeleccione una opcion para continuar\n"+"1. Registrar la informacion de un piloto\n"+"2. Conocer el tiempo promedio obtenido por cada piloto en los grandes premios\n"+"3. Finalizar la aplicacion\n");
			option = lector.nextInt(); lector.nextLine();
			switch(option){
				case 1:
					if(mainChampionship.getPilots()[(Championship.NUM_PILOTS)-1]==null){
						createPilots();
					} else {
						System.out.println("Ya ha ingresado la maxima cantidad de pilotos, no es posible digitar otro");
					}	
					menu = false;
				    break;
				case 2:
					displayAverages();
					menu = false;
					break;
				case 3:	
					System.out.println("\nGracias por utilizar nuestra aplicacion");
					menu = false;
					break;		
				default:
					System.out.println("\nError, opcion no valida");
					menu = false;
					break;	    	
			}
		} return option;
	}	

	public void createPilots(){
		String namePilot, nameTeam, message = "";
		int agePilot, quantity = mainChampionship.getRaces();
		boolean encontro = false;
		int[] pilotScores = new int [quantity];
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("REGISTRAR LA INFORMACION DE LOS PILOTOS");	
		do{
			System.out.println("\nIngrese el nombre completo del piloto: ");
			namePilot = lector.nextLine();
			encontro = mainChampionship.findPilot(namePilot);
			if(encontro==true){
				System.out.println("El piloto ya fue registrado");
			}
		} while(encontro);	
		System.out.println("\nIngrese la edad del piloto: ");
		agePilot = lector.nextInt();lector.nextLine();
		do{
			System.out.println("\nIngrese el equipo al que pertenece el piloto (Scuderia Ferrari, Mclaren F1 Team, Red Bull Racing, Mercedes Amg, Racing Point, Alfa Romeo, Renault, Williams):\n");
			nameTeam = lector.nextLine();
			if(!nameTeam.equalsIgnoreCase("Scuderia Ferrari") && !nameTeam.equalsIgnoreCase("Mclaren F1 Team") && !nameTeam.equalsIgnoreCase("Red Bull Racing") && !nameTeam.equalsIgnoreCase("Mercedes Amg") && !nameTeam.equalsIgnoreCase("Racing Point") && !nameTeam.equalsIgnoreCase("Alfa Romeo") && !nameTeam.equalsIgnoreCase("Renault") && !nameTeam.equalsIgnoreCase("Williams")){
				message = "\nEl equipo no existe, por favor digitelo nuevamente";
				System.out.println(message);
			}
		} while(!nameTeam.equalsIgnoreCase("Scuderia Ferrari") && !nameTeam.equalsIgnoreCase("Mclaren F1 Team") && !nameTeam.equalsIgnoreCase("Red Bull Racing") && !nameTeam.equalsIgnoreCase("Mercedes Amg") && !nameTeam.equalsIgnoreCase("Racing Point") && !nameTeam.equalsIgnoreCase("Alfa Romeo") && !nameTeam.equalsIgnoreCase("Renault") && !nameTeam.equalsIgnoreCase("Williams"));		
		for(int k=0; k<quantity; k++){
			System.out.println("\nIngrese el tiempo obtenido por el piloto en el gran premio #"+(k+1)+":");
			pilotScores[k]= lector.nextInt();lector.nextLine();	
		}
		mainChampionship.addPilot(namePilot, agePilot,nameTeam,pilotScores);		
	}

	public void displayAverages(){
		String message = mainChampionship.showAverageTimes();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\nPROMEDIOS DE CADA UNO DE LOS PILOTOS\n");
		System.out.println(message);
	}
}