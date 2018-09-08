package tp2048;

import java.util.Random;


public class Casillero {

	private int numero;
	//constructor
	Casillero(){
		this.numero=0;
	}
	
	//agrega 2 al primer casillero elegido aleatoriamete
	public void agregarPrimerCasillero(){
		setCasillero(2);
	}
	
	//agrega un valor aleatorio a los demas casilleros elegidos aleatoriamente
	public void agregarCasillero(){
		Random r = new Random();
		int aleatorio= (r.nextInt(2)+1)*2;
		setCasillero(aleatorio);
	}
	
	//setea en cero un casillero
	public void eliminar(){
		setCasillero(0);
	}

	//get
	public int getCasillero(){
		return this.numero;
	}
	
	//set
	public void setCasillero(int num){
		this.numero=num;
	}
	
	//imprime un casillero
	public String toSting(){
		String imp=""; 
		return imp= imp+" "+ this.numero;
	}
	
	public static void main(String[] args) {
	
		Casillero cas1 = new Casillero();
		System.out.println(cas1.toSting());
//		cas1.agregarPrimerCasillero();
//		System.out.println(cas1.toSting());
//		Casillero cas2 = new Casillero();
//		System.out.println(cas2.toSting());
//		cas2.agregarCasillero();
//		System.out.println(cas2.toSting());
		cas1.agregarCasillero();
		System.out.println(cas1.getCasillero());
		
	}

}
