package no.hioa.oop.klasseadmin;

import java.io.Serializable;
import java.util.Vector;

public class Gruppe implements Serializable {

	private Vector<Student> studenter = new Vector();
	
	public Gruppe(){
		
	}
	
	public void leggTilStudent(Student stud){
		studenter.addElement(stud);
	}
	
	public Student[] hentStudenterAsArray(){
		Student[] stud = new Student[studenter.size()];
		studenter.toArray(stud);
		return stud;
	}
	
	public Vector<Student> hentStudenterAsVector(){
		return studenter;
	}
}
