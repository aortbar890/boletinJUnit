package boletinJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import boletinJUnit.Subscripcion;

public class SubscripcionTest {
	
	private Subscripcion sub;
	
	@Test
	public void testPrecioPorMes_Enteros() {
		sub = new Subscripcion(50, 5);
		assertEquals(10, sub.precioPorMes());
	}

	@Test
	public void testPrecioPorMes_Decimales() {
		sub = new Subscripcion(50, 4);
		assertEquals(13.5, sub.precioPorMes());
	}
	
	@Test
	public void testPrecioPorMes_PrecioNegativo() {
		sub = new Subscripcion(-50, 4);
		assertEquals(0, sub.precioPorMes());
	}
	
	@Test
	public void testPrecioPorMes_PeriodoNegativo() {
		sub = new Subscripcion(50, -4);
		assertEquals(0, sub.precioPorMes());
	}
	
	@Test
	public void testPrecioPorMes_Precio0() {
		sub = new Subscripcion(0, 4);
		assertEquals(0, sub.precioPorMes());
	}
	
	@Test
	public void testPrecioPorMes_Periodo0() {
		sub = new Subscripcion(50, 0);
		assertEquals(0, sub.precioPorMes());
	}
	
	
	
	

}
