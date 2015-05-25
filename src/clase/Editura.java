package clase;

import java.util.ArrayList;
import java.util.List;

public class Editura {
String nume;
private static Editura instanta=null;
Autor a1=new Autor("nume1",1);
Manual m1= (Manual) new FactoryMethod().creazaPublicatie("Manual");

Articol m2= (Articol) new FactoryMethod().creazaPublicatie("Articol");
public Editura(){this.nume="Editura ASE";}

public static Editura getInstanta(){
	if(instanta==null)
		instanta=new Editura();
	return instanta;
	
}

public String descrieEditura(){
	return
	this.afiseazaInformatiiEditura()+ " ; "+
	a1.descrieAutor() + " ; "+
	m1.descrierePublicatie();
	
}

public String getNume() {
	return nume;
}

public void setNume(String nume) {
	this.nume = nume;
}




public String afiseazaInformatiiEditura(){
	return "Denumire editura:" + this.nume;
}

public double calculeazaVenitTotal(ArrayList<Publicatie> arrayList) throws Exception{
	 
	 double venit=0;
	 /*
	 Articol art=new Articol();
	 Autor autor=new Autor("autor2",4);
	 art.setAutor(autor);
	 art.setExemplareVandute(122);
	 art.setNumarExemplare(13);
	 art.setTitlu("articol2");
	 Articol art2=new Articol();
	 Autor autor1=new Autor("autor1",4);
	 art.setAutor(autor1);
	 art.setExemplareVandute(12);
	 art.setNumarExemplare(11);
	 art.setTitlu("articol1");
	list.add(art);
	list.add(art2);
	*/
	
	for (Publicatie pub : arrayList){
		if(pub.getPret()!=0 & pub.getExemplareVandute() !=0){
		 venit+=pub.getPret()*pub.getExemplareVandute();
		}
		else venit=0;
	}
	
	
	return venit;
}
}
