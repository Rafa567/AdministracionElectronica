package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public abstract class AdministracionElectronicaBase {
	//No hay que poner private ni final
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected Date fechaCreacion;
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	
}
