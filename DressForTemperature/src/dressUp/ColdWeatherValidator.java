package dressUp;

/**
 * This class ColdWeatherValidator handles the various cold weather specific commands 
 * supplied by the user and implements the business rules before executing the commands
 * @author Avinash
 * 
 */
public class ColdWeatherValidator extends AbstractValidator {
	public ColdWeatherValidator(IDressForWeather dressForWeather) {
		super(dressForWeather);
	}
	@Override
	protected String handleCommand1()
	{
		// Checking if this is the first Command and if there is footWear that is already been worn
		if(isThisFirstCommand() || dressingState.isFootwear())
			return null;
		// Socks and Pants should be put before shoes
		if(!dressingState.isSocks()|| !dressingState.isPants())
			return null;
		String outputData = dressForWeather.putonFootWear();
		dressingState.setFootwear(true);
		return outputData;
	}
	@Override
	protected String handleCommand7() {
		// Checking if all items of common weather clothing and winter specific clothing are worn
		if(!isAllClothingOn() || !dressingState.isJacket() || !dressingState.isSocks())
		{
			return null;
		}
		String outputData = dressForWeather.leaveHouse();
		dressingState.setLeaveHouse(true);
		return outputData;
		
	}
	@Override
	protected String handleCommand3() {
		//  Checking if this is the first Command and if there is socks that is already been worn
		if(isThisFirstCommand() || dressingState.isSocks())
			return null;
		String outputData = dressForWeather.putonSocks();
		dressingState.setSocks(true);
		return outputData;
		
	}
	@Override
	protected String handleCommand5() {
		// Checking if this is the first Command and if there is a jacket that is already been worn
		if(isThisFirstCommand() || dressingState.isJacket())
			return null;
		// Check if the shirt is already put on
		if(!dressingState.isShirt())
			return null;
		String outputData = dressForWeather.putonJacket();
		dressingState.setJacket(true);
		return outputData;
	}
}
