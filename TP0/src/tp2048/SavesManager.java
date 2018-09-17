package tp2048;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

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
	
	public void testAdminrigths() throws IOException 
	{
		File f=new File("C:/test.txt");
		
		 
	
		fw=new FileWriter (f);
		
		fw.write("test");	
		

 	
		
        	if (fw!=null)
        	{
            	try 
            	{
                	fw.close(); //cerramos el archivo
            	} catch (IOException e) {
                	e.printStackTrace();
            	}
            	fw = null;//Cambiamos el valor del FileWriter a null para borrar los datos almacernados en tiempo de ejeccuion
        	}
		f.delete();
		
}
		
		
			
			
		
	
	
	public void guardar(JButton[] j) throws Exception
	{
		list.clear(); //Limpiamos la matriz que guardara la info de los botones para evitar quedarnos con los datos anteriores en tiempo de ejecucion
		
		File f=new File("C:/save.txt");//creamos un nuevo File 
	
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
        	if (fw!=null)
        	{
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
	
	public void grabar_hscore(JLabel label,String file) throws Exception
	{
	
		File f = new File(file);
		try {
			fw= new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}

		try {
			fw.write(label.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
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
	
	public String cargar_score(String file)
	{
		File f = new File(file); 
		
		if (!f.exists())
		{
			return ""+100;
		}
		
		BufferedReader entrada = null; 
		try
		{
			entrada=new BufferedReader(new FileReader(f));
			String linea=null;
			
			if(entrada.ready())
			
				linea=entrada.readLine();
			return linea;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{ 
		try{ 
		entrada.close();
		
		}catch(IOException e1){} 
		}
		return elem; 
		
		
		
		
		
		}
		
	public boolean rutinacarga()
	{
		
	
	File f = new File( "C:\\save.txt" ); 
	
	if (f.exists())  
	{
		int i=0; 
	int j=0;
	
	BufferedReader entrada = null; 
	try 
	{ 
	entrada = new BufferedReader( new FileReader( f ) ); 
	String linea; 
	
	int [] line=new int [4]; 
	
	while(entrada.ready())
	{ 
	linea = entrada.readLine();
	try 
	{
		int num=Integer.parseInt(linea);
		line[i]=num;
		i++;
		
		if (i==4) 
		{
			
			for (int l=0;l<line.length;l++)
			{
				matriz[j][l]=line[l];
			}
			
			j++;
			i=0; 
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
		return false; 
	}
	return false;
	
	
	}
	
	
	 {
		
	}
		
		
	}

