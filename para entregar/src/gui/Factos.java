package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jess.Deffacts;
import jess.JessException;
import jess.Rete;

public class Factos extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner_1, spinner_2, spinner_3, spinner;
	private JComboBox comboBox, comboBox_2, comboBox_1, comboBox_3;
	private MainMenu mainMenu; 

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Factos frame = new Factos();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Factos(MainMenu mainMenu) {
		this.mainMenu = mainMenu; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		String[] tempo = new String[2];
		tempo[0] = "Sol";
		tempo[1] = "Chuva";
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 41, 117, 20);
		comboBox.setModel(new DefaultComboBoxModel(tempo));
		contentPane.add(comboBox);
		
		JLabel lblMetereologia = new JLabel("Estado do tempo");
		lblMetereologia.setBounds(156, 0, 93, 14);
		contentPane.add(lblMetereologia);
		
		JLabel lblCondioMetereolgica = new JLabel("Condi\u00E7\u00E3o Metereol\u00F3gica");
		lblCondioMetereolgica.setBounds(10, 24, 117, 14);
		contentPane.add(lblCondioMetereolgica);
		
		comboBox_1 = new JComboBox();
		String[] intensidadeSol = new String[3];
		intensidadeSol[0] = "Alta";
		intensidadeSol[1] = "Média";
		intensidadeSol[2] = "Baixa";
		comboBox_1.setBounds(144, 41, 117, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(intensidadeSol));
		contentPane.add(comboBox_1);
		
		JLabel lblIntensidadeDoSol = new JLabel("Intensidade do Sol");
		lblIntensidadeDoSol.setBounds(156, 25, 101, 14);
		contentPane.add(lblIntensidadeDoSol);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, -255, 50, 1));
		spinner.setBounds(289, 41, 40, 20);
		contentPane.add(spinner);
		
		JLabel lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(279, 24, 79, 14);
		contentPane.add(lblTemperatura);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinner_1.setBounds(382, 41, 42, 20);
		contentPane.add(spinner_1);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(347, 44, 23, 14);
		contentPane.add(lblDia);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_2.setBounds(382, 69, 42, 20);
		contentPane.add(spinner_2);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(333, 72, 37, 14);
		contentPane.add(lblHoras);
		
		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinner_3.setBounds(382, 97, 42, 17);
		contentPane.add(spinner_3);
		
		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setBounds(322, 99, 48, 14);
		contentPane.add(lblMinutos);
		
		comboBox_2 = new JComboBox();
		String[] mes = new String[12];
		mes[0] = "Janeiro";
		mes[1] = "Fevereiro";
		mes[2] = "Março";
		mes[3] = "Abril";
		mes[4] = "Maio";
		mes[5] = "Junho";
		mes[6] = "Julho";
		mes[7] = "Agosto";
		mes[8] = "Setembro";
		mes[9] = "Outubro";
		mes[10] = "Novembro";
		mes[11] = "Dezembro";
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(144, 145, 117, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(mes));
		contentPane.add(comboBox_2);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(188, 127, 29, 14);
		contentPane.add(lblMs);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maxFevereiro((String) comboBox_2.getSelectedItem());
				try {
					runJESS();
				} catch (JessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(235, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainMenu.setVisible(true);
				mainMenu.setEnabled(true);
				
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancel);
		
	}
	
	private void maxFevereiro(String mes){
	
		if(mes == "Fevereiro"){
			if((int) spinner_1.getValue() > 28)
				spinner_1.setValue(28);
		}
		
		
	}
	
	private void runJESS() throws JessException{
		String facto= "Previsao-metereologica (condicao " + comboBox.getSelectedItem() + ") (intensidade " + comboBox_1.getSelectedItem() +  ") (temperatura " + spinner.getValue() + ") (dia " + spinner_1.getValue() + ") (hora " + spinner_2.getValue() + ") (minuto " + spinner_3.getValue()+ ")";
		//Rete motor= new Rete();
		Rete engine= mainMenu.getGuiEngine();
	
		engine.addDeffacts(new Deffacts("factostempo",facto , engine));
		engine.reset();
		engine.run();
	}
}
