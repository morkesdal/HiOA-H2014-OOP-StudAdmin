package no.hioa.oop.klasseadmin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Filbehandling {

	private static final String FILNAVN = "gruppe.obj";
	
	public static Gruppe lastGruppe(){
		
		File f = new File(Filbehandling.FILNAVN);
		Gruppe gruppe = null;
		
		if (f.exists()){
			try{
				FileInputStream fis = new FileInputStream(Filbehandling.FILNAVN);
		    	BufferedInputStream bis = new BufferedInputStream(fis);
		    	ObjectInputStream ois = new ObjectInputStream(bis);		    	
		
		    	Object obj = ois.readObject();
		    
		    	if (obj instanceof Gruppe)
		    	{
		    		gruppe = (Gruppe)obj;
				
		    	}
		    	ois.close();
		    	bis.close();
		    	fis.close();
			}catch (ClassNotFoundException cnf){
				System.out.println("Fant ikke klassen ved lasting \n " + cnf); gruppe = new Gruppe();
			}catch (IOException ioe){
				System.out.println("Feil ved lasting \n" + ioe);
			}			
			}else{
			gruppe = new Gruppe();   //Ved annen feil ved lasting, start med et nytt Gruppeobjekt.
		}
		
		return gruppe;
		
		
	}
	
	
	public static void lagreGruppe(Gruppe grp){
		
		try{
	  		FileOutputStream fos = new FileOutputStream(Filbehandling.FILNAVN);
	  		BufferedOutputStream bos = new BufferedOutputStream(fos);
    		ObjectOutputStream oos = new ObjectOutputStream(bos);
    		oos.writeObject(grp);
	    	oos.flush();
	    	oos.close();	
	    	bos.flush();
	    	bos.close();
	    	fos.flush();
	    	fos.close();
		}catch (IOException ioe){
			System.out.println("Feil ved lagring! " + ioe);
		}
				
	}		
	
	
}
