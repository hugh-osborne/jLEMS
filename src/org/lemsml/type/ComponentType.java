package org.lemsml.type;

import java.util.ArrayList;
import java.util.HashMap;

import org.lemsml.annotation.Mat;
import org.lemsml.annotation.Mel;
import org.lemsml.behavior.Behavior;
import org.lemsml.behavior.DerivedVariable;
import org.lemsml.behavior.Dynamics;
import org.lemsml.behavior.Equilibrium;
import org.lemsml.canonical.CanonicalElement;
import org.lemsml.expression.Dimensional;
import org.lemsml.expression.ParseError;
import org.lemsml.expression.Parser;
import org.lemsml.expression.Valued;
import org.lemsml.procedure.Procedure;
import org.lemsml.util.ContentError;
import org.lemsml.util.E;
import org.lemsml.xml.XMLElement;

@Mel(info="Root element for defining component types. Note that ComponentClass is used for " +
		"this element in the NeuroML Component definitions. " + 
		"LEMS will handle ComponentClass elements in the same way as ComponentType elements.")
public class ComponentType extends Base implements Named, Summaried, Inheritor {

	@Mat(info="The name of the component type. This can be uses as an XML element name in the shorthand form when" +
			"defining components. ")
	public String name;

	@Mat(info="The component type that this type inherits field definitions for, if any")
	public String eXtends;

	public ComponentType r_extends;

	public LemsCollection<Parameter> parameters = new LemsCollection<Parameter>();

	public LemsCollection<DerivedParameter> derivedParameters = new LemsCollection<DerivedParameter>();

	public LemsCollection<PathParameter> pathParameters = new LemsCollection<PathParameter>();

	public LemsCollection<Requirement> requirements = new LemsCollection<Requirement>();

	public LemsCollection<Exposure> exposures = new LemsCollection<Exposure>();

	public LemsCollection<Child> childs = new LemsCollection<Child>();

	public LemsCollection<Children> childrens = new LemsCollection<Children>();

	public LemsCollection<ComponentReference> componentReferences = new LemsCollection<ComponentReference>();

	public LemsCollection<ComponentTypeRef> componentTypeRefs = new LemsCollection<ComponentTypeRef>();

	public LemsCollection<Link> links = new LemsCollection<Link>();

	public LemsCollection<Property> propertys = new LemsCollection<Property>();

	public LemsCollection<DefaultBehavior> defaultBehaviors = new LemsCollection<DefaultBehavior>();
	
	public LemsCollection<Behavior> behaviors = new LemsCollection<Behavior>();

	public LemsCollection<Dynamics> dynamicses = new LemsCollection<Dynamics>();
	
	public LemsCollection<Equilibrium> equilibriums  = new LemsCollection<Equilibrium>();
	
	public LemsCollection<Procedure> procedures = new LemsCollection<Procedure>();
	
	
	
	
	public LemsCollection<Fixed> fixeds = new LemsCollection<Fixed>();

	public LemsCollection<Constant> constants = new LemsCollection<Constant>();

	public LemsCollection<Attachments> attachmentses = new LemsCollection<Attachments>();

	public LemsCollection<EventPort> eventPorts = new LemsCollection<EventPort>();

	public LemsCollection<Path> paths = new LemsCollection<Path>();

	public LemsCollection<Text> texts = new LemsCollection<Text>();

	public LemsCollection<Collection> collections = new LemsCollection<Collection>();

	public LemsCollection<PairCollection> pairCollections = new LemsCollection<PairCollection>();

	// nineml compatibility - duplicates some of exposure but has other stuff too
	public LemsCollection<AnalogPort> analogPorts = new LemsCollection<AnalogPort>();
	
	
	private LemsCollection<Component> cpts = new LemsCollection<Component>();

	private LemsCollection<FinalParam> finalParams = new LemsCollection<FinalParam>();
	
	private LemsCollection<InstanceProperty> instancePropertys = new LemsCollection<InstanceProperty>();

	private LemsCollection<FinalExposed> finalExposeds = new LemsCollection<FinalExposed>();
	
	
	@Mat(info="Metadata about a component type can be included anywhere by wrapping it in an About element, though this " +
			"is not necessary: LEMS does not use the body text of XML elements itself, so this is free for the " +
			"modeler to include descriptive text or other markup of thier own.")
	public LemsCollection<About> abouts = new LemsCollection<About>();

