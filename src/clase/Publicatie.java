package clase;

import java.util.List;

public abstract class Publicatie {

	// titlu (sir de caractere)
	public String titlu;
	// pret (numar real)
	protected double pret;
	double exemplareVandute;

	public double getExemplareVandute() {
		return exemplareVandute;
	}
	public static Manual cautaPubDupaTitlu(List<Manual> pub,String titlu) throws Exception{
		Manual publicatie=null;
		if(pub.size()!=0){
			if(titlu!=null){
				for(Manual p : pub){
					if(p.getTitlu().equals(titlu)){publicatie=new Manual(p);}
					}
				if(publicatie==null) throw new Exception("Manualul nu exista");
			} else throw new Exception("Titlul introdus este null");
		} else throw new Exception("Lista este nula");
		return publicatie;
	}
	public void setExemplareVandute(double exemplareVandute) {
		this.exemplareVandute = exemplareVandute;
	}
	// metoda abstracta genereazaReferinta() ce intoarce un sir de caractere si nu are argumente.
	public abstract String genereazaReferinta();
public String descrierePublicatie(){
	return "Titlu publicatie reprezentativa : " + this.getTitlu() + ",pret :" +this.getPret();
	
}
	// getteri si setteri
	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public double getPret() {
		return this.pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}
	
	public boolean verificaPretRedus(){
		boolean rez=false;
		if(getPret()<50.0)
			 rez=true;
			if(getPret()>50.0)
				 rez=false;
			return rez;
			
		
		
	}
	public void stabilestePret(double pret) throws ExceptiePretNegativ, ExceptiePretPesteLimita{
		
		if(pret<0) throw new ExceptiePretNegativ();
		else if(pret>5000) throw new ExceptiePretPesteLimita();
		
		this.pret=pret;
		
	}
}