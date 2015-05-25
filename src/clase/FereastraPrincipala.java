package clase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public class FereastraPrincipala extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Autor a1= new Autor("autor1", 12, "2345");
	Autor a2=new Autor("autor2",13,"1234");
	DefaultListModel listModel =new DefaultListModel();
	private JTextField textField_1;;
	ArrayList<Autor> lista=new ArrayList<>();
	public void addlista(){
		
		listModel.clear();
		listModel.addElement(a1);
		listModel.addElement(a2);
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FereastraPrincipala frame = new FereastraPrincipala();
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
	public FereastraPrincipala() {
		getContentPane().setLayout(null);
		
		lista.add(a1);
		lista.add(a2);
		final JList list = new JList();
		list.setBounds(10, 57, 384, 142);
		list.setModel(listModel);
		getContentPane().add(list);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Afiseaza autori");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addlista();
				
				
			}
		});
			
		
		
		
		btnNewButton.setBounds(396, 54, 146, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAfiseazaPublicatii = new JButton("Afiseaza Publicatii");
		btnAfiseazaPublicatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Publicatii pub=new Publicatii();
				pub.setVisible(true);
			}
		});
		btnAfiseazaPublicatii.setBounds(541, 54, 117, 23);
		getContentPane().add(btnAfiseazaPublicatii);
		
		JButton btnPublicatiiReduse = new JButton("Publicatii Reduse");
		btnPublicatiiReduse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publicatiiReduse pr = null;
				try {
					pr = new publicatiiReduse();
				} catch (CustomIOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pr.setVisible(true);
			}
		});
		btnPublicatiiReduse.setBounds(541, 89, 117, 23);
		getContentPane().add(btnPublicatiiReduse);
		
		
		
		JButton btnInregistreazaArticol = new JButton("Inregistreaza Articol");
		btnInregistreazaArticol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InregArticol art=new InregArticol();
				art.setVisible(true);
			}
		});
		btnInregistreazaArticol.setBounds(396, 88, 146, 23);
		getContentPane().add(btnInregistreazaArticol);
		
		JLabel lblCautaAutorDupa = new JLabel("Cauta autor dupa marca");
		lblCautaAutorDupa.setBounds(10, 210, 146, 14);
		getContentPane().add(lblCautaAutorDupa);
		final JLabel label = new JLabel("");
		label.setBounds(10, 262, 341, 20);
		getContentPane().add(label);
		textField_1 = new JTextField();
		textField_1.setBounds(10, 231, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int marca=0;
				try{
					 marca=Integer.parseInt(textField_1.getText());
				}catch(Exception ex) {}
				try {
					label.setText(Autor.getAutorCuoAnMarca(lista, marca).toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					label.setText(e1.toString());
				}
			}
		});
		btnCauta.setBounds(106, 230, 89, 23);
		getContentPane().add(btnCauta);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.ITALIC, 13));
		Editura ed= Editura.getInstanta();
		lblNewLabel.setText(ed.descrieEditura());
		lblNewLabel.setBounds(0, 0, 697, 37);
		getContentPane().add(lblNewLabel);
		
		
		
		
		
	}
}
