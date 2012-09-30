package org.lemsml.jlems.reader;

import org.lemsml.jlems.type.*;
import org.lemsml.jlems.type.dynamics.*;
import org.lemsml.jlems.type.structure.*;
import org.lemsml.jlems.type.simulation.*;

import org.lemsml.jlems.type.procedure.*;

import org.lemsml.jlems.xml.XMLElement;
import org.lemsml.jlems.xml.XMLAttribute;
import org.lemsml.jlems.util.E;
// NB this is generated code. Don't edit it. If there is a problem, fix the superclass,
// the generator - org.jlems.jlemsio.LemsFactoryGenerator, or the class being instantiated.

public class LemsFactory extends AbstractLemsFactory {


    public Object instantiateFromXMLElement(XMLElement xel) {
        Object ret = null;
       String tag = xel.getName();

        if (tag.equals("UNUSED")) {
        } else if (tag.equals("Dimension")) {
            ret = buildDimension(xel);
        } else if (tag.equals("Unit")) {
            ret = buildUnit(xel);
        } else if (tag.equals("Assertion")) {
            ret = buildAssertion(xel);
        } else if (tag.equals("ComponentType")) {
            ret = buildComponentType(xel);
        } else if (tag.equals("Target")) {
            ret = buildTarget(xel);
        } else if (tag.equals("Parameter")) {
            ret = buildParameter(xel);
        } else if (tag.equals("Requirement")) {
            ret = buildRequirement(xel);
        } else if (tag.equals("Exposure")) {
            ret = buildExposure(xel);
        } else if (tag.equals("Child")) {
            ret = buildChild(xel);
        } else if (tag.equals("Children")) {
            ret = buildChildren(xel);
        } else if (tag.equals("Link")) {
            ret = buildLink(xel);
        } else if (tag.equals("ComponentRef")) {
            ret = buildComponentRef(xel);
        } else if (tag.equals("EventPort")) {
            ret = buildEventPort(xel);
        } else if (tag.equals("Text")) {
            ret = buildText(xel);
        } else if (tag.equals("Path")) {
            ret = buildPath(xel);
        } else if (tag.equals("Dynamics")) {
            ret = buildDynamics(xel);
        } else if (tag.equals("StateVariable")) {
            ret = buildStateVariable(xel);
        } else if (tag.equals("StateAssignment")) {
            ret = buildStateAssignment(xel);
        } else if (tag.equals("TimeDerivative")) {
            ret = buildTimeDerivative(xel);
        } else if (tag.equals("DerivedVariable")) {
            ret = buildDerivedVariable(xel);
        } else if (tag.equals("OnStart")) {
            ret = buildOnStart(xel);
        } else if (tag.equals("OnCondition")) {
            ret = buildOnCondition(xel);
        } else if (tag.equals("OnEvent")) {
            ret = buildOnEvent(xel);
        } else if (tag.equals("EventOut")) {
            ret = buildEventOut(xel);
        } else if (tag.equals("Structure")) {
            ret = buildStructure(xel);
        } else if (tag.equals("MultiInstantiate")) {
            ret = buildMultiInstantiate(xel);
        } else if (tag.equals("CoInstantiate")) {
            ret = buildCoInstantiate(xel);
        } else if (tag.equals("Choose")) {
            ret = buildChoose(xel);
        } else if (tag.equals("ChildInstance")) {
            ret = buildChildInstance(xel);
        } else if (tag.equals("ForEach")) {
            ret = buildForEach(xel);
        } else if (tag.equals("EventConnection")) {
            ret = buildEventConnection(xel);
        } else if (tag.equals("Simulation")) {
            ret = buildSimulation(xel);
        } else if (tag.equals("Record")) {
            ret = buildRecord(xel);
        } else if (tag.equals("DataDisplay")) {
            ret = buildDataDisplay(xel);
        } else if (tag.equals("Run")) {
            ret = buildRun(xel);
        } else {
            E.error("Unrecognized name " + tag);
        }
        return ret;
    }


