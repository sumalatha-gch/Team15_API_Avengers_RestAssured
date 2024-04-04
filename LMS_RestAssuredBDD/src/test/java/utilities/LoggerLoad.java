package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Payload.LmsE2EPayload;

public class LoggerLoad {
	 private static Logger logger = LogManager.getLogger();
	
	public static void info(String message) 
	{
		logger.info(message);
	}
	
	public static void warn(String message)
	{
	logger.warn(message);
	}
	
	public static void error(String message)
	{
	logger.error(message);
	}
	
	public static void fatal(String message)
	{
	logger.fatal(message);
	}
	
	public static void debug(String message)
	{
	logger.debug(message);
	}
	
	public static void logBug (String message) {
		//logger.info(message);
		LmsE2EPayload.getBugLog().append(message+"\n");
		LmsE2EPayload.bugCount++;
	}
}
