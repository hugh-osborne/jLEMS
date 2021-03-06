package org.lemsml.jlems.test.dev;

import java.io.File;

import org.codehaus.commons.compiler.jdk.JavaSourceClassLoader;
import org.lemsml.jlems.core.logging.E;
import org.lemsml.jlems.core.run.GeneratedInstance;


public class DynamicCompilation {

	
	public static void main(String[] argv) {
		DynamicCompilation dct = new DynamicCompilation();
		try {
			dct.compileAndLoad();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void compileAndLoad() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader pcl = getClass().getClassLoader();
		
		File fsrc = new File("src");
		File[] spath = {fsrc};
		
		JavaSourceClassLoader cl = new JavaSourceClassLoader(pcl);
		cl.setSourcePath(spath);
	 	
	
		Class nacl = cl.loadClass("org.lemsml.dynamic.na");
		E.info("Loaded class " + nacl);
		
		Object inst = nacl.newInstance();
		E.info("instantiated one " + inst);
		
		GeneratedInstance gi = (GeneratedInstance)inst;
	//	gi.advance(0.01);
	
	}
	
	
}
