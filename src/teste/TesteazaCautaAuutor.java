package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import clase.Autor;

public class TesteazaCautaAuutor extends TestCase {
	
	public TesteazaCautaAuutor(String nume){
		super(nume);
	}
	@Test
	public void VerificaMarca() {
		Autor autor1=new Autor("nume1",1,"2940517250599");
		assertEquals(1, autor1.getMarca());
	}
	@Test
	public void VerificaMarcaNula() {
		Autor autor1=new Autor("nume1");
		assertEquals(0, autor1.getMarca());
	}

	@Test
	public void testCautaAutor() throws Exception {
		Autor a1=new Autor("autor1",1,"123");
		Autor a2=new Autor("autor2",2,"213");
		Autor a3=new Autor("autor3",3,"432");
		List<Autor> lista=new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		assertEquals(a2.getNume(),Autor.getAutorCuoAnMarca(lista,2 ).getNume() );
	}
	@Test
	public void testcautaAutorListaNula() throws Exception {
		Autor a1=new Autor("autor1",1,"123");
		Autor a2=new Autor("autor2",2,"213");
		Autor a3=new Autor("autor3",3,"432");
		try{
		List<Autor> lista=new ArrayList<>();
		Autor.getAutorCuoAnMarca(lista, 2);
		assertFalse(true );
		}catch(Exception e) {assertTrue(true);}
	}
	
	@Test
	public void testcautaAutorNuesteInlista() throws Exception {
		Autor a1=new Autor("autor1",1,"123");
		Autor a2=new Autor("autor2",2,"213");
		Autor a3=new Autor("autor3",3,"432");
		try{
		List<Autor> lista=new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		Autor.getAutorCuoAnMarca(lista, 7);
		assertFalse(true);
		}catch(Exception e){assertTrue(true);}
		
	}
	@Test
	public void testcautaAutorMarcanula() throws Exception {
		Autor a1=new Autor("autor1","123");
		Autor a2=new Autor("autor2","213");
		Autor a3=new Autor("autor3","432");
		try{
		List<Autor> lista=new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		Autor.getAutorCuoAnMarca(lista, 3);
		assertFalse(true);
		}catch(Exception e){assertTrue(true);}
		
	}
	@Test
	public void testcautaAutorMarcaNegativa() throws Exception {
		Autor a1=new Autor("autor1",1,"123");
		Autor a2=new Autor("autor2",2,"213");
		Autor a3=new Autor("autor3",3,"432");
		try{
		List<Autor> lista=new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		Autor.getAutorCuoAnMarca(lista, -9);
		assertFalse(true);
		}catch(Exception e){assertTrue(true);}
		
	}
		
		
}
