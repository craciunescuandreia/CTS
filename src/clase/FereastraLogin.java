package clase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FereastraLogin extends JFrame {

public boolean logare (Autor a) {
	boolean rasp=false;
	if("user".equals(a.getNume()) & "123".equals(a.getCnp())){
		
		rasp= true;
		
		
	}else{
		if(textField.getText()==null || textField_1.getText()==null)
		
		{		rasp= false;}}
			
		
	return rasp;
	}
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FereastraLogin frame = new FereastraLogin();
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
	public FereastraLogin() {
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(75, 53, 70, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(75, 128, 46, 14);
		getContentPane().add(lblParola);
		
		textField = new JTextField();
		textField.setBounds(75, 86, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 153, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Autor a = new Autor(textField.getText(), textField_1.getText());
			boolean rez=	logare(a);
			if(rez){
				FereastraPrincipala f=new FereastraPrincipala();
				f.setVisible(rez);
			}
				
				
			}
		});
		btnLogIn.setBounds(75, 202, 89, 23);
		getContentPane().add(btnLogIn);
		
		
		
		
		
	}
}
