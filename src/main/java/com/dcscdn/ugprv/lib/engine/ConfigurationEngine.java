/**
 * 
 */
package com.dcscdn.ugprv.lib.engine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.ini4j.Ini;

import com.dcscdn.ugprv.lib.system.Trace;

/**
 * 
 * @author Daniel Wilson
 */
public class ConfigurationEngine {

	/**
	 * Configuration Engine Constructor
	 */
	public ConfigurationEngine() {
		super();
	}

	/**
	 * Enumerated Section Headers
	 * @author Daniel Wilson
	 */
	protected enum Section
	{
		; //No Values are enumerated here, instead they should be put in an extending class
		
		Section( String Identifier ) { }
	}
	
	/**
	 * Enumerated Parameters and the related methods for getting and setting parameters.
	 * @author Daniel Wilson
	 */
	protected enum Parameter
	{
		; //No Values are enumerated here, instead they should be put in an extending class
		 
		Parameter( Section Section, String Identifier ){
			//registerSection(Section, Identifier, Parameter);
		}
		
		//=========
		// Getters
		//=========
		
		private void registerSection(Section Section, String Identifier) {
			// TODO Auto-generated method stub
			//Sections.put(Parameter, Section)
		}

		/**
		 * Get the value of of a configuration parameter.
		 * @param Parameter The configuration parameter from which to fetch the value
		 * @return The value of the specified parameter as a string
		 */
		public static String getValueAsString(Parameter Parameter)
		{
			return getValue( Parameter ).toString();
		}
		
		/**
		 * Get the value of of a configuration parameter.
		 * @param Parameter 
		 * @return The value of the specified parameter as a integer
		 */
		public static int getValueAsInt(Parameter Parameter)
		{
			return Integer.parseInt( getValue( Parameter ) );
		}
		
		/**
		 * Get the value of of a configuration parameter.
		 * @param Parameter 
		 * @return The value of the specified parameter as a long integer
		 */
		public static long getValueAsLong(Parameter Parameter)
		{
			return Long.parseLong( getValue( Parameter ) );
		}
		
		/**
		 * Get the value of of a configuration parameter.
		 * @param Parameter 
		 * @return The value of the specified parameter as a boolean
		 */
		public static boolean getValueAsBoolean(Parameter Parameter)
		{
			return false;
		}

		/**
		 * Get a value for a given parameter from the loaded configuration set.
		 * @param Parameter
		 * @return Value
		 */
		private static String getValue(Parameter Parameter)
		{
			try
			{
				return Loaded.get( Parameter ).toString();
			}
			catch ( Exception e )
			{
				Trace.Warn( e , "A call to Configuration.Parameter->getValue(" + Parameter.toString() + ") resulted in the following error: " + e.getMessage() );
				return "";
			}
		}
	}

	protected static HashMap<Parameter, String> Loaded = new HashMap<Parameter, String>();
	protected static HashMap<Parameter, Section> Sections = new HashMap<Parameter, Section>();
	
	/**
	 * Gets the loaded configuration set
	 * @return the HashMap containing the loaded configuration set
	 * @author Daniel Wilson
	 */
	private static HashMap<Parameter, String> getLoaded() {
		return Loaded;
	}

	/**
	 * Sets the loaded configuration set
	 * @param loaded the loaded to set
	 * @author Daniel Wilson
	 */
	private static void setLoaded(HashMap<Parameter, String> loaded) {
		Loaded = loaded;
	}

	/**
	 * Checks to see if the configuration is loaded.
	 * @author Daniel Wilson
	 * @return True if the configuration is loaded, False if it is not.
	 */
	public static boolean isLoaded()
	{
		if ( Loaded.isEmpty() || Loaded.size() == 0 )
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	
	//========
	// Loader
	//========
	
	/**
	 * Loads the configuration set from the configuration file at the given path.
	 * @param FilePath
	 * @author Daniel Wilson
	 */
 	public static void LoadConfiguration(String FilePath)
	{
		try {
			Ini ini = new Ini( new File( FilePath ) );
			
			ParseINI( ini );
		} catch (IOException e) {
			Trace.Error( e, "Failed to load configuration file, Error: " + e.getMessage() );
		}
	}
	
	/**
	 * Reloads the current configuration set from the configuration file at the given path.
	 * @param FilePath
	 * @author Daniel Wilson
	 */
	public static void ReloadConfiguration(String FilePath)
	{
		LoadConfiguration( FilePath );
	}

	/**
	 * Parses an INI object into the Loaded HashMap, based on Sections (Headers) and Parameters (Keys)
	 * @param ini The INI object to parse
	 * @author Daniel Wilson
	 */
	public static void ParseINI( Ini ini )
	{
		//int parameters = Parameter.values().length;
		for ( Parameter key : Parameter.values() )
		{
				//Loaded.put(key, ini.get(sectionName, key.));
		}
	}
}
