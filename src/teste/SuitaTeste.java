package teste;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

public class SuitaTeste extends TestCase {

	@Test

	 public static TestSuite suite() {
		    TestSuite suita = new TestSuite();
		    // Only include short tests
		    suita.addTest(new TesteazaPret("testeazaPretCorect"));
		    suita.addTest(new testGenereazaReferinta("genereazaReferintaAssertEquals"));
		    suita.addTest(new TesteazaVenit_NumarArticole("testEqualsVenit"));
		    suita.addTest(new TesteazaVenit_NumarArticole("testeazaNumarArticoleCorect"));
		    suita.addTest(new TesteazaVarsta_Sex("testCnpCorect"));
		    suita.addTest(new TesteazaVarsta_Sex("testSEXCnpCorect"));
		    suita.addTest(new TesteazaCautaAuutor("testCautaAutor"));
		    return  suita;
		  
		   
		  }

}
