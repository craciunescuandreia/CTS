package clase;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	
	
	
	 
	public static void main(String[] args) {
	
	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FereastraLogin().setVisible(true);
            }
        });
	}
        /*
		// Se construieste o clasa de test pentru instantierea de obiecte din clasa Autor.
				Autor autor1 = new Autor("Nume1", 101);
				Autor autor2 = new Autor(autor1);
				autor2.setNume("Nume2");
				Autor autor3 = new Autor("Nume3", 103);

				// In clasa de test se instanteaza obiecte din toate clasele anterioare. Obiectele create se salveaza in aplicatie intr-o colectie standard (la
				// alegere).
				List<Autor> autori = new ArrayList<Autor>();
				autori.add(autor1);
				autori.add(autor2);
				autori.add(autor3);
				Manual manual1 = new Manual("321654987654", "categorie1", autori, "titlu1", 199.98);

				// Clasa de test este utilizata si pentru a adauga referinte Autor la vectorul/colectia autori asociat/a unui Manual.
				List<Autor> autoriFromManual1 = manual1.getAutori();
				autoriFromManual1.add(new Autor("Nume4", 104));

				// Aplicatia permite salvarea/restaurarea datelor referitoare la manuale intr-un/dintr-un fisier de tip text, in care valorile atributelor sunt scrise
				// pe linie.
				List<Manual> manualListOut = new ArrayList<Manual>();
				manualListOut.add(manual1);
				// mi-e lene sa mai facu un manual :)
				manualListOut.add(manual1);

				try {
					Manual.saveManualToFile(manualListOut);
				} catch (CustomIOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

				List<Manual> manualListIn = null;
				try {
					manualListIn = Manual.getManualFromFile();
				} catch (CustomIOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

				for (Manual manual : manualListIn) {
					System.out.println(manual.genereazaReferinta());
				}

Editura ed=Editura.getInstanta();
ed.descrieEditura();
	}
	*/

}
