package tp2048;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import Animacion.Animacion;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjAnim {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjAnim window = new EjAnim();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjAnim() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		JLabel icono = new JLabel("");
		icono.setBounds(204, 0, 30, 15);
		
		frame.getContentPane().add(icono);
		
		icono.setBackground(Color.WHITE);
		icono.setIcon(new ImageIcon("bajar.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, -100, 442, 96);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.setBounds(73, 39, 111, 23);
		panel.add(btnNuevoJuego);
		
		JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(254, 39, 111, 23);
		panel.add(button);
		
		
		
		
		icono.addMouseListener(new MouseAdapter() 
			{
		
		public void mouseReleased(MouseEvent e)
		{
			int posicion=icono.getY();
			if (posicion>0)
			{
				Animacion.subir(80, 0, 2, icono);
			Animacion.subir(0, -100, 2, panel);
			
			im_down();
			}else
			{
				Animacion.bajar(-100, 0, 2, panel);
				Animacion.bajar(0,80,  2, icono);
				im_up();
			}
		
			
		}
			public void im_up()
			{
		icono.setIcon(new ImageIcon("subir.png"));
			}
			
			public void im_down()
			{
		icono.setIcon(new ImageIcon("bajar.png"));
			}
			});
		
	
		
	
	}
}
