package appPOS;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Referencia;
import interfaz.CoordinadorUI;

public class SistemaPOS implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5437242534545248707L;

	private HashMap<String, Venta> ventas;
	
	private SistemaPuntos sistemaPuntos;
	
	private Venta enProgreso;
	
	private HashMap<String,Cliente> clientesHistoricos;
	
	private CoordinadorUI coordinador;
	
	public SistemaPOS(CoordinadorUI coordinador) 
	{
		this.ventas = new HashMap<String,Venta>();
		this.sistemaPuntos = new SistemaPuntos(this);
		this.clientesHistoricos = new HashMap<>();
		this.coordinador = coordinador;
	}
	
	public boolean existeCliente(String cedula)
	{
		return this.clientesHistoricos.containsKey(cedula.strip());
	}
	
	public Cliente buscarCliente(String cedula)
	{
		return this.clientesHistoricos.get(cedula.strip());
	}

	public Cliente crearCliente(String cedula)
	{
		Cliente nuevo = new Cliente(cedula);
		this.clientesHistoricos.put(cedula, nuevo);
		return nuevo;
	}

	public boolean esAfiliado(String cedula) {
		boolean respuesta = this.sistemaPuntos.esAfiliado(cedula);
		return respuesta;
	}

	public void afiliarCliente(ArrayList<String> atributos, String cedula)
	{
		
		try {
			this.sistemaPuntos.afiliarCliente(atributos, cedula);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	public void iniciarVenta(Cliente cliente)
	{
		
		Venta venta = new Venta(cliente, LocalDate.now());
		this.enProgreso = venta;
	}

	public void agregarProductoVenta(String SKU, String recibo) throws Exception {
		
		if(this.enProgreso == null)
		{
			throw new Exception("Tiene que iniciar la venta antes");
		}
		else
		{
			Referencia ref = coordinador.getReferencia(SKU);
			boolean acumula = this.esAfiliado(enProgreso.getCliente().getCedula());
			this.enProgreso.agregarProducto(ref, acumula, recibo);
		}
	}

	public Venta getVentaActual() {
		return this.enProgreso;
	}

	public void agregarVentaHistorico(Venta ventaActual) {
		this.ventas.put(ventaActual.getId(), ventaActual);
	}
	
	

	
}
