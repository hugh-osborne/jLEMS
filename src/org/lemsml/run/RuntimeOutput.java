package org.lemsml.run;

public class RuntimeOutput {

	String id;
	String title;
	
	double[] box;
	
	public RuntimeOutput() {
	 
	}

	public String toString() {
		return "RuntimeOutput, id=" + id + " title=" + title;
	}
	

	public String getID() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String ttl) {
		title = ttl;
	}
	
	public void setID(String sid) {
		id = sid;
	}
	
	public void setBox(double[] b) {
		box = b;
	}

	public double[] getBox() {
		 return box;
	}

}