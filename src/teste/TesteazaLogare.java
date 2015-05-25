package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import clase.Autor;
import clase.FereastraLogin;
import clase.Publicatie;

public class TesteazaLogare {

Autor log;
	
	@Before
	
	public void setUp(){
	log=Mockito.mock(Autor.class);
		
	}
	@Test
	public void testFalse() {
		Mockito.when(log.getNume()).thenReturn(null);
		Mockito.when(log.getCnp()).thenReturn(null);
		assertFalse(new FereastraLogin().logare(new Autor(log.getNume(),log.getCnp())));
	}
	@Test
	public void testtrueLogare() {
		Mockito.when(log.getNume()).thenReturn("user");
		Mockito.when(log.getCnp()).thenReturn("123");
		assertTrue(new FereastraLogin().logare(log));
	}
	
	@Test
	public void testFalseLogarefaraParola() {
		Mockito.when(log.getNume()).thenReturn("user");
		Mockito.when(log.getCnp()).thenReturn(null);
		assertFalse(new FereastraLogin().logare(log));
	}
	
	@Test
	public void testFalseLogareDateGresite() {
		Mockito.when(log.getNume()).thenReturn("usereee");
		Mockito.when(log.getCnp()).thenReturn("13478");
		assertFalse(new FereastraLogin().logare(log));
	}
	
	@Test
	public void testtrueLogareFaraMockito() {
		FereastraLogin fereastra=new FereastraLogin();
		Autor a=new Autor("user","123");
		assertTrue(fereastra.logare(a));
	}
	


}
