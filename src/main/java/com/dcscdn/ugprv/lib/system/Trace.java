/**
 * 
 */
package com.dcscdn.ugprv.lib.system;

import java.text.SimpleDateFormat;

/**
 * Trace System
 * Used for writing trace messages to console/logs in a common format
 * 
 * @author Daniel Wilson
 */
public class Trace {

	
	/**
	 * Enumerated Trace Types (Severity Levels)
	 * @author Daniel Wilson
	 */
	protected static enum TraceLevel {
		DEBUG, INFO, WARN, ERROR, FATAL;
	}
	
	
	/**
	 * Prints a Debug message to the trace
	 * Requires Debug=true to function
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void Debug( String message )
	{
		LogEntry(message, TraceLevel.DEBUG);
	}
	
	/**
	 * Prints an Informational message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void Info( String message )
	{
		LogEntry(message, TraceLevel.INFO);
	}
	
	/**
	 * Prints a Warning message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void Warn( String message )
	{
		LogEntry(message, TraceLevel.WARN);
	}
	
	/**
	 * Prints an Error message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void Error( String message )
	{
		LogEntry(message, TraceLevel.ERROR);
	}
	
	/**
	 * Prints a Fatal Error message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void Fatal( String message )
	{
		LogEntry(message, TraceLevel.FATAL);
	}

	
	
	/**
	 * Prints a Debug message to the trace with a Stack Trace
	 * Requires Debug=true to function
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Debug(Exception exception, String message )
	{
		Debug(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Informational message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Info(Exception exception, String message )
	{
		Info(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Warning message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Warn( Exception exception, String message )
	{
		Warn(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Error( Exception exception, String message )
	{
		Error(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Fatal Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Fatal( Exception exception, String message )
	{
		Fatal(message);
		StackTrace(exception);
		return;
	}


	
	/**
	 * Prints a Debug message to the trace with a Stack Trace
	 * Requires Debug=true to function
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Debug(Throwable exception, String message )
	{
		Debug(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Informational message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Info(Throwable exception, String message )
	{
		Info(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Warning message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Warn( Throwable exception, String message )
	{
		Warn(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Error( Throwable exception, String message )
	{
		Error(message);
		StackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Fatal Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void Fatal( Throwable exception, String message )
	{
		Fatal(message);
		StackTrace(exception);
		return;
	}

	
	/**
	 * Prints a Stack Trace for the given exception parameter
	 * 
	 * @param exception The exception to print a stack trace for
	 * @author Daniel Wilson
	 */
	private final static void StackTrace( final Throwable exception )
	{
		System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
		exception.printStackTrace(System.out);
	}
	
	/**
	 * Prints a Formatted Trace message, with time-stamp and severity indicator.
	 * 
	 * @param message The message to log to the trace output
	 * @param level	The severity of the log message
	 * @see TraceLevel
	 * @author Daniel Wilson
	 */
	private final static void LogEntry( String message, TraceLevel level )
	{
		//Prepare and get a Date/Timestamp
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-DD HH:MM:SS");
		
		System.out.println("[" + date.toString() + "] [" + level.toString() + "] " + message.toString());
		
		return;
	}
	
}
