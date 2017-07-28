package dressUp;

/**
 * This class HotWeather handles the clothes needed for hot weather
 * by implementing IDressForWeather
 * @author Avinash
 *
 */
public class HotWeather implements IDressForWeather {

	@Override
	public String putonFootWear() {
		return "sandals";
	}

	@Override
	public String putonHeadWear() {
		return "sun visor";
	}

	@Override
	public String putonSocks() {
		return "Fail";
	}

	@Override
	public String putonShirt() {
		return "t-shirt";
	}

	@Override
	public String putonJacket() {
		return "Fail";
	}

	@Override
	public String putonPants() {
		return "shorts";
	}

	@Override
	public String leaveHouse() {
		return "leaving house";
	}

	@Override
	public String takeOffPajamas() {
		return "Removing PJs";
	}

}
