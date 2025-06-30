package DatosPersonales;

public class Administrador extends Persona{
	String sucursalKey;

	public Administrador(int telefono, String nombreCompleto, String DNI, String direccion, String sucursalKey) {
		super(telefono, nombreCompleto, DNI, direccion);
		this.sucursalKey = sucursalKey;
	}

	public String getSucursalKey() {
		return sucursalKey;
	}

	public void setSucursalKey(String sucursalKey) {
		this.sucursalKey = sucursalKey;
	}
	
	
	
}
