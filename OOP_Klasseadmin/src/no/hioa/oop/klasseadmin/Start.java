package no.hioa.oop.klasseadmin;


//Dette er kun en oppstartsklasse for � initiere et objekt av "Main" og laste evt. tidligere grupper.
public class Start {

	
	public static void main(String[] args) {
		new GUIMain(Filbehandling.lastGruppe());
	}

}
