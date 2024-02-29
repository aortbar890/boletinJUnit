package boletinJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import boletinJUnit.Fridge;
import boletinJUnit.NoSuchItemException;

public class FridgeTest {

	private Fridge fridge;
	
    @BeforeEach
    void setUp() {
        fridge = new Fridge();
    }
    @AfterEach
    public void finish() {
        fridge = null; 
    }
	
	
    @ParameterizedTest
    @MethodSource("alimentos")
    void testPut(String item) {
    	if (fridge.contains(item)) {
            assertFalse(fridge.put(item));
        } else {
            assertTrue(fridge.put(item));
        }
    }


    @ParameterizedTest
    @MethodSource("alimentos")
    void testContains(String item) {
        if (fridge.contains(item)) {
            assertTrue(fridge.contains(item));
        } else {
            assertFalse(fridge.contains(item));
        }
    }

        


    @ParameterizedTest
    @MethodSource("alimentos")
     void testTake(String item) {
        fridge.put(item);
        try {
            fridge.take(item);
        } catch (NoSuchItemException e) {
            fail("El elemento debería existir en la nevera, no debería lanzar NoSuchItemException");
        }
        assertFalse(fridge.contains(item));
    }
    
    private static Stream<String> alimentos() {
        return Stream.of("manzana", "platano", "naranja");
    }



}

