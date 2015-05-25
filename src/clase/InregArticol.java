package clase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InregArticol extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InregArticol frame = new InregArticol();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public InregArticol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(37, 27, 46, 14);
		contentPane.add(lblNume);
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(37, 68, 46, 14);
		contentPane.add(lblPret);
		
		JLabel lblNumarExemplare = new JLabel("Numar exemplare");
		lblNumarExemplare.setBounds(37, 114, 46, 14);
		contentPane.add(lblNumarExemplare);
		
		textField = new JTextField();
		textField.setBounds(139, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 65, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 111, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(80, 231, 244, 20);
		contentPane.add(lblNewLabel);
		
		final JLabel label = new JLabel("");
		label.setBounds(70, 207, 254, 25);
		contentPane.add(label);
		
		JButton btnInregistreaza = new JButton("Inregistreaza");
		btnInregistreaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				Articol a=new Articol();
				int nr=0;
				try {
				nr=	Integer.parseInt(textField_3.getText());
				} catch (Exception e1) {
						
				}
				try{
					a.setNumarExemplare(nr);
				} catch (Exception e1) {
					label.setText("");
					label.setText(e1.toString());
				}
				int pret=0;
				try{
				pret= Integer.parseInt(textField_1.getText());
				}catch(Exception exv){};
				a.setTitlu(textField.getText());
				try {
					a.stabilestePret(pret);
				} catch (ExceptiePretNegativ | ExceptiePretPesteLimita e1) {
					lblNewLabel.setText("");
					lblNewLabel.setText(e1.toString());
				}
				if(a.getPret() !=0 & a.getNumarExemplare() !=0 & a.getTitlu()!=null){
					label.setText("");
					lblNewLabel.setText("");
					lblNewLabel.setText(a.afiseazaArticol());}
				
				
			}
		});
		btnInregistreaza.setBounds(136, 190, 116, 20);
		contentPane.add(btnInregistreaza);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InregArticol art=new InregArticol();
				art.setVisible(false);
			}
		});
		btnInapoi.setBounds(335, 228, 89, 23);
		contentPane.add(btnInapoi);
		
		
		
	}

}
