package appInventario;

import java.io.Serializable;

public class ProductoCongelado extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8964877588819253175L;
	private double tempCongelacion;
	
	public ProductoCongelado(String codigo, String vencimiento,String[] charac, Referencia referencia) {
		super(codigo, vencimiento,charac, referencia);
	}

	public double getTempCongelacion() {
		return tempCongelacion;
	}

	public void setTempCongelacion(double tempCongelacion) {
		this.tempCongelacion = tempCongelacion;
	}
	
	

}
