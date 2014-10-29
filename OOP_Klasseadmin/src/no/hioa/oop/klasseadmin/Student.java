package no.hioa.oop.klasseadmin;

import java.io.Serializable;
import java.util.Date;
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
	
	
	private String forNavn = "";
	private String etterNavn = "";
	private String fagOmrade ="";
	private boolean mann = true;
	private int studieStart = 2014;
	private long id = new Date().getTime();  //En id for å gjøre studenten unik (i tilfelle det er to med helt like navn).
	private Vector<Oppgave> oppgaver = new Vector();
	
	
	public Student(){
		
	}
	
	public Student(String forNavn, String etterNavn, int studieStart, boolean kjonnMann, String fagOmrade){
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.studieStart = studieStart;
		this.mann = kjonnMann;
		this.fagOmrade = fagOmrade;
	}
	
	public String getForNavn(){
		return forNavn;
	}
	
	public void setForNavn(String forNavn){
		this.forNavn = forNavn;
	}
	
	public String getEtterNavn(){
		return etterNavn;
	}
	
	public void setEtterNavn(String etterNavn){
		this.etterNavn = etterNavn;
	}
	
	public String toString(){
		return forNavn + " " + etterNavn;
	}
	
	public void setFagOmrade(String fagOmrade){
		this.fagOmrade = fagOmrade;
	}
	
	public String getFagOmrade(){
		return fagOmrade;
	}
	
	public void setStudieStart(String studieStart){
		this.studieStart = Integer.parseInt(studieStart);
	}
	
	public int getStudieStart(){
		return studieStart;
	}
	
	public boolean isMann(){
		return mann;
	}
	
	public boolean isDame(){
		return !mann;
	}
	
	public void setKjonn(boolean mann){
		this.mann = mann;
	}
	
	public long getId(){
		return id;
	}
	
	public void addOppgave(Oppgave opg){
		oppgaver.addElement(opg);
	}
	
	public Oppgave[] getOppgaver(){ //Returnerer alle oppgavene som en array.
		Oppgave[] opg = new Oppgave[oppgaver.size()];
		oppgaver.toArray(opg);
		return opg;
	}
	
	public boolean isGodkjent(){

		//Gå gjennom alle oppgaver, dersom en ikke er godkjent: returner false
		for (int i = 0; i < oppgaver.size(); i++){
			if (oppgaver.elementAt(i).isGodkjent())
				continue;
			else
				return false;
				
		}
		
		return true;
	}
}
