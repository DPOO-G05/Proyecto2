package appInventario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.time.*;

import procesamientoInventario.ConstructorArchivo;

public class SistemaInventario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2444695876594637884L;

	private ConstructorArchivo constructorArchivo;

	private HashMap<String, Categoria> categorias;

	private HashMap<String, Lote> lotes;
	
	private HashMap<String, Referencia> referencias;

	public SistemaInventario()
	{
		this.constructorArchivo = new ConstructorArchivo(this);
		this.categorias = new HashMap<String, Categoria>();
		this.lotes = new HashMap<String,Lote>();
		this.referencias = new HashMap<String,Referencia>();
	}

	
	public void leerCSV(File archivo)
	{
		this.constructorArchivo.leerCSV(archivo);
		this.constructorArchivo.crearCategorias();
		this.constructorArchivo.crearGondolas();
		this.constructorArchivo.crearReferencias();
		this.constructorArchivo.crearLotes();
	}
	
	public HashMap<String,Categoria> getCategorias()
	{
		return this.categorias;
	}


	public HashMap<String, Lote> getLotes() {
		return lotes;
	}
	
	public HashMap<String, Referencia> getReferencias()
	{
		return this.referencias;
	}


	public Referencia buscarReferencia(String sKU) {
		
		Referencia ref = this.referencias.get(sKU);
		return ref; 
	}


	public void disminuirInventario(HashMap<String, Integer> referencias2) throws Exception
	{
		for(String SKU: referencias2.keySet())
		{
			Referencia ref = referencias.get(SKU);
			if (ref == null)
			{
				throw new Exception("La referencia no existe en el Sistema Inventario, pueda que se deba a una promoción... continuando la ejecución");
			}
			else
			{
				int cantidadDisminuir = referencias2.get(SKU);
				try
				{
					ref.disminuirInventario(cantidadDisminuir);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		}
	}


	public void eliminarLotesVencidos() 
	{
		//Identificar los productos para los que hay perdidas y generarlas
		this.calcularPerdidas();
		//Eliminar lotes vencidos definitivamente
		lotes.keySet().removeIf(key -> lotes.get(key).getProducto().getFechaVenc().isBefore(LocalDate.now()));

	}


	private void calcularPerdidas() 
	{
		Iterator<String> iterator = lotes.keySet().iterator();
		while(iterator.hasNext())
		{
			String llave = iterator.next();
			Producto prod = lotes.get(llave).getProducto();
			if (prod.getFechaVenc().isBefore(LocalDate.now()))
			{
				prod.getReferencia().eliminarProducto(prod);
			}
		}
	}
	
		
	
}
