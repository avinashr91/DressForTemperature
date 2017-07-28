package dressUp;


/**
 * This class ColdWeatherValidator handles the various hot	 weather specific commands 
 * supplied by the user and implements the business rules before executing the commands
 * @author Avinash
 * 
 */
public class HotWeatherValidator extends AbstractValidator {
	public HotWeatherValidator(IDressForWeather dressForWeather) {
		super(dressForWeather);
	}
	@Override
	protected String handleCommand1()
	{
		// Checking if this is the first Command and if there is a footWear that is already been worn
		if(isThisFirstCommand() || dressingState.isFootwear())
			return null;
		// Pants should be put before shoes
		if(!dressingState.isPants())
			return null;
		String outputData = dressForWeather.putonFootWear();
		dressingState.setFootwear(true);
		return outputData;
		
	}
	@Override
	protected String handleCommand7() {
		// Checking if all items of hot  weather clothing are worn
		if(!isAllClothingOn())
		{
			return null;
		}
		String outputData = dressForWeather.leaveHouse();
		dressingState.setLeaveHouse(true);
		return outputData;
	}
	@Override
	protected String handleCommand3() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String handleCommand5() {
		// TODO Auto-generated method stub
		return null;
	}

}
