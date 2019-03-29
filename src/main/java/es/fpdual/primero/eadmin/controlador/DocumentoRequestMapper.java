package es.fpdual.primero.eadmin.controlador;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

public class DocumentoRequestMapper {

	private DocumentoRequestMapper() {
		// sonar
	}

	static Documento toDocumento(DocumentoRequest documentoRequest) {
		return new Documento(documentoRequest.getId(), documentoRequest.getNombre(), construyeUsuario(documentoRequest),
				documentoRequest.getFechaCreacion(), construyeTipoDocumento(documentoRequest.getTipoDocumento()));
	}

	private static Usuario construyeUsuario(DocumentoRequest documentoRequest) {
		return new Usuario(documentoRequest.getId(), "Usuario" + documentoRequest.getId(),
				"cargo" + documentoRequest.getId());
	}

	private static TipoDocumento construyeTipoDocumento(String tipoDocumento) {

		TipoDocumento resultado;

		switch (tipoDocumento) {
		case "DOCUMENTO CONTABLE":
			resultado = TipoDocumento.DOCUMENTO_CONTABLE;
			break;
		case "DOCUMENTO FACTURA":
			resultado = TipoDocumento.DOCUMENTO_FACTURA;
			break;
		case "DOCUMENTO NOMINA":
			resultado = TipoDocumento.DOCUMENTO_NOMINA;
			break;
		case "DOCUMENTO PADRON":
			resultado = TipoDocumento.DOCUMENTO_PADRON;
			break;
		case "DOCUMENTO SUBVENCION":
			resultado = TipoDocumento.DOCUMENTO_SUBVENCION;
			break;
		default:
			resultado = TipoDocumento.DOCUMENTO_CONTABLE;
		}
		return resultado;
	}
}
