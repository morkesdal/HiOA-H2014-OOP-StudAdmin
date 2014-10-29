package no.hioa.oop.klasseadmin;

import java.util.Scanner;

public class Main {

	
	//Main
	//Vis valg (legg til studenter ELLER lag lister)
	//Hvis legg til studenter
	//--Spør om informasjon, lag nytt studentobjekt
	//Hvis lag lister
	//--Spør hva slags liste, så skriv ut.
	
	private Gruppe gruppe = null;
	private Scanner innData = new Scanner(System.in); //Leser inn informasjon fra brukeren
	
	public Main(Gruppe grp){
		gruppe = grp;
		
		visMeny();
		
	}
	
	
	private void visMeny(){
		String valg = new String("");
		System.out.println("\n\n\n\n---- VELKOMMEN TIL VERDENS BESTE STUDENTADMINISTRASJON ----\n");
		System.out.println("-1-  Legg til en ny student");
		System.out.println("-2-  Generer studentliste");
		System.out.println("-0-  Avslutt\n");
		System.out.print("Valg:");
		valg = innData.next();
		
		if (valg.equals("1")){
			leggTilStudent();
		}else if (valg.equals("2")){
			//blablabla
		}else if (valg.equals("0")){
			System.exit(0); // Avslutt
		}
	}
	
	

	private void leggTilStudent(){
				
		Student stud = new Student();
		
		//Spør om informasjon
		System.out.print("LEGG TIL NY STUDENT\n\nStudentens fornavn:");
		stud.setForNavn(innData.next());
		System.out.print("Etternavn:");
		stud.setEtterNavn(innData.next());
		System.out.print("(M)ann eller (D)ame:");
		if (innData.next().toLowerCase().equals("m")){
			stud.setKjonn(true);
		}else{
			stud.setKjonn(false);
		}
		System.out.print("Studiestart (årstall): ");
		stud.setStudieStart(innData.next());
		System.out.print("Fagområde: ");
		stud.setFagOmrade(innData.next());
		
		//Legge til Studentobjekten i Gruppa
		gruppe.leggTilStudent(stud);
		
		//Lagre Gruppa
		Filbehandling.lagreGruppe(gruppe);
		
		visMeny();
	}
	
	
	
	
	
	
	
	
/*	//Dette er bare en testmetode for å teste om Filbehandling-metoden fungerer som den skal
	private void testrun(){
		//Lag ti studenter (med navn Ola0, Ola1 osv.
		for (int i = 0; i < 10; i++){
			gruppe.leggTilStudent(new Student("Ola" + i, "Olsen", 2014, true, "ikt"));
		}
		
		//Lagre liste
		Filbehandling.lagreGruppe(gruppe);
		
		//Skriv ut listen og antall studenter
		Student[] stud = gruppe.hentStudenterAsArray();
		for (int j = 0; j < stud.length; j++){
			System.out.println(stud[j].toString());
		}
		System.out.println("\nTotalt " + (stud.length) + " studenter.");
	}
*/
}
