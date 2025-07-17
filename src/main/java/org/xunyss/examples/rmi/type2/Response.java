package org.xunyss.examples.rmi.type2;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String value;
	
	public Response(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
