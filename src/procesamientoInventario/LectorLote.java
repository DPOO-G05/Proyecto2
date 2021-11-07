package procesamientoInventario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.*;

public class LectorLote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4283124359898487578L;

	private LectorArchivo lector;
	
	private ArrayList<Lote> lotes;

	public void setLector(LectorArchivo lector) {
		this.lector = lector;
		this.lotes = new ArrayList<>();
	}
	
	public ArrayList<Lote> getLotes(HashMap<String,Referencia> referencias)
	{
		ArrayList<ArrayList<String>> data = this.lector.getDatos();
		
		for(ArrayList<String> linea : data)
		{
			
			//Obtener información
			String SKU = linea.get(2);
			String idLote = linea.get(0);
			String vencimiento = linea.get(1);
			LocalDate venc = LocalDate.parse(vencimiento);
			double precioVenta = Double.parseDouble(linea.get(10));
			double costoProveedor = Double.parseDouble(linea.get(9));	
			double unidades = Double.parseDouble(linea.get(8));
		
			//Recuperar el producto
			Producto producto = referencias.get(SKU).getProductos().get(venc);
			
			//Crear el lote
			Lote lote = new Lote(idLote, venc, producto, precioVenta,costoProveedor,unidades);
			//Asociar el Lote al Producto
			producto.setLote(lote);

			//Actualizar la información de la referencia (precio) 
			Referencia ref = referencias.get(SKU);
			
			ref.setPrecioVenta(precioVenta);
			//Agregar el lote al array
			this.lotes.add(lote);
		}
		
		return this.lotes;

	}
	
}
