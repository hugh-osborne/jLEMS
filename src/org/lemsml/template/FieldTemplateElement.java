package org.lemsml.template;

import java.util.HashMap;

import org.lemsml.run.StateInstance;
import org.lemsml.type.Lems;
import org.lemsml.type.Unit;
import org.lemsml.util.ContentError;
import org.lemsml.util.RuntimeError;
 

public class FieldTemplateElement extends TemplateElement {

	String fieldName;
	
	String unitName;
	
	String qual = null;
	
	Unit unit;
	
	public FieldTemplateElement(String fnm, Lems lems) throws ContentError {
		String rest = fnm;
		if (fnm.indexOf(".") > 0) {
 			int idot = fnm.indexOf(".");
 			qual = fnm.substring(0, idot);
			rest = fnm.substring(idot + 1, fnm.length());
			 
		} else {
			rest = fnm;
		}
		int ico = rest.indexOf(":");
		if (ico > 0) {
			fieldName = rest.substring(0, ico);
			unitName = rest.substring(ico + 1, rest.length());
			
			unit = lems.getUnit(unitName);
			
		} else {
			fieldName = rest;
			unitName = null;
		}
		
	}
	
	public String toString() {
		return "Field: " + fieldName;
	}
	
	
 
 
	@Override
	public String eval(HashMap<String, String> vmap) {
		String ret = "";
		if (vmap.containsKey(fieldName)) {
			ret = vmap.get(fieldName);
		}
		return ret;
	}

	@Override
	public String eval(StateInstance so, HashMap<String, StateInstance> context) throws ContentError, RuntimeError {
		 String ret = "";
		 
		 double fac = 1.0;
		 double off = 0.;
		 if (unit != null) {
			 fac = unit.getLocalizingFactor();
			 off = unit.getLocalizingOffset();
		 }
		 
		 int isl = fieldName.indexOf("/");
		 if (isl > 0) {
			 String sf = fieldName.substring(0, isl);
			 String rest = fieldName.substring(isl + 1, fieldName.length());
			 if (context.containsKey(sf)) {
				// E.info("got first part of " + fieldName + " in context");
				 ret += context.get(sf).getPathStringValue(rest, fac, off);
				 
			 } else {
				// E.info("not in context " + fieldName);
				 ret += so.getPathStringValue(fieldName, fac, off);
			 }
			 
		 } else {
			 ret += so.getPathStringValue(fieldName, fac, off);
		 }
		 
		 if (unit != null) {
			 ret += " " + unit.getSymbol();
		 }
		 
		 return ret;
	}

 

}