package log4jExamples;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BasicConfigure {
	
	static Logger logger = Logger.getLogger(BasicConfigure.class);
	
	
	public static void main(String[] args) {
		
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties"); 
		logger.debug("Logger Debug");
		
		logger.info("Logger info");
		logger.warn("Logger Warn");
		logger.error("Logger error");
		logger.fatal("Logger fatal");
		
		
	}
	
	

}
