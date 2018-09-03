package juego;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void construirTablero() {
		Tablero tab = new Tablero();
		for(int i=0;i<tab.getCasilla().length;i++){
			for(int j=0;j<tab.getCasilla()[i].length;j++){
				assertFalse(tab.getCasilla()[i][j]!=null);
			}
		}
	}
	
	
	@Test
	public void verificarValoresIguaes(){
		Tablero tab = new Tablero();
		tab.crearCasilleros();
		assertTrue(tab.getCasilla()[1][3].getCasillero()==0);
		tab.getCasilla()[1][3].agregarPrimerCasillero();
		assertTrue(tab.getCasilla()[1][3].getCasillero()==2);
		assertTrue(tab.getCasilla()[1][0].getCasillero()==0);
		tab.getCasilla()[1][0].agregarCasillero();
		assertTrue(tab.getCasilla()[1][0].getCasillero()!=0);
	}
	
	@Test
	public void pruebaSumar(){
		Tablero tab = new Tablero();
		tab.crearCasilleros();
		tab.getCasilla()[1][3].agregarPrimerCasillero();
		tab.getCasilla()[1][2].agregarPrimerCasillero();
		tab.sumar(tab.getCasilla()[1][2], tab.getCasilla()[1][3]);
		assertTrue(tab.getCasilla()[1][2].getCasillero()==2);
		assertTrue(tab.getCasilla()[1][3].getCasillero()==4);	
	}
	
	
	
	

}
