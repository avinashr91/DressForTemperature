package dressUp;

import java.util.Arrays;
import java.util.List;

/**
 * This DressPickerSystem class picks the correct dress order to be put on 
 * for the corresponding type of weather
 * @author Avinash
 *
 */
public class DressPickerSystem{
	AbstractValidator validator = null;
	/**
	 * @param input represents the user input command 
	 * @return String This returns the correct dress order to wear before leaving the house
	 */
	public String buildDressOrder(String input) {
		// TODO Auto-generated method stub
		if(input == null || input.trim().length() == 0)
			return "fail";
		List<String> cmds = Arrays.asList(input.split(",|\\ "));
		String weather = cmds.get(0);
		
		if (weather.equals("HOT")) {
			// HotWeather Validator's Instantiation 
			validator = new HotWeatherValidator(new HotWeather());
		}
		else if(weather.equals("COLD"))
		{
			// ColdWeather Validator's Instantiation
			validator = new ColdWeatherValidator(new ColdWeather());
		}
		else
		{
			return "fail";
		}
		return validator.validateAndGetOrder(cmds.subList(1, cmds.size()));
	}
	
}
