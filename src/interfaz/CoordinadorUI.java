package interfaz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Categoria;
import appInventario.Gondola;
import appInventario.Lote;
import appInventario.Producto;
import appInventario.ProductoCongelado;
import appInventario.ProductoFresco;
import appInventario.ProductoGondola;
import appInventario.ProductoRefrigerado;
import appInventario.Referencia;
import appInventario.SistemaInventario;
import interfaz.interfazInventario.FormularioProducto;

public class CoordinadorUI {

	private UI principal;
	private SistemaInventario sistemaInventario;
	private final String FRESCO = "FRESCO";
	private final String CONGELADO = "CONGELADO";
	private final String REFRIGERADO = "REFRIGERADO";

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
  
            //myObjectOutStream.writeObject(this.sistemaInventario);
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
	
	public void agregarNuevoProducto(ArrayList<String> caracteristicas, FormularioProducto formulario)
	{
		//Indice	información
		//0			nombre
		//1			SKU
		//2			categoria
		//3			gondola
		//4			marca
		//5			empacado ("Y" o "N")
		//6			cantidad
		//7			costo
		//8			precio
		//9			pesoNeto
		//10		unidad
		//11		tempRef
		//12		tempCongelado
		//13		idLote
		//14		vencimiento (YYYY-MM-DD)
		//15		tieneImagen ("NO" o "SI) - la imagen
	
		//1. Extraer toda la información:
		String nombre = caracteristicas.get(0);
		String SKU = caracteristicas.get(1);
		String catStr = caracteristicas.get(2);
		String gondStr = caracteristicas.get(3);
		String marca = caracteristicas.get(4);
		String empacado = caracteristicas.get(5);
		String cantidad = caracteristicas.get(6);
		String costo = caracteristicas.get(7);
		String precio = caracteristicas.get(8);
		String pesoNeto = caracteristicas.get(9);
		String unidad = caracteristicas.get(10);
		String tempRef = caracteristicas.get(11);
		String tempCongelado = caracteristicas.get(12);
		String idLote = caracteristicas.get(13);
		String vencimiento = caracteristicas.get(14);
		boolean tieneImagen = !(formulario.getImagen() == null);
		File imagen = formulario.getImagen();
		
		//2. Construir insumos de los Constructores
		String[] charac = {nombre, marca, empacado, cantidad, costo, precio,pesoNeto,unidad};
	
		//
		HashMap<String, Categoria> categorias  = this.getSistemaInventario().getCategorias();
		
		//Verificar si existe la categoria


		boolean existeCat = categorias.containsKey(catStr);

		Categoria categoria;

		if (existeCat)
		{
			//Recuperarla y asignar
			categoria = categorias.get(catStr);
		}
		else
		{
			//Crear Categoria
			categoria = new Categoria(catStr);
			this.sistemaInventario.getCategorias().put(catStr, categoria);
		}
		
		
		//Verificar si existe la gondola
		
		HashMap<String, Gondola> gondolas = categoria.getGondolas(); 
		boolean existeGond = gondolas.containsKey(gondStr); 
		
		Gondola gondola;
		if (existeGond)
		{
			gondola = gondolas.get(gondStr);
		}
		else
		{
			//Crear nueva gondola
			gondola = new Gondola(gondStr);
			categoria.agregarGondola(gondola);
			gondola.setCategoria(categoria);
		}

		// Verificar si existe la referencia
		boolean existeRef = gondola.getReferencias().containsKey(SKU);
		Referencia ref;
		if (!existeRef)
		{
			ref = new Referencia(SKU, gondola);
			this.sistemaInventario.getReferencias().put(SKU, ref);
			gondola.getReferencias().put(SKU, ref);
		}
		else
		{
			ref = gondola.getReferencias().get(SKU);
		}

		
		
		
		
		Producto prod;
		//Crear el producto
		if(catStr.equals(FRESCO)|| gondStr.equals(FRESCO))
		{
			ProductoFresco producto = new ProductoFresco(SKU, vencimiento, charac, ref, LocalDate.now()); 
			ref.agregarProducto(producto);
			ref.actualizarUnidades(producto.getUnidadesRestantes());
			prod = producto;

		}
		else if(catStr.equals(CONGELADO)|| gondStr.equals(CONGELADO))
		{
			ProductoCongelado producto = new ProductoCongelado(SKU, vencimiento, charac, ref, LocalDate.now());
			producto.setTempCongelacion(Double.parseDouble(tempCongelado));
			ref.agregarProducto(producto);
			ref.actualizarUnidades(producto.getUnidadesRestantes());
			prod = producto;
		}
		else if(catStr.equals(REFRIGERADO)|| gondStr.equals(REFRIGERADO))
		{
			ProductoRefrigerado producto = new ProductoRefrigerado(SKU, vencimiento, charac, ref, LocalDate.now());
			producto.setTempRefrigerado(Double.parseDouble(tempRef));
			ref.agregarProducto(producto);
			ref.actualizarUnidades(producto.getUnidadesRestantes());
			prod = producto;

		}
		else
		{
			ProductoGondola producto = new ProductoGondola(SKU, vencimiento, charac, ref, LocalDate.now());
			producto.setGondola(gondola);
			ref.agregarProducto(producto);
			ref.actualizarUnidades(producto.getUnidadesRestantes());
			prod =  producto;
		}
		
		//Crear el nuevo Lote con la información y asociarle el producto
		
		Lote lote = new Lote(idLote, LocalDate.parse(vencimiento), prod, prod.getPrecioUnidad(),prod.getCostoUnidad(),prod.getUnidadesRestantes());
		this.sistemaInventario.getLotes().put(idLote, lote);
		prod.setLote(lote);
	
		this.principal.actualizarInventario();
	}
	

}
