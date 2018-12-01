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
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Animacion.Animacion;

public class Interfaz {

	private JFrame frame;
	private JFrame inicio;
	private static Tablero tablero=new Tablero();

	private static Image cero=new ImageIcon("0.png").getImage();
	private static Image up_in=new ImageIcon("subir_in.png").getImage();
	private static Image down_in=new ImageIcon("bajar_in.png").getImage();
	private static Image up=new ImageIcon("subir.png").getImage();
	private Image down=new ImageIcon("bajar.png").getImage();
	private Image close=new ImageIcon("close-icon.png").getImage();
	private Image close_in=new ImageIcon("close-icon-in.png").getImage();
	boolean abajo=false;
	
	private static Image[] imagenes= 
			{
			new ImageIcon("2.png").getImage(),
			new ImageIcon("4.png").getImage(),
			new ImageIcon("8.png").getImage(),
			new ImageIcon("16.png").getImage(),
			new ImageIcon("32.png").getImage(),
			new ImageIcon("64.png").getImage(),
			new ImageIcon("128.png").getImage(),
			new ImageIcon("256.png").getImage(),
			new ImageIcon("512.png").getImage(),
			new ImageIcon("1024.png").getImage(),
			new ImageIcon("2048.png").getImage(),
			
			
			};
			//new ImageIcon("64.png").getImage(),
			
			
			
	
	
	private static Color [] paletaColores= {
			new Color(252, 243, 207),
			new Color(247, 220, 111), 
			new Color(241, 196, 15  ),
			new Color(248, 196, 113),
			new Color (243, 156, 18),
			new Color(230, 126, 34),
			new Color(211, 84, 0 ), 
			new Color (231, 76, 60 ), 
			new Color (176, 58, 46),
			new Color (169, 50, 38  ),
			new Color (200, 35, 15)};
	private static Color border=new Color(31, 97, 141);
	private static int [] fontSize= {0,65,65,50,35,30,25};
	boolean perdiste=false;

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
	

	public static void colorear(JLabel [] comp) 
	{
		 for (JLabel j: comp) 
		    {
				JLabel boton=(JLabel)j;
				 String nombre=boton.getText();
				 Integer num=Integer.parseInt(nombre);
				 
				 
				 if (num==0) 
					 j.setIcon((new ImageIcon( cero.getScaledInstance(120, 120, Image.SCALE_SMOOTH))));
				 
				 else 
				 {
				 int pos=(int) (Math.log10(num)/Math.log10(2))-1;
				
				 boton.setIcon((new ImageIcon( imagenes[pos].getScaledInstance(120, 120, Image.SCALE_SMOOTH))));
				 j.setBackground(paletaColores[pos]); 
				 }			
		    }
	}

	public void jugar(JLabel[] botones,JLabel scoreinfo,JLabel hscoreinfo,JLabel mensajefinal)
	{
		if (!tablero.estaLleno()) tablero.elegirCasillero().agregarCasillero();
		
			botones[tablero.getultimo()].setForeground(new Color (156, 8, 216));
			dibujar(tablero.getmatriz(),botones);
			setScore(tablero.getScore(),scoreinfo);
			corregirLabel(scoreinfo);
			if (tablero.gano() ) mensajefinal.setText("Ganaste");
	}
	public static JLabel generarBoton(int x,int y) 
	{
		JLabel b01 = new JLabel("");
		b01.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b01.setFocusable(false);
		b01.setBounds(x, y, 120, 120);
		b01.setBackground(Color.LIGHT_GRAY);
		return b01;
		
	}
	
