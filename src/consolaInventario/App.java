package consolaInventario;
import java.io.*;
import java.util.*;

import appInventario.*;
import procesamientoInventario.LectorArchivo;

public class App {

	
	private SistemaInventario sistemaInventario;

	public App() 
	{
		cargarInformacion();
		desplegarInformacion();
	}

	
	public static void main(String[] args) {
		System.out.println("Aplicaci�n Iniciada");
		
		App app = new App();
		app.desplegarMenu();

	}

	
	
	public void desplegarMenu()
	{
		//Despliega el Men� Principal de la Aplicaci�n de Inventario
		boolean continuar = true;

		while (continuar)
		{
			
			System.out.println("\n***********************\n\tMenu\n");
			System.out.println("1. Cargar Informaci�n CSV");
			System.out.println("2. Salir de la Aplicaci�n");

			int respuesta = Integer.parseInt(input("Seleccione su opci�n"));

			if (respuesta == 2)
			{
				terminar();
				continuar = false;
				System.out.println("Hasta luego");
			}
			else
			{
				ejecutar(respuesta);
			}
		}
	}
	
	private String input(String mensaje)
	{
			Scanner input = new Scanner(System.in);
			System.out.printf("%s", mensaje + ": ");
			String respuesta = input.nextLine();
			return respuesta;
		
	}
	
	private void ejecutar(int respuesta)
	{
		switch (respuesta)
		{
			case 1:
				cargarCSV();
				break;
		}
	}
	
	
	private void cargarCSV()
	{
		this.sistemaInventario.leerCSV();
		System.out.println("Informaci�n Cargada Exitosamente");
	}
	
	private void terminar()
	{
		//Serializar el sistemaInventario y guardarlo al archivo
		try {
            FileOutputStream myFileOutStream
                = new FileOutputStream(
                    "./src/persistencia/app.ser");
  
            ObjectOutputStream myObjectOutStream
                = new ObjectOutputStream(myFileOutStream);
  
            myObjectOutStream.writeObject(this.sistemaInventario);
  
            // closing FileOutputStream and
            // ObjectOutputStream
            myObjectOutStream.close();
            myFileOutStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }	
	}
	
	private void cargarInformacion()
	{
		//Deserializar el sistemaInventario y asignarlo de nuevo a la aplicaci�n.
  
		SistemaInventario sistemaInventario;
        try {
            FileInputStream fileInput = new FileInputStream("./src/persistencia/app.ser");
            ObjectInputStream objectInput
                = new ObjectInputStream(fileInput);
  
            sistemaInventario = (SistemaInventario)objectInput.readObject();
            this.sistemaInventario = sistemaInventario;
            objectInput.close();
            fileInput.close();
        }
  
        catch (IOException obj1) {
            obj1.printStackTrace();
            return;
        }
  
        catch (ClassNotFoundException obj2) {
            System.out.println("Class not found");
            obj2.printStackTrace();
            return;
        }
  
        System.out.println("Informaci�n Cargada Exitosamente");
  

	}
	
	private void desplegarInformacion()
	{
		int numCategorias = this.sistemaInventario.getCategorias().size();
		int numRef = this.sistemaInventario.getReferencias().size(); 
		int numLotes = this.sistemaInventario.getLotes().size();
		
		System.out.printf("***********************\n 1. N�mero de Categorias: %d\n 2. N�mero de Referencias: %d\n 3. N�mero de Lotes: %d\n", numCategorias, numRef, numLotes);
	}
	
	
	
}
