package tp2048;

import java.util.Random;

public class Tablero {

	private int ultimo;
	private  Casillero[][] casilla;
	private  int fila;
	private  int columna;

	// constructor
	Tablero()
	{
		this.casilla = new Casillero[4][4];
		crearCasilleros();
		//this.getCasilla()=
	
	}

	// crea casilleros

	public int getultimo()
	{
		return ultimo;
	}
	public void nuevoJuego()
	{
		casilla=new Casillero[4][4];
		crearCasilleros();
		Random gen =new Random();
		int uno=(gen.nextInt(3));
		int dos=(gen.nextInt(3));
		casilla[uno][dos].agregarCasillero();
	}
	public int [][] getmatriz() 
	{
		int ret [][] =new int [4][4];
	
		for (int i=0;i<4;i++ ) 
		{
			for (int j=0;j<4;j++) 
			{
				ret[i][j]=casilla[i][j].getCasillero();
			}
		}
		return ret;
	}
	public void crearCasilleros() {
		for (int i = 0; i < getCasilla().length; i++) {
			for (int j = 0; j < getCasilla()[i].length; j++) {
				getCasilla()[i][j] = new Casillero();
			}
		}
	}

	// elige una casilla aleatoria
	public Casillero elegirCasillero() 
	{

		
		Random aleatorio = new Random();
		fila = aleatorio.nextInt(4);
		columna = aleatorio.nextInt(4);

		while (casilla[fila][columna].getCasillero() != 0) {
			fila = aleatorio.nextInt(4);
			columna = aleatorio.nextInt(4);
		}
		ultimo=fila*4+columna;
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
	public static boolean verificarValoresIguales(Casillero cas1, Casillero cas2) {
		return (cas1.getCasillero() == cas2.getCasillero());
		
	}

	// suma dos casilleros

	public void desplazamientoDer() {
		for (int i = 0; i < 4; i++) {
			int posActual = 3;
			int posAcomparar = 2;
			int aux = 3;
			while (posActual >= 0 && posAcomparar > -1) {
				if (posActual > 0 && verificarValoresIguales(casilla[i][posActual], casilla[i][posAcomparar]) == true
						&& casilla[i][posActual].getCasillero() != 0 ) 
				{
					int suma = casilla[i][posAcomparar].getCasillero() + casilla[i][posActual].getCasillero();
					casilla[i][posActual].setCasillero(0);
					casilla[i][posAcomparar].setCasillero(0);
					casilla[i][aux].setCasillero(suma);
					aux--;
					posActual = posAcomparar - 1;
					posAcomparar -= 2;
				} else if (casilla[i][posActual].getCasillero() == 0) {
					
					posActual--;
					posAcomparar--;
				} else if (casilla[i][posAcomparar].getCasillero() == 0) {
					posAcomparar--;
				} else {
					int guardado = casilla[i][posActual].getCasillero();
					casilla[i][posActual].setCasillero(0);
					casilla[i][aux].setCasillero(guardado);
					aux--;
					posActual = posAcomparar;
					posAcomparar--;
				}
			}

			if (posActual >= 0) {
				int guardado1 = casilla[i][posActual].getCasillero();
				casilla[i][posActual].setCasillero(0);
				;
				casilla[i][aux].setCasillero(guardado1);
			}
		}
	}

	public void desplazamientoIzq() {
		for (int i = 0; i < 4; i++) {
			int posActual = 0;
			int posAcomparar = 1;
			int aux = 0;
			while (posActual <= 3 && posAcomparar < 4) {
				if (posActual < 3 && casilla[i][posActual].getCasillero() == casilla[i][posAcomparar].getCasillero() && casilla[i][posActual].getCasillero() != 0) 
				{
					int suma = casilla[i][posAcomparar].getCasillero() + casilla[i][posActual].getCasillero();
					casilla[i][posActual].setCasillero(0);
					casilla[i][posAcomparar].setCasillero(0);
					casilla[i][aux].setCasillero(suma);
					aux++;
					posActual = posAcomparar + 1;
					posAcomparar += 2;

				} else if (casilla[i][posActual].getCasillero() == 0) {
					posActual++;
					posAcomparar++;
				} else if (casilla[i][posAcomparar].getCasillero() == 0) {
					posAcomparar++;
				} else {
					int guardado = casilla[i][posActual].getCasillero();
					casilla[i][posActual].setCasillero(0);
					casilla[i][aux].setCasillero(guardado);
					aux++;
					posActual = posAcomparar;
					posAcomparar++;
				}
			}
			if (posActual <= 3) {
				int guardado1 = casilla[i][posActual].getCasillero();
				casilla[i][posActual].setCasillero(0);
				casilla[i][aux].setCasillero(guardado1);

			}
		}
	}

	public void desplazamientoAbajo() {
		for (int i = 0; i < 4; i++) {
			int posActual = 3;
			int posAcomparar = 2;
			int aux = 3;
			while (posActual >= 0 && posAcomparar > -1) {
				if (posActual > 0 && casilla[posActual][i].getCasillero() == casilla[posAcomparar][i].getCasillero() && casilla[posActual][i].getCasillero() != 0
						&& casilla[posAcomparar][i].getCasillero() != 0) {
					int suma = casilla[posAcomparar][i].getCasillero() + casilla[posActual][i].getCasillero();
					casilla[posActual][i].setCasillero(0);
					casilla[posAcomparar][i].setCasillero(0);
					casilla[aux][i].setCasillero(suma);
					
					aux--;
					posActual=posAcomparar-1;
					posAcomparar-=2;

				} else if (casilla[posActual][i].getCasillero() == 0) {
					posActual--;
					posAcomparar--;
				} else if (casilla[posAcomparar][i].getCasillero() == 0) {
					posAcomparar--;
				} else {
					int guardado = casilla[posActual][i].getCasillero();
					casilla[posActual][i].setCasillero(0);
					casilla[aux][i].setCasillero(guardado);
					aux--;
					posActual = posAcomparar;
					posAcomparar--;
				}
			}
			if (posActual >= 0) {
				int guardado = casilla[posActual][i].getCasillero();
				casilla[posActual][i].setCasillero(0);
				casilla[aux][i].setCasillero(guardado);

			}
		}
	}

	public void desplazamientoArriba() {
		for (int i = 0; i < 4; i++) {
			int posActual = 0;
			int posComparador = 1;
			int aux = 0;
			while (posActual <= 3 && posComparador < 4) {
				if (posActual < 3 && casilla[posActual][i].getCasillero() == casilla[posComparador][i].getCasillero() && casilla[posActual][i].getCasillero() != 0)
				{
					int suma = casilla[posComparador][i].getCasillero() + casilla[posActual][i].getCasillero();
					casilla[posActual][i].setCasillero(0);
					casilla[posComparador][i].setCasillero(0);
					casilla[aux][i].setCasillero(suma);;
					aux++;
					posActual = posComparador + 1;
					posComparador += 2;
					
				}
				else if (casilla[posActual][i].getCasillero() == 0)
				{
					posActual++;
					posComparador++;
				} 
				else if (casilla[posComparador][i].getCasillero() == 0)
				{
					posComparador++;
				} 
				else 
				{
					int guardado = casilla[posActual][i].getCasillero();
					casilla[posActual][i].setCasillero(0);
					casilla[aux][i].setCasillero(guardado);
					aux++;
					posActual = posComparador;
					posComparador++;
				}
			}
			if (posActual <= 3) {
				int guardado1 = casilla[posActual][i].getCasillero();
				casilla[posActual][i].setCasillero(0);
				casilla[aux][i].setCasillero(guardado1);

			}
		}
	}

	public boolean exiteMovPosible() {
		for (int i = 0; i < 3; i++) {
			if (casilla[i][0].getCasillero() == 0 || casilla[i][1].getCasillero() == 0
					|| casilla[i][0].getCasillero() == casilla[i][1].getCasillero()) {
				return true;
			}
		}
		for (int j = 2; j <= 3; j++) {
			for (int i = 0; i <= 2; i++) {
				if (casilla[i][j - 1].getCasillero() == 0 || casilla[i][j].getCasillero() == 0
						|| casilla[i][j - 1].getCasillero() == casilla[i][j].getCasillero()) {
					return true;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (casilla[3][i].getCasillero() == casilla[3][i + 1].getCasillero()
					|| casilla[i][3].getCasillero() == casilla[i + 1][3].getCasillero()) {
				return true;
			}
		}
		if (casilla[3][3].getCasillero() == 0) {
			return true;
		}
		return false;
	}

}