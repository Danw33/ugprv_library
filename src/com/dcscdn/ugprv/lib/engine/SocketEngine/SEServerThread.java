/**
 * 
 */
package com.dcscdn.ugprv.lib.engine.SocketEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.dcscdn.ugprv.lib.system.Trace;

/**
 * @author Daniel Wilson
 *
 */
public class SEServerThread {

	private Socket ServerSocket = null;
	private SEProtocol ServerProtocol = new SEProtocol();
	
	/**
	 * @param ServerSocket 
	 * @param ServerProtocol 
	 * @author Daniel Wilson
	 */
	public SEServerThread(Socket ServerSocket, SEProtocol ServerProtocol) {
		super();
		this.ServerSocket 	= ServerSocket;		//The socket which this thread has been assigned
		this.ServerProtocol = ServerProtocol;	//The protocol to be used for handling received data
	}

	
	/**
	 * A listener method designed to run on a separate thread
	 * @author Daniel Wilson
	 */
	public void StartThread()
	{
		try 
		(
            PrintWriter out = new PrintWriter(ServerSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader( ServerSocket.getInputStream() ) );
        ) 
        {
            String inputLine, outputLine;
            
            outputLine = ServerProtocol.ProcessInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = ServerProtocol.ProcessInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("CLOSE"))
                    break;
            }
            
            ServerSocket.close();
        } catch (IOException e) {
            Trace.Error(e, "SocketEngine: Error in child server thread (Socket: " + ServerSocket.getPort() + ", "
            				+ "Remote Host: " + ServerSocket.getInetAddress().getHostAddress().toString() + "). "
            				+ "Message: " + e.getMessage());
        }
	}
}
