package mcode.javainterview.designpattern;

import static org.junit.Assert.assertFalse;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

public class MultiSingletonInstanceTest {

	/**
	 * Question:
	 * 	Can there be more than one instance for a singleton class if it was implement 100% correctly?
	 * Answer:
	 * 	Yes.  There could be multiple instance of a singleton class if loaded by different ClassLoader or in different JVM.
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void multiSingletonInstanceUsingDifferentClassLoaderTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		ClassLoader classLoader = new URLClassLoader(new URL[] { MultiSingletonInstanceTest.class.getClassLoader().getResource("mcode/javainterview/designpattern2")});
		Class<SingletonClassExample> singletonClass = (Class<SingletonClassExample>) classLoader.loadClass("mcode.javainterview.designpattern.SingletonClassExample");
		
		
		SingletonClassExample instance1 = SingletonClassExample.getInstance();
		SingletonClassExample instance2 = (SingletonClassExample)singletonClass.getMethods()[0].invoke(null, null);
		assertFalse(instance1 == instance2);
	}

}
