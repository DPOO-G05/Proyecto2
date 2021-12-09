package procesamientoPOS;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Lote;
import appInventario.SistemaInventario;
import appPOS.Promocion;
import appPOS.SistemaPOS;
import procesamientoInventario.LectorArchivo;

public class ConstructorArchivoPOS  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4636644829552526565L;

	private LectorPromociones lectProm;
	
	private SistemaPOS principalPOS;
	
	private SistemaInventario principalINV;
	
	public ConstructorArchivoPOS(SistemaPOS principalPOS, SistemaInventario principalINV) {
		this.principalPOS = principalPOS;
		this.principalINV = principalINV;
		this.lectProm = new LectorPromociones(principalPOS,principalINV);
	}
	
	public void leerCSV(File archivo) {
		LectorArchivoPOS lector = new LectorArchivoPOS();
		this.lectProm.setLector(lector);
		
		try {
			lector.leerArchivo(archivo);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void crearPromociones() {
		HashMap<String,ArrayList<Promocion>> promociones = principalPOS.getPromociones();
		ArrayList<Promocion> promocionesArray = this.lectProm.getPromociones();
		System.out.println(promocionesArray);
		
		for (Promocion promocion: promocionesArray) {
			String SKU = promocion.getProductoAplicable();
			System.out.println(SKU);
			if (!promociones.containsKey(SKU)) {
				System.out.println("paso");
				promociones.put(SKU, new ArrayList<Promocion>());
				promociones.get(SKU).add(promocion);
			}
			
			else {
				promociones.get(SKU).add(promocion);
			}
			
		}
		System.out.println("Creador");
		System.out.println(principalPOS.getPromociones());
		
	}
	
	

}