	public void blackfont(JLabel [] botones)
	{
		for (JLabel b :botones) 
			{
				b.setForeground(Color.DARK_GRAY);
			}
	}
	public void gameOver(JLabel hscore,JLabel hscoreinfo, JLabel score, JLabel scoreinfo, JPanel gameover,JLabel [] botones,JLabel icono,JLabel mensajefinal) 
	{
		String scoreText=scoreinfo.getText();
		String hscoreText=hscoreinfo.getText();
		
		Integer scoreInt=Integer.parseInt(scoreText);
		Integer hscoreInt=Integer.parseInt(hscoreText);
		
		if (scoreInt>hscoreInt)
		{
			hscore.setForeground(Color.BLUE);
			hscoreinfo.setText(scoreInt.toString());
			try {
				tablero.grabar_hscore(scoreinfo);
			} catch (Exception e) 
			{
				
				JOptionPane.showConfirmDialog(frame,"Acceso denegado: No se puede grabar el nuevo Highscore. Inicie como administrador",
						"Error: Administrator rights required",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
			}
			
		}
		corregirLabel(hscoreinfo);
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
				
				
				
				score.setText("Score final");
			}	
			
			
			}
			
			frame.setFocusable(false);
	}
	
	//Utilizada como recurso grafico para cambiar imagen de un drop menu
	public void im_up(JLabel icono)
	{
	
icono.setIcon(new ImageIcon(up.getScaledInstance(35, 20,Image.SCALE_SMOOTH)));
	}
	
	//Utilizada como recurso grafico para cambiar imagen de un drop menu
	public void im_down(JLabel icono)
	{
		
		icono.setIcon(new ImageIcon(down.getScaledInstance(35, 20,Image.SCALE_SMOOTH)));
	}

	//Metodo que vacia la matriz en los botones
public static void  dibujar(int[][] matriz , JLabel [] botones)
	
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
	
		}
	
	}
		//corregir(botones);
		colorear(botones);
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

public static void desactivar(JLabel [] comp) 
{
    
		for (JLabel j: comp) 
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

		  if (num==0) 
		 
			 boton.setFont(new Font("Tahoma", Font.PLAIN, 0));
		  else 
		  {
			  int pos=nombre.length();
			   boton.setFont(new Font("Tahoma", Font.PLAIN, fontSize[pos]));
		  }
			 
		  }

}


//utilizada para corregir el tamaño de la letra en el label cuando este cambia
	public static void corregirLabel(JLabel label)
	{

    	
		 String nombre=label.getText();
		 Integer num=Integer.parseInt(nombre);
		 
		 if (num>=1000) 
			label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 
		 if (num>=10000)
			 label.setFont(new Font("Tahoma",Font.PLAIN,14));
		 
		
	}
	
