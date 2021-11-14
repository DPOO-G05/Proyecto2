package interfaz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import appInventario.SistemaInventario;

public class CoordinadorUI {

	private UI principal;
	private SistemaInventario sistemaInventario;

	CoordinadorUI(UI principal)
	{
		this.principal = principal;
		cargarInformacion();
		desplegarInformacion();
	}
	
	
	public void guardarInformacion()
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
            
            System.out.println("Información Guardada Exitosamente");
        }
        catch (IOException e) {
            e.printStackTrace();
        }	
	}


	
	private void cargarInformacion()
	{
		//Deserializar el sistemaInventario y asignarlo de nuevo a la aplicación.
  
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
  
        System.out.println("Información Cargada Exitosamente");
 
	}
	
	private void desplegarInformacion()
	{
		int numCategorias = this.sistemaInventario.getCategorias().size();
		int numRef = this.sistemaInventario.getReferencias().size(); 
		int numLotes = this.sistemaInventario.getLotes().size();
		
		System.out.printf("***********************\n 1. Número de Categorias: %d\n 2. Número de Referencias: %d\n 3. Número de Lotes: %d\n", numCategorias, numRef, numLotes);
	}
	
	public SistemaInventario getSistemaInventario()
	{
		return this.sistemaInventario;
	}
	

}
