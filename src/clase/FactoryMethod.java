package clase;



public class FactoryMethod {

	public Publicatie creazaPublicatie(String a){
		 switch (a){
		 case "Articol" :  return new Articol();
		 case "Manual" : return new Manual("Titlu Principal",11);
		 }
		 return null;
		}
}