	@Mat(info="Structured metadata can be put in Meta elements. The content is read into a generic xml data structure. " +
			"Other tools can then do their own thing with it. Each Meta element should set the context attribute, so " +
			"tools can use the getMeta(context) method to retrieve elements that match a particular context.")
	public LemsCollection<Meta> metas = new LemsCollection<Meta>();
	
	public boolean standalone;
	
	boolean resolved = false;

	public ComponentType() {

	}

	public ComponentType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "ComponentType, name=" + summary();
	}

	public String summary() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		if (description != null)
			sb.append(" (" + description + ")");
		if (r_extends != null) {
			sb.append(" extends " + r_extends.getName() + " ");
		}
		for (FinalParam fp : finalParams) {
			String sv = fp.getSValue();
			sb.append("\n         " + fp.getName() + " (" + fp.getDimension().getName() + ") "
					+ (sv != null ? " = " + sv : ""));
		}

		return sb.toString();
	}

	
	
	
	public String getAbout() {
		String ret = "";
		for (About about : abouts) {
			ret += about.getText();
		}
		return ret;
	}
	
	
	public boolean isExtension() {
		boolean ret = false;
		if (this.r_extends != null) {
			ret = true;
		}
		return ret;
	}
 

	public boolean isOrExtends(String typeName) {
		if (getName().equals(typeName))
			return true;
		ComponentType ext = this.r_extends;
		while (ext != null) {
			if (ext.getName().equals(typeName))
				return true;
			ext = ext.r_extends;
		}
		return false;
	}
	
	
	
	

	

	public boolean isOrExtendsType(ComponentType ct) {
		boolean ret = false;
		if (this == ct) {
			ret = true;
		} else {
			ComponentType ext = this.r_extends;
			while (ext != null) {
				if (ext == ct) {
					ret = true;
				}
				ext = ext.r_extends;
			}
		}
		return ret;
	}

	
	
	
	public boolean extendsType(ComponentType ct) {
		boolean ret = false;
		ComponentType ext = r_extends;
		while (ext != null) {
			if (ext.equals(ct)) {
				ret = true;
				break;
			}
			ext = ext.r_extends;
		}
		return ret;
	}

	public void addCpt(Component cpt) {
		cpts.add(cpt);
	}

	public LemsCollection<Component> getComponents() {
		return cpts;
	}

	public void resolve(Lems lems, Parser p) throws ContentError, ParseError {

		for (AnalogPort ap : analogPorts) {
			if (ap.mode.equals("send")) {
				exposures.add(new Exposure(ap.name, ap.dimension));
			
			} else if (ap.mode.equals("reduce")) {
				if (ap.reduce_op.equals("+")) {
					for (Behavior b : behaviors) {				
						DerivedVariable dv = new DerivedVariable(ap.name);
						dv.value = "0";
						dv.reduce = "add";
						b.addDerivedVariable(dv);  
					}
				} else {
					E.warning("unhandled " + ap);
				}
				
			} else {
				E.shortWarning("Ignoring analog port: " + ap);
			}
		}
		
		
		
		for (Parameter dp : parameters) {
			dp.resolve(lems.getDimensions());
		}

		for (DerivedParameter dp : derivedParameters) {
			dp.resolve(lems.getDimensions());
		}

		HashMap<String, Double> valHM = new HashMap<String, Double>();
		for (Constant c : constants) {
			c.resolve(lems.getDimensions(), lems.getUnits(), null, valHM);
		}

		for (Property pr : propertys) {
			pr.resolve(lems.getDimensions());
		}

		for (Requirement req : requirements) {
			req.resolve(lems.getDimensions());
		}

		for (Exposure exp : exposures) {
			exp.resolve(lems.getDimensions());
		}

		for (Child ch : childs) {
			ch.resolve(lems, p);
		}

		for (ComponentReference cr : componentReferences) {
			cr.resolve(lems, p);
		}

		for (ComponentTypeRef tr : componentTypeRefs) {
			tr.resolve(lems, p);
		}

		for (Link lin : links) {
			lin.resolve(lems, p);
		}

		for (Children chn : childrens) {
			chn.resolve(lems, p);
		}

		for (Attachments atn : attachmentses) {
			atn.resolve(lems, p);
		}

		if (eXtends != null) {
			r_extends = lems.getComponentTypeByName(eXtends);

			if (r_extends == null) {
				throw new ContentError("missing extends " + eXtends);
			} else {
				r_extends.checkResolve(lems, p);
			}

		}
		
		for (Property prop : propertys) {
			instancePropertys.add(new InstanceProperty(prop.getName(), prop.getDimension()));
		}

		for (Parameter dp : parameters) {
			finalParams.add(new FinalParam(dp.getName(), dp.getDimension()));
		}

		
		for (DerivedParameter dp : derivedParameters) {
			finalParams.add(new DerivedFinalParam(dp.getName(), 
					dp.getDimension(), dp.getSelect(), dp.getValue()));
		}

		if (r_extends != null) {
			for (FinalParam fp : r_extends.getFinalParams()) {
				finalParams.add(fp.makeCopy());
			}
			for (EventPort ep : r_extends.getEventPorts()) {
				eventPorts.add(ep.makeCopy());
			}

			for (ComponentReference cr : r_extends.getComponentRefs()) {
				componentReferences.add(cr.makeCopy());
			}

			for (Link lin : r_extends.getLinks()) {
				links.add(lin.makeLinkCopy());
			}
			for (Requirement req : r_extends.getRequirements()) {
				requirements.add(req.makeCopy());
			}
			for (Exposure exp : r_extends.getExposures()) {
				exposures.add(exp.makeCopy());
			}
			
			for (PairCollection pc : r_extends.getPairCollections()) {
				pairCollections.add(pc.makeCopy());
			}
			
			for (Collection c : r_extends.getCollections()) {
				collections.add(c.makeCopy());
			}
			
		}

		for (Fixed sp : fixeds) {
			try {
				if (finalParams.hasName(sp.getPseudoName())) {
					finalParams.getByName(sp.getPseudoName()).setSValue(
							sp.getValue());
				}
			} catch (ContentError ce) {
				throw ce;
			}
		}

		for (Constant c : constants) {
			FinalParam fp = new FinalParam(c.getName(), c.getDimension());
			fp.setSValue(c.getStringValue());
			finalParams.add(fp);
		}

		for (EventPort ep : eventPorts) {
			ep.resolve(lems.getDimensions());
		}

		for (Behavior b : behaviors) {
			b.setComponentType(this);
			b.resolve(lems, p);
		}

		for (DefaultBehavior db : defaultBehaviors) {
			db.resolve(this);
		}

		for (Exposure exp : exposures) {

			finalExposeds.add(new FinalExposed(exp.getName(), exp.getDimension()));
		}

		resolved = true;
	}

	public LemsCollection<EventPort> getEventPorts() {
		return eventPorts;
	}

	public LemsCollection<FinalParam> getFinalParams() {
		return finalParams;
	}

	public LemsCollection<InstanceProperty> getInstancePropertys() {
		return instancePropertys;
	}
	
	public void checkResolve(Lems lems, Parser p) throws ContentError,
			ParseError {
		if (!resolved) {
			resolve(lems, p);
		}
	}

	public LemsCollection<Parameter> getDimParams() {
		return parameters;
	}

	public LemsCollection<Constant> getConstants() {
		return constants;
	}

	public LemsCollection<DerivedParameter> getDerivedParameters() {
		return derivedParameters;
	}

	public boolean setsParam(Parameter dp) throws ContentError {
		return fixeds.hasPseudoName(dp.getName());
	}

	public String getSetParamValue(Parameter dp) throws ContentError {
		Fixed sp = fixeds.getByPseudoName(dp.getName());
		return sp.getValue();
	}

	public EventPort getInEventPort(String port) throws ContentError {
		EventPort ret = null;
		if (eventPorts.hasName(port)) {
			EventPort ep = eventPorts.getByName(port);
			if (ep.isDirectionIn()) {
				ret = ep;
			} else {
				E.error("input port needed for " + port
						+ " but got output port");
			}
		}
		if (ret == null) {
			E.error("No such port: " + port+" on "+this);
		}
		return ret;
	}

	public EventPort getOutEventPort(String port) throws ContentError {
		EventPort ret = null;
		if (eventPorts.hasName(port)) {
			EventPort ep = eventPorts.getByName(port);
			if (ep.isDirectionOut()) {
				ret = ep;
			} else {
				E.error("output port needed for " + port
						+ " but got input port");
			}
		}
		if (ret == null) {
			E.error("No such port: " + port+" on "+this);
		}
		return ret;
	}

	public Behavior getBehavior(String nm) {
		Behavior ret = null;
		for (Behavior b : behaviors) {
			if (nm.equals(b.getName())) {
				ret = b;
			}
		}
		return ret;
	}

	public Behavior getBehavior() throws ContentError {
		Behavior ret = null;
		if (defaultBehaviors.size() == 1) {
			ret = defaultBehaviors.getOnly().getBehavior();
			// E.info("behavior returning default " + ret);

		} else if (defaultBehaviors.size() > 1) {
			throw new ContentError("only one default behavior allowed");
		}

		if (ret == null) {
			if (behaviors.size() == 0 && r_extends != null) {
				ret = r_extends.getBehavior();
			} else {
				if (behaviors.size() == 1) {
					ret = behaviors.getOnly();
				} else {
					//E.info("No dynamics is specified for " + name);
					return null;
				}
			}
		}
		return ret;
	}

	public Valued getSimpleExposed(String nm) throws ContentError {
		Valued ret = null;
		if (finalParams.hasName(nm)) {
			ret = finalParams.getByName(nm);
		}
		if (ret == null) {
			if (finalExposeds.hasName(nm)) {
				ret = finalExposeds.getByName(nm);
			}
		}

		if (ret == null) {
			throw new ContentError("No quantity '" + nm + "' available in "
					+ this + "\nfinalParams: " + finalParams
					+ "\nfinalExposeds: " + finalExposeds);
		}

		return ret;
	}

	 
	
	public boolean hasChild(String scb) throws ContentError {
		return childs.hasName(scb);
	}

	public Children getChildren(ComponentType ftype) throws ContentError {
		Children ret = null;
		for (Children chn : childrens) {
			ComponentType t = chn.getComponentType();
			if (ftype.equals(t) || ftype.eXtends(t)) {
				ret = chn;
			}
		}
		
		if (ret == null) {
			throw new ContentError("No such children list for type: (" + ftype.getName()+") in "+ this.getName() + "\n"
                                + "Existing children lists: [" + childrens.listAsText() + "], existing childs: ["+childs.listAsText()+"]\n");
		}
		return ret;
	}

	public ArrayList<ComponentType> getChildTypes() throws ContentError {
		ArrayList<ComponentType> childCTs = new ArrayList<ComponentType>();

		for (Children chn : childrens) {
			ComponentType t = chn.getComponentType();
			childCTs.add(t);
		}
		for (Child child : childs) {
			ComponentType t = child.getComponentType();
			childCTs.add(t);
		}
		return childCTs;
	}

	private boolean eXtends(ComponentType t) {
		boolean ret = false;
		if (r_extends != null) {
			if (t.equals(r_extends) || r_extends.eXtends(t)) {
				ret = true;
			}
		}
		return ret;
	}

	public ComponentType getExtends() {
		return r_extends;
	}

	public boolean hasBehavior() {
		boolean ret = false;
		if (behaviors.size() > 0) {
			ret = true;
		} else if (r_extends != null && r_extends.hasBehavior()) {
			ret = true;
		}
		return ret;
	}

	public LemsCollection<ComponentReference> getComponentRefs() {
		return componentReferences;
	}

	public LemsCollection<Link> getLinks() {
		return links;
	}


	public void checkEquations(HashMap<String, Dimensional> cdimHM) throws ContentError {
		for (Behavior b : behaviors) {
			b.checkEquations(cdimHM);
		}

	}

	public LemsCollection<Attachments> getAttachmentss() {
		return attachmentses;
	}

	public Children getChildrenByName(String sn) throws ContentError {
		return childrens.getByName(sn);
	}

	public Valued getFinalParam(String sn) throws ContentError {
		return finalParams.getByName(sn);
	}

	public ComponentReference getComponentRef(String sn) throws ContentError {
		return componentReferences.getByName(sn);
	}

	public CanonicalElement makeCanonical() {
		CanonicalElement ret = new CanonicalElement("ComponentType");
		ret.add(new CanonicalElement("name", name));
		if (eXtends != null) {
			ret.add(new CanonicalElement("extends", eXtends));
		}
		for (Parameter p : parameters) {
			ret.add(p.makeCanonical());
		}

		for (EventPort ep : eventPorts) {
			ret.add(ep.makeCanonical());
		}

		for (Child ch : childs) {
			ret.add(ch.makeCanonical());
		}
		for (Children chn : childrens) {
			ret.add(chn.makeCanonical());
		}
		for (ComponentReference cr : componentReferences) {
			ret.add(cr.makeCanonical());
		}

		// MUSTDO - other component classes

		return ret;
	}

	public LemsCollection<Path> getPaths() {
		return paths;
	}

	public LemsCollection<Text> getTexts() {
		return texts;
	}

	public LemsCollection<Requirement> getRequirements() {
		return requirements;
	}

	public LemsCollection<Exposure> getExposures() {
		return exposures;
	}

	public Exposure getExposure(String snm) throws ContentError {
		if (!exposures.hasName(snm)) {
			throw new ContentError("No such exposure " + snm + " in " + this);
		}
		Exposure ret = exposures.getByName(snm);
		if (ret == null) {
			throw new ContentError("Problem getting value of exposure " + snm + " in " + this);
		}
		return ret;
	}

	public LemsCollection<Property> getPropertys() {
		return propertys;
	}

	public Collection getCollection(String cnm) throws ContentError {
		return collections.getByName(cnm);
	}

	public PairCollection getPairCollection(String cnm) throws ContentError {
		return pairCollections.getByName(cnm);
	}

	public LemsCollection<Collection> getCollections() {
		return collections;
	}
	
	public LemsCollection<PairCollection> getPairCollections() {
		return pairCollections;
	}

	public LemsCollection<ComponentTypeRef> getComponentTypeRefs() {
		return componentTypeRefs;
	}

	public LemsCollection<PathParameter> getPathParameters() {
		return pathParameters;
	}

	public LemsCollection<Parameter> getParameters() {
		return parameters;
	}

	public double getHierarchyWeight(Lems lems) {
		double ret = 0.;
		ret += childrens.size();
		ret += 0.5 * childs.size();
		for (ComponentType ct : lems.getComponentTypes()) {
			if (this.isOrExtendsType(ct)) {
				
			} else if (ct.isOrExtendsType(this)) {
				
			} else {
				ret -= ct.referencesTo(this);
			}
		}
		return ret;
	}
	
	
	public boolean inherited(Object obj) throws ContentError {
		boolean ret = false;
		if (r_extends != null && r_extends.hasInheritable(obj)) {
			ret = true;
		}
		return ret;
	}
	
	

	private double referencesTo(ComponentType dest) {
		double ret = 0;
		for (ComponentReference cr : componentReferences) {
			if (dest.isOrExtendsType(cr.getComponentType())) {
				ret += 1;
			}
		}
		return ret;
	}
	
	
	private boolean hasInheritable(Object obj) throws ContentError {
		 boolean ret = false;
		 if (obj instanceof Exposure && exposures.hasName(((Exposure)obj).getName())) {
			 ret = true;
		 } else if (obj instanceof EventPort && eventPorts.hasName(((EventPort)obj).getName())) {
			 ret = true;
		 } else if (obj instanceof Requirement && requirements.hasName(((Requirement)obj).getName())) {
			 ret = true;
		 }
		 
		 return ret;
	}
	
	
	
	public void addParameter(Parameter p) {
		 parameters.add(p);
		
	}
	
	public ArrayList<ComponentType> getChildCompTypes() throws ContentError {
		ArrayList<ComponentType> childCTs = new ArrayList<ComponentType>();

		for (Children chn : childrens) {
			ComponentType t = chn.getComponentType();
			childCTs.add(t);
		}
		for (Child child : childs) {
			ComponentType t = child.getComponentType();
			childCTs.add(t);
		}
		return childCTs;
	}

	
	public XMLElement getContextMeta(String ctxt) {
		XMLElement ret = null;
		for (Meta m : metas) {
			if (m.context != null && m.context.equals(ctxt)) {
				ret = m.getXMLValue();
			}
		}
		return ret;
	}

	public void addEventPort(EventPort ep) {
		eventPorts.add(ep);
		
	}

	public void addBehavior(Behavior b) {
		behaviors.add(b);
	}

	public void addExposure(Exposure expo) {
		exposures.add(expo);
	}

	public String getChildType(String name) {
		String ret = null;
		for (Child ch : childs) {
			if (ch.name != null && ch.name.equals(name)) {
				ret = ch.type;
				break;
			}
		}
		return ret;
	}

	public LemsCollection<Procedure> getProcedures() {
		return procedures;
	}

 
	
}
