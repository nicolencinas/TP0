package tp2048;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Animacion.Animacion;

public class Interfaz {

	private JFrame frame;
	private JFrame inicio;
	SavesManager saveManager=new SavesManager();
	static Tablero tablero=new Tablero();
	
	boolean perdiste=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablero.elegirCasillero().agregarPrimerCasillero();
					tablero.elegirCasillero().agregarCasillero();
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
	public Interfaz()
	{
		initialize();
//		try
//		{
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//		}catch (Exception e)
//		{
//			
//		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

	//Genera un unico boton 
	public static JButton generarBoton(int x,int y) 
	{
		JButton b01 = new JButton("");
		b01.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b01.setFocusable(false);
		b01.setBounds(x, y, 120, 120);
		return b01;
		
	}
	public void gameOver(JLabel hscore,JLabel hscoreinfo, JLabel score, JLabel scoreinfo, JPanel gameover,JButton [] botones,JLabel icono,JLabel mensajefinal) 
	{
		int scorey=score.getY();
			
			int ub=gameover.getY();
			if (ub>134) 
			{
			Animacion.subir(800,20, 1, 1, mensajefinal);
			Animacion.subir(800, 134, 1, 1, gameover);
			
			icono.setBounds(-100, -100, -100, -100);
			desactivar(botones);
			
			if (scorey<=300) 
			{
				
				
				Animacion.bajar(0, 300, 15, 3, scoreinfo);
				
				Animacion.mover_izquierda(490, 350, 10, 1, scoreinfo);
				
				
                Animacion.bajar(1, 300, 15, 3, hscoreinfo);
				
				Animacion.mover_derecha(5, 145, 10, 1, hscoreinfo);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Animacion.bajar(0, 250, 15, 3, score);
				
				Animacion.mover_izquierda(520, 375, 9, 1, score);
				
				Animacion.bajar(0, 250, 15, 3, hscore);
				
				Animacion.mover_derecha(27, 167, 9, 1, hscore);
				Integer hsc=Integer.parseInt(hscoreinfo.getText())+100;
				hscoreinfo.setText(hsc.toString());
				
				score.setText("Score final");
			}	
			
			
			}
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

public static void  dibujar(int[][] matriz , JButton [] botones)
	
	{
		
		int but=0;
		for (int i=0;i<matriz.length;i++) 
	{
		for (int j=0;j<matriz.length;j++)
		{
			
			int e=matriz[i][j];
			
			botones[but].setFont(new Font("Tahoma", Font.PLAIN, 65));
			botones[but].setText(""+e);
			but++;
	
			System.out.print(matriz[i][j]+" ");
		}
	
		System.out.println("");
	}
		corregir(botones);
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
public void setScore(Integer num, JLabel label ) 
{
	
	label.setText(num.toString());
	
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
		 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 65));
		 
		 if (num>=100 && num<1000) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		 
		 if (num>=1000) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		 
		 if(num<100) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 65));

