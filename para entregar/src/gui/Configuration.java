package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.TextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Vector;

public class Configuration extends JFrame {

	private JPanel contentPane;
	private JPasswordField emailfieldPassword;
	private String emailPassword;
	private String emailEmail;
	private String faceToken;
	private String emailUsername;
	
	TextField textFieldUsername;
	TextField emailtextFieldEmail;
	TextField facetextFieldToken;

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}


	public String getEmailEmail() {
		return emailEmail;
	}

	public void setEmailEmail(String emailEmail) {
		this.emailEmail = emailEmail;
	}

	public String getFaceToken() {
		return faceToken;
	}

	public void setFaceToken(String faceToken) {
		this.faceToken = faceToken;
	}

	public String getEmailUsername() {
		return emailUsername;
	}

	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}

	/**
	 * Create the frame.
	 */
	public Configuration(MainMenu mainMenu) {
		startfields();
		setTitle("Configura\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Token do Facebook");
		label.setAlignment(Label.CENTER);
		label.setBounds(250, 64, 133, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Credenciais Sifeup");
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(24, 36, 133, 22);
		contentPane.add(label_1);
		
		textFieldUsername = new TextField();
		textFieldUsername.setBounds(34, 162, 123, 22);
		contentPane.add(textFieldUsername);
		
		Label label_2 = new Label(" Sifeup");
		label_2.setBounds(34, 134, 62, 22);
		contentPane.add(label_2);
		
		emailtextFieldEmail = new TextField();
		emailtextFieldEmail.setBounds(34, 92, 124, 22);
		contentPane.add(emailtextFieldEmail);
		
		Label label_3 = new Label("Email Notifica\u00E7\u00E3o");
		label_3.setBounds(35, 64, 112, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Senha");
		label_4.setBounds(34, 190, 62, 22);
		contentPane.add(label_4);
		
		emailfieldPassword = new JPasswordField();
		emailfieldPassword.setBounds(34, 218, 123, 20);
		contentPane.add(emailfieldPassword);
		
		facetextFieldToken = new TextField();
		facetextFieldToken.setBounds(260, 102, 123, 22);
		contentPane.add(facetextFieldToken);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setConfigs();
				 try {
			            File confsFile = new File("configs.txt");
			            FileOutputStream is = new FileOutputStream(confsFile);
			            OutputStreamWriter osw = new OutputStreamWriter(is);    
			            Writer w = new BufferedWriter(osw);
			            w.write(getEmailEmail());
			            w.write("\n");
			            w.write(getEmailUsername());
			            w.write("\n");
			            w.write(getEmailPassword());
			            w.write("\n");
			            w.write(getFaceToken());
			            w.close();
			        } catch (IOException e1) {
			            System.err.println("Problem writing to the file configs.txt");
			        }
					setVisible(false);
					mainMenu.setVisible(true);
					mainMenu.setEnabled(true);
			}
		});
		btnGuardar.setBounds(335, 281, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filename="configs.txt";
				Vector <String> configsFile = new Vector <String>();
				String line=null;
				try
				{

					URL path = ClassLoader.getSystemResource(filename);
					if(path==null) {
						System.err.format("Can´t find or file '%s' doesen't exist\n",filename);
						return;
					}

					File f = new File(path.toURI());
					BufferedReader reader = new BufferedReader(new FileReader(f));

					while ((line = reader.readLine()) != null)
					{

						configsFile.add(line);

					}
					reader.close();

				}
				catch (NumberFormatException e1)
				{
					System.err.format("'%s' isn't in the right format.\n", line);
					return;
				}
				catch(SecurityException e1){
					System.err.format("No permitions to access '%s'.\n", filename);
					return;
				}
				catch (Exception e1)
				{
					System.err.format("Exception occurred trying to read '%s'.\n", filename);
					e1.printStackTrace();
					return;

				}

				if (configsFile.size()!= 7)
				{
					System.err.format("File '%s' doesn't have the service configurations right.", filename);
					return;
				}
				//textFieldMC.setText(configsFile.get(0));
				//mCspinner.setValue(Integer.parseInt(configsFile.get(1)));
				//textFieldMDB.setText(configsFile.get(2));
				//mDBspinner.setValue(Integer.parseInt(configsFile.get(3)));
				//textFieldMDR.setText(configsFile.get(4));
				//mDRspinner.setValue(Integer.parseInt(configsFile.get(5)));
				//bSpacespinner.setValue(Integer.parseInt(configsFile.get(6)));
			}

			
		});
		btnCarregar.setBounds(230, 281, 89, 23);
		contentPane.add(btnCarregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainMenu.setVisible(true);
				mainMenu.setEnabled(true);
			}
		});
		btnCancelar.setBounds(120, 281, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	
	public void setConfigs(){
		emailPassword = emailfieldPassword.getText();
		emailEmail=emailtextFieldEmail.getText();
		emailUsername=textFieldUsername.getText();
		faceToken=facetextFieldToken.getText();
	
	}
	public void loadConfigs()
	{
		 emailfieldPassword.setText(emailPassword);
		emailtextFieldEmail.setText(emailEmail);
		textFieldUsername.setText(emailUsername);
		facetextFieldToken.setText(faceToken);
	}
	
	public void startfields()
	{
		emailPassword = "";
		emailEmail="";
		emailUsername="";
		faceToken="";

	}
	
}
