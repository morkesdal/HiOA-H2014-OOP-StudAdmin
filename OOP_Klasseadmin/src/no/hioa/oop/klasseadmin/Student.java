package no.hioa.oop.klasseadmin;

import java.io.Serializable;
import java.util.Vector;

public class Student implements Serializable{

	//Class Student
	//variabler fag, studiestart, oppgaver, kjønn, fornavn, etternavn, id, godkjentforeksamen
	//
	//funksjoner for å hente og sette alle variablene.
	//set og get
	//
	//id variablen kan settes som en Date.long (dette bare for å lage et unikt nummer på studentet.. det kan jo hende at noen med samme navn går på skolen.)
	//
	//funksjon isgodkjent
	//hvis alle oppgaver er godkjent, returner true.
	
	
	Vector<Oppgave> oppgaver = new Vector();
	private String navn = "";
	
	
	
	public Student(String navn){
		this.navn = navn;
	}
	
	public String toString(){
		return navn;
	}
}
