package appInventario;

import java.io.File;
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

	private Gondola gondola;
	
	private File imagen;

	public Referencia(String SKU, Gondola gondola)
	{
		this.SKU = SKU;
		this.gondola = gondola;
		this.productos = new TreeMap<LocalDate, Producto>();
	}
	
	public SortedMap<LocalDate, Producto> getProductos()
	{
		return this.productos;
	}
	
	public void actualizarUnidades(int cantidad)
	{
		//Recibe por par�metro el n�mero de unidades a subir o bajar
		this.unidadesRestantes += cantidad;
	}

	public void agregarProducto(Producto producto)
	{
		productos.put(producto.getFechaVenc(), producto);
		this.precioVenta = producto.getPrecioUnidad();
	}
	
	public void setPrecioVenta(double precio)
	{
		this.precioVenta = precio;
	}

	public Gondola getGondola()
	{
		return this.gondola;
	}

	public String getSKU()
	{
		return this.SKU;
	}
	
	public void setImagen(File imagen)
	{
		this.imagen = imagen;
	}
	
	public File getImagen()
	{
		return this.imagen;
	}
	
	public String getRutaImagen()
	{
		return this.imagen.getAbsolutePath();
	}
	
	public String getNombre()
	{
		return this.productos.get(this.productos.firstKey()).getNombre();
	}
	
	public double getPrecioVenta()
	{
		return this.precioVenta;
	}
	
	public String generarRecibo() {
		var producto = productos.firstEntry().getValue();
		String recibo = producto.getNombre();
		recibo += ",";
		recibo += String.valueOf(getPrecioVenta());
		return recibo;
		
	}
}
