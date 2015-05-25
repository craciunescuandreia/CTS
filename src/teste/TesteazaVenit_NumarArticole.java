package teste;

import static org.junit.Assert.*;
import junit.framework.TestCase;


import org.junit.Test;

import clase.Articol;
import clase.Autor;
import clase.ExceptiePretNegativ;
import clase.ExceptiePretPesteLimita;
import clase.Manual;

public class TesteazaVenit_NumarArticole extends TestCase{
	
	public  TesteazaVenit_NumarArticole(String nume){
		super(nume);
	}

	@Test
	public void testEqualsVenit() throws Exception {
		Autor a=new Autor("autor1",1);
		Articol art=new Articol(a,5);
		art.setPret(3);
		assertEquals("",15,art.calculeazaVenit(art),0.0);
	}
	@Test
	public void testEqualsVenitNrArticloeNull() throws Exception {
		Autor a=new Autor("autor1",1);
		Articol art=new Articol(a,0);
		art.setPret(3);
		assertEquals("",0,art.calculeazaVenit(art),0.0);
	}
	
	@Test
	public void testEqualsVenitArticolNull() throws Exception {
	
		Articol art=null;
		try{
			art.calculeazaVenit(art);
			assertFalse(true);
		}catch (Exception e) {assertTrue(true);}
		
		
	}
	@Test
	public void testEqualsVenitPretNull() throws Exception {
		Autor a=new Autor("autor1",1);
		Articol art=new Articol(a,11);
		art.setPret(0);
		assertEquals("",0,art.calculeazaVenit(art),0.0);
	}
	
	@Test
	public void testeazaNumarArticloleNegativ() throws Exception {
		try{
		Articol art=new Articol();
		art.setNumarExemplare(-200);
		assertFalse(true);
		} catch(Exception ex) { 
			assertTrue(true);
		}
	}



@Test
public void testeazaNumarArticloleNull() throws Exception {
	try{
	Articol art=new Articol();
	art.setNumarExemplare(0);
	assertFalse(true);
	} catch(Exception ex) { 
		assertTrue(true);
	}
}

@Test
public void testeazaNumarArticloleIncorect() throws Exception {
	try{
	Articol art=new Articol();
	art.setNumarExemplare(19000);
	assertFalse(true);
	} catch(Exception ex) { 
		assertTrue(true);
	}
}
@Test
public void testeazaNumarArticoleCorect() throws Exception {
	
	Articol art=new Articol();
	art.setNumarExemplare(20);
	assertEquals(20, art.getNumarExemplare());
	

}
}

