package dressUp;
 
import java.lang.reflect.Method;
import java.util.List;

/**
 * This AbstractValidator class handles the various commands supplied by the user 
 * and implements the business rules before executing the commands
 * @author Avinash
 *
 */
public abstract class AbstractValidator{

	protected IDressForWeather dressForWeather;
	protected DressingState dressingState;
	protected String failure;

	/**
	 * @param dressForWeather - An IDressForWeather instance representing either HotWeather or ColdWeather
	 * return AbstractValidator object with the right weather object and a dressingState object to maintain
	 * the dresses put on currently
	 */
	protected AbstractValidator(IDressForWeather dressForWeather) {
		this.dressForWeather = dressForWeather;
		this.dressingState = new DressingState();
		this.failure = "fail";
	}

	/**
	 * @return String This returns the corresponding footWear to put on
	 * after analyzing the rules to execute Command1
	 */
	protected abstract String handleCommand1() ;
	
	
	/**
	 * @return String This returns the corresponding headWear to put on
	 * after analyzing the rules to execute Command2 
	 */
	protected String handleCommand2() {	
		
		// Check to decide if this is not the first command executed and if already a piece of headWear is worn 
		if(isThisFirstCommand() || dressingState.isHeadwear())
			return null;
		
		// Check if Shirt is worn
		if(!dressingState.isShirt())
			return null;
		String outputData = dressForWeather.putonHeadWear();
		dressingState.setHeadwear(true);
		return outputData;
	}
	/**
	 * @return String This returns the socks to put on
	 * after analyzing the rules to execute Command3
	 */
	protected abstract String handleCommand3();
	
	/**
	 * @return String This returns the corresponding shirt to put on 
	 * after analyzing the rules to execute Command4 
	 */
	protected String handleCommand4() {
		
		// Check to decide if this is not the first command executed and if already a piece of shirt is worn
		if(isThisFirstCommand() || dressingState.isShirt())
			return null;
		String outputData = dressForWeather.putonShirt();
		dressingState.setShirt(true);
		return outputData;
	}
	
	/**
	 * @return String This returns the jacket to put on 
	 * after analyzing the rules to execute Command5 
	 */
	protected abstract String handleCommand5();
	
	/**
	 * @return String This returns the corresponding pants to put on 
	 * after analyzing the rules to execute Command6 
	 */
	protected String handleCommand6() {
		// Check to decide if this is not the first command executed and if already a piece of pants is worn
		if(isThisFirstCommand() || dressingState.isPants())
			return null;
		String outputData = dressForWeather.putonPants();
		dressingState.setPants(true) ;
		return outputData;
	}
	/**
	 * @return String This returns "leaving house" if the user shall leave the house 
	 * after analyzing the rules to execute Command7 
	 */
	protected abstract String handleCommand7();
	
	/**
	 * @return String This returns "Removing PJs"
	 * after analyzing the rules to execute Command8 
	 */
	
	protected String handleCommand8() {
		
		// Check if the Command 8 to take off pajamas is already executed 
		if(dressingState.isTakeOffPJs())
			return null;
		String outputData = dressForWeather.takeOffPajamas();
		dressingState.setTakeOffPJs(true);
		return outputData;
	}
	
	/**
	 * @return boolean This validates if the first Command that will be issued is to take off pajamas
	 */
	protected boolean isThisFirstCommand() {
		return !dressingState.isTakeOffPJs();
	}
	
	/**
	 * @return boolean This validates if all the items of clothing are put on
	 */
	protected boolean isAllClothingOn()
	{
		return dressingState.isFootwear() && dressingState.isHeadwear() && dressingState.isPants() && dressingState.isShirt();
	}
	
	
	/**
	 * @param states represents the commands given as an input by the user
	 * @return String This is the dressing order to be followed before leaving the house 
	 */
	public String validateAndGetOrder(List<String> states) {
		String output = "";
		// Regex for Digits
		String regex = "\\d+";
		for (String state : states) {
			try
			{
				// Processing only digits and their commands
				if(state.trim().length() == 0)
					continue;
					
				if(state == null || state.trim().matches(regex))
				{
					// Using Java's Reflection to execute the correct command for a state 
					Method method = this.getClass().getSuperclass().getDeclaredMethod("handleCommand" + state);
					method.setAccessible(true);
					String result = (String)method.invoke(this);
					if(result != null)
					{
						// Success State Case
						output += result+ ", ";
					}
					else
					{
						// Failed State Case
						output += failure;
						return output;
					}
				}
				// Appending fail when a non digit is encountered
				else
				{
					output += failure;
					return output;
				}
			}
			// Handles if there is not a class method declared with that name
			catch(NoSuchMethodException ex)
			{
				output += failure;
				return output;
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return output.substring(0, output.length()-2);
	}
}
