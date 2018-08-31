package tp2048;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

public class Negocio 
{

	FileWriter fw;
	ArrayList<String> list;
	
	String elem;
	
	public Negocio()
	{
		try {
			this.fw= new FileWriter("d:/save.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list=new ArrayList<String>();
		elem="";
		
	}
	
	public void guardar(JButton[] j)
	{
		for (JButton boton : j)
		{
			String s =(String)boton.getText();
			list.add(s);
		}
		
		try {
        	fw = new FileWriter("d:/save.txt");
        	for (int i=0; i<list.size(); i++){
            	if (i>0)
            	{
                	//nueva línea
                fw.write(System.getProperty("line.separator"));
            	}
            	elem = (String) list.get(i);
            	fw.write(elem);
        	}
    	} catch (IOException e) {
        	e.printStackTrace();
    	}
    	finally{
        	if (fw!=null){
            	try {
                	fw.close();
            	} catch (IOException e) {
                	e.printStackTrace();
            	}
            	fw = null;
        	}
    	}
}
	public int [][] cargar2() 
	{
		 int [][] matriz=new int [4][4]; 
		 int num=1;
		for (int i=0;i<4;i++) 
		{
			for (int j=0;j<4;j++) 
			{
				matriz[i][j]=num;
				num++;
			}
		}
		return matriz;
	}
	public int [][] cargar()
	{
		
	int matriz[][] =new int [4][4];
	File f = new File( "d:\\save2.txt" ); 
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
		//i++;
		
		if (i>=3)
		{
			i=0;
			for (int l=0;l<4;l++) 
			{
				matriz[i][j]=line[l];
			}
			j++;
			
			
			
		}
		
	}catch (Exception e)
	{
		
	}
	
	
	} 
	}catch (IOException e) { 
	e.printStackTrace(); 
	} 
	finally 
	{ 
	try{ 
	entrada.close(); 
	}catch(IOException e1){} 
	} return matriz;
	} 
	
	 {
		
	}
		
		
	}

