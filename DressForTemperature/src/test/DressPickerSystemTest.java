/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dressUp.DressPickerSystem;

/**
 * This class DressPickerSystemTest runs the test cases for DressPickerSystem 
 * that covers all the possible combinations of commands that could be input by the user
 * @author Avinash
 *
 */
public class DressPickerSystemTest {

	/**
	 * Test method for {@link dressUp.DressPickerSystem#buildDressOrder(java.lang.String)}.
	 */
	@Test
	public void testBuildDressOrder() {
		DressPickerSystem dressPicker = new DressPickerSystem();
		
		// Sample Test Cases Supplied
		
		assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house",dressPicker.buildDressOrder("HOT 8, 6, 4, 2, 1, 7"));
		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 5, 1, 7"));
		assertEquals("Removing PJs, shorts, fail",dressPicker.buildDressOrder("HOT 8, 6, 6"));
		assertEquals("Removing PJs, shorts, fail",dressPicker.buildDressOrder("HOT 8, 6, 6"));
		assertEquals("Removing PJs, shorts, fail",dressPicker.buildDressOrder("HOT 8, 6, 3"));
		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 5, 7"));
		assertEquals("fail",dressPicker.buildDressOrder("COLD 6"));
		

		// Rule 2: Pajamas must be taken off before wearing anything - first command must be 8
		assertEquals("fail",dressPicker.buildDressOrder("HOT 5"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 6"));
		
		assertEquals("fail",dressPicker.buildDressOrder("HOT 6"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 5"));
		
		assertEquals("fail",dressPicker.buildDressOrder("HOT 1"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 2"));
		
		assertEquals("fail",dressPicker.buildDressOrder("HOT 2"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 1"));
		
		assertEquals("fail",dressPicker.buildDressOrder("HOT 3"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 4"));
		
		assertEquals("fail",dressPicker.buildDressOrder("HOT 4"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 3"));
		
		assertEquals("fail",dressPicker.buildDressOrder("HOT 7"));
		
		assertEquals("fail",dressPicker.buildDressOrder("COLD 7"));
		
		// Rule 3: Only 1 piece of each type of clothing may be put on
		

		assertEquals("Removing PJs, shorts, fail",dressPicker.buildDressOrder("HOT 8, 6, 6"));
		
		assertEquals("Removing PJs, shorts, t-shirt, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 4"));
		
		assertEquals("Removing PJs, shorts, t-shirt, sun visor, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 2, 4"));
		
		assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 2, 1, 2"));
		
		assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 2, 1, 1"));
		
		assertEquals("Removing PJs, pants, fail",dressPicker.buildDressOrder("COLD 8, 6, 6"));
		
		assertEquals("Removing PJs, pants, socks, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 3"));
		
		assertEquals("Removing PJs, pants, socks, shirt, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 4"));
		
		assertEquals("Removing PJs, pants, socks, shirt, hat, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 2"));
		
		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 5, 5"));
		
		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 5, 1, 1"));
		
		
		// Rule 4: Socks cannot be put when it is hot
		assertEquals("Removing PJs, shorts, t-shirt, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 3"));
		
		// Rule 5: Jacket cannot be put when it is hot
		assertEquals("Removing PJs, shorts, t-shirt, sandals, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 1, 5"));
		

		// Rule 4: Socks cannot be put when it is hot - But can be put on when it is cold
		assertEquals("Removing PJs, pants, shirt, socks",dressPicker.buildDressOrder("COLD 8, 6, 4, 3"));
		
		// Rule 5: Jacket cannot be put when it is hot - But can be put on when it is cold
		assertEquals("Removing PJs, pants, shirt, socks, boots, jacket",dressPicker.buildDressOrder("COLD 8, 6, 4, 3, 1, 5"));
		
		
		// Rule 6 : Socks must be put on before shoes
		assertEquals("Removing PJs, pants, shirt, fail",dressPicker.buildDressOrder("COLD 8, 6, 4, 1, 3, 7"));
		
		// Rule 7 : Pants must be put on before shoes
		assertEquals("Removing PJs, shirt, socks, fail",dressPicker.buildDressOrder("COLD 8, 4, 3, 1, 6, 7"));
		
		// Rule 7 : Pants must be put on before shoes - Hot Climate
		assertEquals("Removing PJs, t-shirt, fail",dressPicker.buildDressOrder("HOT 8, 4, 1, 6, 7"));
		
		// Rule 6 : Socks must be put on before shoes
		assertEquals("Removing PJs, pants, shirt, socks, boots",dressPicker.buildDressOrder("COLD 8, 6, 4, 3, 1"));
		
		// Rule 7 : Pants must be put on before shoes
		assertEquals("Removing PJs, shirt, socks, pants, boots",dressPicker.buildDressOrder("COLD 8, 4, 3, 6, 1"));
		
		// Rule 7 : Pants must be put on before shoes - Hot Climate
		assertEquals("Removing PJs, t-shirt, shorts, sandals",dressPicker.buildDressOrder("HOT 8, 4, 6, 1"));
		
		// Rule 8 : Shirt must be put on before headWear
		assertEquals("Removing PJs, shorts, sandals, fail",dressPicker.buildDressOrder("HOT 8, 6, 1, 2"));
		
		// Rule 8 : Shirt must be put on before headWear - Cold Climate 
		assertEquals("Removing PJs, pants, socks, boots, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 1, 2"));
		
		// Rule 8 : Shirt must be put on before jacket
		assertEquals("Removing PJs, pants, fail",dressPicker.buildDressOrder("COLD 8, 6, 5"));
		
		// Rule 8 : Shirt must be put on before headWear - Success case
		assertEquals("Removing PJs, shorts, t-shirt, sun visor",dressPicker.buildDressOrder("HOT 8, 6, 4, 2"));
		
		// Rule 8 : Shirt must be put on before headWear - Success Case  (Cold)
		assertEquals("Removing PJs, pants, socks, boots, shirt, hat",dressPicker.buildDressOrder("COLD 8, 6, 3, 1, 4, 2"));
		
		// Rule 8 : Shirt must be put on before jacket - Success Case
		assertEquals("Removing PJs, pants, shirt, jacket",dressPicker.buildDressOrder("COLD 8, 6, 4, 5"));
		
		// Rule 9 : You cannot leave the house until all items of clothing are on 
		
		assertEquals("Removing PJs, pants, fail",dressPicker.buildDressOrder("COLD 8, 6, 7"));
		
		assertEquals("Removing PJs, pants, socks, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 7"));
		
		assertEquals("Removing PJs, pants, socks, shirt, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 7"));
		
		assertEquals("Removing PJs, pants, socks, shirt, hat, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 7"));
		
		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, fail",dressPicker.buildDressOrder("COLD 8, 6, 3, 4, 2, 5, 7"));
		
		assertEquals("Removing PJs, shorts, fail",dressPicker.buildDressOrder("HOT 8, 6, 7"));
		
		assertEquals("Removing PJs, shorts, t-shirt, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 7"));
		
		assertEquals("Removing PJs, shorts, t-shirt, sun visor, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 2, 7"));
		
		
		// Rule 10 : Command Number not available - No.25 not available  (Invalid commands)
		assertEquals("Removing PJs, shorts, t-shirt, fail",dressPicker.buildDressOrder("HOT 8, 6, 4, 25, 1, 7"));
		
		// Rule 10 : Invalid Commands 
		assertEquals("fail",dressPicker.buildDressOrder("HOT a, 6, 4, 2, 1, 7"));
		
		// Extra Rule : Wrong Climate Names - Strict upper case climate names
		assertEquals("fail",dressPicker.buildDressOrder("HOTS 8, 6, 4, 2, 1, 7"));
		
		assertEquals("fail",dressPicker.buildDressOrder("hot 8, 6, 4, 2, 1, 7"));
		
		// Working for values without spaces
		
		assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house",dressPicker.buildDressOrder("HOT 8,6,4,2,1,7"));
		
		assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house",dressPicker.buildDressOrder("COLD 8,6,3,4,2,5,1,7"));
		
	}

}
