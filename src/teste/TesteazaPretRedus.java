package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clase.Articol;
import clase.Publicatie;



public class TesteazaPretRedus  {
	Publicatie pub;
	
	@Before
	
	public void setUp(){
	pub=Mockito.mock(Publicatie.class);
		
	}
	@Test
	public void testFalse() {
		Mockito.when(pub.getPret()).thenReturn(30.0);
		assertFalse(pub.verificaPretRedus());
	}
	
	@Test
	public void testFalseSimplu() {
		Publicatie p=new Articol();
		p.setPret(70.0);
		assertFalse(p.verificaPretRedus());
		
		
	}
	@Test
	public void testtrueSimplu() {
		Publicatie p=new Articol();
		p.setPret(30.0);
		assertTrue(p.verificaPretRedus());
		
		
	}
	
	
	
	

}
