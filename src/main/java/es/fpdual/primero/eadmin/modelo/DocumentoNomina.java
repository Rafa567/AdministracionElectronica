package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoNomina extends Documento {

	private final String tipoNomina;

	public DocumentoNomina(int id, String nombre, Usuario usuario, Date fechaCreacion, String tipoNomina) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_NOMINA);
		this.tipoNomina = tipoNomina ;
	}

	public String getTipoNomina() {
		return tipoNomina;
	}
}