package procesamientoInventario;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import appInventario.*;

public class LectorProducto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7431732051467359728L;

	private LectorArchivo lector;
	
	private static final String REFRIGERADO = "REFRIGERADO";

	private static final String CONGELADO = "CONGELADO";

	private static final String FRESCO = "FRESCO";

	public LectorArchivo getLector() {
		return lector;
	}

	public void setLector(LectorArchivo lector) {
		this.lector = lector;
	}
	

	public void getProductos(HashMap<String, Referencia> referencias, HashMap<String, Categoria> categorias)
	{
		/*1. Iterar sobre cada linea extrayendo:
		 * 1) Información del producto
		 * 2) Información de la Categoria 
		 * 3) Información Gondola
		 * 4) Crear el producto particular
		 * 5) Asociar el producto particular a la referencia (es posible que toque crearla).
		 * 6) Asociar la referencia al mapa de ser necesario.
		 * 7) Asocial la referencia a la gondola de ser necesario.
	*/	

		ArrayList<ArrayList<String>> data = this.lector.getDatos();
		
		for (ArrayList<String> linea : data)
		{
			String[] charac = new String[8];

			//1. Extraer la información del producto 
			String vencimiento = linea.get(1).strip().toUpperCase();
			String SKU = linea.get(2).strip().toUpperCase();
			String nombre = linea.get(3).strip().toUpperCase();
			charac[0] = nombre;
			String categoria = linea.get(4).strip().toUpperCase();
			String gondola = linea.get(5).strip().toUpperCase();
			//    - Verificar que la gondola no sea vacia 
			if (gondola.equals(""))
			{
				gondola = categoria;
			}
			String marca = linea.get(6).strip().toUpperCase();
			charac[1] = marca;
			String empacadoStr = linea.get(7).toUpperCase();
			charac[2] = empacadoStr;
			int unidades = Integer.parseInt(linea.get(8));
			charac[3] = linea.get(8);
			double costoUnidad = Double.parseDouble(linea.get(9));
			charac[4] = linea.get(9);
			double precioUnidad = Double.parseDouble(linea.get(10));
			charac[5] = linea.get(10);
			String pesoNeto = linea.get(11).strip().toUpperCase();
			charac[6] = pesoNeto;
			String unidadMedida = linea.get(12).strip().toUpperCase(); 
			charac[7] = unidadMedida;
			//2. Crear o buscar la referencia
			Referencia referencia;
			if (!referencias.containsKey(SKU))
			{
				Referencia ref = new Referencia(SKU);
				referencias.put(SKU, ref);
			}
			
			referencia = referencias.get(SKU);
			
			//3. Crear el producto dependiendo del tipo
			if (categoria.equals(REFRIGERADO))
			{
				ProductoRefrigerado producto = new ProductoRefrigerado(SKU, vencimiento, charac, referencia);
				double temp = Double.parseDouble(linea.get(13));
				producto.setTempRefrigerado(temp);
				referencia.agregarProducto(producto);
				referencia.actualizarUnidades(producto.getUnidadesRestantes());
			}
			else if (categoria.equals(CONGELADO))
			{
				ProductoCongelado producto = new ProductoCongelado(SKU,vencimiento, charac, referencia);
				double temp = Double.parseDouble(linea.get(14));
				producto.setTempCongelacion(temp);
				referencia.agregarProducto(producto);
				referencia.actualizarUnidades(producto.getUnidadesRestantes());
			}
			else if (categoria.equals(FRESCO))
			{
				ProductoFresco producto = new ProductoFresco(SKU, vencimiento, charac, referencia);
				referencia.agregarProducto(producto);
				referencia.actualizarUnidades(producto.getUnidadesRestantes());
			}
			else
			{
				ProductoGondola producto = new ProductoGondola(SKU,vencimiento, charac, referencia);
				Categoria cat = categorias.get(categoria);
				Gondola gond = cat.getGondolas().get(gondola);
				producto.setGondola(gond);
				referencia.agregarProducto(producto);
				referencia.actualizarUnidades(producto.getUnidadesRestantes());
				gond.getReferencias().put(SKU, referencia);
			}
		}

	}
}
