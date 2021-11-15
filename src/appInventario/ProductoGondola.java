package appInventario;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductoGondola extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3400613663797205736L;
	private Gondola gondola; 
	public ProductoGondola(String codigo, String vencimiento,String[] charac, Referencia referencia, LocalDate fechaIngreso) {
		super(codigo, vencimiento, charac, referencia, fechaIngreso);
	}
	
	public void setGondola(Gondola gondola)
	{
		this.gondola = gondola;
	}

}
