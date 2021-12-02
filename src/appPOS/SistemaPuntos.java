package appPOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class SistemaPuntos 
{
	
	private HashMap<String, Cliente> registrados;
	private SistemaPOS sistemaPos;
	
	public SistemaPuntos(SistemaPOS sistemaPos)
	{
		this.sistemaPos = sistemaPos;
		this.registrados = new HashMap<>();
	}

	public boolean esAfiliado(String cedula) {
		return this.registrados.containsKey(cedula);
	}

	public void afiliarCliente(ArrayList<String> atributos, String cedula) throws Exception {
		
		//Recibe array con la siguiente estructura:
		//[nombre, edad, estadoCivil, situacionLaboral]
		// y la cedula
	
		Cliente cliente = sistemaPos.buscarCliente(cedula);
		
		if(cliente != null)
		{
			cliente.setNombre(atributos.get(0));
			cliente.setEdad(Integer.parseInt(atributos.get(1)));
			cliente.setEstadoCivil(atributos.get(2));
			cliente.setSexo(atributos.get(3));
			this.registrados.put(cedula, cliente);
		}
		else
		{
			throw new Exception("El cliente que quiere afiliar no existe. Debe registrarlo primero en los clientes historicos");
		}
		
	}


}
