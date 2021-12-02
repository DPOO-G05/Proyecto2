package appPOS;

import java.util.HashMap;

public class Cliente {
	
	private String nombre;
	private String cedula;
	private int edad;
	private String sexo;
	private String estadoCivil;
	private String situacionLaboral;
	private int puntos;
	private HashMap<String, Venta> compras;
	
	//Constructor
	public Cliente(String cedula)
	{
		this.cedula = cedula;
		this.compras = new HashMap<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String string) {
		this.sexo = string;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSituacionLaboral() {
		return situacionLaboral;
	}
	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void agregarVenta(Venta venta) {
		this.compras.put(venta.getId(), venta);
	}
	
	
}
