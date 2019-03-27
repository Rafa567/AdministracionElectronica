package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.Documento;

public class DocumentoTest {
	
	@Test
	public void deberiaDevolverTrueSiLosDocumentosSonIguales() {
		
		//Inicialización
		final Documento documento1 = new Documento(5, null, null, null, null );
		final Documento documento2 = new Documento(5, null, null, null, null );
		//Ejecución
		final boolean resultado = documento1.equals(documento2);
		//Comprobación del resultado
		assertTrue(resultado);
		
	}
	
	@Test
	public void deberiaDevolverFalseElEqualsDeDocumento() {
		
		//Inicialización
		final Documento documento1 = new Documento(10, null, null, null, null );
		final Documento documento2 = new Documento(5, null, null, null, null );
		//Ejecución
		final boolean resultado = documento1.equals(documento2);
		//Comprobación del resultado
		assertFalse(resultado);
		
	}
	
	
	@Test
	public void deberiaDevolverTrueElHashCodeDelDocumento() {
		
		//Inicialización
		final Documento documento = new Documento(5,  null, null, null, null );
		//Ejecución
		final int resultado = documento.hashCode();
		//Comprobación del resultado
		assertEquals(5, resultado);
		
	}
	
}
