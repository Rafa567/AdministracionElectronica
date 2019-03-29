package es.fpdual.primero.eadmin.repositorio;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RepositorioDocumentoEnListaTest {

	private RepositorioDocumentoEnLista repositorioDocumento;
	private Documento documento;

	@Before
	public void inicializarEnCadaTest() {

		this.documento = mock(Documento.class);
		this.repositorioDocumento = new RepositorioDocumentoEnLista();
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {

		final Documento documento = mock(Documento.class);
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(20);
		this.repositorioDocumento.altaDocumento(documento);

		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));

	}

	@Test(expected = AdministacionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoYaExistente() {
		final Documento documento = mock(Documento.class);

		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(20);

		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);

	}

	@Test
	public void deberiaModificarDocumento() {

		Documento documentoAlmacenado = new Documento(20, "Doc 1", null, null, null);
		Documento documentoModificado = new Documento(20, "Doc 2", null, null, null);

		this.repositorioDocumento.altaDocumento(documentoAlmacenado);
		this.repositorioDocumento.modificarDocumento(documentoModificado);

		assertEquals("Doc 2", this.repositorioDocumento.obtenerTodosDocumentos().get(0).getNombre());

	}

	@Test(expected = AdministacionElectronicaException.class)
	public void deberiaLazarExcepcionModificarDocumento() {

		this.repositorioDocumento.modificarDocumento(this.documento);
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		when(this.documento.getNombre()).thenReturn("Documento 1");
		when(this.documento.getId()).thenReturn(20);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(20);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().isEmpty());
	}
	
	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEliminarNoExiste() {
		this.repositorioDocumento.eliminarDocumento(20);
	}
	
	@Test
	public void deberiaDevolverUnoSiEstaVacio() {
		
		final int resultado = this.repositorioDocumento.siguienteId();
		assertEquals(1,resultado);
	}
	
	@Test
	public void deberiaDevolverElSiguienteId() {
		
		when(this.documento.getId()).thenReturn(20);
		
		this.repositorioDocumento.altaDocumento(documento);
		final int resultado = this.repositorioDocumento.siguienteId();
		assertEquals(21,resultado);
	}
	
}
