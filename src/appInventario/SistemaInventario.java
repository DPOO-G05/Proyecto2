package appInventario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

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
	
		
	
}
