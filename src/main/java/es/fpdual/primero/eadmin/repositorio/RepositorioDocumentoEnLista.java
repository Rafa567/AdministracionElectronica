package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.modelo.AdministacionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

@Repository

public class RepositorioDocumentoEnLista implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new AdministacionElectronicaException("El documento ya existe");
		}
		documentos.add(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new AdministacionElectronicaException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		//Solucion 1
		Documento documentoAEliminar = new Documento(codigoDocumento, null, null, null, null);
		
		//Solucion 2
		documentoAEliminar = documentos.stream().filter(d -> d.getId().intValue == codigoDocumento);
		final int indice = documentos.indexOf(documentoAEliminar);
		documentos.remove(indice);
	}
	

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return null;
	}

	@Override
	public int siguienteId() {
		return 0;
	}

}
