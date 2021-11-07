package procesamientoInventario;

import java.io.Serializable;
import java.util.ArrayList;

public class LectorGondola implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4185701996042555443L;
	private LectorArchivo lector;

	public LectorArchivo getLector() {
		return lector;
	}

	public void setLector(LectorArchivo lector) {
		this.lector = lector;
	}
	
	public ArrayList<String[]> getGondolas()
	{
		//Retorna un ArrayList de String[] donde cada
		// String[] es una relación con el formato:
		// gondola String[1]
		// categoria String[0]

		ArrayList<String[]> gondolas = new ArrayList<>();

		//Recuperar información CSV
		ArrayList<ArrayList<String>> data = lector.getDatos();
	
		//Iterar filas CSV
		for(ArrayList<String> fila :data)
		{
			// Recuperar nombre de la gondola
			String celda = fila.get(5).strip().toUpperCase();
	
			if (celda.equals(""))
			{
				//Crear gondola única para Refrigerados, Congelados y Frescos
				celda = fila.get(4).strip().toUpperCase();
			}
			//Nombre categoria
			String categoria = fila.get(4).strip().toUpperCase();
			//Asociar gondola a categoria;
			String[] relacion = {categoria,celda};
			gondolas.add(relacion);
			
		}
		
		return gondolas;
		
	}
}
