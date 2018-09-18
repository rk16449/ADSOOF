/**
 * 
 */
package sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Raj
 *
 */
class BubbleSortTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link sort.BubbleSort#sort(T[])}.
	 */
	@Test
	void testSort() {
		Integer[] rgInts = new Integer[] {5, 10, 25, 16};
		
		BubbleSort.sort(rgInts);
		
		for(int i=0; i<rgInts.length; i++) {
			System.out.println(rgInts[i]);
		}
		
		// Check that the values are sorted
		
	}

}
