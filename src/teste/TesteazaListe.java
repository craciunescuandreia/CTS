package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clase.CustomIOException;
import clase.Manual;
import clase.Publicatie;
import clase.Publicatii;
import clase.publicatiiReduse;

public class TesteazaListe {

	@Test
	public void testListaManualeNula() throws CustomIOException {
		Publicatii pub=new Publicatii();
		ArrayList<Manual> lista=pub.afiseazaManuale();
		assertNotNull(lista);
		
	}
	@Test
	public void testListaPublicatiiReduse() throws CustomIOException {
		publicatiiReduse pub=new publicatiiReduse();
		ArrayList<Publicatie> lista=pub.publicatiiReduse();
		assertNotNull(lista);
		
	}
	@Test

	public void test_listaNull() throws CustomIOException{
		Manual manual=new Manual();
		List<Manual> lista=manual.getManualFromFile();
		assertNotNull(lista);
	}
	@Test
	public void testnumarManuale() throws CustomIOException {
	Manual m=new Manual();
		int nr=m.redaNumaruldeManuale();
		assertNotNull(nr);
		
	}
	@Test
	public void testnumarManualeEquals() throws CustomIOException {
	Manual m=new Manual();
		int nr=m.redaNumaruldeManuale();
		assertEquals(2, nr);
		
	}
	@Test
	public void testnumarAutoriEquals() throws CustomIOException {
	Manual m=new Manual();
		int nr=m.redaNumarulDeautoriaiuneiCarti("13");
		assertEquals(0, nr);
		
	}
	@Test
	public void testnumarAutoriNotNull() throws CustomIOException {
	Manual m=new Manual();
		int nr=m.redaNumarulDeautoriaiuneiCarti("13");
		assertNotNull(nr);
		
	}

}
