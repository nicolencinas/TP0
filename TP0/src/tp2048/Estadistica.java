package tp2048;

import java.util.Comparator;
import java.util.Date;

public class Estadistica
{
	String nombre;
	Integer puntaje;
	Date date;
	
	public Estadistica(String nombre, Integer puntaje) 
	{
		date=new Date();
		this.nombre=nombre;
		this.puntaje=puntaje;
		
	}
	
	public static class comparar implements Comparator<Estadistica> 
	{

		@Override
		public int compare(Estadistica arg0, Estadistica arg1)
		{
			return arg0.puntaje.compareTo(arg1.puntaje);
		}

	}
	
	 
	

}
