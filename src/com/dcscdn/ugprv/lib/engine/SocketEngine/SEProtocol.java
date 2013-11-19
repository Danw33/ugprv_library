/**
 * 
 */
package com.dcscdn.ugprv.lib.engine.SocketEngine;

/**
 * @author Daniel Wilson
 *
 */
public class SEProtocol {

	/**
	 * 
	 */
	public SEProtocol() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Receives Input Data and Processes, Returning Output Data to send to the connected client.
	 * @param InputData
	 * @return Output Data to send back to the connected client.
	 * @author Daniel Wilson
	 */
	public String ProcessInput(String InputData)
	{
		//Here, the dummy function simply returns the same data it recieved!
		//Great for testing, although this should be overriden by an extending SEProtocol Class!
		return InputData;
	}

}
