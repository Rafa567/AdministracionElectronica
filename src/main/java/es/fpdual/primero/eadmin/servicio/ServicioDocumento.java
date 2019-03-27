package es.fpdual.primero.eadmin.servicio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public interface ServicioDocumento {
	Documento altaDocumento(Documento documento);
	Documento modificarDocumento(Documento documento);
	void eliminarDocumento(int codigoDocumento);
	List<Documento> obtenerTodosDocumentos();
}
