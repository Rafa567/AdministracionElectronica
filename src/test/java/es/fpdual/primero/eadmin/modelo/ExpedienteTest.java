package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;
import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.TipoExpediente;
import es.fpdual.primero.eadmin.modelo.Usuario;

public class ExpedienteTest {

	@Test
	public void deberiaConstruirUnExpedienteConDocumentos() {
		final Usuario usuario = new Usuario(1, "Juan", "Alcalde");
		final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario, new Date(),
				"12312312321312321");
		final Documento documento = new DocumentoContable(15, "operacion contable", usuario, new Date(),
				"999999999999999");
		final Documento documentoNuevo = new Documento(20, "operacion contable", usuario, new Date(),
				TipoDocumento.DOCUMENTO_PADRON);
		final List<Documento> documentos = new ArrayList<Documento>();

		for (Documento documentoActual : documentos) {
			if (esDocumentoContable(documentoActual)) {
				System.out.println(documentoActual);
			}
		}

		// for (Documento documentoActual : documentos) {
		// if (esDocumentoContable(documentoActual)) {
		// System.out.println(documentoActual.getNombre().length());
		// }
		// }

		for (Documento documentoActual : documentos) {
			System.out.println(documentoActual.getNombre().length());

		}

		documentos.stream().filter(documentoActual -> esDocumentoContable(documentoActual))
				.forEach(documentoActual -> System.out.println(documentoActual));

		documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);

		final List<Documento> documentoContables = documentos.stream().filter(this::esDocumentoContable)
				.collect(Collectors.toList());

		documentos.stream().map(documentoActual -> documentoActual.getNombre()).map(nombre -> nombre.length())
				.forEach(longitud -> System.out.println(longitud));

		documentos.stream().map(Documento::getNombre).map(String::length).forEach(System.out::println);

		documentos.add(documentoContable);
		documentos.add(documento);
		documentos.add(documentoNuevo);

		final Expediente expediente = new Expediente(1, "expediente 1", usuario, new Date(),
				TipoExpediente.EXPEDIENTE_LICENCIA_OBRAS, documentos);

		// Comprobar resultados
		assertEquals(documentos, expediente.getDocumentos());

		assertEquals(3, documentos.size());
	}

	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	@Test
	
	public void devolverLaLongitudDeLosNombresYComprobarQueTengaElValorCorrecto() {
		
		//Inicializando
		final Usuario usuario = new Usuario (2,"usu","c");
		final Date fechaCreacion = new Date();
		final Documento doc1 =  new Documento(1,"uno",usuario,fechaCreacion,TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento doc2 =  new Documento(2,"cuatro",usuario,fechaCreacion,TipoDocumento.DOCUMENTO_CONTABLE);
		final List<Documento> documentos = new ArrayList<>();
		documentos.add(doc1);
		documentos.add(doc2);
		final Expediente expediente = new Expediente(1,"nombre",usuario,fechaCreacion,TipoExpediente.EXPEDIENTE_SUBVENCIONES,documentos);
		
		//Ejecucion
		final List<Integer> resultado = expediente.obtenerLongitudNombresDocumentos();
		
		//Comprobacion de resultados
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		assertEquals(6, resultado.get(1).intValue());
		assertEquals(Integer.parseInt("6"),resultado.get(1).intValue());
	
		}
		
	}


