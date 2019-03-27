package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoSubvencion extends Documento {
	
	private final String tipoSubvencion;

	public DocumentoSubvencion(int id, String nombre, Usuario usuario, Date fechaCreacion, String numeroOperacionContable, String tipoSubvencion) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_SUBVENCION);
		this.tipoSubvencion = tipoSubvencion ;
	}

	public String getTipoSubvencion() {
		return tipoSubvencion;
	}
}


