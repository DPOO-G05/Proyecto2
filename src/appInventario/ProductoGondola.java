package appInventario;

import java.io.Serializable;

public class ProductoGondola extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3400613663797205736L;
	private Gondola gondola; 
	public ProductoGondola(String codigo, String vencimiento,String[] charac, Referencia referencia) {
		super(codigo, vencimiento, charac, referencia);
	}
	
	public void setGondola(Gondola gondola)
	{
		this.gondola = gondola;
	}

}
