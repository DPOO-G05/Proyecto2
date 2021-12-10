package appInventario;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;


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
	
	private ArrayList<String> dataInventario;
	
	

	public Referencia(String SKU, Gondola gondola)
	{
		this.SKU = SKU;
		this.gondola = gondola;
		this.productos = new TreeMap<LocalDate, Producto>();
		this.dataInventario = new ArrayList<>();
		this.imagen = new File("./src/persistencia/imagenesProductos/placeholder.png");
	}
	
	public SortedMap<LocalDate, Producto> getProductos()
	{
		return this.productos;
	}
	
	public void actualizarUnidades(int cantidad)
	{
		//Recibe por par�metro el n�mero de unidades a subir o bajar
		this.unidadesRestantes += cantidad;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   String fecha = dtf.format(now);  
	   String cantidadStr = Integer.toString(this.unidadesRestantes);
	   String finalStr = fecha + "," + cantidadStr;
	   this.dataInventario.add(finalStr);

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

	public void disminuirInventario(int cantidadDisminuir) throws Exception
	{
		if (cantidadDisminuir < 0 )
		{
			throw new Exception("La cantidad a disminuir no puede ser negativa");
		}
		else if (cantidadDisminuir > this.unidadesRestantes)
		{
			throw new Exception("No hay suficientes productos para vender esta cantidad");
		}
		else 
		{
			// 1. disminuir la cuenta global
			this.actualizarUnidades(-cantidadDisminuir);
			
			//2. Ir vendiendo uno a uno los productos disminuyendo sus cantidades 
			int restantes = cantidadDisminuir;
			Set<LocalDate> llaves = this.productos.keySet();
			Iterator<LocalDate> iterator = llaves.iterator();
			while (iterator.hasNext() && cantidadDisminuir > 0)
			{
				LocalDate fecha = iterator.next(); 
				Producto prod = this.productos.get(fecha);
				//Disminuir la cantidad en el producto y sincronizar eso con la cantidad del Lote
				cantidadDisminuir = prod.disminuirCantidad(cantidadDisminuir);
			}

		   			
		}
	}

	public int getRestantes()
	{
		return this.unidadesRestantes;

	}

	public ArrayList<String> getDataInventario()
	{
		return this.dataInventario;
	}

	
	
	
}
