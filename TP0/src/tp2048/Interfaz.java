package tp2048;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;

import Animacion.Animacion;

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
	//Genera un unico boton 
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
	
	//Utilizada como recurso grafico para cambiar imagen de un drop menu
	public void im_up(JLabel icono)
	{
icono.setIcon(new ImageIcon("subir.png"));
	}
	//Utilizada como recurso grafico para cambiar imagen de un drop menu
	public void im_down(JLabel icono)
	{
icono.setIcon(new ImageIcon("bajar.png"));
	}

	//Utilizada para generar una matriz a partir de una lista de botones //En un futuro recibira una matriz para poder graficar lo que reciba de la clase negocio
	public static int [][] matriz(Component [] comp)
	
	{
		Random gen =new Random();
		int [][] ret=new int [4][4];
		int but=0;
		for (int i=0;i<ret.length;i++) 
	{
		for (int j=0;j<ret.length;j++)
		{
			int e=(gen.nextInt(2)+1)*2;
			ret[i][j]=e;
			
			((JButton) comp[but]).setFont(new Font("Tahoma", Font.PLAIN, 65));
			 ((JButton) comp[but]).setText(""+e);
			but++;
	
			System.out.print(ret[i][j]+" ");
		}
		System.out.println("");
	}
		return ret;
	}
	
	//Utilizada en pruebas actualiza la matriz
	public static void matriz_sumas(JButton [] comp)
	
	{
		for (int j=0;j<comp.length;j++)
		{
			
			 JButton boton=(JButton)comp[j];
			 String nombre=boton.getText();
			 Integer suma=Integer.parseInt(nombre);
			
			 suma*=2;
			
			 ((JButton) comp[j]).setText(suma.toString());
			
	
			
		}
		corregir(comp);
	}
	//Utilizada en pruebas actualiza la matriz
public static void matriz_restas(JButton [] comp)
	
	{
		for (int j=0;j<comp.length;j++)
		{
			 JButton boton=(JButton)comp[j];
			 String nombre=boton.getText();
			 Integer suma=Integer.parseInt(nombre);
			
			 suma/=2;
			
			 ((JButton) comp[j]).setText(suma.toString());
		}
		corregir(comp);
	}

//Utilizada para mejorar la interfaz grafica evitando dibujado sobre dibujado
public static void activar(Component [] comp) 
{
    
		for (Component j: comp) 
        {
        	try 
        	{
        		j.setEnabled(true);
        	
        	}catch (Exception e1) 
        	{
        		
        	}
        }
}
//Utilizada para mejorar la interfaz grafica evitando dibujado sobre dibujado

public static void desactivar(JButton [] comp) 
{
    
		for (JButton j: comp) 
        {
        	try 
        	{
        		j.setEnabled(false);
        	
        	}catch (Exception e1) 
        	{
        		
        	}
        }
}

//Utilizada como rescurso grafico para cambiar el tamaño del texto dependiendo de la cantidad de caracteres que se encuentren dentro del JButton
public static void corregir(JButton [] comp)
{
    for (JButton j: comp) 
    {
    	
    	JButton boton=(JButton)j;
		 String nombre=boton.getText();
		 Integer num=Integer.parseInt(nombre);
		 
		 if (num<10) 
		 {
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 65));
		 }
		 if (num>=100 && num<1000) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		 
		 if (num>=1000) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		 
		 if(num<100) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 65));

		 
		 if(num>10000) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 30));
    }
}
	
