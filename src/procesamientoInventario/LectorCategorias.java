package procesamientoInventario;

import java.io.Serializable;
import java.util.*;
import appInventario.Categoria;

public class LectorCategorias implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8453971042751651085L;
	private LectorArchivo lector;

	public LectorArchivo getLector() {
		return lector;
	}

	public void setLector(LectorArchivo lector) {
		this.lector = lector;
	}

	
	public ArrayList<String> getCategorias()
	{

		ArrayList<String> categorias = new ArrayList<>();
	
		ArrayList<ArrayList<String>> datos = lector.getDatos();

		String celda;

		for (ArrayList<String> linea: datos)
		{
			celda = linea.get(4).strip().toUpperCase();
			categorias.add(celda);

		}
		
		return categorias;

	}
	
	
	

	
}
