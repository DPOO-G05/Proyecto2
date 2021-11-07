package appInventario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


public class Referencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5840029347459473414L;

	private int unidadesRestantes;

	private double precioVenta;

	private TreeMap<LocalDate, Producto> productos;

	private String SKU;

	public Referencia(String SKU)
	{
		this.SKU = SKU;
		this.productos = new TreeMap<LocalDate, Producto>();
	}
	
	public SortedMap<LocalDate, Producto> getProductos()
	{
		return this.productos;
	}
	
	public void actualizarUnidades(int cantidad)
	{
		//Recibe por parámetro el número de unidades a subir o bajar
		this.unidadesRestantes += cantidad;
	}

	public void agregarProducto(Producto producto)
	{
		productos.put(producto.getFechaVenc(), producto);
	}
	
	public void setPrecioVenta(double precio)
	{
		this.precioVenta = precio;
	}
}
