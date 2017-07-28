package dressUp;

public class InputHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DressPickerSystem dressPicker = new DressPickerSystem();
		System.out.println(dressPicker.buildDressOrder(args[0]));
	}

}
