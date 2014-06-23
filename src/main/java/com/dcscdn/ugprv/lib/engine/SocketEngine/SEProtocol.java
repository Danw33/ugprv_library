/**
 * 
 */
package com.dcscdn.ugprv.lib.engine.SocketEngine;

/**
 * @author Daniel Wilson
 *
 */
public interface SEProtocol {


	/**
	 * Receives Input Data and Processes, Returning Output Data to send to the connected client.
	 * @param InputData
	 * @return Output Data to send back to the connected client.
	 * @author Daniel Wilson
	 */
	public String ProcessInput(String InputData);

}
