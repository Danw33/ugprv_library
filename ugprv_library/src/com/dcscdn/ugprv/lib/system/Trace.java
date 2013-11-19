/**
 * 
 */
package com.dcscdn.ugprv.lib.system;

import java.text.SimpleDateFormat;

import com.dcscdn.ugprv.lib.engine.ConfigurationEngine;

import print.color.Ansi.BColor;
import print.color.Ansi.FColor;
import print.color.ColoredPrinter;
import print.color.Ansi.*;

/**
 * Trace System
 * Used for writing trace messages to console/logs in a common format
 * 
 * @author Daniel Wilson
 */
public class Trace {

	protected static ColoredPrinter printer = new ColoredPrinter.Builder(9, false).build();
	
	public static boolean PrettyLogging = false; 
	
	/**
	 * Enumerated Trace Types (Severity Levels)
	 * @author Daniel Wilson
	 */
	protected static enum TraceLevel {
		DEBUG, INFO, WARN, ERROR, FATAL;
	}

	
	/**
	 * Trace constructor
	 * Responsible for initialising the trace printer
	 * Trace printing depends on the inclusion of JCDP, which intern depends on JANSI!
	 * @author Daniel Wilson
	 */
	public Trace() { super(); }

	
	
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
	private final static void StackTrace( final Exception exception )
	{
		exception.printStackTrace();
	}
	
	/**
	 * Prints a Stack Trace for the given exception parameter
	 * 
	 * @param exception The exception to print a stack trace for
	 * @author Daniel Wilson
	 */
	private final static void StackTrace( final Throwable exception )
	{
		exception.printStackTrace();
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
		
		if( PrettyLogging == true ){
			//Set the default foreground (text) and background (highlight) colours
			FColor EntryForeground = FColor.WHITE;
			BColor EntryBackground = BColor.NONE;
			
			//Set the colour of the log entry based on the Trace Level (E.g: Warning is Yellow)
			if 		( level == TraceLevel.DEBUG ) 	{  EntryForeground = FColor.CYAN;  	}
			else if ( level == TraceLevel.INFO 	) 	{  EntryForeground = FColor.BLUE;  	}
			else if ( level == TraceLevel.WARN 	) 	{  EntryForeground = FColor.YELLOW; }
			else if ( level == TraceLevel.ERROR ) 	{  EntryForeground = FColor.RED;  	}
			else if ( level == TraceLevel.FATAL ) 	{  EntryForeground = FColor.WHITE;  EntryBackground = BColor.RED; };
			
			//Print the entry to the console
			printer.println("[" + date.toString() + "] [" + level.toString() + "] " + message.toString() , Attribute.NONE, EntryForeground, EntryBackground);
		}
		else
		{
			System.out.println("[" + date.toString() + "] [" + level.toString() + "] " + message.toString());
		}
		
		return;
	}
	
}
