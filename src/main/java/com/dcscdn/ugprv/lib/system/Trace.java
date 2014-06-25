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
	protected static enum traceLevel {
		DEBUG, INFO, WARN, ERROR, FATAL;
	}
	
	
	/**
	 * Prints a Debug message to the trace
	 * Requires Debug=true to function
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void debug( String message )
	{
		logEntry(message, traceLevel.DEBUG);
	}
	
	/**
	 * Prints an Informational message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void info( String message )
	{
		logEntry(message, traceLevel.INFO);
	}
	
	/**
	 * Prints a Warning message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void warn( String message )
	{
		logEntry(message, traceLevel.WARN);
	}
	
	/**
	 * Prints an Error message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void error( String message )
	{
		logEntry(message, traceLevel.ERROR);
	}
	
	/**
	 * Prints a Fatal Error message to the trace
	 * 
	 * @param message The trace message to print
	 * @author Daniel Wilson
	 */
	public final static void fatal( String message )
	{
		logEntry(message, traceLevel.FATAL);
	}

	
	
	/**
	 * Prints a Debug message to the trace with a Stack Trace
	 * Requires Debug=true to function
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void debug(Exception exception, String message )
	{
		debug(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Informational message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void info(Exception exception, String message )
	{
		info(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Warning message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void warn( Exception exception, String message )
	{
		warn(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void error( Exception exception, String message )
	{
		error(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Fatal Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void fatal( Exception exception, String message )
	{
		fatal(message);
		stackTrace(exception);
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
	public final static void debug(Throwable exception, String message )
	{
		debug(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Informational message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void info(Throwable exception, String message )
	{
		info(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Warning message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void warn( Throwable exception, String message )
	{
		warn(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints an Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void error( Throwable exception, String message )
	{
		error(message);
		stackTrace(exception);
		return;
	}
	
	/**
	 * Prints a Fatal Error message to the trace with a Stack Trace
	 * 
	 * @param message The trace message to print
	 * @param exception The exception requiring a stack trace
	 * @author Daniel Wilson
	 */
	public final static void fatal( Throwable exception, String message )
	{
		fatal(message);
		stackTrace(exception);
		return;
	}

	
	/**
	 * Prints a Stack Trace for the given exception parameter
	 * 
	 * @param exception The exception to print a stack trace for
	 * @author Daniel Wilson
	 */
	private final static void stackTrace( final Throwable exception )
	{
		System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
		exception.printStackTrace(System.out);
	}
	
	/**
	 * Prints a Formatted Trace message, with time-stamp and severity indicator.
	 * 
	 * @param message The message to log to the trace output
	 * @param level	The severity of the log message
	 * @see traceLevel
	 * @author Daniel Wilson
	 */
	private final static void logEntry( String message, traceLevel level )
	{
		//Prepare and get a Date/Timestamp
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-DD HH:MM:SS");
		
		System.out.println("[" + date.toString() + "] [" + level.toString() + "] " + message.toString());
		
		return;
	}
	
}
