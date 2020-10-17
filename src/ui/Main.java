package ui;
import model.Championship;
import java.util.Scanner;

public class Main{

	public Scanner lector;

	//Atributes
	private Championship mainChampionship;

	public Main(){

		lector = new Scanner(System.in);
	}
		
	public static void main(String[] args){

		Main objMain = new Main();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Bienvenido al sistema de la FIA");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		int year, quantity; 
		System.out.println("REGISTRAR LA INFORMACION DEL CAMPEONATO");
		System.out.println("\nIngrese el año del campeonato: ");
		year = lector.nextInt();
		System.out.println("\nIngrese la cantidad de grandes premios: ");
		quantity = lector.nextInt();lector.nextLine();
		Championship campeonato = new Championship(year, quantity);
		objMain.menu();
	}

	public void menu(){
		boolean menu = true;
		while (menu){
			System.out.println("Digite\n"+"1. Registrar la informacion de los pilotos\n"+"2. Conocer el tiempo promedio obtenido por cada piloto en los grandes premios\n"+"3. Finalizar la aplicacion\n");
			int option = lector.nextInt();
			switch(option){
				case 1: 
					createPilots(quantity);
					menu = false;
				    break;
				case 2:

					menu = false;
					break;
				case 3:	
					System.out.println("Gracias por utilizar nuestra aplicacion");
					break;		
				default:
					System.out.println("Error, opcion no valida");
					break;	    	
			}
		}
	}	

	public void createPilots(int quantity){
		String namePilot, nameTeam;
		int agePilot;
		System.out.println("REGISTRAR LA INFORMACION DE LOS PILOTOS");
		System.out.println("\nIngrese el nombre completo del piloto: ");
		namePilot = lector.nextLine();
		System.out.println("\nIngrese la edad del piloto: ");
		agePilot = lector.nextInt();
		do{
			System.out.println("Ingrese el nombre del equipo al que corresponde el piloto: Scuderia Ferrari Mclaren F1 Team, Red Bull Racing, Mercedes Amg, Racing Point, Alfa Romeo, Renault, Williams");
			nameTeam = lector.nextLine();
		} while();
		int[] pilotScores = new int [quantity];
		for(int k=0; k<quantity; k++){
			System.out.println("Ingrese el tiempo obtenido por el piloto en el gran premio #"+k);
			pilotScores[k]= lector.nextInt();	
		}
		campeonatox.addPilot(namePilot, agePilot, nameTeam, pilotScores);	
	}

	public void displayInfo(){
		
	}
}