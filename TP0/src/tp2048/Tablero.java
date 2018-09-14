package tp2048;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Tablero 
{

	private Integer score;
	private int ultimo;
	private  Casillero[][] casilla;
	private  int fila;
	private  int columna;
	SavesManager saves=new SavesManager();
	private final String scorepath="C:\\score.txt" ;
	private final String hscorepath="C:\\high.txt" ;

	// constructor
	public Tablero()
	{
		this.casilla = new Casillero[4][4];
		crearCasilleros();
		score=0;
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
		score= 0;
		this.elegirCasillero().agregarCasillero();
		this.elegirCasillero().agregarPrimerCasillero();
	}
	public int getScore() 
	{
		return score;
	}
	
	public void grabar_score(JLabel label)
	{
		saves.grabar_hscore(label,scorepath);
	}
	
	public void grabar_hscore(JLabel label)
	{
		saves.grabar_hscore(label,hscorepath);
	}
	

	

	public void cargarJuego() 
	{
		int [][] matriz=saves.cargar();
		score=(saves.rutinacarga() ? Integer.parseInt(saves.cargar_score(scorepath)) : 0);
		for (int i=0;i<matriz.length;i++) 
		{
			for (int j=0;j<matriz.length;j++) 
			{
				
				casilla[i][j]=new Casillero(matriz[i][j]);
			}
		}
	}
	public String hscore()
	{
		return saves.cargar_score(hscorepath);
	}
	
	public void guardarJuego(JButton [] j, JLabel label) 
	{
		saves.grabar_hscore(label, scorepath);
		saves.guardar(j);
		
	}
	
	public String score() 
	{
		return saves.cargar_score(scorepath);
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
				getCasilla()[i][j] = new Casillero(0);
			}
		}
	}

	public void ganar() 
	{
		casilla[0][0].setCasillero(2048);
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

	public boolean  desplazamientoDer()
	{
		boolean ret =false;
		for (int i = 0; i < 4; i++) 
		{
			int posActual = 3;
			int posAcomparar = 2;
			int aux = 3;
		
			while (posActual >= 0 && posAcomparar > -1) 
			{
				Casillero comparando=casilla[i][posActual];
				Casillero comparador= casilla[i][posAcomparar];
				
				if (posActual > 0 && comparando.equals(comparador) && comparando.getCasillero() != 0 ) 
				{
					int suma = casilla[i][posAcomparar].getCasillero() + comparando.getCasillero();
					score+=suma;
					comparando.setCasillero(0);
					comparador.setCasillero(0);
					casilla[i][aux].setCasillero(suma);
					aux--;
					posActual = posAcomparar - 1;
					posAcomparar -= 2;
					ret=true;
				} else if (comparando.getCasillero() == 0) {
					
					posActual--;
					posAcomparar--;
				} else if (comparador.getCasillero() == 0) {
					posAcomparar--;
				} else {
					int guardado = comparando.getCasillero();
					comparando.setCasillero(0);
					casilla[i][aux].setCasillero(guardado);
					aux--;
					posActual = posAcomparar;
					posAcomparar--;
					ret=true;
				}
			}

			if (posActual >= 0) {
				int guardado1 = casilla[i][posActual].getCasillero();
				casilla[i][posActual].setCasillero(0);
				casilla[i][aux].setCasillero(guardado1);
			}
		}
		return ret;
	}

	
	
	public boolean desplazamientoIzq() 
	{
		boolean ret =false;
		for (int i = 0; i < 4; i++) 
		{
			int posActual = 0;
			int posAcomparar = 1;
			int aux = 0;
			while (posActual <= 3 && posAcomparar < 4)
			{
				Casillero comparando=casilla[i][posActual];
				Casillero comparador=casilla[i][posAcomparar];
				if (posActual < 3 && comparando.equals(comparador) && comparando.getCasillero() != 0) 
				{
					int suma = comparador.getCasillero() + comparando.getCasillero();
					score+=suma;
					comparando.setCasillero(0);
					comparador.setCasillero(0);
					casilla[i][aux].setCasillero(suma);
					aux++;
					posActual = posAcomparar + 1;
					posAcomparar += 2;
					ret =true;

				} else if (comparando.getCasillero() == 0) {
					posActual++;
					posAcomparar++;
				} else if (comparador.getCasillero() == 0) {
					posAcomparar++;
				} else {
					int guardado = comparando.getCasillero();
					comparando.setCasillero(0);
					casilla[i][aux].setCasillero(guardado);
					aux++;
					posActual = posAcomparar;
					posAcomparar++;
					ret =true;
				}
			}
			if (posActual <= 3) {
				int guardado1 = casilla[i][posActual].getCasillero();
				casilla[i][posActual].setCasillero(0);
				casilla[i][aux].setCasillero(guardado1);

			}
		}
		return ret;
	}

	public boolean desplazamientoAbajo()
	{
		boolean ret =false;
		for (int i = 0; i < 4; i++)
		{
			int posActual = 3;
			int posAcomparar = 2;
			int aux = 3;
			while (posActual >= 0 && posAcomparar > -1)
			{
				Casillero comparando=casilla[posActual][i];
				Casillero comparador=casilla[posAcomparar][i];
				if (posActual > 0 && comparando.equals(comparador) && comparando.getCasillero() != 0
						&& comparador.getCasillero() != 0) {
					int suma = comparador.getCasillero() + comparando.getCasillero();
					score+=suma;
					comparando.setCasillero(0);
					comparador.setCasillero(0);
					casilla[aux][i].setCasillero(suma);
					
					aux--;
					posActual=posAcomparar-1;
					posAcomparar-=2;
					ret =true;

				} else if (comparando.getCasillero() == 0) {
					posActual--;
					posAcomparar--;
				} else if (comparador.getCasillero() == 0) {
					posAcomparar--;
				} else {
					int guardado = comparando.getCasillero();
					comparando.setCasillero(0);
					casilla[aux][i].setCasillero(guardado);
					aux--;
					posActual = posAcomparar;
					posAcomparar--;
					ret =true;
				}
			}
			if (posActual >= 0) {
				int guardado = casilla[posActual][i].getCasillero();
				casilla[posActual][i].setCasillero(0);
				casilla[aux][i].setCasillero(guardado);

			}
		}
		return ret;
	}

	public boolean desplazamientoArriba() 
	{
		boolean ret =false;
		for (int i = 0; i < 4; i++)
		{
			int posActual = 0;
			int posComparador = 1;
			int aux = 0;
			while (posActual <= 3 && posComparador < 4)
			{
				Casillero comparando=casilla[posActual][i];
				Casillero comparador=casilla[posComparador][i];
				if (posActual < 3 && comparando.equals(comparador) && comparando.getCasillero() != 0)
				{
					int suma = comparador.getCasillero() + comparando.getCasillero();
					score+=suma;
					comparando.setCasillero(0);
					comparador.setCasillero(0);
					casilla[aux][i].setCasillero(suma);;
					aux++;
					posActual = posComparador + 1;
					posComparador += 2;
					ret =true;
					
				}
				else if (comparando.getCasillero() == 0)
				{
					posActual++;
					posComparador++;
				} 
				else if (comparador.getCasillero() == 0)
				{
					posComparador++;
				} 
				else 
				{
					int guardado = comparando.getCasillero();
					comparando.setCasillero(0);
					casilla[aux][i].setCasillero(guardado);
					aux++;
					posActual = posComparador;
					posComparador++;
					ret =true;
				}
			}
			if (posActual <= 3) 
			{
				int guardado1 = casilla[posActual][i].getCasillero();
				casilla[posActual][i].setCasillero(0);
				casilla[aux][i].setCasillero(guardado1);

			}
		}
		return ret;
	}

	public boolean exiteMovPosible() 
	{
		for (int j=0;j<4;j++)
		{
			for (int i=1;i<4;i++)
			{
				Casillero comparando=casilla[i][j];
				Casillero comparador=casilla[i-1][j];
				if (comparando.getCasillero()==0 || comparador.getCasillero()==0 || comparando.equals(comparador) )
					return true;
			}
		}
		
		for (int j=1;j<4;j++)
		{
			for (int i=0;i<4;i++)
			{
				Casillero comparando=casilla[i][j];
				Casillero comparador=casilla[i][j-1];
				if (comparando.getCasillero()==0 || comparador.getCasillero()==0 || comparando.equals(comparador) )
					return true;
			}
		}
		
		return false;
		
	}

}