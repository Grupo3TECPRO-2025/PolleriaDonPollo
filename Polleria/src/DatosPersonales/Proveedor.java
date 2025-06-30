package DatosPersonales;

public class Proveedor extends Persona{
	String RUC, nombreEmpresa;

	public Proveedor(int telefono, String nombreCompleto, String DNI, String direccion, String rUC,
			String nombreEmpresa) {
		super(telefono, nombreCompleto, DNI, direccion);
		RUC = rUC;
		this.nombreEmpresa = nombreEmpresa;
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
	
	
	
}
