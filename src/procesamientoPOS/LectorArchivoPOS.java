package procesamientoPOS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorArchivoPOS implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 5389315848484745744L;
	
	ArrayList<ArrayList<String>> datos;

	
	public LectorArchivoPOS()
	{
		this.datos = new ArrayList<ArrayList<String>>();
	}
	
	
	
	public void leerArchivo(File archivo) throws IOException
	{
		try
		{
			BufferedReader lectura = new BufferedReader(new FileReader(archivo));
			lectura.readLine();
			String linea = lectura.readLine();
		
			while (linea != null)
			{
				String[] valores = linea.split(",");
				
				ArrayList<String> info = new ArrayList<>(Arrays.asList(valores));
				
				this.datos.add(info);
				
				linea = lectura.readLine();
				
			}
			
			lectura.close();
		
			imprimirContenido();
			
		}
		catch (FileNotFoundException e)
		{

			e.printStackTrace();

		}
		
		
		
	}
	
	public void imprimirContenido()
	{
		for(ArrayList<String> fila: this.datos)
		{
			for(String valor: fila)
			{
				System.out.printf("%s\n", valor);
			}
		}
	}



	public ArrayList<ArrayList<String>> getDatos() {
		return datos;
	}



	public void setDatos(ArrayList<ArrayList<String>> datos) {
		this.datos = datos;
	}
}
