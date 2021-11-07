package appPOS;

public class Cliente {
	

	private String nombre;
	private int cedula;
	private int edad;
	private char sexo;
	private String estadoCivil;
	private String situacionLaboral;
	private boolean clienteNuevo;
	private int puntos;
	private boolean inscrito;
	
	
	//Metodos
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
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
	
	public void cliente(String[] infoCliente) {
		
	}

}
