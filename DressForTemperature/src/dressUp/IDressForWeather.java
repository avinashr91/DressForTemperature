package dressUp;

/**
 * This interface IDressForWeather handles the functions to put on clothes that are needed by 
 * all kinds of Weather instances 
 * All Weather classes must implement this interface
 * @author Avinash
 *
 */
public interface IDressForWeather 
{
	/**
	 * @return String This returns the footWear to be put on for the weather
	 */
	
	public String putonFootWear();
	
	/**
	 * @return String This returns the headWear to be put on for the weather
	 */
	
	public String putonHeadWear();
	
	/**
	 * @return String This returns the socks to be put on for the weather
	 */
	
	public String putonSocks();
	
	/**
	 * @return String This returns the shirt to be put on for the weather
	 */
	
	public String putonShirt();
	
	/**
	 * @return String This returns the jacket to be put on for the weather
	 */
	
	public String putonJacket();
	
	/**
	 * @return String This returns the pants to be put on for the weather
	 */
	
	public String putonPants();
	
	/**
	 * @return String This returns "leaving house" 
	 */
	
	public String leaveHouse();
	
	/**
	 * @return String This returns "Removing PJs" 
	 */
	
	public String takeOffPajamas();
}

