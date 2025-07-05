package DatosPersonales;

import java.util.ArrayList;

import Inventario.MateriaPrima;

public class Proveedor {
	String RUC, nombreEmpresa, direccion;
	int telefono;
	 private ArrayList<MateriaPrima> TipoProvicion;


	public Proveedor(String RUC, String nombreEmpresa, String direccion, int telefono) {
		super();
		this.RUC = RUC;
		this.nombreEmpresa = nombreEmpresa;
		this.direccion = direccion;
		this.telefono = telefono;
		TipoProvicion = new ArrayList<MateriaPrima>();
	}


	public ArrayList<MateriaPrima> getTipoProvicion() {
		return TipoProvicion;
	}


	public void setTipoProvicion(ArrayList<MateriaPrima> tipoProvicion) {
		TipoProvicion = tipoProvicion;
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
