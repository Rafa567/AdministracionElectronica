package es.fpdual.primero.eadmin.modelo;

public class Usuario extends AdministracionElectronicaBase{
	

	private final String cargo;

	public Usuario(int id, String nombre, String cargo) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			final Usuario usuario = (Usuario) obj;
			return usuario.getId() == usuario.getId();
		}
		return false;
	}	
	
}
