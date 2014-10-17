package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
        public void testMultipleNumbers(){
       		assertEquals(6, Calculator.add("1,2,3"));
        }

	@Test
	public void testNewlineNumbers(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test
	public void testNewDelimeter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	

	@Test
	public void testNegativeExceptions(){
		try{
			Calculator.add("-1,2");
		}catch(Exception e){
			assertEquals("Negatives not allowed: -1", e.getMessage());
		}

		try{
			Calculator.add("2,-4,3,-5");
		}catch(Exception e){
			assertEquals("Negatives not allowed: -4,-5", e.getMessage());
		}
	}

	@Test
	public void testIgnoreBigNums(){
		assertEquals(1, Calculator.add("1,1001"));
	}

	@Test
	public void testLongDelimeter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
}
