package interfaz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.DefaultListModel;

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
import appPOS.Cliente;
import appPOS.Promocion;
import appPOS.SistemaPOS;
import appPOS.Venta;
import interfaz.interfazInventario.FormularioProducto;

public class CoordinadorUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546555423014517128L;
	private UI principal;
	private SistemaInventario sistemaInventario;
	public SistemaPOS sistemaPos;
	private final String FRESCO = "FRESCO";
	private final String CONGELADO = "CONGELADO";
	private final String REFRIGERADO = "REFRIGERADO";

	CoordinadorUI(UI principal)
	{
		this.principal = principal;
		this.sistemaPos = new SistemaPOS(this);
		cargarInformacion();
		desplegarInformacion();
		File archivo = new File("/Proyecto2/src/consolaInventario/promociones.csv");
		this.sistemaPos.constructorArchivoPOS.leerCSV(archivo);
		this.sistemaPos.constructorArchivoPOS.crearPromociones();
		
	
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
            myObjectOutStream.writeObject(this.sistemaInventario);
            FileOutputStream myFileOutPOS
                = new FileOutputStream(
                    "./src/persistencia/pos.ser");
  
            ObjectOutputStream myObjectOutPOS
                = new ObjectOutputStream(myFileOutPOS);
            myObjectOutPOS.writeObject(this.sistemaPos);
            //closing FileOutputStream and
            //ObjectOutputStream
            myObjectOutStream.close();
            myFileOutStream.close();
            myObjectOutPOS.close();
            myFileOutPOS.close();
            
            System.out.println("Informaci�n Guardada Exitosamente");
        }
        catch (IOException e) {
            e.printStackTrace();
        }	
	}


	
	private void cargarInformacion()
	{
		//Deserializar el sistemaInventario y asignarlo de nuevo a la aplicaci�n.
  
		SistemaInventario sistemaInventario;
		SistemaPOS sistemaPos;
        try {
            FileInputStream fileInput = new FileInputStream("./src/persistencia/app.ser");
            FileInputStream inputPOS = new FileInputStream("./src/persistencia/pos.ser");
            ObjectInputStream objectInput
        		= new ObjectInputStream(fileInput);
            ObjectInputStream posInput = new ObjectInputStream(inputPOS);
  
            sistemaInventario = (SistemaInventario)objectInput.readObject();
            sistemaPos =new SistemaPOS(this);
            this.sistemaPos =  sistemaPos;
            this.sistemaInventario = sistemaInventario; 
            objectInput.close();
            fileInput.close();
            posInput.close();
            inputPOS.close();

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
	
	public SistemaInventario getSistemaInventario()
	{
		return this.sistemaInventario;
	}
	
	public void agregarNuevoProducto(ArrayList<String> caracteristicas, FormularioProducto formulario)
	{
		//Indice	informaci�n
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
	
		//1. Extraer toda la informaci�n:
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
			ref.setImagen(formulario.getImagen());
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
		
		//Crear el nuevo Lote con la informaci�n y asociarle el producto
		
		Lote lote = new Lote(idLote, LocalDate.parse(vencimiento), prod, prod.getPrecioUnidad(),prod.getCostoUnidad(),prod.getUnidadesRestantes());
		this.sistemaInventario.getLotes().put(idLote, lote);
		prod.setLote(lote);
	
		this.principal.actualizarInventario();
	}
	
	public void leerCSV(File archivo)
	{
		this.sistemaInventario.leerCSV(archivo);
	}
	
	public void eliminarVencidos()
	{
		HashMap<String, Lote> lotes =  this.getSistemaInventario().getLotes();
		
		Set<String> llaves = lotes.keySet();
		
		for(String llave: llaves)
		{
			Lote lote =  lotes.get(llave);
			String key = llave;
			Producto prod = lote.getProducto();  
			if(prod.getFechaVenc().isBefore(LocalDate.now()))
			{
				lotes.remove(key);
				prod.getReferencia().getProductos().remove(prod.getFechaVenc());
				lote = null;
				prod = null;
			}
		}
		
	}
	
	public void eliminarPromocionesVencidas()
	{
		HashMap<String, ArrayList<Promocion>> promociones =  this.sistemaPos.getPromociones();
		
		Set<String> llaves = promociones.keySet();

		for(String llave: llaves)
		{
			ArrayList<Promocion> listaProms =  promociones.get(llave);
			
			for(Promocion promocion: listaProms) {
				if(promocion.getFechaInicio().isAfter(LocalDate.now()) && promocion.getFechaVencimiento().isBefore(LocalDate.now())) {
					listaProms.remove(promocion);
				}
			}
			
			if(listaProms.isEmpty()) {
				promociones.remove(llave);
			}
			
		}
			
	}
	
	public boolean existeCliente(String cedula)
	{
		boolean respuesta = this.sistemaPos.existeCliente(cedula);
		return respuesta;
	}
	
	public Cliente buscarCliente(String cedula)
	{
		return this.sistemaPos.buscarCliente(cedula);
	}
	
	public Cliente crearCliente(String cedula)
	{
		return this.sistemaPos.crearCliente(cedula);
	}


	public boolean esAfiliado(String cedula)
	{
		boolean respuesta = this.sistemaPos.esAfiliado(cedula);
		return respuesta;

	}


	public void afiliarCliente(ArrayList<String> atributos, String cedula) {
		this.sistemaPos.afiliarCliente(atributos, cedula);
	}


	public void iniciarVenta(Cliente cliente) {

		this.sistemaPos.iniciarVenta(cliente);

	}


	public void popularProductos(DefaultListModel model) {
		HashMap<String, Referencia> referencias = this.sistemaInventario.getReferencias();
		for (String SKU: referencias.keySet())
		{
			Referencia ref = referencias.get(SKU);
			model.addElement(ref);
		}
	}


	public void agregarProductoVenta(String SKU, String recibo) {
		try {
			
			sistemaPos.agregarProductoVenta(SKU, recibo);


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}


	public Referencia getReferencia(String SKU) {
		return this.sistemaInventario.buscarReferencia(SKU);
	}


	public Venta getVentaActual() {
		return this.sistemaPos.getVentaActual();
	}
	
	public double getTotalVenta()
	{
		Venta actual = getVentaActual();
		return actual.calcularTotal();
	}


	public ArrayList<String> getProductosActuales() {
		ArrayList<String> respuesta = new ArrayList<>();

		Venta actual = getVentaActual();
		
		HashMap<String,Integer> productos = actual.getProductos();
	
		for (String llave: productos.keySet())
		{
			if (sistemaInventario.getReferencias().containsKey(llave)) {
				int cantidad = productos.get(llave);
				String cantidadStr = Integer.toString(cantidad);
				Referencia referencia = getReferencia(llave);
				String nombre = referencia.getNombre();
				double precio = referencia.getPrecioVenta();
				double total = precio * cantidad;
				String totalStr = Double.toString(total);
				
				String row = nombre + "," + cantidadStr + "," + total;
				
				respuesta.add(row);
			}
			
			else if (sistemaPos.getPromociones().containsKey(llave)){
				int cantidad = productos.get(llave);
				String cantidadStr = Integer.toString(cantidad);
				Promocion promocion = sistemaPos.getPromociones().get(llave).get(0);
				String nombre = promocion.getCodigo();
				double precio = 0;
				double total = precio * cantidad;
				String totalStr = Double.toString(total);
				
				String row = nombre + "," + cantidadStr + "," + totalStr;
				
				respuesta.add(row);
			}
		
			
		}
		return respuesta;
	}


	public void agregarVentaHistorico(Venta ventaActual) {

		this.sistemaPos.agregarVentaHistorico(ventaActual);

	}
}
