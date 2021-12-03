package appPOS;
import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Producto;
import appInventario.Referencia;


public class Venta implements Serializable {
	
	private Cliente cliente;
	private int puntos;
	private String id;
	private String recibo;
	private float monto;
	private LocalDate fecha;
	private HashMap<String,Integer> listaReferencias; 
	
	public Venta(Cliente cliente,LocalDate fecha)
	{
		this.fecha = fecha;
		this.cliente = cliente;
		this.id = fecha.toString() + "," + cliente.getCedula();
		this.listaReferencias = new HashMap<>();
	}

	public void agregarProducto(Referencia ref, boolean acumulaPuntos, String recibo) {
		int unidades; 
		if (!listaReferencias.containsKey(ref.getSKU()))
		{
			this.listaReferencias.put(ref.getSKU(),1);
			unidades = this.listaReferencias.get(ref.getSKU());
		}
		else
		{
			unidades = this.listaReferencias.get(ref.getSKU());
			unidades += 1;
			this.listaReferencias.put(ref.getSKU(),unidades);
		}
		
		this.monto += ref.getPrecioVenta();

		if (acumulaPuntos)
		{
			this.puntos = (int) (this.monto/1000);
		}
		
		this.recibo = recibo;
		
	}
	
	public double calcularTotal()
	{
		return this.monto;
	}

	public HashMap<String, Integer> getProductos() {
		return this.listaReferencias;
	}

	public String getId() {

		return this.id;
	}
	
	public void cerrarVenta()
	{
		this.puntos = (int) (this.monto/1000);
	}
	
	public int getPuntos()
	{
		return this.puntos;
	}
	
	public void setRecibo(String recibo)
	{
		this.recibo = recibo;
	}
	
	public Cliente getCliente()
	{
		return this.cliente;
	}
	
	@Override
	public String toString()
	{
		return this.recibo;
	}
	
	public double getMonto()
	{
		return this.monto;
	}

	

}
