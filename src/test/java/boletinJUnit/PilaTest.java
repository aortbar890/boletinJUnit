package boletinJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import boletinJUnit.Pila;

public class PilaTest {


	@Test
	public void testPush() {
		Pila pila = new Pila();
		
		pila.push(0);
		assertTrue(pila.isEmpty());
		
		pila.push(2);
		assertTrue(pila.isEmpty());

		pila.push(10);
		assertEquals(10, (int) pila.pop());

		pila.push(20);
		assertTrue(pila.isEmpty());

		pila.push(25); 
		assertTrue(pila.isEmpty());
	}

    @Test
    public void testPop() {
        Pila pila = new Pila();
        
        assertNull(pila.pop());
        
        pila.push(10);
        assertEquals(10, (int) pila.pop());
        
        assertNull(pila.pop());
    }

    @Test
    public void testIsEmpty() {
        Pila pila = new Pila();
        
        assertTrue(pila.isEmpty());
        
        pila.push(10);
        assertFalse(pila.isEmpty()); 
        
        pila.pop();
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testTop() {
        Pila pila = new Pila();
        
        assertNull(pila.top());
        
        pila.push(10);
        assertEquals(10, (int) pila.top());
        
        pila.pop();
        assertNull(pila.top());
    }
}
