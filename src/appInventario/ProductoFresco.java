package appInventario;

import java.io.Serializable;

public class ProductoFresco extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9120167411147338417L;

	public ProductoFresco(String codigo, String vencimiento, String[] charac, Referencia referencia) {
		super(codigo, vencimiento,charac, referencia);
	}

}
