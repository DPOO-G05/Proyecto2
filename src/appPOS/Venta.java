package appPOS;
import java.time.*;
import java.util.ArrayList;


public class Venta {
	
	private int puntos;
	private float monto;
	private LocalDate fecha;
	private ArrayList<String> listaProductos; 
	
	//Metodos ;
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return LocalDate.now();
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}	
	
	public ArrayList<String> getListaProductos() {
		return listaProductos;
	}


	public void agregarProducto(String product,ArrayList<String> listaProd) {
		this.listaProductos.add(product);
	}
	
	public void calcularPrecioCobrar(String precio) {
		
	}
	public float calcularTotal() {
		float total = 0;
		return total;
		
	}
	
	public void generarRecibo() {
		Recibo recibo = new Recibo();
		recibo.setResumenPuntos("Los puntos acumulados con esta compra son " + this.getPuntos().toString());
		ArrayList<String> productos = this.getListaProductos();
		for (String p : productos) {
			String s = "";
			s += productos.get(p);
		}
		recibo.setResumenProductos("Resumen de los productos: " + s );
		
	}

}
