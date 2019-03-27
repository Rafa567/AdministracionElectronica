package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoPadron extends Documento {

	private final String tipoPadron;

	public DocumentoPadron(int id, String nombre, Usuario usuario, Date fechaCreacion, String numeroOperacionContable,
			String tipoPadron) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_PADRON);
		this.tipoPadron = tipoPadron;
	}

	public String getTipoPadron() {
		return tipoPadron;
	}
}
