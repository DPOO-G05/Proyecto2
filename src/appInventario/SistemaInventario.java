package appInventario;

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

	
	public void leerCSV()
	{
		this.constructorArchivo.leerCSV();
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
	
	public void guardarInformacion()
	{
		HashMap<String, String> foodType = new HashMap<>();
		  
        // storing data in HashMap
        foodType.put("Burger", "Fastfood");
        foodType.put("Cherries", "Fruit");
        foodType.put("Fish", "Seafood");
        foodType.put("Spinach", "Vegetables");
        foodType.put("Chicken", "Protein-Rich");
		 // try catch block
        try {
            FileOutputStream myFileOutStream
                = new FileOutputStream(
                    "./src/persistencia/db.ser");
  
            ObjectOutputStream myObjectOutStream
                = new ObjectOutputStream(myFileOutStream);
  
            myObjectOutStream.writeObject(foodType);
  
            // closing FileOutputStream and
            // ObjectOutputStream
            myObjectOutStream.close();
            myFileOutStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }	
	}
	
	public void cargarInformacion()
	{
		HashMap<String, String> newHashMap = null;
		  
        try {
            FileInputStream fileInput = new FileInputStream("./src/persistencia/db.ser");
            ObjectInputStream objectInput
                = new ObjectInputStream(fileInput);
  
            newHashMap = (HashMap)objectInput.readObject();
  
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
  
        System.out.println("Deserializing  HashMap..");
  
        // Displaying content in "newHashMap.txt" using
        // Iterator
        Set set = newHashMap.entrySet();
        Iterator iterator = set.iterator();
  
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
  
            System.out.print("key : " + entry.getKey()
                             + " & Value : ");
            System.out.println(entry.getValue());
        }
    }	
	
	
}
