package clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manual extends Publicatie {

	// atributul ISBN (sir de caractere constant)
		private final String isbn;
		// o categorie (sir de caractere)
		private String categorie;
		int numarExemplare;
		// vector/colectie de referinte Autor, autori, in care se salveaza autorii manualului.
		private List<Autor> autori;
		
		

		public static final String OUTPUT_FILE = "fisier_manuale.txt";

		public int getNumarExemplare() {
			return numarExemplare;
		}

		public void setNumarExemplare(int numarExemplare) {
			this.numarExemplare = numarExemplare;
		}

		// Pentru aceasta clasa se defineste constructor cu parametri.
		public Manual(String isbn, String categorie, List<Autor> autori, String titlu, double pret) {
			super();
			this.isbn = isbn;
			this.categorie = categorie;
			this.autori = autori;
			// astia sunt dint Publicatie si trebuiesc instantiati
			setTitlu(titlu);
			setPret(pret);
		}

		public Manual() {
			isbn=null;
		}
		
		
		public Manual(String isbn) {
			super();
			this.isbn = isbn;
		}

		public Manual(Manual m){
			this.titlu=m.getTitlu();
			this.isbn=m.getIsbn();
			this.numarExemplare=m.numarExemplare;
			this.categorie=m.categorie;
			this.autori=m.autori;
		}

		public Manual(String titlu, int pret) {
			this.titlu=titlu;
			this.pret=pret;
			this.isbn="122";
		
		}

		// Metoda mostenita din clasa de baza va returna un sir de forma Autor 1, Autor 2,... - Titlu, ISBN.
		@Override
		public String genereazaReferinta() {
			StringBuilder sb = new StringBuilder();
			if(autori.size() !=0){
			for (int i = 0, max = autori.size(); i < max; i++) {
				Autor autor = autori.get(i);
				// Autor 1, Autor 2,...
				sb.append(autor.getNume());
				if (i < max - 1) {
					sb.append(", ");
				}
			}
			// - Titlu, ISBN
			sb.append(" - ");
			if(getTitlu()!=null)
			sb.append(getTitlu()).append(", ");
			if(getIsbn()!=null)
			sb.append(getIsbn());
			return sb.toString();}
			else return null;
		}
		

		@Override
		public String toString() {
			return "Manual [isbn=" + isbn + ", categorie=" + categorie
					+ ", numarExemplare=" + numarExemplare + ", autori="
					+ autori + "]";
		}

		// urmeaza getteri si setteri pentru toate campurile din Manual
		public String getCategorie() {
			return categorie;
		}

		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}

		public List<Autor> getAutori() {
			return autori;
		}

		public void setAutori(List<Autor> autori) {
			this.autori = autori;
		}

		public String getIsbn() {
			return isbn;
		}

		// save Manual to file
		public static void saveManualToFile(List<Manual> manuale) throws CustomIOException {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));
				for (Manual manual : manuale) {
					writer.write(manual.getCategorie());
					writer.write(",");
					writer.write(manual.getIsbn());
					writer.write(",");
					writer.write(manual.getTitlu());
					writer.write(",");
					writer.write(String.valueOf(manual.getPret()));
					writer.write(',');
					writer.write(String.valueOf(manual.getExemplareVandute()));
					writer.write('\n');

					for (Autor autor : manual.getAutori()) {
						writer.write(autor.getNume());
						writer.write(",");
						writer.write(String.valueOf(autor.getMarca()));
						writer.write(",");
					}
					writer.write('\n');
				}
			} catch (IOException e) {
				throw new CustomIOException("Can not read using the BufferedWriter", e);
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					throw new CustomIOException("Can not close the BufferedWriter", e);
				}
			}
		}

		// get Manual from file
		public static List<Manual> getManualFromFile() throws CustomIOException {
			List<Manual> manuale = new ArrayList<Manual>();
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(OUTPUT_FILE));
				String line = null;
				while ((line = reader.readLine()) != null) {

					String[] strAtribute = line.split(",");

					Manual manual = new Manual(strAtribute[1], strAtribute[0], null, strAtribute[2], Double.valueOf(strAtribute[3]));
                    manual.setExemplareVandute(Double.valueOf(strAtribute[4]));
					if ((line = reader.readLine()) != null) {
						List<Autor> autori = new ArrayList<Autor>();
						String[] strAutori = line.split(",");
						for (int i = 0; i < strAutori.length; i += 2) {
							Autor autor = new Autor(strAutori[i], Integer.valueOf(strAutori[i + 1]));
							autori.add(autor);
						}
						manual.setAutori(autori);
					}

					manuale.add(manual);
				}
			} catch (IOException e) {
				throw new CustomIOException("Can not read using the BufferedReader", e);
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					throw new CustomIOException("Can not close the BufferedReader", e);
				}
			}
			return manuale;
		}
		
		public static int redaNumaruldeManuale() throws CustomIOException{
			int nr;
			List<Manual> lista=new ArrayList<>();
			lista=getManualFromFile();
			if(lista.size()!=0)
			nr=lista.size();
			else nr=0;
			return nr;
		}
		public static int redaNumarulDeautoriaiuneiCarti(String isbn) throws CustomIOException{
			int nr=0;
			List<Manual> lista=new ArrayList<>();
			lista=getManualFromFile();
			for (Manual m : lista){
				if(m.getIsbn().equals(isbn)){
					nr=m.getAutori().size();
				}else nr=0;
				
			}
			return nr;
		}

}
