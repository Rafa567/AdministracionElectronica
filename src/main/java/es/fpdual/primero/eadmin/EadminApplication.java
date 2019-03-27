package es.fpdual.primero.eadmin;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;
import es.fpdual.primero.eadmin.modelo.Usuario;


@SpringBootApplication

public class EadminApplication {

	public static void main(String[] args) {
			
		final Usuario usuario = new Usuario(4,"bob","chef");
		final Date fecha = new Date();
			
	
		final DocumentoContable documentoContable = new DocumentoContable(10,"operacion contable",usuario,fecha,"12312312321312321");
		
		 final Documento documento = new DocumentoContable(15,"operacion contable",usuario,fecha,"999999999999999");
			SpringApplication.run(EadminApplication.class, args);
			
			documentoContable.getNumeroOperacionContable();
			
			Documento documentoNuevo;
			documentoNuevo = documentoContable;
			documentoNuevo = documento;
			
			DocumentoContable documentoContable2;
			documentoContable2 = documentoContable;
			documentoContable2 = (DocumentoContable) documento;
			
			
	}

}
