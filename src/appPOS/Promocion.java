package appPOS;
import java.io.Serializable;
import java.time.LocalDate;

import appInventario.Producto;

public class Promocion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2488331718435447398L;
	
	private String codigo;
	private LocalDate fechaInicio;
	private LocalDate fechaVencimiento;
	private String SKUproductoAplicable;
	

	public Promocion(String codigo, LocalDate fechaInicio, LocalDate fechaVencimiento, String SKUproductoAplicable) {
		
		this.codigo = codigo;
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		this.SKUproductoAplicable = SKUproductoAplicable;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public String getProductoAplicable() {
		return SKUproductoAplicable;
	}
	
	public void setProductoAplicable(String SKUproducto) {
		this.SKUproductoAplicable = SKUproducto;
	}
	
	public double getBeneficio() {
		return 0;
	}
	
}
