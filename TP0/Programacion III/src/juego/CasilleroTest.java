package juego;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasilleroTest {
	
	@Test
	public void construirCasilleroVacio(){
		Casillero casilla = new Casillero();
		assertFalse(casilla.getCasillero()!=0);
	}

	@Test
	public void probarPrimerCasillero() {
		Casillero casilla = new Casillero();
		casilla.agregarPrimerCasillero();
		assertEquals(2, casilla.getCasillero());
	}
	
	@Test
	public void probarCasilleroAleatorio() {
		Casillero casilla = new Casillero();
		Casillero casilla1 = new Casillero();
		casilla.agregarCasillero();
		casilla1.agregarCasillero();
		assertTrue((casilla.getCasillero() == (4) || casilla.getCasillero() == 2) == true);
		assertTrue((casilla1.getCasillero() == (4) || casilla1.getCasillero() == 2) == true);

	}

	@Test
	public void settearCasilleroEnCero() {
		Casillero casilla = new Casillero();
		casilla.agregarCasillero();
		assertTrue((casilla.getCasillero() == (4) || casilla.getCasillero() == 2) == true);
		casilla.eliminar();
		assertTrue(casilla.getCasillero()==0);
	}

}
