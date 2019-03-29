package es.fpdual.primero.eadmin.repositorio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	void  altaDocumento(Documento documento);
	void modificarDocumento(Documento documento);
	void eliminarDocumento(int id);
	List<Documento> obtenerTodosDocumentos();
	int siguienteId();
}
