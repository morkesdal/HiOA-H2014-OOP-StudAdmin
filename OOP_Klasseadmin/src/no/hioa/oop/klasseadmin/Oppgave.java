package no.hioa.oop.klasseadmin;

import java.io.Serializable;

public class Oppgave implements Serializable{

	private String tilbakeMelding = "";
	private boolean godkjent = false;
	private String levertDato = ""; //Valg string for dato for å gjøre det enklere å håndtere
	private String oppgaveNavn = "";
	
	
	public Oppgave(){
		
	}

	public Oppgave(String oppgaveNavn, boolean godkjent, String levertDato, String tilbakeMelding){ //konstuktør som samtidig tar i mot alle variablene
		this.godkjent = godkjent;
		this.levertDato = levertDato;
		this.tilbakeMelding = tilbakeMelding;
		this.oppgaveNavn = oppgaveNavn;
	}
	
	public void setOppgaveNavn(String oppgaveNavn){
		this.oppgaveNavn = oppgaveNavn;
	}
	
	public String getOppgaveNavn(){
		return oppgaveNavn;
	}
	
	public String toString(){
		return oppgaveNavn;
	}
	
	public String getLevertDato(){ //returnerer dato for oppgavelevert
		return levertDato;
	}
	
	public void setLevertDato(String levertDato){ //setter dato for oppgavelevert
		this.levertDato = levertDato;
	}
	
	public boolean isTilbakeMeldingOk(){ //Returnerer true hvis det er gitt tilbakemelding (hvis tilbakeMelding string inneholder tekst).
		if (tilbakeMelding == null){
			return false;
		}else if (tilbakeMelding.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public String getTilbakeMelding(){
		return tilbakeMelding;
	}
	
	public void settTilbakeMelding(String tilbakeMelding){ //Lar deg sette tilbakemeldingsteksten.
		this.tilbakeMelding = tilbakeMelding;
	}
	
	public void setGodkjent(boolean godkjent){ //Lar deg sette om oppgaven er godkjent eller ei
		this.godkjent = godkjent;
	}
	
	public boolean isGodkjent(){//returnerer true hvis oppgaven er godkjent.
		return godkjent;
	}
	
	
}
