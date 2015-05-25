package clase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Publicatii extends JFrame {

	private JPanel contentPane;
DefaultListModel listModel =new DefaultListModel();
private JTextField textField;
private JTextField textField_1;;
	
	public void addlista() throws CustomIOException{
		Autor a1= new Autor("autor1", 12, "2345");
		Autor a2=new Autor("autor2",13,"1234");
		ArrayList<Manual> lista=this.afiseazaManuale();
		listModel.clear();
		for(Manual m : lista)
		listModel.addElement(m);
		//listModel.addElement(a2);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Publicatii frame = new Publicatii();
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
	public Publicatii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JRadioButton rdbtnManuale = new JRadioButton("Manuale");
		
		final JRadioButton rdbtnArticole = new JRadioButton("Articole");
		rdbtnArticole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnManuale.setSelected(false);
			}
		});
		rdbtnArticole.setBounds(0, 17, 109, 23);
		contentPane.add(rdbtnArticole);
		
	
		rdbtnManuale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnArticole.setSelected(false);
			}
		});
		rdbtnManuale.setBounds(130, 17, 109, 23);
		contentPane.add(rdbtnManuale);
		final JLabel label = new JLabel("");
		label.setBounds(265, 51, 159, 23);
		contentPane.add(label);
		
		
		
		JButton btnAfiseaza = new JButton("Afiseaza");
		btnAfiseaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rdbtnManuale.isSelected()){
					addlista();
					label.setText("");
					}
					else if(rdbtnArticole.isSelected()){addlista();label.setText("");}
					else label.setText("nu a fost selecatata nicio varianta");
				} catch (CustomIOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfiseaza.setBounds(255, 17, 89, 23);
		contentPane.add(btnAfiseaza);
		
		JList list = new JList();
		list.setModel(listModel);
		list.setBounds(10, 74, 542, 96);
		contentPane.add(list);
		
		JLabel lblCautaManualDupa = new JLabel("Cauta manual dupa isbn");
		lblCautaManualDupa.setBounds(20, 181, 141, 14);
		contentPane.add(lblCautaManualDupa);
		
		textField = new JTextField();
		textField.setBounds(23, 206, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(510, 17, 42, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblVeziNumarDe = new JLabel("Vezi numar de autori:");
		lblVeziNumarDe.setBounds(255, 181, 124, 14);
		contentPane.add(lblVeziNumarDe);
		
		JLabel lblIsbnCarte = new JLabel("Isbn carte:");
		lblIsbnCarte.setBounds(228, 209, 92, 14);
		contentPane.add(lblIsbnCarte);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 206, 119, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JLabel label_1 = new JLabel("");
		label_1.setBounds(497, 209, 46, 14);
		contentPane.add(label_1);
		

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 237, 498, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titlu=textField.getText();
				try {
					Manual m=Publicatie.cautaPubDupaTitlu(afiseazaManuale(),titlu );
					lblNewLabel.setText(m.genereazaReferinta());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					lblNewLabel.setText(e1.toString());
				}
				
			}
		});
		btnCauta.setBounds(138, 205, 89, 23);
		contentPane.add(btnCauta);
		
		
		
		JButton btnNewButton = new JButton("Vezi profit editura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Articol art=new Articol();
				Editura ed=new Editura();
				ArrayList<Publicatie> lista=new ArrayList<>();
				try {
					lista.addAll(afiseazaManuale());
					lista.addAll(afiseazaManuale());
					lblNewLabel_1.setText(String.valueOf(ed.calculeazaVenitTotal(lista)));
					if(ed.calculeazaVenitTotal(lista)==0.0) lblNewLabel_1.setText("Valori setate incorect");
				} catch (CustomIOException e1) {
					// TODO Auto-generated catch block
				lblNewLabel_1.setText(e1.toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					lblNewLabel_1.setText(e1.toString());
				}
			}
		});
		btnNewButton.setBounds(364, 17, 141, 23);
		contentPane.add(btnNewButton);
		
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(169, 273, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JButton btnVeziNrPublicatii = new JButton("Vezi nr publicatii");
		btnVeziNrPublicatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int nr=Manual.redaNumaruldeManuale();
					lblNewLabel_2.setText(String.valueOf(nr));
				} catch (CustomIOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnVeziNrPublicatii.setBounds(10, 273, 151, 23);
		contentPane.add(btnVeziNrPublicatii);
		
		JButton btnNewButton_1 = new JButton("Vezi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int nr=Manual.redaNumarulDeautoriaiuneiCarti(textField_1.getText());
					label_1.setText(String.valueOf(nr));
				} catch (CustomIOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(398, 205, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
		
		
		
		
	}
	public static ArrayList<Manual> afiseazaManuale() throws CustomIOException{
		Publicatie manual=new Manual();
		ArrayList<Manual> list=new ArrayList<>();
		Autor autor1 = new Autor("Nume1", 101);
		Autor autor2 = new Autor(autor1);
		autor2.setNume("Nume2");
		Autor autor3 = new Autor("Nume3", 103);

		
		ArrayList<Autor> autori = new ArrayList<>();
		autori.add(autor1);
		autori.add(autor2);
		autori.add(autor3);
		Manual manual1 = new Manual("321654987654", "categorie1", autori, "titlu1", 20);
		manual1.setExemplareVandute(2);
		Manual manual2 = new Manual("355654987654", "categorie2", autori, "titlu2", 80);
		manual2.setExemplareVandute(2);
        list.add(manual1);
        list.add(manual2);
		Manual.saveManualToFile(list);
		ArrayList<Manual> lista=(ArrayList<Manual>) Manual.getManualFromFile();
		return lista;
		
	}
}
