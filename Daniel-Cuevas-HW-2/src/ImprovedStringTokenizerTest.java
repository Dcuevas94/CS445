import static org.junit.Assert.*;

import org.junit.Test;


public class ImprovedStringTokenizerTest {
	
	ImprovedStringTokenizer IST = new ImprovedStringTokenizer("Dan");
	ImprovedStringTokenizer IST2 = new ImprovedStringTokenizer("Dan", "Cuevas");
	ImprovedStringTokenizer IST3 = new ImprovedStringTokenizer("Dan", "Cuevas", false);
	ImprovedStringTokenizer IST4 = new ImprovedStringTokenizer("Dan", "Cuevas", true);
	@Test
	public void testTokens1() {
		IST.hasMoreTokens();
	}
	@Test
	public void testTokens2() {
		IST2.hasMoreTokens();
	}
	@Test
	public void testTokens3() {
		IST3.hasMoreTokens();
	}
	@Test
	public void testTokens4() {
		IST4.hasMoreTokens();
	}

}
