package appInventario;

import java.io.Serializable;
import java.util.*;

public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4826642133222588403L;

	private HashMap<String,Gondola> gondolas;
	
	private String nombre;
	
	public Categoria(String nombre)
	{
		this.gondolas = new HashMap<String,Gondola>();
		this.nombre = nombre;
	}
	
	public void agregarGondola(Gondola gondola)
	{
		String nombreGondola = gondola.getNombre();
		//Verificar que no esta en el mapa
		if(!this.gondolas.containsKey(nombreGondola))
		{
			this.gondolas.put(nombreGondola, gondola);
		}

	}

	public HashMap<String, Gondola> getGondolas() {
		return gondolas;
	}

}
