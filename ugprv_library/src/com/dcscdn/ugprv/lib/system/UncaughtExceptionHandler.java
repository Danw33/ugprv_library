/**
 * 
 */
package com.dcscdn.ugprv.lib.system;

/**
 * A class that provides basic functionality to catch any uncaught exceptions and print them to the trace.
 * @author Daniel
 */
public final class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	/**
	 * Class Constructor for the Uncaught Exception Handler
	 * @author Daniel Wilson
	 */
	public UncaughtExceptionHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overrides the java native uncaught exception handler and logs using this library's trace methods.
	 * If the trace method also fails, a native system.out is used.
	 * @author Daniel Wilson
	 * @param thread The thread which has experienced the exception.
	 * @param exception The exception object itself.
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable exception) {
		// TODO Auto-generated method stub
		try
		{
			Trace.Fatal( exception, "An Uncaught Exception was encoutered in the thread " + thread.getName() + " (ID:#" + thread.getId() + "). "
									+ "The exception message reads '" + exception.getMessage() + "'"
									+ "A Stack Trace follows detailing the origin of the problem for debugging purposes. "
									+ "Note that the program may now be in an unstable and unusable state, and should be restarted ASAP!" );
		}
		catch( Exception handlerException )
		{
			System.out.println("========================== FATAL ERROR ==========================");
			System.out.println("An Uncaught Exception was encoutered in the thread " + thread.getName() + " (ID:#" + thread.getId() + ")");
			System.out.println("The exception message reads '" + exception.getMessage() + "'");
			System.out.println("An Additional Exception was encountered while attempting to log the exception to trace - '" + handlerException.getMessage() + "'");
			System.out.println("A Stack Trace follows detailing the origin of the problem for debugging purposes.");
			System.out.println("Note that the program may now be in an unstable and unusable state, and should be restarted ASAP!");
			exception.printStackTrace();
			System.out.println("Stack Trace of Additional Exception:");
			handlerException.printStackTrace();
			System.out.println("==========================+=+=+=+=+=+=+==========================");
		}
	}

}
