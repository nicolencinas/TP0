package tp2048;

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
			this.fw= new FileWriter("c:/save.txt");
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
        	fw = new FileWriter("c:/save.txt");
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
		
		
	}

