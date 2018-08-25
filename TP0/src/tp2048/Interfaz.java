package tp2048;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Interfaz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		int [][] matriz=new int [4][4];
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton b00 = new JButton("");
		b00.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		b00.setBounds(10, 11, 120, 120);
		frame.getContentPane().add(b00);
		
		JButton b01 = new JButton("3");
		b01.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b01.setBounds(159, 11, 120, 120);
		frame.getContentPane().add(b01);
		
		JButton b02 = new JButton("");
		b02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b02.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b02.setBounds(304, 11, 120, 120);
		frame.getContentPane().add(b02);
		
		JButton b03 = new JButton("");
		b03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b03.setFont(new Font("Tahoma", Font.PLAIN, 65));
		b03.setBounds(454, 11, 120, 120);
		frame.getContentPane().add(b03);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_3.setBounds(10, 156, 120, 120);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_4.setBounds(159, 156, 120, 120);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(304, 156, 120, 120);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_6.setBounds(454, 156, 120, 120);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_7.setBounds(10, 300, 120, 120);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_8.setBounds(159, 300, 120, 120);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_9.setBounds(304, 300, 120, 120);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_10.setBounds(454, 300, 120, 120);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_11.setBounds(454, 441, 120, 120);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_12.setBounds(304, 441, 120, 120);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_13.setBounds(159, 441, 120, 120);
		frame.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 65));
		button_14.setBounds(10, 441, 120, 120);
		frame.getContentPane().add(button_14);
		
		
	}
}
