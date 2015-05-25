package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clase.Manual;
import clase.Publicatie;

public class TesteazaCautaManual {

	@Test
	public void testCautaManual() throws Exception {
		Manual m1=new Manual("isbn1");
		m1.setTitlu("titlu1");
		m1.setNumarExemplare(4);
		
		Manual m2=new Manual("isbn2");
		m2.setTitlu("titlu2");
		m2.setNumarExemplare(8);
		List<Manual> lista=new ArrayList<>();
		lista.add(m1);
		lista.add(m2);
		assertEquals(m1.getTitlu(), Publicatie.cautaPubDupaTitlu(lista, "titlu1").getTitlu());
	}
	@Test
	public void testListaNula() throws Exception {
		Manual m1=new Manual("isbn1");
		m1.setTitlu("titlu1");
		m1.setNumarExemplare(4);
		
		Manual m2=new Manual("isbn2");
		m2.setTitlu("titlu2");
		m2.setNumarExemplare(8);
		try{
		List<Manual> lista=new ArrayList<>();
		Manual.cautaPubDupaTitlu(lista, "titu1");
		assertFalse(true);
	}catch(Exception e) {assertTrue(true);}
	}
	@Test
	public void testTitluNull() throws Exception {
		Manual m1=new Manual("isbn1");
		m1.setNumarExemplare(4);
		Manual m2=new Manual("isbn2");
		m2.setNumarExemplare(8);
		try{
		List<Manual> lista=new ArrayList<>();
		Manual.cautaPubDupaTitlu(lista, "titlu1");
		assertFalse(true);
	}catch(Exception e) {assertTrue(true);}
	}
	@Test
	public void testTitluNeexistent() throws Exception {
		Manual m1=new Manual("isbn1");
		m1.setNumarExemplare(4);
		m1.setTitlu("titlu1");
		Manual m2=new Manual("isbn2");
		m2.setNumarExemplare(8);
		m2.setTitlu("titlu2");
		try{
		List<Manual> lista=new ArrayList<>();
		Manual.cautaPubDupaTitlu(lista, "titlu20");
		assertFalse(true);
	}catch(Exception e) {assertTrue(true);}
	}
	@Test
	public void testCautaTitluNulll() throws Exception {
		Manual m1=new Manual("isbn1");
		m1.setNumarExemplare(4);
		m1.setTitlu("titlu1");
		Manual m2=new Manual("isbn2");
		m2.setNumarExemplare(8);
		m2.setTitlu("titlu2");
		try{
		List<Manual> lista=new ArrayList<>();
		Manual.cautaPubDupaTitlu(lista, null);
		assertFalse(true);
	}catch(Exception e) {assertTrue(true);}
	}

}
