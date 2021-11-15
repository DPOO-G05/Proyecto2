package appInventario;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductoCongelado extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8964877588819253175L;
	private double tempCongelacion;
	
	public ProductoCongelado(String codigo, String vencimiento,String[] charac, Referencia referencia, LocalDate fechaIngreso) {
		super(codigo, vencimiento,charac, referencia, fechaIngreso);
	}

	public double getTempCongelacion() {
		return tempCongelacion;
	}

	public void setTempCongelacion(double tempCongelacion) {
		this.tempCongelacion = tempCongelacion;
	}
	
	

}
