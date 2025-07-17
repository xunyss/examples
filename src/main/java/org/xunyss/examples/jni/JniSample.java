package org.xunyss.examples.jni;

public class JniSample {

	static {
		System.loadLibrary("library-name");
	}
	
	public native void sayHello(String name);
}
