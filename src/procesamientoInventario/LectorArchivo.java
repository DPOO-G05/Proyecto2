package procesamientoInventario;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LectorArchivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8934289369761744497L;
	ArrayList<ArrayList<String>> datos;

	
	public LectorArchivo()
	{
		this.datos = new ArrayList<ArrayList<String>>();
	}
	
	
	
	public void leerArchivo() throws IOException
	{
		try
		{
			BufferedReader lectura = new BufferedReader(new FileReader("./src/consolaInventario/lotes.csv"));
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