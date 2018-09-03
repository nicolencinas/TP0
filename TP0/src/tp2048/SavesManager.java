package tp2048;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SavesManager 
{

	FileWriter fw=null;
	ArrayList<String> list;
	int matriz[][] =new int [4][4];
	String elem;
	
	public SavesManager()
	{

		list=new ArrayList<String>();
		elem="";
		
	}
	
	public void guardar(JButton[] j)
	{
		list.clear(); //Limpiamos la matriz que guardara la info de los botones para evitar quedarnos con los datos anteriores en tiempo de ejecucion
		
		File f=new File("C:/save2.txt");//creamos un nuevo File 
	
		for (JButton boton : j) //Recorremos la lista de botones y los agregamos a una lista 
		{
			String s =(String)boton.getText();
			list.add(s);
		}
		
		try {
        	fw = new FileWriter(f); //convertimos el File en un FileWriter
        	for (int i=0; i<list.size(); i++){
            	if (i>0)
            	{
                	//nueva línea
                fw.write(System.getProperty("line.separator")); 
            	}
            	elem = (String) list.get(i); //casteamos a String lo obtenido en cada linea
            	fw.write(elem); //escribimo en el File Writer
        	}
    	} catch (IOException e) { //Manejo de excepciones
        	e.printStackTrace();
    	}
    	finally{
        	if (fw!=null){
            	try {
                	fw.close(); //cerramos el archivo
            	} catch (IOException e) {
                	e.printStackTrace();
            	}
            	fw = null;//Cambiamos el valor del FileWriter a null para borrar los datos almacernados en tiempo de ejeccuion
        	}
    	}
}

	
	public int [][] cargar()
	{
		return matriz; //LA matriz ira cambiando y obtenemos su valor luego de hacer la rutina de carga
	}
	
	public boolean rutinacarga()
	{
		
	
	File f = new File( "C:\\save2.txt" ); //Buscamos nuestro archivo .txt
	
	if (f.exists())  //Si existe entramos en el codigo
	{
		int i=0; //indices para recorrer alamacenar las columnas
	int j=0; //indice para almacernas las filas
	
	BufferedReader entrada = null; 
	try 
	{ 
	entrada = new BufferedReader( new FileReader( f ) ); //Creamos un Buffer de lectura
	String linea; //creamos un String que contendra cada linea
	
	int [] line=new int [4]; // creamos un arreglo que se copiara en cada una de filas
	
	while(entrada.ready()) //si el buffer esta listo
	{ 
	linea = entrada.readLine(); //leemos linea a linea
	
	try 
	{
		int num=Integer.parseInt(linea); //castemos la entrada a int
		line[i]=num; //lo agregamos al arreglo
		i++;//cambiamos el indice del arrelo;
		
		if (i==4) //Si el arreglo esta completo
		{
			
			for (int l=0;l<line.length;l++) //lo recorremos y copiamos en la fila j todo los valores del arreglo line
			{
				matriz[j][l]=line[l];
			}
			
			j++; //pasamos a la siguiente linea
			i=0; //volvemos a cero para empezar de la columna 0 otra vez para almacenar las columnas
			
			
		}
		
	}catch (Exception e)
	{
		e.printStackTrace();
	}
	
	
	} 
	}catch (IOException e) { 
	e.printStackTrace(); 
	} 
	finally 
	{ 
	try{ 
	entrada.close();
	return true;
	}catch(IOException e1){} 
	} 
	}
	else 
	{ 
		return false; //Si el archivo no existe retorna false para darle infomacion a la interfaz y saber que mensaje mostrar en cada caso
	}
	return false;
	
	
	}
	
	
	 {
		
	}
		
		
	}

