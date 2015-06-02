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

import nrc.fuzzy.jess.FuzzyRete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jess.Deffacts;
import jess.JessException;
import jess.Rete;

import java.awt.Label;

public class MenuTestFacts extends JFrame {

	private JPanel contentPane;
	private JSpinner spinnerDay, spinnerHour, spinnerMinutes, spinnerTemperature;
	private JComboBox comboBoxMeterCondi, comboBoxMonth, comboBoxSunIntensity, comboBox_3;
	private MainMenu mainMenu; 
	private String weather;
	private String intensity;
	private String temperature;
	private String hour;
	

	

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}
	public MenuTestFacts(MainMenu mainMenu) {
		resetVariables();
		
		setTitle("Menu Factos");
		this.mainMenu = mainMenu; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 300);
		getContentPane().setLayout(null);
		
		Label label = new Label("Estado Meteriol\u00F3gico");
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 10, 438, 22);
		getContentPane().add(label);
		
		JButton btnSol = new JButton("Sol");
		btnSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWeather("sol");
			}
		});
		btnSol.setBounds(10, 70, 89, 23);
		getContentPane().add(btnSol);
		
		JButton btnChuva = new JButton("Chuva");
		btnChuva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWeather("chuva");
			}
		});
		btnChuva.setBounds(10, 102, 89, 23);
		getContentPane().add(btnChuva);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setIntensity("alta");
			}
		});
		btnAlta.setBounds(122, 70, 89, 23);
		getContentPane().add(btnAlta);
		
		JButton btnBaixa = new JButton("Baixa");
		btnBaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setIntensity("baixa");
			}
		});
		btnBaixa.setBounds(122, 102, 89, 23);
		getContentPane().add(btnBaixa);
		
		Label label_1 = new Label("Tempo");
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(21, 42, 62, 22);
		getContentPane().add(label_1);
		
		Label label_2 = new Label("Intensidade Tempo");
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(105, 42, 134, 22);
		getContentPane().add(label_2);
		
		JButton btnQuente = new JButton("Quente");
		btnQuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTemperature("calor");
			}
		});
		btnQuente.setBounds(231, 70, 89, 23);
		getContentPane().add(btnQuente);
		
		JButton btnAmeno = new JButton("Ameno");
		btnAmeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTemperature("ameno");
			}
		});
		btnAmeno.setBounds(231, 102, 89, 23);
		getContentPane().add(btnAmeno);
		
		JButton btnFrio = new JButton("Frio");
		btnFrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTemperature("frio");
			}
		});
		btnFrio.setBounds(231, 135, 89, 23);
		getContentPane().add(btnFrio);
		
		Label label_3 = new Label("Temperatura");
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(231, 42, 89, 22);
		getContentPane().add(label_3);
		
		JButton btnManh = new JButton("Manh\u00E3");
		btnManh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHour("manha");
			}
		});
		btnManh.setBounds(344, 70, 89, 23);
		getContentPane().add(btnManh);
		
		JButton btnTarde = new JButton("Tarde");
		btnTarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHour("tarde");
			}
		});
		btnTarde.setBounds(344, 102, 89, 23);
		getContentPane().add(btnTarde);
		
		JButton btnNoite = new JButton("Noite");
		btnNoite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHour("noite");
			}
		});
		btnNoite.setBounds(344, 135, 89, 23);
		getContentPane().add(btnNoite);
		
		Label label_4 = new Label("Momento Dia");
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(344, 42, 94, 22);
		getContentPane().add(label_4);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainMenu.setVisible(true);
				mainMenu.setEnabled(true);
			}
		});
		btnCancel.setBounds(231, 227, 89, 23);
		getContentPane().add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					runFacts();
				} catch (JessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(344, 227, 89, 23);
		getContentPane().add(btnSubmit);
		
	}
	
	private void maxFevereiro(String mes){
	
		if(mes == "Fevereiro"){
			if((int) spinnerDay.getValue() > 28)
				spinnerDay.setValue(28);
		}	
		
	}
	
	private void convertTemperatureToFuzzy(double temp)
	{
		double hot= calcHot(temp);
		double cold = calcCold(temp);
		double smooth = calcSmooth(temp);
		if(temp <=15)
		{
			temperature="frio";
		}
		else if(temp >= 33)
		{
			temperature="calor";
		}
		else if(cold > hot && cold > smooth && temp >=15 && temp <= 20)
			temperature="frio";

		else
			if(hot > cold && hot > smooth&& temp >=25 && temp <=33)
				temperature="calor";
			else
				temperature="ameno";


	}
	private double calcCold(double value){

		return -0.2*value+4;
	}
	private double calcSmooth(double value){
		return -0.4*Math.pow(value,2) + 1.84*value - 20.16;
	}
	private double calcHot(double value){
		return 0.125*value - 3.125;
	}

	private void runFacts() throws JessException{
		String facto= "(assert (Estado-metereologia (condicao " + weather + ") (intensidade " + intensity + ") (temperatura " + temperature + ")(hora " + hour + ")))";
		//String fuzzyFacto = "(assert (temperature (new nrc.fuzzy.FuzzyValue ?*fuzzy-temperatura* \"" + temperature + "\")))";
	
		FuzzyRete engine= mainMenu.getGuiEngine();
		engine.eval(facto);
		//engine.eval(fuzzyFacto);
		engine.run();
		engine.reset();
		resetVariables();
	}
	
	private void resetVariables()
	{
		temperature="nil";
		hour="nil";
		intensity="nil";
		weather="nil";
	}
}
