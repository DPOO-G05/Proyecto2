package appPOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.ControladorCliente;

public class SistemaPuntos {
	
	private ArrayList<Cliente> clientes = null;
	//Metodos 
	
	public void preguntarDetallesPersonales() {
		String nombre = input("Por favor ingrese su nombre: ");
		int edad = Integer.parseInt(input("Ingrese su edad: "));
		int cedula = Integer.parseInt(input("Ingrese el numero de su cedula: "));
		char sexo = input("Ingrese 'm' para genero masculino, 'f' para genero femenino o 'n' para cualquier otro: ").charAt(0);
		String sitLaboral = input("Ingrese su sitaucion laboral: ");
		String estadoCivil = input("Ingrese su estado civil: ");
		

	}
	
	public void agregarCliente(Cliente cliente,ArrayList<Cliente> clientes) {
		
		clientes.add(cliente);
	}
	
	public void acumularPuntos(Cliente cliente,Venta venta) {
		int puntosActuales = cliente.getPuntos();
		int puntosAcumulados = venta.getPuntos();
		cliente.setPuntos(puntosAcumulados + puntosActuales);
	}
	
	public void eliminarCliente(Cliente cliente,ArrayList<Cliente> clientes) {
		clientes.remove(cliente);
	}
	
	public void redimirPuntos(Cliente cliente) {
	}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}
