package DatosPersonales;

public class Persona {
	private int  telefono;
    private String NombreCompleto,DNI;
	public Persona(int telefono, String nombreCompleto, String DNI) {
		this.telefono = telefono;
		NombreCompleto = nombreCompleto;
		this.DNI = DNI;
	}
	
	public Persona(int telefono, String nombreCompleto) {
		this.telefono = telefono;
		NombreCompleto = nombreCompleto;
	}
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombreCompleto() {
		return NombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}

	public String getDNI() {
		return DNI;
	}


	
    
}
