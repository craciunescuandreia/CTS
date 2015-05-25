package teste;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import clase.Autor;
import clase.CustomIOException;
import clase.ExceptiePretNegativ;
import clase.ExceptiePretPesteLimita;
import clase.Manual;
import clase.Publicatie;

public class TesteazaPret extends TestCase {

	
	
	public TesteazaPret(String string) {
		super(string);
	}

	@Test
	public void testeazaPretNegativ() throws ExceptiePretNegativ, ExceptiePretPesteLimita {
		try{
		Manual manual=new Manual();
		manual.stabilestePret(-200);
		assertFalse(true);
		} catch(ExceptiePretNegativ ex) { 
			assertTrue(true);
		}
	}
	
	@Test
	public void testeazaPretPesteLimita() throws ExceptiePretNegativ, ExceptiePretPesteLimita {
		try{
		Manual manual=new Manual();
		manual.stabilestePret(10000);
		assertFalse(true);
		} catch(ExceptiePretPesteLimita ex) { 
			assertTrue(true);
		}
	}
	@Test
	public void testeazaPretCorect() throws ExceptiePretNegativ, ExceptiePretPesteLimita {
		
		Publicatie manual=new Manual();
		manual.stabilestePret(100.0);
		assertEquals("Pret corect" ,100.0, manual.getPret(),0.0);
		
	}
	@Test
	public void VerificaPretRedusTrue() throws ExceptiePretNegativ, ExceptiePretPesteLimita {
		Publicatie manual=new Manual();
		manual.stabilestePret(49);
		assertTrue(manual.verificaPretRedus());
	}
	
	@Test
	public void VerificaPretRedusFalse() throws ExceptiePretNegativ, ExceptiePretPesteLimita {
		Publicatie manual=new Manual();
		manual.stabilestePret(150);
		assertFalse(manual.verificaPretRedus());
	}
	
	


	
}

