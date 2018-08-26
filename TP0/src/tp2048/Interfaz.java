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
import javax.swing.JTextField;

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
	
			
		}
	}
		return ret;
	}
	private void initialize()
	{
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//LinkedList <JButton> botones =new LinkedList <JButton>();
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
		frame.getContentPane().add(generarBoton(454, 441));
		frame.getContentPane().add(generarBoton(304, 441));
		frame.getContentPane().add(generarBoton(159, 441));
		frame.getContentPane().add(generarBoton(10, 441));

        Component [] comp=frame.getContentPane().getComponents();
        
        for (Component jb: comp) 
        {
        	((JButton)jb).addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				matriz(comp);
			}
				
			
				
				
			
		}));
        }	
        	 
        for (Component jc: comp) 
        {
              	((JButton)jc).addKeyListener(new KeyAdapter() {
      			public void keyReleased(KeyEvent e)
      			{
      				if (e.getKeyCode()==38)
      				matriz(comp);
      			}
      				
      			
      				
      				
      			
      		});	
        }
        
		
		
	
		
		
		
		
		
	}

}
