package dressUp;

/**
 * This class ColdWeather handles the clothes needed for hot weather
 * by implementing IDressForWeather
 * @author Avinash
 *
 */
public class ColdWeather implements IDressForWeather{

	@Override
	public String putonFootWear() {
		return "boots";
	}

	@Override
	public String putonHeadWear() {
		return "hat";
	}

	@Override
	public String putonSocks() {
		return "socks";
	}

	@Override
	public String putonShirt() {
		return "shirt";
	}

	@Override
	public String putonJacket() {
		return "jacket";
	}

	@Override
	public String putonPants() {
		return "pants";
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
