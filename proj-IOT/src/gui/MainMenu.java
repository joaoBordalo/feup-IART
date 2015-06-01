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

import nrc.fuzzy.jess.FuzzyRete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jess.Rete;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private FuzzyRete guiEngine;
	private Configuration configuration;

	/**
	 * Launch the application.
	 */

	public Configuration getConfiguration() {
		return configuration;
	}



	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}



	/**
	 * Create the frame.
	 */
	public MainMenu(FuzzyRete engine) {
		this.guiEngine= engine;
		configuration= new Configuration(MainMenu.this);
		configuration.startfields();
		setTitle("INTERNET OF THINGS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfigurations = new JButton("Configura\u00E7\u00F5es");
		btnConfigurations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				configuration = new Configuration(MainMenu.this);
				configuration.setVisible(true);
				
			}
		});
		btnConfigurations.setBounds(27, 68, 148, 95);
		contentPane.add(btnConfigurations);
		
		JButton buttonFactos = new JButton("Factos");
		buttonFactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuTestFacts factos= new MenuTestFacts(MainMenu.this);
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
		/*
		JButton btnRuleDefinition = new JButton("Defini\u00E7\u00E3o de Regras");
		btnRuleDefinition.setBounds(141, 174, 148, 34);
		contentPane.add(btnRuleDefinition);*/
	}

	

	public FuzzyRete getGuiEngine() {
		return guiEngine;
	}

	public void setGuiEngine(FuzzyRete guiEngine) {
		this.guiEngine = guiEngine;
	}
}
