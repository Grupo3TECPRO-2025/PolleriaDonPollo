package DatosPersonales;

import java.time.LocalDateTime;

public class ClienteCuenta {
	String DNI;
	LocalDateTime fechaRegistro;
	int puntosCuenta ;
	Cliente cli;
	public ClienteCuenta(String dNI, int puntosCuenta, Cliente cli) {

		DNI = dNI;
		this.fechaRegistro = LocalDateTime.now();
		this.puntosCuenta = puntosCuenta;
		this.cli = cli;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getPuntosCuenta() {
		return puntosCuenta;
	}
	public void setPuntosCuenta(int puntosCuenta) {
		this.puntosCuenta = puntosCuenta;
	}
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	
	
	
	
	
	
}
