package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import clase.Autor;
import clase.Manual;

public class testGenereazaReferinta extends TestCase {
	Manual manual;
	List<Autor> listaAutori;
	@Before
	public void setUp(){
		System.out.println("setUp Unit test");
		manual = new Manual();
		 listaAutori=new ArrayList<Autor>();
		
	}
	public testGenereazaReferinta(String nume){
		super(nume);
	}

	@Test
	public void genereazaReferintaListaAutoriNenula() {
		
		Autor a1=new Autor("autor1",1);
		Autor a2=new Autor("autor2",2);
		listaAutori.add(a1);
		listaAutori.add(a2);
		manual.setAutori(listaAutori);
		assertNotNull(manual.genereazaReferinta());
	}
	
	@Test
	public void genereazaReferintaListaAutoriNula() {
		manual.setAutori(listaAutori);
		assertNull(manual.genereazaReferinta());
	}
	
	
	@Test
	public void testNotNulldinfisier() throws IOException {
		File file = new File("autori");
		if(!file.exists())
			throw new FileNotFoundException(
					"Lipsa fisier");
		BufferedReader reader = 
				new BufferedReader(new FileReader(file));
		String linie = null;
		while((linie = reader.readLine())!=null){
			
			String[] valori = linie.split("\t");
			if(valori.length==1)
				continue;
			String nume = valori[0];
			int cota = Integer.parseInt(valori[1]);
			Autor a=new Autor(nume,cota);
			List<Autor> listaAutori=new ArrayList<Autor>();
			listaAutori.add(a);
			manual.setAutori(listaAutori);
			
			
			assertNotNull(manual.genereazaReferinta());
			
		}
		
		reader.close();
	}
	@Test
	public void genereazaReferintaAssertEquals() {
		
		Autor a1=new Autor("autor1",1);
		Autor a2=new Autor("autor2",2);
		listaAutori.add(a1);
		listaAutori.add(a2);
		manual.setAutori(listaAutori);
		manual.setTitlu("titlu1");
		
		assertEquals("autor1, autor2 - titlu1, ",manual.genereazaReferinta());
	}
	
	@Test
	public void testEqualsFisier() throws IOException {
		File file = new File("Manuale");
		if(!file.exists())
			throw new FileNotFoundException(
					"Lipsa fisier");
		BufferedReader reader = 
				new BufferedReader(new FileReader(file));
		String linie = null;
		while((linie = reader.readLine())!=null){
				linie = linie.trim();
			if(linie.isEmpty())
				continue;
			
			String[] valori = linie.split("\t");
			if(valori.length==1)
				continue;
			String nume = valori[0];
			int cota = Integer.parseInt(valori[1]);
			Autor a=new Autor(nume,cota);
			List<Autor> listaAutori=new ArrayList<Autor>();
			listaAutori.add(a);
			
			manual.setAutori(listaAutori);
			manual.setTitlu(valori[2]);
			assertEquals("autor1 - titlu1, null",manual.genereazaReferinta());
			
			}
		
		reader.close();
	}

}
	