//Genera la matriz de botones que se dibujara
public static JButton[] generarBotones() 
{
	JButton[] ret = new JButton[16];;
	int i[]= {10,159,304,454};
	int e[]= {11,156,300,441};
	int indi=0;
	int inde=0;
	
	for (int o=0;o<16;o++) 
	{
		if (indi>=3) 
		{
			indi=0;
			inde++;
		}else indi++;
		
		if (inde>=4) inde=0;
		
		ret[o]=generarBoton(i[indi],e[inde]+50);
	}
	return ret;
}
	
	private void initialize()
	{
		//Aqui comienza el codigo referente al frame utilizado como pantalla de inicio
		inicio = new JFrame();
		inicio.setBounds(100, 100, 600, 700);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.getContentPane().setLayout(null);
		
		JButton start = new JButton("Iniciar Juego");
		start.setFont(new Font("Tahoma", Font.PLAIN, 39));
	
		start.setBounds(112, 103, 363, 90);
		inicio.getContentPane().add(start);
		
		JButton stats = new JButton("Ver estadisitcas");
		stats.setFont(new Font("Tahoma", Font.PLAIN, 39));
		stats.setBounds(112, 222, 363, 90);
		inicio.getContentPane().add(stats);
		
		JButton cargar = new JButton("Cargar");
		cargar.setFont(new Font("Tahoma", Font.PLAIN, 39));
		cargar.setBounds(112, 342, 363, 90);
		inicio.getContentPane().add(cargar);
		
		JButton salir=new JButton("Salir");
		salir.setFont(new Font("Tahoma", Font.PLAIN, 39));
		salir .setBounds(200, 462, 200, 70);
		inicio.getContentPane().add(salir);
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				inicio.dispose();
			}
			
		});

		
		//Declaracion del Frame principal
		frame = new JFrame("Juego 2048");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		frame.setEnabled(false);
		frame.setVisible(false);
		
		
		//Aqui comienza la definicion del panel de drop menu
	JLabel icono = new JLabel("");
	icono.setBounds(300, 1, 30, 15);
	
	frame.getContentPane().add(icono);
	
	icono.setBackground(Color.WHITE);
	icono.setIcon(new ImageIcon("bajar.png"));
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(0, -100, 600, 96);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	JButton newG = new JButton("Nuevo Juego");
	newG.setBounds(150, 39, 111, 23);

	panel.add(newG);
	
	JButton guardar = new JButton("Guardar");
	guardar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	guardar.setBounds(350, 39, 111, 23);
	panel.add(guardar);

	icono.setToolTipText("Desplegar drop menu");
	
	
	//Genero los botones y los agrego al frame
	JButton[] botones=generarBotones();
	for (int i=0;i<16;i++) 
	{
		frame.getContentPane().add(botones[i]);
	}
	
	newG.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			
			frame.requestFocus();
			matriz(botones);
			activar(botones);
			Animacion.subir(80, 0, 0, icono);
			Animacion.subir(0, -100, 0, panel);
		    im_down(icono);
			
		}
	});
	//Controlo los mouse events realizados en el drop menu
	icono.addMouseListener(new MouseAdapter() 
	{

public void mouseReleased(MouseEvent e)
{
	int posicion=panel.getY();
	if (posicion>=0)
	{
		
		Animacion.subir(80, 0, 2, icono);
		Animacion.subir(0, -100, 2, panel);
		activar(botones);
		im_down(icono);
	}else
	{
		
		Animacion.bajar(-100, 0, 2, panel);
		Animacion.bajar(0,80,  2, icono);
		im_up(icono);
		desactivar(botones);
		
		
	}

	
}

	});

	
	//Aqui cierro el frame de inicio y abro el frame de juego
    	start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				matriz(botones);
				frame.setBounds(inicio.getBounds());
				frame.setEnabled(true);
				frame.setVisible(true);
				inicio.dispose();
				
			}
		});
    	
       //Le saco el foco a todos los botones ya que no se utilizaran para nada y hara que se pierda el foco en el frame
        for (JButton j: botones) 
        {
        	try 
        	{
        		j.setFocusable(false);
        	
        	}catch (Exception e) 
        	{
        		
        	}

        }

       //Agrego un KeyListener al frame para controlar la entrada de teclado
	
        frame.addKeyListener(new KeyAdapter() {
      			public void keyPressed(KeyEvent e)
      			{
      				if (e.getKeyCode()==38)
      					//System.out.println(e.getID());
      				matriz(botones);
      				
      				if (e.getKeyCode()==39)
      					matriz_sumas(botones);
      				
      				if (e.getKeyCode()==37)
      					matriz_restas(botones);
      				
      				if (e.getKeyCode()==27)
      				{
      					inicio.setBounds(frame.getBounds());
      					inicio.setEnabled(true);
      					inicio.setVisible(true);
      					frame.setVisible(false);
      					frame.setEnabled(false);
      					
      					for (Component j: botones) 
      			        {
      			        	JButton boton=(JButton)j;
      			        	(boton).setText("");
      			        }
      						
      				}
      				
      				
      			}
      				
      			
      				
      				
      			
      		});	
        
  
        
	}

}
