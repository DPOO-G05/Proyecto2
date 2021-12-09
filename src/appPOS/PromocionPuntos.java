package appPOS;

import java.time.LocalDate;

import appInventario.Producto;

public class PromocionPuntos extends Promocion {
	
	private double multiplicador;

	public PromocionPuntos(String codigo, LocalDate fechaInicio, LocalDate fechaVencimiento,
			String productoAplicable) {
		super(codigo, fechaInicio, fechaVencimiento, productoAplicable);
		// TODO Auto-generated constructor stub
	}
	
	public double getMultiplicador() {
		return multiplicador;
	}
	
	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

}
