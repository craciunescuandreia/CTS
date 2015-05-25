package clase;

import java.util.Calendar;
import java.util.List;

public class Autor {
	// nume (sir de caractere)
		private String nume;
		// marca (intreg constant)
		private final int marca;
        String cnp;
		public String getCnp() {
			return cnp;
		}

		public void setCnp(String cnp) {
			this.cnp = cnp;
		}
		public int getVarsta(){
			int varsta=0;
			if(cnp!=null){
			try{
				varsta= Calendar.getInstance().get(1) - (1900 + Integer.parseInt("" + cnp.charAt(1) + cnp.charAt(2)));
		       
		       
			} catch(Exception e) { }
			}
			else
			
			varsta=0;
			return varsta;
			
			}
		
		
		public String getSex(){
			if(cnp !=null){
			switch(cnp.charAt(0)){
				case '1': return "M";
				case '2': return "F";
				
				
			}
			}
			return "Cnp incorect";
		}

		// constructor cu parametri
		public Autor(String nume, int marca,String cnp) {
			super();
			this.nume = nume;
			this.marca = marca;
			this.cnp=cnp;
		}
		
		public String descrieAutor(){
			return "Nume persoana contact : " + this.getNume() + ",marca :"+ this.getMarca();
		}

		public Autor(String nume, int marca) {
			super();
			this.nume = nume;
			this.marca = marca;
		}



		public Autor(String nume) {
			super();
			this.nume = nume;
			this.marca=0;
		}


		// constructor de copiere
		public Autor(Autor autor) {
			super();
			this.nume = autor.nume;
			this.marca = autor.marca;
			this.cnp=autor.cnp;
		}

		public Autor(String nume, String cnp) {
			this.nume=nume;
			this.cnp=cnp;
			marca=0;
		}
		

		@Override
		public String toString() {
			return "Autor [nume=" + nume + ", marca=" + marca + ", cnp=" + cnp
					+ "]";
		}

		// functii accesor (get(), set()) pentru atributele private
		public String getNume() {
			return nume;
		}

		public void setNume(String nume) {
			this.nume = nume;
		}

		public int getMarca() {
			return marca;
		}
		public static Autor getAutorCuoAnMarca(List<Autor> autori,int marca) throws Exception{
			Autor a=null;
			if(autori.size()!=0){
				for(int i=0;i<autori.size();i++){
					if(autori.get(i).getMarca()==marca)
					{	a=new Autor( autori.get(i));}
					
				}if(a==null) throw new Exception("Autorul nu se afla in lista");
			} else throw new Exception ("Lista nula");
			return a;
		}

		// fara setMarca pentru ca e final !!

}
