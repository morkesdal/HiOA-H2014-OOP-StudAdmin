package no.hioa.oop.klasseadmin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class Dialog extends JDialog implements ActionListener{

	protected JButton btnLukk = new JButton("Lukk");
	
	protected void setup(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout( new BorderLayout());
		
		btnLukk.addActionListener(this);
	}

	
	protected void centerScreen() {
		  Dimension dim = getToolkit().getScreenSize();
		  Rectangle abounds = getBounds();
		  setLocation((dim.width - abounds.width) / 2,
		      (dim.height - abounds.height) / 2);
	}


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnLukk){
			setVisible(false);
		}
	}			
		
}
