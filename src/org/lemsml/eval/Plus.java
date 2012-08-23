package org.lemsml.eval;

import java.util.ArrayList;
import java.util.HashSet;

public class Plus extends DOp {

	
	public Plus(DVal dvl, DVal dvr) {
		super(dvl, dvr);
	}
	
	public Plus makeCopy() {
		return new Plus(left.makeCopy(), right.makeCopy());
	}
	
	public Plus makePrefixedCopy(String s, HashSet<String> stetHS) {
		return new Plus(left.makePrefixedCopy(s, stetHS), right.makePrefixedCopy(s, stetHS));
	}
	
	public double eval() {
		return left.eval() + right.eval();
	}

        @Override
        public String toString() {
                return "("+left +" + "+ right +")";
        }

        public String toString(String prefix, ArrayList<String> ignore) {
                return "("+left.toString(prefix, ignore) +" + "+ right.toString(prefix, ignore) +")";
        }
	
}
