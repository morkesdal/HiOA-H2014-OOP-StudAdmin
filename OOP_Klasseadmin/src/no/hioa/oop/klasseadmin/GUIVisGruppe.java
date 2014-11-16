package no.hioa.oop.klasseadmin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIVisGruppe extends Dialog {

	
	
	private String navnliste = null;

	//private JButton btnLukk = new JButton("Lukk");
	private JTextArea txtListe = new JTextArea();
	private JScrollPane scroll = new JScrollPane(txtListe);
	
	
	
	
	public GUIVisGruppe(String navnliste){
		this.navnliste = navnliste;
		
		setup();
		
		setVisible(true);
	}
	
	protected void setup(){
		super.setup();
		
		this.setModal(true);
		this.setSize(320, 240);
		
		
		
		//Sette opp trykklyttere
		btnLukk.addActionListener(this);
		
		//Legge til navn i lista - Sette klar tekstboksen
		txtListe.setText(navnliste);
		txtListe.setEditable(false);
		
		//Legge ut komponenter
		this.add(scroll, BorderLayout.CENTER);
		this.add(btnLukk, BorderLayout.SOUTH);
		
		centerScreen();
	}
	
	public void actionPerformed(ActionEvent ae){
		super.actionPerformed(ae);
		
	}
	
}
