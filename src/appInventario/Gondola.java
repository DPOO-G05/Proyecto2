package appInventario;

import java.io.Serializable;
import java.util.*;

public class Gondola implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4340926957313791660L;
	private HashMap<String, Referencia> referencias;
	private Categoria categoria;
	private String nombre;
	
	public Gondola(String nombre)
	{
		this.referencias = new HashMap<String,Referencia>();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	public HashMap<String,Referencia> getReferencias()
	{
		return this.referencias;
	}
}
