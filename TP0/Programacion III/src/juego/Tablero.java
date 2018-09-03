package juego;

import java.util.Random;

public class Tablero {

	private Casillero[][] casilla;
	private static int fila;
	private static int columna;

	// constructor
	Tablero() {
		this.casilla = new Casillero[4][4];
	}

	// crea casilleros
	public void crearCasilleros() {
		for (int i = 0; i < getCasilla().length; i++) {
			for (int j = 0; j < getCasilla()[i].length; j++) {
				getCasilla()[i][j] = new Casillero();
			}
		}
	}

	// elige una casilla aleatoria
	public Casillero elegirCasillero() {

		Random aleatorio = new Random();
		fila = aleatorio.nextInt(4);
		columna = aleatorio.nextInt(4);

		while (casilla[fila][columna].getCasillero() != 0) {
			fila = aleatorio.nextInt(4);
			columna = aleatorio.nextInt(4);
		}
		return this.casilla[fila][columna];
	}

	public boolean estaLleno() {
		boolean lleno = true;
		for (int i = 0; i < getCasilla().length; i++) {
			for (int j = 0; j < getCasilla()[i].length; j++) {
				if (getCasilla()[i][j].getCasillero() == 0) {
					lleno = false;
				}

			}
			lleno = lleno && true;
		}
		return lleno;
	}

	public boolean gano() {

		for (int i = 0; i < getCasilla().length; i++) {
			for (int j = 0; j < getCasilla()[i].length; j++) {
				if (getCasilla()[i][j].getCasillero() == 2048) {
					return true;
				}
			}
		}
		return false;
	}

	// get
	public Casillero[][] getCasilla() {
		return casilla;
	}

	// set
	public void setCasilla(Casillero[][] casilla) {
		this.casilla = casilla;
	}

	// verifica si dos casilleros tienen el mismo valor
	public boolean verificarValoresIguales(Casillero cas1, Casillero cas2) {
		if (cas1.getCasillero() == cas2.getCasillero()) {
			return true;
		}
		return false;
	}

	// suma dos casilleros
	public int sumar(Casillero cas1, Casillero cas2) {
		cas2.setCasillero(cas1.getCasillero() + cas2.getCasillero());
		cas1.eliminar();
		return cas2.getCasillero();
	}

	public static void main(String[] args) {
		Tablero tab = new Tablero();
		int fila1, fila2;
		int columna1, columna2;

		System.out.println("Crea tablero setteado en cero");

		for (int i = 0; i < tab.getCasilla().length; i++) {
			for (int j = 0; j < tab.getCasilla()[i].length; j++) {
				tab.getCasilla()[i][j] = new Casillero();
				System.out.print(tab.getCasilla()[i][j].toSting());
			}
			System.out.println();
		}

		System.out
				.println("Elige dos casilleros al azar, uno lo settea en 2 y en 2o4");

		tab.elegirCasillero().agregarPrimerCasillero();
		tab.elegirCasillero().agregarCasillero();
		// verificar que a veces no se ejecuta bien el agregar primer casillero
		//
		// System.out.println("prueba sumar");
		// tab.elegirCasillero().agregarPrimerCasillero();
		// fila1=fila;
		// columna1=columna;
		// tab.elegirCasillero().agregarCasillero();
		// fila2=fila;
		// columna2=columna;
		//
		// System.out.println(fila1+", "+columna1);
		// System.out.println(fila2+", "+columna2);
		//
		//
		// if(tab.verificarValoresIguales(tab.casilla[fila1][columna1],
		// tab.casilla[fila2][columna2])==true){
		// tab.sumar(tab.casilla[fila1][columna1],tab.casilla[fila2][columna2]);
		// }

		// for(int i=0;i<tab.getCasilla().length;i++){
		// for(int j=0;j<tab.getCasilla()[i].length;j++){
		// System.out.print(tab.getCasilla()[i][j].toSting());
		// }
		// System.out.println();
		// }
		// System.out.println();

		System.out.println("1");

		for (int i = 0; i < tab.getCasilla().length; i++) {
			for (int j = 0; j < tab.getCasilla()[i].length; j++) {
				System.out.print(tab.getCasilla()[i][j].toSting());
			}
			System.out.println();
		}

		int n = 2;
		while (tab.estaLleno() == false && tab.gano() == false) {
			System.out.println(n);
			System.out.println();
			tab.elegirCasillero().agregarCasillero();
			// verificar que a veces no se ejecuta bien el agregar primer
			// casillero
			// ver que el aleatorio no elija algo que ya esta ocupado..LISTO
			for (int i = 0; i < tab.getCasilla().length; i++) {
				for (int j = 0; j < tab.getCasilla()[i].length; j++) {
					System.out.print(tab.getCasilla()[i][j].toSting());
				}
				System.out.println();
			}
			n++;
		}
		if (tab.gano() == true) {
			System.out.println("ganaste");
		}

		if (tab.estaLleno() == true) {
			System.out.println("perdiste");
		}

	}

}
