package crm.crm.vtiger.genericLibrary;

import java.util.Date;
import java.util.Random;
/**
 * This Class contains methods specific to Java
 * @author rohit
 *
 */
public class JavaUtility 
{
	/**
	 * This method returns Random No.
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	/**
	 * This method will return date in Default Format
	 * @return
	 */
	public String getCurrentDate()
	{
		Date date = new Date();
		String currDate= date.toString();
		return currDate;
		
	}
	
	/**
	 * This method will return date in specified format
	 * @return
	 */
	public String getFinalDateFormat()
	{
		Date date = new Date();
		String currDate = date.toString();
		String[] s = currDate.split(" ");
		String YYYY = s[5];
		String DD = s[2];
		String MM = s[1];
		String today = YYYY+"_"+MM+"_"+DD;
		return today;
	}

}
