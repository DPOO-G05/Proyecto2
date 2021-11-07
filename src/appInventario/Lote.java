package appInventario;

import java.io.Serializable;
import java.time.LocalDate;

public class Lote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5061802896147678521L;
	private String id;
	private LocalDate vencimiento;
	private Producto producto;
	private double precioVenta;
	private double costoProveedor;
	private double unidades;
	
	public Lote(String id, LocalDate venc, Producto prod, double preVen, double cost, double uni)
	{

		this.id = id;
		this.vencimiento = venc;
		this.producto = prod;
		this.precioVenta = preVen;
		this.costoProveedor = cost;
		this.unidades = uni;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
