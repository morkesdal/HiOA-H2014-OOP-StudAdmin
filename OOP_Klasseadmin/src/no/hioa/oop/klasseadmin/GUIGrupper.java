package no.hioa.oop.klasseadmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIGrupper extends Dialog {

	
	private JPanel panelMain = new JPanel( new GridLayout(0,1));
	private JPanel panelSouth = new JPanel(new FlowLayout());
	

	private JButton btnLukk = new JButton("Lukk");
	private JButton btnSorterStudiestart = new JButton("Sorter baser på studiestart");
	private JButton btnSorterFag = new JButton("Sorter baser på fag");
	private JButton btnSorterMann = new JButton("Sorter alle menn");
	private JButton btnSorterDame = new JButton("Sorter alle kvinner");
	
	
	private Gruppe grp = null;
	
	public GUIGrupper(Gruppe grp){
		this.grp = grp;
		
		setup();
		
		setVisible(true);
	}
	
	protected void setup(){
		super.setup();
		this.setModal(true);
		this.setSize(320, 240);
		
		//Legg til lyttere
		btnSorterStudiestart.addActionListener(this);
		btnLukk.addActionListener(this);
		btnSorterFag.addActionListener(this);
		btnSorterMann.addActionListener(this);
		btnSorterDame.addActionListener(this);
		
		//Temp
		btnSorterFag.setEnabled(false);
		btnSorterStudiestart.setEnabled(false);
		
		
		//Legg ut komponenter i vinduet
		panelMain.add(btnSorterStudiestart);
		panelMain.add(btnSorterFag);
		panelMain.add(btnSorterMann);
		panelMain.add(btnSorterDame);
		panelSouth.add(btnLukk);
		this.add(panelMain, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);
		
		centerScreen();
	}
	
	private String sorterKjonn(boolean mann){ //sortere på kjønn, returnere navnliste 
		
		Student[] stud = grp.hentStudenterAsArray();
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 0; i < stud.length; i++){
			if (stud[i].isMann() == mann){
				sb.append(stud[i].toString() + "\n");
			}
		}
		
		
		return sb.toString();
	}

	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == btnLukk){
			setVisible(false);
		}else if (ae.getSource() == btnSorterMann){
			new GUIVisGruppe(sorterKjonn(true));
		}else if (ae.getSource() == btnSorterDame){
			new GUIVisGruppe(sorterKjonn(false));
		}
	}				
}
