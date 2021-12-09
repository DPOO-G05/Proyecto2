package appPOS;

import java.time.LocalDate;

import appInventario.Producto;

public class PromocionCombo extends Promocion {
	
	private double descuento; 
	
	public PromocionCombo(String codigo, LocalDate fechaInicio, LocalDate fechaVencimiento,
			String productoAplicable) {
		super(codigo, fechaInicio, fechaVencimiento, productoAplicable);
		// TODO Auto-generated constructor stub
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
@Override
	
	public double getBeneficio() {
		return descuento;
	}
	
	

}
