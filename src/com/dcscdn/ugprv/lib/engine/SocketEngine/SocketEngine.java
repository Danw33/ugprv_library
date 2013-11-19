/**
 * 
 */
package com.dcscdn.ugprv.lib.engine.SocketEngine;


import java.io.IOException;
import java.net.ServerSocket;

import com.dcscdn.ugprv.lib.system.Trace;
import com.dcscdn.ugprv.lib.engine.SocketEngine.SEServerThread;

/**
 * Socket Engine
 * Handles socket pools, connections, and listener functions
 * Used by most network-facing methods at some stage
 * 
 * @author Daniel Wilson
 */
public class SocketEngine {

	/**
	 * The Default Maximum number of threads to spawn if not specified when calling a method.
	 * @author Daniel Wilson
	 */
	private final int DEFAULT_THREAD_LIMIT = 40; 
	
	/**
	 * constructor stub
	 */
	public SocketEngine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/////////////////////////////////
	// Public Server Methods
	/////////////////////////////////
	
	/**
	 * Starts a Multi-Threaded Server on the Given Port, with the given protocol and default maximum thread limit.
	 * @author Daniel Wilson
	 * @param Port The port on which the server should listen
	 */
	public void Server( SEProtocol Protocol, int Port )
	{
		Server(Protocol, Port, DEFAULT_THREAD_LIMIT);
	}
	
	/**
	 * Starts a Multi-Threaded Server on the Given Port, with the given protocol and maximum thread limit.
	 * @author Daniel Wilson
	 * @param Protocol The SocketEngine protocol ({@code SEProtocol}) to be used for handling communicated data.
	 * @param Port The port on which the server should listen (Above 1024, Below 65535)
	 * @param ThreadLimit The maximum number of threads to be spawned before refusing connections
	 */
	public void Server( SEProtocol Protocol, int Port, int ThreadLimit )
	{
		boolean listening = true;
	    
		try ( ServerSocket ServerSocket = new ServerSocket(Port)) { 
	    	while ( listening ) {
		    	new SEServerThread(ServerSocket.accept(), Protocol).StartThread();
		    }
		} catch ( IOException e ) {
	        Trace.Error(e, "SocketEngine: Error Starting Multi-Threaded Listening Server. Message: " + e.getMessage() );
	    }
	}
	
	/////////////////////////////////
	// Public Client Methods
	/////////////////////////////////
	
	public void Client(){}
	
	
	
}
