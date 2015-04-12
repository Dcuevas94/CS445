import static org.junit.Assert.*;

import org.junit.Test;


public class ImprovedRandomTest {
	int min = 3;
	int max = 11;
	ImprovedRandom IR = new ImprovedRandom();
	int expected = IR.randIntParameter(min, max);
	
	@Test
	public void test() {
		assertTrue((expected >= 3) && (expected <= 11)); 
	}

}
