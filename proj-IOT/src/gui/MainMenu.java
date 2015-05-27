package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;*/
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("INTERNET OF THINGS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDefinicoes = new JButton("Defini\u00E7\u00F5es");
		btnDefinicoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				//Definicoes definicoes = new Definicoes(MainMenu.this);
				//definicoes.setVisible(true);
				
			}
		});
		btnDefinicoes.setBounds(27, 68, 148, 95);
		contentPane.add(btnDefinicoes);
		
		JButton buttonFactos = new JButton("Factos");
		buttonFactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Factos factos= new Factos(MainMenu.this);
				factos.setVisible(true);
			}
		});
		buttonFactos.setBounds(260, 68, 148, 95);
		contentPane.add(buttonFactos);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(335, 227, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnCrditos = new JButton("Cr\u00E9ditos");
		btnCrditos.setBounds(10, 227, 89, 23);
		contentPane.add(btnCrditos);
	}
}
