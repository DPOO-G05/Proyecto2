package appInventario;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductoRefrigerado extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7053841866909463357L;
	private double tempRefrigerado;

	public ProductoRefrigerado(String codigo, String vencimiento, String[] charac, Referencia referencia, LocalDate fechaIngreso) {
		super(codigo, vencimiento, charac, referencia, fechaIngreso);
	}

	public double getTempRefrigerado() {
		return tempRefrigerado;
	}

	public void setTempRefrigerado(double tempRefrigerado) {
		this.tempRefrigerado = tempRefrigerado;
	}

}
