package org.lemsml.jlems.reader;

import org.lemsml.jlems.type.About;
import org.lemsml.jlems.type.Assertion;
import org.lemsml.jlems.type.Component;
import org.lemsml.jlems.type.ComponentType;
import org.lemsml.jlems.type.Dimension;
import org.lemsml.jlems.type.Insertion;
import org.lemsml.jlems.type.Meta;
import org.lemsml.jlems.type.Unit;
import org.lemsml.jlems.type.Lems;
import org.lemsml.jlems.type.Target;
import org.lemsml.jlems.type.Constant;
import org.lemsml.jlems.util.ContentError;
import org.lemsml.jlems.util.E;
import org.lemsml.jlems.xml.XMLAttribute;
import org.lemsml.jlems.xml.XMLElement;

public abstract class AbstractLemsFactory {

	
	public Lems buildLemsFromXMLElement(XMLElement root) throws ContentError {
	 	Lems ret=  null;
		if (root.isTag("Lems")) {
			ret = readLems(root);
		} else {
			throw new ContentError("Cant read lems from " + root);
		}
		return ret;
	}
	
	public abstract Object instantiateFromXMLElement(XMLElement root) throws ContentError;
	
	
	private Lems readLems(XMLElement root) throws ContentError {
		Lems ret = new Lems();
		for (XMLElement xel : root.getElements()) {
			if (xel.isTag("Number")) {
				ret.numbers.add((Number)instantiateFromXMLElement(xel));
			} else if (xel.isTag("Constant")) {
				ret.constants.add((Constant)instantiateFromXMLElement(xel));
			} else if (xel.isTag("Unit")) {
				ret.units.add((Unit)instantiateFromXMLElement(xel));
			} else if (xel.isTag("Dimension")) {
				ret.dimensions.add((Dimension)instantiateFromXMLElement(xel));
			} else if (xel.isTag("Assertion")) {
				ret.assertions.add((Assertion)instantiateFromXMLElement(xel));
			} else if (xel.isTag("Target")) {
				ret.targets.add((Target)instantiateFromXMLElement(xel));
			} else if (xel.isTag("ComponentType")) {
				ret.componentTypes.add((ComponentType)instantiateFromXMLElement(xel));
			} else {
 				ret.components.add(readComponentFromXMLElement(xel));
			}
		}
		return ret;
	}
	 
	
	  

	private Component readComponentFromXMLElement(XMLElement xel) throws ContentError {
		Component ret = new Component();
		if (xel.getTag().equals("Component")) {
			// should have a type field
		} else {
			ret.setDeclaredName(xel.getTag());
		}
		
		for (XMLAttribute xa : xel.getAttributes()) {
			String xn = xa.getName();
			if (xn.equals("id")) {
				ret.id = xa.getValue();
			} else if (xn.equals("type")) {
				ret.type = xa.getValue();
			} else if (xn.equals("extends")) {
				ret.eXtends = xa.getValue();
			} else {
				ret.addAttribute(xa.makeCopy());
			}
		}
		
		for (XMLElement cel : xel.getXMLElements()) {
			String ct = cel.getTag();
			 
			if (ct.equals("About")) {
				About ab = (About)instantiateFromXMLElement(cel);
				ret.abouts.add(ab);
			} else if (ct.equals("Meta")) {
				Meta m = (Meta)instantiateFromXMLElement(cel);
				ret.metas.add(m);
				
			} else if (ct.equals("Insertion")) {
				Insertion ins = (Insertion)instantiateFromXMLElement(cel);
				ret.insertions.add(ins);
			
			} else {
				ret.addComponent(readComponentFromXMLElement(cel));
			}
		}
		
		return ret;
	}

	
	protected String internalFieldName(String s) {
		String ret = s;
		if (ret.equals("extends")) {
			// "extends" occurs in the definitions, but it is not a valid field name
			ret = "eXtends";
		}
		return ret;
	}
	
	
	
	protected String parseString(String s) {
		return s;
	}
	
	 
	protected double parseDouble(String s) {
		double ret = 0;
		if (s.length() > 0) {
		try {
			ret= Double.parseDouble(s);
		} catch (Exception ex) {
			E.error("Can't parse double from " + s);
		}
		}
		return ret;
	}
	
	protected int parseInt(String s) {
		int ret = 0;
		if (s.length() > 0) {
		try {
			ret= Integer.parseInt(s);
		} catch (Exception ex) {
			E.error("Can't parse int from " + s);
		}
		}
		return ret;
	}
	
	protected boolean parseBoolean(String s) {
		boolean ret = false;
		if (s.length() > 0) {
			String sl = s.toLowerCase();
			if (sl.equals("0") || sl.equals("false")) {
				ret = false;
			} else if (sl.equals("1") || s.equals("true")) {
				ret = true;
				
			} else {
				E.error("Can't parse boolean from " + s);
			}
		}
		return ret;
	}
	
	
	
}
