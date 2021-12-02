package appPOS;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Producto;
import appInventario.Referencia;


public class Venta {
	
	private Cliente cliente;
	private int puntos;
	private String id;
	private float monto;
	private LocalDate fecha;
	private HashMap<String,Integer> listaReferencias; 
	private Recibo recibo;
	
	public Venta(Cliente cliente,LocalDate fecha)
	{
		this.fecha = fecha;
		this.cliente = cliente;
		this.id = fecha.toString() + "-" + cliente.getCedula();
		this.listaReferencias = new HashMap<>();

	}

	public void agregarProducto(Referencia ref) {
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
		
		monto += ref.getPrecioVenta();
	}
	
	public double calcularTotal()
	{
		return this.monto;
	}

	public HashMap<String, Integer> getProductos() {
		return this.listaReferencias;
	}

	public Recibo getRecibo() {
		return this.recibo;
	}

	public String getId() {

		return this.id;
	}

	

}
