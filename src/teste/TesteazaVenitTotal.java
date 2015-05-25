package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clase.Articol;
import clase.Autor;
import clase.Editura;
import clase.Publicatie;

public class TesteazaVenitTotal {

	@Test
	public void testVenitTotalaCorect() throws Exception {
		List<Publicatie> list=new ArrayList<>();
		Articol art=new Articol();
		 Autor autor=new Autor("autor2",4);
		 art.setAutor(autor);
		 art.setExemplareVandute(122);
		 art.setPret(1);
		 art.setNumarExemplare(13);
		 art.setTitlu("articol2");
		 Articol art2=new Articol();
		 Autor autor1=new Autor("autor1",4);
		 art2.setAutor(autor1);
		 art2.setExemplareVandute(12);
		 art2.setNumarExemplare(11);
		 art2.setPret(1);
		 art2.setTitlu("articol1");
		list.add(art);
		list.add(art2);
		assertEquals("",134, new Editura().calculeazaVenitTotal((ArrayList<Publicatie>) list),0.0);
	}
	@Test
	public void testVenitTotalFarapret() throws Exception {
		List<Publicatie> list=new ArrayList<>();
		Articol art=new Articol();
		 Autor autor=new Autor("autor2",4);
		 art.setAutor(autor);
		 art.setExemplareVandute(122);
		
		 art.setNumarExemplare(13);
		 art.setTitlu("articol2");
		 Articol art2=new Articol();
		 Autor autor1=new Autor("autor1",4);
		 art2.setAutor(autor1);
		 art2.setExemplareVandute(12);
		 art2.setNumarExemplare(11);
		// art2.setPret(1);
		 art2.setTitlu("articol1");
		list.add(art);
		list.add(art2);
		assertEquals("",0, new Editura().calculeazaVenitTotal((ArrayList<Publicatie>) list),0.0);
	}
	@Test
	public void testVenitTotalFaraNumarExemplare() throws Exception {
		List<Publicatie> list=new ArrayList<>();
		Articol art=new Articol();
		 Autor autor=new Autor("autor2",4);
		 art.setAutor(autor);
		 art.setPret(1);
		 art.setNumarExemplare(13);
		 art.setTitlu("articol2");
		 Articol art2=new Articol();
		 Autor autor1=new Autor("autor1",4);
		 art2.setAutor(autor1);
		 art2.setNumarExemplare(11);
		 art2.setPret(1);
		 art2.setTitlu("articol1");
		list.add(art);
		list.add(art2);
		assertEquals("",0, new Editura().calculeazaVenitTotal((ArrayList<Publicatie>) list),0.0);
	}
	@Test
	public void testVenitTotalFaraPretfaraNr() throws Exception {
		List<Publicatie> list=new ArrayList<>();
		Articol art=new Articol();
		 Autor autor=new Autor("autor2",4);
		 art.setAutor(autor);
		 art.setNumarExemplare(13);
		 art.setTitlu("articol2");
		 Articol art2=new Articol();
		 Autor autor1=new Autor("autor1",4);
		 art2.setAutor(autor1);
		 art2.setNumarExemplare(11);
		 art2.setTitlu("articol1");
	   	list.add(art);
		list.add(art2);
		assertEquals("",0, new Editura().calculeazaVenitTotal((ArrayList<Publicatie>) list),0.0);
	}



}
