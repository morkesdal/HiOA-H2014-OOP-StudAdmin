package no.hioa.oop.klasseadmin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUIMain extends Dialog implements MouseListener{

	
	//Main
	//Vis valg (legg til studenter ELLER lag lister)
	//Hvis legg til studenter
	//--Spør om informasjon, lag nytt studentobjekt
	//Hvis lag lister
	//--Spør hva slags liste, så skriv ut.
	
	private Gruppe gruppe = null;
	
	private JPanel panelEast = new JPanel(new GridLayout(0,1));
	
	private JList listStudenter = null;
	private DefaultListModel listModel = new DefaultListModel();
	private JScrollPane scrollStudenter = null;
	
	private JButton btnLeggTilElev = new JButton("Legg til elev");
	private JButton btnRedigerElev = new JButton("Rediger elev");
	private JButton btnLagGruppe = new JButton("Lag gruppe");
	
	
	public GUIMain(Gruppe grp){
		gruppe = grp;
		
		//visMeny();
		setup();
		
		this.setVisible(true);
	}
	
	protected void setup(){ //Ordner vinduet klart til førstegangsvisning
		super.setup(); //Kjører setup-metoden fra Dialog-klassen (som denne klassen arver fra)
		this.setTitle("Studentadministrasjon");
		this.setSize(320, 240);
		//Gjør klar listen med studenter
		updateListe();
		listStudenter = new JList(listModel);		
		scrollStudenter = new JScrollPane(listStudenter);
		
		
		//Legg alle komponenter og knapper til paneler
		panelEast.add(btnLeggTilElev);
		panelEast.add(btnRedigerElev);
		panelEast.add(btnLagGruppe);
		
		//Legg komponenter og paneler til i dialogvinduet
		this.add(scrollStudenter, BorderLayout.CENTER);
		this.add(panelEast, BorderLayout.EAST);
		
		//Legg til lytterer etter knappetrykk
		btnLeggTilElev.addActionListener(this);
		btnRedigerElev.addActionListener(this);
		btnLagGruppe.addActionListener(this);
		listStudenter.addMouseListener(this);
		
		//Sentrer dialogen på PC-skjermen
		centerScreen();
		
		
	}
	
	
/*	private void visMeny(){
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
		stud.setFagOmrade(innData.next().toLowerCase());  //Sett alt til små bokstaver (gjør det enklere å sammenligne senere).
		
		//Legge til Studentobjekten i Gruppa
		gruppe.leggTilStudent(stud);
		
		//Lagre Gruppa
		Filbehandling.lagreGruppe(gruppe);
		
		visMeny();
	}*/

	
	private Student getValgteStudent(){
		return gruppe.hentStudenterAsVector().elementAt( listStudenter.getSelectedIndex());
	}
	
	private void updateListe(){//Oppdaterer innholdet i listboksen
		Student[] stud = gruppe.hentStudenterAsArray();
		//listStudenter = new JList(gruppe.hentStudenterAsArray());
		
		listModel.clear();
		
		for (int i = 0; i < stud.length; i++) {
			listModel.addElement(stud[i]);
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae) { //Tar hånd om hva som skjer når noe blir klikket på
		
		if (ae.getSource() == btnLeggTilElev){
			new GUIStudent(gruppe);
			Filbehandling.lagreGruppe(gruppe);
			updateListe();
			
		}else if (ae.getSource() == btnRedigerElev){
			new GUIStudent(gruppe, getValgteStudent());
			Filbehandling.lagreGruppe(gruppe);
			updateListe();
		}else if (ae.getSource() == btnLagGruppe){
			new GUIGrupper(gruppe);
		}
	}

	public void mouseClicked(MouseEvent me) {
		  if (me.getClickCount() == 2) {
				new GUIStudent(gruppe, getValgteStudent());
				Filbehandling.lagreGruppe(gruppe);
				updateListe();		
			 }		
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
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
