package appPOS;

import java.time.LocalDate;

import appInventario.Producto;

public class PromocionRegalo extends Promocion {
	

	private int pagueNumero; // pague 2
	private int recibaNumero; // lleve 1 extra

	
	public PromocionRegalo(String codigo, LocalDate fechaInicio, LocalDate fechaVencimiento,
			String productoAplicable) {
		super(codigo, fechaInicio, fechaVencimiento, productoAplicable);
		// TODO Auto-generated constructor stub
	}

	
	public int getPagueNumero() {
		return pagueNumero;
	}
	
	public void setPagueNumero(int pagueNumero) {
		this.pagueNumero = pagueNumero;
	}
	
	public int getRecibaNumero() {
		return pagueNumero;
	}
	
	public void setRecibaNumero(int recibaNumero) {
		this.recibaNumero = recibaNumero;
	}
	
	
	
	

}
