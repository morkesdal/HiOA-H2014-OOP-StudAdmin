package no.hioa.oop.klasseadmin;

public class Main {

	
	//Main
	//Vis valg (legg til studenter ELLER lag lister)
	//Hvis legg til studenter
	//--Sp�r om informasjon, lag nytt studentobjekt
	//Hvis lag lister
	//--Sp�r hva slags liste, s� skriv ut.
	
	
	
	private Gruppe gruppe = null;
	
	public Main(Gruppe grp){
		gruppe = grp;
		
		
		
		testrun(); //kj�r testmetode
		
	}
	
	
	//Dette er bare en testmetode for � teste om Filbehandling-metoden fungerer som den skal
	private void testrun(){
		//Lag ti studenter (med navn Ola0, Ola1 osv.
		for (int i = 0; i < 10; i++){
			gruppe.leggTilStudent(new Student("Ola" + i));
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

}