//Genera la matriz de botones que se dibujara
public static JLabel[] generarBotones() 
{
	JLabel[] ret = new JLabel[16];;
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
		//Declaracion del frame de inicio
		inicio = new JFrame("Juego 2048: Menu de seleccion");
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
		inicio.add(imagen);
		
		
		// Declaracion de los botones del frame de inicio
		
		//Boton que dara inicio al juego
		JButton start = new JButton("Iniciar Juego");
		start.setFont(new Font("Tahoma", Font.PLAIN, 30));
		start.setBounds(144, 310, 313, 60);
		inicio.getContentPane().add(start);
		
		//Boton que dara las estadisiticas historicas del juego
		JButton stats = new JButton("Ver estadisitcas");
		stats.setFont(new Font("Tahoma", Font.PLAIN, 30));
		stats.setBounds(144, 390, 313, 60);
		inicio.getContentPane().add(stats);
		
		//Boton que se utilizara para cargar la partida
		JButton cargar = new JButton("Cargar");
		cargar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cargar.setBounds(144, 470, 313, 60);
		inicio.getContentPane().add(cargar);
		
		//Boton que se utiliza para salir del juego
		JButton salir=new JButton("Salir");
		salir.setFont(new Font("Tahoma", Font.PLAIN, 30));
		salir .setBounds(200, 590, 200, 60);
		inicio.getContentPane().add(salir);


		
		//Declaracion del Frame principal
		frame = new JFrame("Juego 2048");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		frame.setEnabled(false);
		frame.setVisible(false);
		
		JDialog dialog=new JDialog(frame);
		Rectangle bou=frame.getBounds();
		dialog.setBounds((int) (bou.x+bou.getWidth()),bou.y+bou.height/2,500,250);
		dialog.setVisible(false);
		dialog.setModal(true);
		dialog.setUndecorated(true);
		
		dialog.setLayout(null);
		JLabel clos=new JLabel("Cerrar");
		
		
		clos.setBounds(475, 0, 25, 25);
		clos.setIcon(new ImageIcon(close.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		clos.setToolTipText("Cerrar");
		
		dialog.add(clos);
		
		clos.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
			dialog.dispose();
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				clos.setIcon(new ImageIcon(close_in.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
			}
			
			public void mouseExited(MouseEvent e ) 
			{
				clos.setIcon(new ImageIcon(close.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
			}
			
		});
		
		//Label que se mostrara al finalizarse el juego
		JLabel j=new JLabel("Clickee sobre el panel para salir");
		j.setBounds(210,300,600,300);
		j.setVisible(false);
		frame.getContentPane().add(j);
		
		
		//Definicion de los componentes del panel de drop menu
		
		//Icono que consiste en una flecha que contendra la accion para desplegar el drop menu
		JLabel icono = new JLabel("");
		icono.setBounds(280, 1, 35, 20);
		icono.setBackground(Color.WHITE);
		Image imo=new ImageIcon("bajar.png").getImage();
		icono.setIcon(new ImageIcon(imo.getScaledInstance(35, 20,Image.SCALE_SMOOTH)));
		icono.setToolTipText("Desplegar drop menu");
		frame.getContentPane().add(icono);
		
		
		//Panel que contendra los botones
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, -100, 570, 96);
		panel.setLayout(null);
		panel.setBorder(new RoundedBorder(30,border));
		frame.getContentPane().add(panel);
		
		//Label que se mostrara cuando la partida sea guardada
		JLabel guardada=new JLabel();
		guardada.setText("Partida guardada");
		guardada.setBounds(430,-100,160,30);
		guardada.setBackground(Color.white);
		guardada.setBorder(new RoundedBorder(30,border));
		frame.add(guardada);
		
		//Label que se mostrara cuando la patida sea cargada
		JLabel cargada=new JLabel();
		cargada.setText("Partida cargada");
		cargada.setVisible(false);
		cargada.setBounds(30,20,160,30);
		cargada.setBackground(Color.white);
		cargada.setBorder(new RoundedBorder(30,border));
		frame.add(cargada);
		
		//Boton que inicia un nuevo juego
		JButton newG = new JButton("Nuevo Juego");
		newG.setBounds(100, 39, 111, 23);
	    newG.setBorder(new RoundedBorder(10,border));
		panel.add(newG);
		
		//Boton que guarda el juego
		JButton guardar = new JButton("Guardar");
		guardar.setBorder(new RoundedBorder(10,border));
		guardar.setBounds(360, 39, 111, 23);
		panel.add(guardar);
	    
		
    	//Definicion de los componentes del panel de fin del juego
		
		
		//Labels que mostraran el highscore y su contenido
		JLabel hscore=new JLabel ("HighScore");
		hscore.setBounds(27,1,100,15);
		JLabel hscoreinfo=new JLabel(tablero.hscore());
		corregirLabel (hscoreinfo);
		hscoreinfo.setBackground(Color.WHITE);
		hscoreinfo.setBorder(new RoundedBorder(30,border));
		hscoreinfo.setFont(new Font("Tahoma", Font.PLAIN, 20));;
		corregirLabel(hscoreinfo);
		hscoreinfo.setBounds(5,14 , 100, 40);
		frame.getContentPane().add(hscore);
		frame.getContentPane().add(hscoreinfo);
	
		//Labels que mostrara el score y su contenido
		JLabel score=new JLabel ("Score");
		score.setBounds(522,1,100,10);
		JLabel scoreinfo=new JLabel("0");
		scoreinfo.setBackground(Color.WHITE);
		scoreinfo.setBorder(new RoundedBorder(30,border));
		scoreinfo.setFont(new Font("Tahoma", Font.PLAIN, 20));;
		scoreinfo.setBounds(490,14 , 100, 40);
		frame.getContentPane().add(score);
		frame.getContentPane().add(scoreinfo);
		
		//Panel que se mostrara al final del juego con la informacion de fin del juego
		JPanel gameover=  new JPanel();
		gameover.setVisible(true);
		gameover.setBounds(20,800,560,334);
		gameover.setBorder(new RoundedBorder(30,border));
		gameover.setBackground(Color.WHITE);
		gameover.setLayout(null);
		
		//JLabel que mostrara el mensaje correspondiente (gano o perdio)
		JLabel mensajefinal= new JLabel("Perdiste");
		mensajefinal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mensajefinal.setBounds(220,800,120,30);
		gameover.add(mensajefinal);
		frame.getContentPane().add(gameover);
		
		//Cambio el borde de los botones principales
		cargar.setBorder(new RoundedBorder(30,border));
		start.setBorder(new RoundedBorder(30,border));
		salir.setBorder(new RoundedBorder(30,border));
		stats.setBorder(new RoundedBorder(30,border));
	
	
	// Por ultimo genero los botones y los agrego al frame
	JLabel[] botones=generarBotones();
	
	for (int i=0;i<16;i++) 
	{
		frame.getContentPane().add(botones[i]);
	}
	
	//A partir de aca se definen las acciones de los componentes
	//Acciones del logo
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
	
	//Aqui cierro el frame de inicio y abro el frame de juego
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			int t=0;
			try
			{
				tablero.getSaves().testAdminrigths();
			} catch (IOException e1)
			{
				 t=JOptionPane.showConfirmDialog(inicio,"No se tiene permisos de administrador: Esto puede conllevar errores durante la ejecucion \n ¿Desea continuar de todos modos?",
						"Error: Admin Rights required.",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
			
			
			if (t==0) 
			{
			tablero.nuevoJuego();
			setScore(tablero.getScore(),scoreinfo);
			dibujar(tablero.getmatriz(),botones);
			frame.setBounds(inicio.getBounds());
			frame.setEnabled(true);
			frame.setVisible(true);
			inicio.dispose();
			}

            if (t==1) 
			{
				inicio.dispose();
			}
			
			
		}
	});
	//Acciones del boton salir
	salir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			inicio.dispose();
		}
		
	});
	
	//Defino las acciones del Boton de cargar juego de la pantalla incicial
		cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
				int seleccion=-1;
				if (!tablero.getSaves().rutinacarga()) 
				{
					seleccion=JOptionPane.showConfirmDialog(inicio,"No existe una partida guardada. \n ¿Desea iniciar una nueva partida? ",
							"Error",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
				}
				
				else 
				{
					tablero.cargarJuego();
					setScore(tablero.getScore(),scoreinfo);
					
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
					 tablero.nuevoJuego();
					dibujar(tablero.getmatriz(),botones);
					frame.setBounds(inicio.getBounds());
					frame.setEnabled(true);
					frame.setVisible(true);
					inicio.dispose();
				
			
				
				}

			}
			
		});	

		stats.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showConfirmDialog(inicio, "Lo siento, la funcion requerida aun no fue desarrollada. ","Function: not implemented yet",JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
		});
	//Defino las acciones del boton de nuevo juego del drop menu
	newG.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			int ret=JOptionPane.showConfirmDialog(guardar, "¿Deseas Comenzar un nuevo juego?","Confirmar Nuevo Juego",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (ret==0) 
			{
				tablero.nuevoJuego();
				dibujar(tablero.getmatriz(),botones);
				setScore(tablero.getScore(),scoreinfo);

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
			
			int ex=-1;
			if (ret==0)
			{
				try {
					tablero.guardarJuego(botones,scoreinfo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(frame,"Acceso denegado, se necesitan derechos de administrador ",
							"Error: Administrator rights required ",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
					ex=0;
				}
				if (ex!=0)
				{
					Animacion.mover_izquierda(1000, 490, 10, 2, scoreinfo);
				Animacion.mover_izquierda(1000, 520, 10, 2, score);
				Animacion.subir(20, -100, 35,1, guardada);
				}
				
			}
			
			activar(botones);
			Animacion.subir(80, 0, 0,1, icono);
			Animacion.subir(0, -100, 0,1, panel);
			im_down(icono);
			
		   frame.requestFocus();
		    
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
		
		Animacion.subir(77, 0, 2,1, icono);
		Animacion.subir(0, -100, 2,1, panel);
		activar(botones);
		icono.setToolTipText("Desplegar drop menu");
		abajo=false;

		im_down(icono);
	}else
	{
		
		Animacion.bajar(-100, 0, 2,1, panel);
		Animacion.bajar(0,77,  2,1, icono);
		im_up(icono);
		icono.setToolTipText("Retraer drop menu");
		desactivar(botones);
		abajo=true;
	}

}
		
		public void mouseEntered(MouseEvent e) 
		{
			if (abajo)
			icono.setIcon(new ImageIcon(up_in.getScaledInstance(35, 20, Image.SCALE_SMOOTH)));
			else 
				icono.setIcon(new ImageIcon(down_in.getScaledInstance(35, 20, Image.SCALE_SMOOTH)));
				
		}
		
		public void mouseExited(MouseEvent e) 
		{
			if (abajo)
			icono.setIcon(new ImageIcon(up.getScaledInstance(35, 20, Image.SCALE_SMOOTH)));
			else 
				icono.setIcon(new ImageIcon(down.getScaledInstance(35, 20, Image.SCALE_SMOOTH)));
				
		}
		
	});
	
	//Defino un mouse listener para mostrar un  mensaje al posicionar el puntero sobre el label
	gameover.addMouseListener(new MouseAdapter() 
	{

		
		public void mouseEntered(MouseEvent e)
		{
			j.setVisible(true);
		}
		
		public void mouseExited(MouseEvent e)
		{
			j.setVisible(false);
		}
		public void mouseReleased(MouseEvent e)
		{

			frame.dispose();
		}

	});

       //Por ultimo Agrego un KeyListener al frame para controlar la entrada de teclado
	
        frame.addKeyListener(new KeyAdapter() {
      			public void keyReleased(KeyEvent e)
      			{
      				
      				 
      				if (e.getKeyCode()==38)
      					
      				{
      					blackfont(botones);
      					tablero.desplazamientoArriba();
      					jugar(botones,scoreinfo, hscoreinfo, mensajefinal);
      				}
      				
      				
      				if (e.getKeyCode()==39) 
      				{
      					blackfont(botones);
      					tablero.desplazamientoDer();
      					
      					jugar(botones,scoreinfo, hscoreinfo, mensajefinal);
      				

      				}
      				
      				if (e.getKeyCode()==37)
      				{
      					blackfont(botones);
      					tablero.desplazamientoIzq();
      					jugar(botones,scoreinfo, hscoreinfo, mensajefinal);
      					
      				
      				}
      				
      				if (e.getKeyCode()==40)
      				{
      					blackfont(botones);
      					tablero.desplazamientoAbajo();
      					jugar(botones,scoreinfo, hscoreinfo, mensajefinal);

      		
      				}
      				if (e.getKeyCode()==27)
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
      			        	JLabel boton=(JLabel)j;
      			        	(boton).setText("");
      			        }
      				}	
      					} 
      				
      				if ((!tablero.exiteMovPosible() && tablero.estaLleno()) || tablero.gano())
  					{
  						gameOver(hscore,hscoreinfo,score,scoreinfo,gameover, botones, icono,mensajefinal) ;
  						dialog.setVisible(true);
  						
  					}
      			}
      	});	
        
        
        
  
        
	}

}
