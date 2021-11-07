package appPOS;

public class ControladorCliente {
	private int id;
	
	//Metodos
	
	public void crearCliente(String nombre,int edad, int cedula, char sexo, String sitlaboral,String estadocivil) {
		Cliente cliente = new Cliente();
		cliente.setEdad(edad);
		cliente.setCedula(cedula);
		cliente.setEstadoCivil(estadocivil);
		cliente.setNombre(nombre);
		cliente.setSexo(sexo);
		cliente.setSituacionLaboral(sitlaboral);
		
	}

}
