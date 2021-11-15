package appInventario;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductoFresco extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9120167411147338417L;

	public ProductoFresco(String codigo, String vencimiento, String[] charac, Referencia referencia, LocalDate fechaIngreso) {
		super(codigo, vencimiento,charac, referencia, fechaIngreso);
	}

}
