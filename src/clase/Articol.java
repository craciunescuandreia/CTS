package clase;

public class Articol extends Publicatie {
Autor autor;
int numarExemplare;
	
	public Articol(Autor autor, int numarExemplare) {
	super();
	this.autor = autor;
	this.numarExemplare = numarExemplare;
}
	public Articol() {
		
	}
	@Override
	public String genereazaReferinta() {
		return "Articolul " + this.getTitlu() + "a fost scris de catre" + this.autor.getNume();
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public int getNumarExemplare() {
		return numarExemplare;
	}
	public void setNumarExemplare(int numarExemplare) throws Exception {
		if(numarExemplare<0) throw new Exception ("Numar exemplare negativ");
		else if(numarExemplare==0) throw new Exception ("Numar de exmplare null");
		else if(numarExemplare >3000) throw new Exception("Numar exemplare incorect");
		
		this.numarExemplare = numarExemplare;
		}
	
	@Override
	public String toString() {
		return "Articol [numarExemplare=" + numarExemplare + "]";
	}
	public String afiseazaArticol(){
		return "Titlu: " +this.titlu + " ,pret: "+ this.pret + " ,Numar exemplare :" +this.numarExemplare;
	}
	public  double calculeazaVenit(Articol art) throws Exception{
		if(art !=null){
			if(numarExemplare !=0 & this.getPret() !=0.0)
				
				return numarExemplare * this.getPret();
			else return 0.0;
			
		}else throw new Exception ("Articolul nu exista");
		
	}
	
	

}
