package teste;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import clase.Autor;

public class TesteazaVarsta_Sex extends TestCase{

	public TesteazaVarsta_Sex(String nume){
		super(nume);
	}
	@Test
	public void testCnpCorect() {
		Autor a=new Autor("autor1",3);
		a.setCnp("29405");
		assertEquals(21, a.getVarsta());
		
	}
	@Test
	public void testCnpNUll() {
		Autor a=new Autor("autor1",3);
		assertEquals(0, a.getVarsta());
		
	}
	@Test
	public void testCnpIncorect() {
		Autor a=new Autor("autor1",3);
		a.setCnp("kgtdyu");
		assertEquals(0, a.getVarsta());
		
	}
	
	@Test
	public void testSEXCnpIncorect() {
		Autor a=new Autor("autor1",3);
		a.setCnp("kgtdyu");
		assertEquals("Cnp incorect", a.getSex());
		
	}
	@Test
	public void testSEXCnpCorect() {
		Autor a=new Autor("autor1",3);
		a.setCnp("17873");
		assertEquals("M", a.getSex());
		
	}
	@Test
	public void testSEXCnpNull() {
		Autor a=new Autor("autor1",3);
	//	a.setCnp("17873");
		assertEquals("Cnp incorect", a.getSex());
		
	}

}