    private Dimension buildDimension(XMLElement xel) {
        Dimension ret = new Dimension();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("m")) {
                ret.m = parseInt(xv);
            } else if (xn.equals("l")) {
                ret.l = parseInt(xv);
            } else if (xn.equals("t")) {
                ret.t = parseInt(xv);
            } else if (xn.equals("i")) {
                ret.i = parseInt(xv);
            } else if (xn.equals("k")) {
                ret.k = parseInt(xv);
            } else if (xn.equals("n")) {
                ret.n = parseInt(xv);
            } else if (xn.equals("c")) {
                ret.c = parseInt(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Unit buildUnit(XMLElement xel) {
        Unit ret = new Unit();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("symbol")) {
                ret.symbol = parseString(xv);
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("powTen")) {
                ret.powTen = parseInt(xv);
            } else if (xn.equals("power")) {
                ret.power = parseInt(xv);
            } else if (xn.equals("scale")) {
                ret.scale = parseDouble(xv);
            } else if (xn.equals("offset")) {
                ret.offset = parseDouble(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Assertion buildAssertion(XMLElement xel) {
        Assertion ret = new Assertion();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("matches")) {
                ret.matches = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private ComponentType buildComponentType(XMLElement xel) {
        ComponentType ret = new ComponentType();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("eXtends")) {
                ret.eXtends = parseString(xv);
            } else if (xn.equals("standalone")) {
                ret.standalone = parseBoolean(xv);
            } else if (xn.equals("id")) {
                ret.id = parseString(xv);
            } else if (xn.equals("description")) {
                ret.description = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof Parameter) {
                ret.parameters.add((Parameter)obj);
            } else if (obj instanceof DerivedParameter) {
                ret.derivedParameters.add((DerivedParameter)obj);
            } else if (obj instanceof PathParameter) {
                ret.pathParameters.add((PathParameter)obj);
            } else if (obj instanceof Requirement) {
                ret.requirements.add((Requirement)obj);
            } else if (obj instanceof Exposure) {
                ret.exposures.add((Exposure)obj);
            } else if (obj instanceof Child) {
                ret.childs.add((Child)obj);
            } else if (obj instanceof Children) {
                ret.childrens.add((Children)obj);
            } else if (obj instanceof Link) {
                ret.links.add((Link)obj);
            } else if (obj instanceof ComponentReference) {
                ret.componentReferences.add((ComponentReference)obj);
            } else if (obj instanceof ComponentTypeRef) {
                ret.componentTypeRefs.add((ComponentTypeRef)obj);
            } else if (obj instanceof Property) {
                ret.propertys.add((Property)obj);
            } else if (obj instanceof Dynamics) {
                ret.dynamicses.add((Dynamics)obj);
            } else if (obj instanceof Structure) {
                ret.structures.add((Structure)obj);
            } else if (obj instanceof Simulation) {
                ret.simulations.add((Simulation)obj);
            } else if (obj instanceof Equilibrium) {
                ret.equilibriums.add((Equilibrium)obj);
            } else if (obj instanceof Procedure) {
                ret.procedures.add((Procedure)obj);
            } else if (obj instanceof Fixed) {
                ret.fixeds.add((Fixed)obj);
            } else if (obj instanceof Constant) {
                ret.constants.add((Constant)obj);
            } else if (obj instanceof Attachments) {
                ret.attachmentses.add((Attachments)obj);
            } else if (obj instanceof EventPort) {
                ret.eventPorts.add((EventPort)obj);
            } else if (obj instanceof Path) {
                ret.paths.add((Path)obj);
            } else if (obj instanceof Text) {
                ret.texts.add((Text)obj);
            } else if (obj instanceof Collection) {
                ret.collections.add((Collection)obj);
            } else if (obj instanceof PairCollection) {
                ret.pairCollections.add((PairCollection)obj);
            } else if (obj instanceof AnalogPort) {
                ret.analogPorts.add((AnalogPort)obj);
            } else if (obj instanceof About) {
                ret.abouts.add((About)obj);
            } else if (obj instanceof Meta) {
                ret.metas.add((Meta)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Target buildTarget(XMLElement xel) {
        Target ret = new Target();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("component")) {
                ret.component = parseString(xv);
            } else if (xn.equals("reportFile")) {
                ret.reportFile = parseString(xv);
            } else if (xn.equals("timesFile")) {
                ret.timesFile = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Parameter buildParameter(XMLElement xel) {
        Parameter ret = new Parameter();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("description")) {
                ret.description = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Requirement buildRequirement(XMLElement xel) {
        Requirement ret = new Requirement();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("description")) {
                ret.description = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Exposure buildExposure(XMLElement xel) {
        Exposure ret = new Exposure();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("description")) {
                ret.description = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Child buildChild(XMLElement xel) {
        Child ret = new Child();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("type")) {
                ret.type = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Children buildChildren(XMLElement xel) {
        Children ret = new Children();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("type")) {
                ret.type = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Link buildLink(XMLElement xel) {
        Link ret = new Link();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("type")) {
                ret.type = parseString(xv);
            } else if (xn.equals("isAny")) {
                ret.isAny = parseBoolean(xv);
            } else if (xn.equals("compClass")) {
                ret.compClass = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private ComponentRef buildComponentRef(XMLElement xel) {
        ComponentRef ret = new ComponentRef();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("type")) {
                ret.type = parseString(xv);
            } else if (xn.equals("isAny")) {
                ret.isAny = parseBoolean(xv);
            } else if (xn.equals("compClass")) {
                ret.compClass = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private EventPort buildEventPort(XMLElement xel) {
        EventPort ret = new EventPort();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("direction")) {
                ret.direction = parseString(xv);
            } else if (xn.equals("description")) {
                ret.description = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Text buildText(XMLElement xel) {
        Text ret = new Text();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Path buildPath(XMLElement xel) {
        Path ret = new Path();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Dynamics buildDynamics(XMLElement xel) {
        Dynamics ret = new Dynamics();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("simultaneous")) {
                ret.simultaneous = parseBoolean(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof DerivedVariable) {
                ret.derivedVariables.add((DerivedVariable)obj);
            } else if (obj instanceof StateVariable) {
                ret.stateVariables.add((StateVariable)obj);
            } else if (obj instanceof TimeDerivative) {
                ret.timeDerivatives.add((TimeDerivative)obj);
            } else if (obj instanceof KineticScheme) {
                ret.kineticSchemes.add((KineticScheme)obj);
            } else if (obj instanceof OnStart) {
                ret.onStarts.add((OnStart)obj);
            } else if (obj instanceof OnEvent) {
                ret.onEvents.add((OnEvent)obj);
            } else if (obj instanceof OnCondition) {
                ret.onConditions.add((OnCondition)obj);
            } else if (obj instanceof Regime) {
                ret.regimes.add((Regime)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private StateVariable buildStateVariable(XMLElement xel) {
        StateVariable ret = new StateVariable();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("exposure")) {
                ret.exposure = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private StateAssignment buildStateAssignment(XMLElement xel) {
        StateAssignment ret = new StateAssignment();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("variable")) {
                ret.variable = parseString(xv);
            } else if (xn.equals("value")) {
                ret.value = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private TimeDerivative buildTimeDerivative(XMLElement xel) {
        TimeDerivative ret = new TimeDerivative();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("variable")) {
                ret.variable = parseString(xv);
            } else if (xn.equals("value")) {
                ret.value = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private DerivedVariable buildDerivedVariable(XMLElement xel) {
        DerivedVariable ret = new DerivedVariable();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("name")) {
                ret.name = parseString(xv);
            } else if (xn.equals("select")) {
                ret.select = parseString(xv);
            } else if (xn.equals("dimension")) {
                ret.dimension = parseString(xv);
            } else if (xn.equals("reduce")) {
                ret.reduce = parseString(xv);
            } else if (xn.equals("exposure")) {
                ret.exposure = parseString(xv);
            } else if (xn.equals("value")) {
                ret.value = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private OnStart buildOnStart(XMLElement xel) {
        OnStart ret = new OnStart();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof StateAssignment) {
                ret.stateAssignments.add((StateAssignment)obj);
            } else if (obj instanceof EventOut) {
                ret.eventOuts.add((EventOut)obj);
            } else if (obj instanceof Transition) {
                ret.transitions.add((Transition)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private OnCondition buildOnCondition(XMLElement xel) {
        OnCondition ret = new OnCondition();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("test")) {
                ret.test = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof StateAssignment) {
                ret.stateAssignments.add((StateAssignment)obj);
            } else if (obj instanceof EventOut) {
                ret.eventOuts.add((EventOut)obj);
            } else if (obj instanceof Transition) {
                ret.transitions.add((Transition)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private OnEvent buildOnEvent(XMLElement xel) {
        OnEvent ret = new OnEvent();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("port")) {
                ret.port = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof StateAssignment) {
                ret.stateAssignments.add((StateAssignment)obj);
            } else if (obj instanceof EventOut) {
                ret.eventOuts.add((EventOut)obj);
            } else if (obj instanceof Transition) {
                ret.transitions.add((Transition)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private EventOut buildEventOut(XMLElement xel) {
        EventOut ret = new EventOut();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("port")) {
                ret.port = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Structure buildStructure(XMLElement xel) {
        Structure ret = new Structure();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private MultiInstantiate buildMultiInstantiate(XMLElement xel) {
        MultiInstantiate ret = new MultiInstantiate();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("number")) {
                ret.number = parseString(xv);
            } else if (xn.equals("indexVariable")) {
                ret.indexVariable = parseString(xv);
            } else if (xn.equals("component")) {
                ret.component = parseString(xv);
            } else if (xn.equals("componentType")) {
                ret.componentType = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof Assign) {
                ret.assigns.add((Assign)obj);
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private CoInstantiate buildCoInstantiate(XMLElement xel) {
        CoInstantiate ret = new CoInstantiate();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("at")) {
                ret.at = parseString(xv);
            } else if (xn.equals("component")) {
                ret.component = parseString(xv);
            } else if (xn.equals("componentType")) {
                ret.componentType = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof Assign) {
                ret.assigns.add((Assign)obj);
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Choose buildChoose(XMLElement xel) {
        Choose ret = new Choose();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private ChildInstance buildChildInstance(XMLElement xel) {
        ChildInstance ret = new ChildInstance();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("component")) {
                ret.component = parseString(xv);
            } else if (xn.equals("componentType")) {
                ret.componentType = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof Assign) {
                ret.assigns.add((Assign)obj);
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private ForEach buildForEach(XMLElement xel) {
        ForEach ret = new ForEach();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("instances")) {
                ret.instances = parseString(xv);
            } else if (xn.equals("as")) {
                ret.as = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private EventConnection buildEventConnection(XMLElement xel) {
        EventConnection ret = new EventConnection();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("from")) {
                ret.from = parseString(xv);
            } else if (xn.equals("to")) {
                ret.to = parseString(xv);
            } else if (xn.equals("delay")) {
                ret.delay = parseString(xv);
            } else if (xn.equals("receiver")) {
                ret.receiver = parseString(xv);
            } else if (xn.equals("receiverContainer")) {
                ret.receiverContainer = parseString(xv);
            } else if (xn.equals("sourcePort")) {
                ret.sourcePort = parseString(xv);
            } else if (xn.equals("targetPort")) {
                ret.targetPort = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof Assign) {
                ret.assigns.add((Assign)obj);
            } else if (obj instanceof BuildElement) {
                ret.buildElements.add((BuildElement)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Simulation buildSimulation(XMLElement xel) {
        Simulation ret = new Simulation();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else if (obj instanceof Record) {
                ret.records.add((Record)obj);
            } else if (obj instanceof Run) {
                ret.runs.add((Run)obj);
            } else if (obj instanceof DataDisplay) {
                ret.dataDisplays.add((DataDisplay)obj);
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Record buildRecord(XMLElement xel) {
        Record ret = new Record();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("quantity")) {
                ret.quantity = parseString(xv);
            } else if (xn.equals("timeScale")) {
                ret.timeScale = parseString(xv);
            } else if (xn.equals("scale")) {
                ret.scale = parseString(xv);
            } else if (xn.equals("color")) {
                ret.color = parseString(xv);
            } else if (xn.equals("display")) {
                ret.display = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private DataDisplay buildDataDisplay(XMLElement xel) {
        DataDisplay ret = new DataDisplay();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("title")) {
                ret.title = parseString(xv);
            } else if (xn.equals("dataRegion")) {
                ret.dataRegion = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

    private Run buildRun(XMLElement xel) {
        Run ret = new Run();

        for (XMLAttribute xa : xel.getAttributes()) {
            String xn = internalFieldName(xa.getName());
            String xv = xa.getValue();

            if (xn.equals("UNUSED")) {
            } else if (xn.equals("component")) {
                ret.component = parseString(xv);
            } else if (xn.equals("variable")) {
                ret.variable = parseString(xv);
            } else if (xn.equals("increment")) {
                ret.increment = parseString(xv);
            } else if (xn.equals("total")) {
                ret.total = parseString(xv);
            } else if (xn.equals("components")) {
                ret.components = parseString(xv);
            } else {
                E.warning("unrecognized attribute " + xa);
            }
        }


        for (XMLElement cel : xel.getXMLElements()) {
            String xn = cel.getTag();

            Object obj = instantiateFromXMLElement(cel);
            if (xn.equals("UNUSED")) {
            } else {
                E.warning("unrecognized element " + cel);
            }
        }


        return ret;
    }

}