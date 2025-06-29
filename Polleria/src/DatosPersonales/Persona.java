package DatosPersonales;

public class Persona {
	private int  telefono;
    private String NombreCompleto,DNI,Direccion;
	public Persona(int telefono, String nombreCompleto, String dNI, String direccion) {
		this.telefono = telefono;
		NombreCompleto = nombreCompleto;
		DNI = dNI;
		Direccion = direccion;
	}
	
	public Persona(int telefono, String nombreCompleto, String direccion) {
		this.telefono = telefono;
		NombreCompleto = nombreCompleto;
		Direccion = direccion;
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

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
    
}
