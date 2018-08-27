package tp2048;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Interfaz {

	private JFrame frame;
	private JFrame inicio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(false);
					window.frame.setEnabled(false);
					window.inicio.setVisible(true);
					
					window.frame.setResizable(false);
					window.inicio.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static JButton generarBoton(int x,int y) 
	{
		JButton b01 = new JButton("");
		b01.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b01.setBounds(x, y, 120, 120);
		return b01;
		
	}

	public static int [][] matriz(Component [] comp)
	
	{
		Random gen =new Random();
		int [][] ret=new int [4][4];
		int but=0;
		for (int i=0;i<ret.length;i++) 
	{
		for (int j=0;j<ret.length;j++)
		{
			int e=gen.nextInt(100);
			ret[i][j]=e;
			
			 ((JButton) comp[but]).setText(""+e);
			but++;
	
			System.out.print(ret[i][j]+" ");
		}
		System.out.println("");
	}
		return ret;
	}
	
	public static void matriz_sumas(Component [] comp)
	
	{
		for (int j=0;j<comp.length;j++)
		{
			
			 JButton boton=(JButton)comp[j];
			 String nombre=boton.getText();
			 Integer suma=Integer.parseInt(nombre);
			 //if (suma!=100)
			 suma+=1;
			
			 ((JButton) comp[j]).setText(suma.toString());
			
	
			
		}
		corregir(comp);
	}
public static void matriz_restas(Component [] comp)
	
	{
		for (int j=0;j<comp.length;j++)
		{
			
			 JButton boton=(JButton)comp[j];
			 String nombre=boton.getText();
			 Integer suma=Integer.parseInt(nombre);
			 //if (suma!=0)
			 suma-=1;
			
			
			 ((JButton) comp[j]).setText(suma.toString());
			 			
	
			
		}
		corregir(comp);
	}

public static void corregir(Component [] comp)
{
    for (Component j: comp) 
    {
    	
    	JButton boton=(JButton)j;
		 String nombre=boton.getText();
		 Integer num=Integer.parseInt(nombre);
		 
		 if (num>=100 && num<1000) 
		 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		 
		 if (num>=1000) boton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		 
		 if(num<100) boton.setFont(new Font("Tahoma", Font.PLAIN, 65));
			 
    	 
    	
    	
    }
}
		
	
	private void initialize()
	{
		
		inicio = new JFrame();
		inicio.setBounds(100, 100, 600, 600);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar Juego");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setBounds(inicio.getBounds());
				frame.setEnabled(true);
				frame.setVisible(true);
				inicio.setVisible(false);
				inicio.setEnabled(false);
				
			}
		});
		btnNewButton.setBounds(112, 103, 363, 90);
		inicio.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Ver estadisitcas");
		button.setFont(new Font("Tahoma", Font.PLAIN, 39));
		button.setBounds(112, 222, 363, 90);
		inicio.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cargar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 39));
		button_1.setBounds(112, 342, 363, 90);
		inicio.getContentPane().add(button_1);

		
		//Declaracion del Frame principal
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		frame.setEnabled(false);
		frame.setVisible(false);
		

		frame.getContentPane().add(generarBoton(10,11));
		frame.getContentPane().add(generarBoton(159,11));
		frame.getContentPane().add(generarBoton(304,11));		
		frame.getContentPane().add(generarBoton(454,11));
		frame.getContentPane().add(generarBoton(10, 156));
		frame.getContentPane().add(generarBoton(159, 156));
		frame.getContentPane().add(generarBoton(304, 156));
		frame.getContentPane().add(generarBoton(454, 156));
		frame.getContentPane().add(generarBoton(10, 300));
		frame.getContentPane().add(generarBoton(159, 300));
		frame.getContentPane().add(generarBoton(304, 300));
		frame.getContentPane().add(generarBoton(454, 300));		
		frame.getContentPane().add(generarBoton(10, 441));
		frame.getContentPane().add(generarBoton(159, 441));
		frame.getContentPane().add(generarBoton(304, 441));
		frame.getContentPane().add(generarBoton(454, 441));
		
		
		

        Component [] comp=frame.getContentPane().getComponents();
       
        for (Component j: comp) 
        {
        	JButton boton=(JButton)j;
        	(boton).setFocusable(false);
        	
        	
        	
        }
        
        matriz (comp);
        frame.addKeyListener(new KeyAdapter() {
      			public void keyReleased(KeyEvent e)
      			{
      				if (e.getKeyCode()==38)
      				matriz(comp);
      				
      				if (e.getKeyCode()==39)
      					matriz_sumas(comp);
      				
      				if (e.getKeyCode()==37)
      					matriz_restas(comp);
      				
      				if (e.getKeyCode()==27)
      				{
      					inicio.setBounds(frame.getBounds());
      					inicio.setEnabled(true);
      					inicio.setVisible(true);
      					frame.setVisible(false);
      					frame.setEnabled(false);
      					
      					for (Component j: comp) 
      			        {
      			        	JButton boton=(JButton)j;
      			        	(boton).setText("");
      			        }
      						
      				}
      				
      				
      			}
      				
      			
      				
      				
      			
      		});	
        
  
        
	}

}
