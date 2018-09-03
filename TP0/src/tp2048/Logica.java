package tp2048;

import java.util.HashSet;
import java.util.Random;

public class Logica
{
 
	int[][] matriz;
	
	
	public Logica()
	{
		matriz=new int [4][4];
		
	}  
	
	public int[][]  get_matriz() 
	{
		return matriz;
	}
	
	public int [][]  nuevo_juego() 
	{
		matriz=new int [4][4] ;//Actualizo la matriz 
		
		Random gen=new Random();
		int primero=(gen.nextInt(2)+1)*2;
		int segundo=(gen.nextInt(2)+1)*2;
		
		int ubj1=gen.nextInt(4);
		int ubi1=gen.nextInt(4);
		
		int ubj2=gen.nextInt(4);
		int ubi2=gen.nextInt(4);
		
		matriz[ubi1][ubj1]=primero;
		matriz[ubi2][ubj2]=segundo;
		
		return matriz;
		
		
	}
	
	public int [][] mover_derecha()
	{
	
		for (int i=0;i<4;i++)
		{
			mover_fila(matriz[i]);
		}
		return matriz;
	}
	
	
	public void mover_fila(int [] fila) 
	{
		for (int i=fila.length-1;i>=0;i--) 
		{
			mover(i,fila);
		}
	}

	private void mover(int i, int[] fila)
	{
	
		if (fila[i]!=0) 
		{
			int dezp=0;
			for (int j=i;j<fila.length;j++)
			{
				if (fila[j]==0)
					dezp++;
			}
			
			if (dezp>0)
			{
				
				int aux=fila[i];
				fila[i]=0;
				fila[i+dezp]=aux;	
		
				
			}
		}
		
	}
}
