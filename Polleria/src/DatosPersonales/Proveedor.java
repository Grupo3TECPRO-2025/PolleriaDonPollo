package DatosPersonales;

public class Proveedor {
	String RUC, nombreEmpresa, direccion;
	int telefono;


	public Proveedor(String RUC, String nombreEmpresa, String direccion, int telefono) {
		super();
		this.RUC = RUC;
		this.nombreEmpresa = nombreEmpresa;
		this.direccion = direccion;
		this.telefono = telefono;
	}


	public String getRUC() {
		return RUC;
	}


	public void setRUC(String rUC) {
		RUC = rUC;
	}


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	
	
}