		  if (num==0) 
		 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 0));
		 
		 if(num>10000) 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		 if (num>100000)
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 25));
    }
}
	public static void corregirLabel(JLabel label)
	{

    	
		 String nombre=label.getText();
		 Integer num=Integer.parseInt(nombre);
		 
		
	
		 if (num>=1000) 
			label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 
		
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
		ret[o]=generarBoton(i[indi],e[inde]+50);
		
		if (indi>=3) 
		{
			inde++;
			indi=0;
		}
				
		else 
		{
			indi++;
			
		}
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
		
		//Esta es la definicion de Un Jlabel que se usara como contenedor de un hipervinculo que envia al usuario a un instructivo del juego
		// en la pagina de wikipedia
		
		JLabel imagen = new JLabel("");
		imagen.setSize(270,270);
		imagen.setLocation(165,0);
		Image im=new ImageIcon("50935.png").getImage();
		imagen.setIcon(new ImageIcon( im.getScaledInstance(270, 270, Image.SCALE_SMOOTH)));
		imagen.setToolTipText("Ver informacion del juego. Go to: https://es.wikipedia.org/wiki/2048_(videojuego)");
		
		
		imagen.addMouseListener(new MouseAdapter() 
		{

			public void mouseReleased(MouseEvent e)
			{
				String uri="https://es.wikipedia.org/wiki/2048_(videojuego)";
				try 
				{
					Desktop.getDesktop().browse(java.net.URI.create(uri));
				} catch (IOException e1)
				{
			
					e1.printStackTrace();
				}
			}
			
			public void mouseEntered(MouseEvent e)
			{
				try {
					Thread.sleep(300);
				} catch (InterruptedException e1)
				{
				
					e1.printStackTrace();
				}
				imagen.setLocation(164, 0);
				imagen.setBorder(BorderFactory.createLineBorder(new Color(58,76,186)));
			}
			
			public void  mouseExited(MouseEvent e)
			{
				imagen.setLocation(165, 0);
				imagen.setBorder(null);
			}

		});
		
		//Botones del frame de inicio
		JButton start = new JButton("Iniciar Juego");
		start.setFont(new Font("Tahoma", Font.PLAIN, 30));
	 
	
		inicio.setTitle("Juego 2048: Menu de seleccion");
		inicio.add(imagen);
		start.setBounds(144, 310, 313, 60);
		inicio.getContentPane().add(start);
		
		JButton stats = new JButton("Ver estadisitcas");
		stats.setFont(new Font("Tahoma", Font.PLAIN, 30));
		stats.setBounds(144, 390, 313, 60);
		inicio.getContentPane().add(stats);
		
		JButton cargar = new JButton("Cargar");
		cargar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cargar.setBounds(144, 470, 313, 60);
		inicio.getContentPane().add(cargar);
		

		JButton salir=new JButton("Salir");
		salir.setFont(new Font("Tahoma", Font.PLAIN, 30));
		salir .setBounds(200, 590, 200, 60);
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
	icono.setBounds(280, 1, 30, 15);
	
	frame.getContentPane().add(icono);
	
	icono.setBackground(Color.WHITE);
	icono.setIcon(new ImageIcon("bajar.png"));
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(10, -100, 570, 96);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	panel.setBorder(new RoundedBorder(30));
	
	JLabel guardada=new JLabel();
	guardada.setText("Partida guardada");
	guardada.setBounds(430,-100,160,30);
	guardada.setBackground(Color.white);
	guardada.setBorder(new RoundedBorder(30));
	frame.add(guardada);
	
	JLabel cargada=new JLabel();
	cargada.setText("Partida cargada");
	cargada.setVisible(false);
	cargada.setBounds(30,20,160,30);
	cargada.setBackground(Color.white);
	cargada.setBorder(new RoundedBorder(30));
	frame.add(cargada);
	
	JButton newG = new JButton("Nuevo Juego");
	newG.setBounds(100, 39, 111, 23);
    newG.setBorder(new RoundedBorder(10));
	panel.add(newG);
	
	JButton guardar = new JButton("Guardar");
	guardar.setBorder(new RoundedBorder(10));
	guardar.setBounds(360, 39, 111, 23);
	panel.add(guardar);
    
	
	icono.setToolTipText("Desplegar drop menu");
	
		
	
	//Definicion del panel de fin del juego
		
		JLabel hscore=new JLabel ("HighScore");
		hscore.setBounds(27,1,100,15);
		JLabel hscoreinfo=new JLabel(saveManager.cargar_hscore());
		corregirLabel (hscoreinfo);
		hscoreinfo.setBackground(Color.WHITE);
		hscoreinfo.setBorder(new RoundedBorder(30));
		//hscoreinfo.setFont(new Font("Tahoma", Font.PLAIN, 20));;
		hscoreinfo.setBounds(5,14 , 100, 40);
		frame.getContentPane().add(hscore);
		frame.getContentPane().add(hscoreinfo);
	
	
		JLabel score=new JLabel ("Score");
		score.setBounds(522,1,100,10);
		JLabel scoreinfo=new JLabel("0");
		scoreinfo.setBackground(Color.WHITE);
		scoreinfo.setBorder(new RoundedBorder(30));
		scoreinfo.setFont(new Font("Tahoma", Font.PLAIN, 20));;
		scoreinfo.setBounds(490,14 , 100, 40);
		frame.getContentPane().add(score);
		frame.getContentPane().add(scoreinfo);
		
		JPanel gameover=  new JPanel();
		gameover.setVisible(true);
		gameover.setBounds(20,800,560,334);
		gameover.setBorder(new RoundedBorder(30));
		gameover.setBackground(Color.WHITE);
		gameover.setLayout(null);
		
		JLabel mensajefinal= new JLabel("Perdiste");
		mensajefinal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mensajefinal.setBounds(220,800,120,30);
		gameover.add(mensajefinal);
		frame.getContentPane().add(gameover);
		
	//Cambio el borde de los botones principales
		cargar.setBorder(new RoundedBorder(30));
		start.setBorder(new RoundedBorder(30));
		salir.setBorder(new RoundedBorder(30));
		stats.setBorder(new RoundedBorder(30));
	
	
	//Genero los botones y los agrego al frame
	JButton[] botones=generarBotones();
	
	for (int i=0;i<16;i++) 
	{
		frame.getContentPane().add(botones[i]);
	}
	
	//Defino las acciones del boton de nuevo juego del drop menu
	newG.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			int ret=JOptionPane.showConfirmDialog(guardar, "¿Deseas Comenzar un nuevo juego?","Confirmar Nuevo Juego",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (ret==0) 
			{
				tablero.nuevoJuego();
				dibujar(tablero.getmatriz(),botones);

			}
			
			activar(botones);
			Animacion.subir(80, 0, 0,1, icono);
			Animacion.subir(0, -100, 0,1, panel);
		    im_down(icono);
			frame.requestFocus();
		}
	});
	
	//Defino las acciones del boton guardar del drop menu
	guardar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			int ret=JOptionPane.showConfirmDialog(guardar, "¿Deseas Guardar la partida?","Confirmar Guardado",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (ret==0)
			{
				tablero.guardarJuego(botones);
				Animacion.mover_izquierda(1000, 490, 10, 2, scoreinfo);
				Animacion.mover_izquierda(1000, 520, 10, 2, score);
				Animacion.subir(20, -100, 35,1, guardada);
			}
			
			activar(botones);
			Animacion.subir(80, 0, 0,1, icono);
			Animacion.subir(0, -100, 0,1, panel);
			im_down(icono);
			
		   frame.requestFocus();
		    
		}
	});
	
	
	//Defino las acciones del Boton de cargar juego de la pantalla incicial
	cargar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
		
			int seleccion=-1;
			if (!tablero.saves.rutinacarga()) 
			{
				
				
			
				seleccion=JOptionPane.showConfirmDialog(inicio,"No existe una partida guardada. \n ¿Desea iniciar una nueva partida? ","Error",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
		
			}
			
			
			
			else 
			{
				tablero.cargarJuego();
				dibujar(tablero.getmatriz(),botones);
				cargada.setVisible(true);
				Animacion.mover_izquierda(30, -200, 15,1, cargada);
			
				Animacion.mover_derecha(-800, 27, 10, 2, hscore);
				Animacion.mover_derecha(-800, 5, 10, 2, hscoreinfo);
			frame.setBounds(inicio.getBounds());
			frame.setEnabled(true);
			frame.setVisible(true);
			inicio.dispose();
			}
				
			 if (seleccion==0)
			{
				dibujar(tablero.getmatriz(),botones);
				frame.setBounds(inicio.getBounds());
				frame.setEnabled(true);
				frame.setVisible(true);
				inicio.dispose();
			
		
			
			}

		}
		
	});	

	//Aqui cierro el frame de inicio y abro el frame de juego
    	start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tablero.nuevoJuego();
				dibujar(tablero.getmatriz(),botones);
				frame.setBounds(inicio.getBounds());
				frame.setEnabled(true);
				frame.setVisible(true);
				inicio.dispose();
				
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
		
		Animacion.subir(80, 0, 2,1, icono);
		Animacion.subir(0, -100, 2,1, panel);
		activar(botones);
		icono.setToolTipText("Desplegar drop menu");

		im_down(icono);
	}else
	{
		
		Animacion.bajar(-100, 0, 2,1, panel);
		Animacion.bajar(0,80,  2,1, icono);
		im_up(icono);
		icono.setToolTipText("Retraer drop menu");
		desactivar(botones);
	}

}
	});
	

       //Agrego un KeyListener al frame para controlar la entrada de teclado
	
        frame.addKeyListener(new KeyAdapter() {
      			public void keyReleased(KeyEvent e)
      			{
      				if (e.getKeyCode()==38)
      					
      				{
      					for (JButton b :botones) 
      					{
      						b.setForeground(Color.BLACK);
      					}
      					tablero.desplazamientoArriba();
      					if (!tablero.estaLleno())tablero.elegirCasillero().agregarCasillero();
      					botones[tablero.getultimo()].setForeground(Color.green);
      					dibujar(tablero.getmatriz(),botones);
      					setScore(tablero.getScore(),scoreinfo);
      					
      					if (!tablero.exiteMovPosible())
      					{
      						gameOver(hscore,hscoreinfo,score,scoreinfo,gameover, botones, icono,mensajefinal) ;
      						saveManager.grabar_hscore(hscoreinfo);
      						frame.setFocusable(false);
      					}
      				}
      				
      				
      				if (e.getKeyCode()==39) 
      				{
      					for (JButton b :botones) 
      					{
      						b.setForeground(Color.BLACK);
      					}
      					tablero.desplazamientoDer();
      					if (!tablero.estaLleno())tablero.elegirCasillero().agregarCasillero();
      					dibujar(tablero.getmatriz(),botones);
      					botones[tablero.getultimo()].setForeground(Color.green);
      					setScore(tablero.getScore(),scoreinfo);
      					if (!tablero.exiteMovPosible())
      					{
      						gameOver(hscore,hscoreinfo,score,scoreinfo,gameover, botones, icono,mensajefinal) ;
      						saveManager.grabar_hscore(hscoreinfo);
      						frame.setFocusable(false);
      					}

      				}
      				
      				if (e.getKeyCode()==37)
      				{
      					for (JButton b :botones) 
      					{
      						b.setForeground(Color.BLACK);
      					}
      					tablero.desplazamientoIzq();
      					if (!tablero.estaLleno())tablero.elegirCasillero().agregarCasillero();
      					botones[tablero.getultimo()].setForeground(Color.green);
      					dibujar(tablero.getmatriz(),botones);
      					setScore(tablero.getScore(),scoreinfo);
      					
      					System.out.println(tablero.getScore());
      					if (!tablero.exiteMovPosible())
      					{
      						gameOver(hscore,hscoreinfo,score,scoreinfo,gameover, botones, icono,mensajefinal) ;
      						saveManager.grabar_hscore(hscoreinfo);
      						frame.setFocusable(false);
      					}
      					
      				}
      				
      				if (e.getKeyCode()==40)
      				{
      					for (JButton b :botones) 
      					{
      						b.setForeground(Color.BLACK);
      					}
      					tablero.desplazamientoAbajo();
      					if (!tablero.estaLleno())tablero.elegirCasillero().agregarCasillero();
      					botones[tablero.getultimo()].setForeground(Color.green);
      					dibujar(tablero.getmatriz(),botones);
      					setScore(tablero.getScore(),scoreinfo);

      					if (!tablero.exiteMovPosible())
      					{
      						gameOver(hscore,hscoreinfo,score,scoreinfo,gameover, botones, icono,mensajefinal) ;
      						saveManager.grabar_hscore(hscoreinfo);
      						frame.setFocusable(false);
      					}
      					
      				}
      				if (e.getKeyCode()==27)
      				{
      					if (tablero.estaLleno()) frame.dispose();
      					
      					if (!tablero.estaLleno()) 
      					{
      					int i=JOptionPane.showConfirmDialog(frame,"En realidad quiere salir. Se perderan la partida actual","Confirmar Salida",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
      					if (i==0) 
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
      					
      			}
      					
      		}
      					
      	});	
        
  
        
	}

}
