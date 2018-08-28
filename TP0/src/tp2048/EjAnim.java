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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 442, 96);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(95, 156, 243, 15);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(206, 95, 30, 15);
			frame.getContentPane().add(lblNewLabel);
			lblNewLabel.setLabelFor(panel);
			panel.setBorder(lblNewLabel.getBorder());
			lblNewLabel.addMouseListener(new MouseAdapter() 
			{
				boolean continuar=true;
				public void mouseReleased(MouseEvent e)
				{
					Animacion.bajar(-110, 0, 5, panel);
				}
				
			
				
				
			});
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\usuario\\Downloads\\drop-down-colores\\limon\\bajar.png"));
	}
}
