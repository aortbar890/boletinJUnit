package boletinJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import boletinJUnit.OperadorAritmetico;

public class OperadorAritmeticoTest {

	@Test
	public void testSuma() {
		
		assertEquals(5, OperadorAritmetico.suma(2, 3));
		
			
		assertEquals(-5, OperadorAritmetico.suma(-2, -3));
		
		
		assertEquals(-1, OperadorAritmetico.suma(2, -3));
	}

	@Test
	public void testDivision() {
		
		try {
			assertEquals(2, OperadorAritmetico.division(6, 3));
			assertEquals(0, OperadorAritmetico.division(0, 3));
			assertEquals(-4, OperadorAritmetico.division(12, -3));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
    @Test
    public void testDivisionPorCero() throws Exception {
        OperadorAritmetico.division(5, 0);
    }



}
