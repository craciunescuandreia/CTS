package clase;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;

public class publicatiiReduse extends JFrame {

	private JPanel contentPane;
DefaultListModel listModel =new DefaultListModel();;
	
	public void addlista() throws CustomIOException{
		
		ArrayList<Publicatie> lista=this.publicatiiReduse();
		listModel.clear();
		for(Publicatie m : lista)
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
					publicatiiReduse frame = new publicatiiReduse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws CustomIOException 
	 */
	public publicatiiReduse() throws CustomIOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		this.addlista();
		list.setModel(listModel);
		
		list.setBounds(54, 66, 370, 122);
		contentPane.add(list);
		
		JLabel lblUrmatoarelePublicatiiSe = new JLabel("Urmatoarele publicatii se afla la reducere:");
		lblUrmatoarelePublicatiiSe.setBounds(54, 11, 242, 30);
		contentPane.add(lblUrmatoarelePublicatiiSe);
	}
	public ArrayList<Publicatie> publicatiiReduse() throws CustomIOException{
		ArrayList<Publicatie> reduse=new ArrayList<>();
		boolean redus=false;
		ArrayList<Manual> total=Publicatii.afiseazaManuale();
		for(Manual m : total){
			redus=m.verificaPretRedus();
			if(redus==true)
				reduse.add(m);
			
		}
		return reduse;
	}
}
