package procesamientoInventario;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Categoria;
import appInventario.Gondola;
import appInventario.Lote;
import appInventario.Producto;
import appInventario.ProductoCongelado;
import appInventario.ProductoFresco;
import appInventario.ProductoRefrigerado;
import appInventario.Referencia;
import appInventario.SistemaInventario;

public class ConstructorArchivo implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7776037060304417834L;
	private LectorCategorias lecCat;
	private LectorGondola lecGond;
	private LectorLote lecLot;
	private LectorProducto lecProd;

	private SistemaInventario principal;

	public ConstructorArchivo(SistemaInventario principal)
	{
		this.principal = principal;
		
		this.lecCat = new LectorCategorias();
		this.lecGond = new LectorGondola();
		this.lecLot = new LectorLote();
		this.lecProd = new LectorProducto();

	}

	
	public void leerCSV()
	{
		LectorArchivo lector = new LectorArchivo();
		this.lecCat.setLector(lector);
		this.lecGond.setLector(lector);
		this.lecLot.setLector(lector);
		this.lecProd.setLector(lector);
		
		try {
			lector.leerArchivo();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		
	}
	
	public void crearCategorias()
	{
		ArrayList<String> csvCats= lecCat.getCategorias();
		HashMap<String, Categoria> categorias = principal.getCategorias();
		for(String nombre: csvCats)
		{
			
			//Si no está en las categorias, crear y agregar
			if(!categorias.containsKey(nombre))
			{
				Categoria cat = new Categoria(nombre);
				categorias.put(nombre, cat);
			}

		}
		
	}
	
	public void crearGondolas()
	{

		ArrayList<String[]> gondolas = lecGond.getGondolas(); 
		HashMap<String, Categoria> categorias = principal.getCategorias();

		
		for(String[] relacion: gondolas)
		{
			String categoria = relacion[0];
			String gond = relacion[1];

			//Verificar que la categoria ya existe
			if (categorias.containsKey(categoria))
			{
				//Buscar y agregar o crear gondola
				Gondola gondola;
				Categoria cat = categorias.get(categoria);
				HashMap<String,Gondola> gondolasMap = cat.getGondolas();
				if (!gondolasMap.containsKey(gond))
				{
					gondola = new Gondola(gond);
					gondolasMap.put(gond, gondola);
					gondola.setCategoria(cat);
				}

			}
			else
			{
				System.out.println("Error: Debe crear la categoria antes de intentar agregar la gondola");
			}
		}
	}
	
	
	public void crearLotes()
	{
		HashMap<String, Referencia> referencias = principal.getReferencias(); 
		HashMap<String, Lote> lotes = principal.getLotes();
		//Leer la información de los lotes de la data del CSV
		ArrayList<Lote> lotesArr = this.lecLot.getLotes(referencias);
		
		for (Lote lote: lotesArr)
		{
			String id = lote.getId();
			//Verificar que no se encuentre en el mapa
			if (!lotes.containsKey(id))
			{
				lotes.put(id, lote);
			}
			else
			{
				continue;
			}
		}
	}
	
	
	public void crearReferencias()
	{
		this.lecProd.getProductos(principal.getReferencias(), principal.getCategorias());
	}
	
	
	
}
