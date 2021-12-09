package procesamientoPOS;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import appInventario.Lote;
import appInventario.SistemaInventario;
import appPOS.Promocion;
import appPOS.PromocionCombo;
import appPOS.PromocionDescuento;
import appPOS.PromocionPuntos;
import appPOS.PromocionRegalo;
import appPOS.SistemaPOS;

public class LectorPromociones implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1544794976145924025L;

	private LectorArchivoPOS lector;
	
	private SistemaPOS principalPOS;
	
	private SistemaInventario principalINV;
	
	private ArrayList<Promocion> promociones;

	
	public LectorPromociones(SistemaPOS principalPOS, SistemaInventario principalINV ) {
		this.principalPOS = principalPOS;
		this.principalINV = principalINV;
		this.promociones = new ArrayList<>();
	}

	public LectorArchivoPOS getLector() {
		return lector;
	}

	public void setLector(LectorArchivoPOS lector) {
		this.lector = lector;
	}
	
	public ArrayList<Promocion> getPromociones(){
		ArrayList<ArrayList<String>> data = this.lector.getDatos();
		for(ArrayList<String> linea : data)
		{
			String codigo = linea.get(0);
			String tipo = linea.get(1);
			String SKUproductoAplicable = linea.get(2);
			String fechaIn = linea.get(3);
			LocalDate fechaInicio = LocalDate.parse(fechaIn);
			String fechaVe = linea.get(4);
			LocalDate fechaVencimiento = LocalDate.parse(fechaVe);
			double descuento = Double.parseDouble(linea.get(5));
			int pagueNumero = Integer.parseInt(linea.get(6));
			int recibaNumero = Integer.parseInt(linea.get(7));
			double multiplicador = Double.parseDouble(linea.get(8));
			
			
			if (tipo.equals("combo")) {
				PromocionCombo promocion = new PromocionCombo(codigo,fechaInicio,fechaVencimiento,SKUproductoAplicable);
				promocion.setDescuento(descuento);
				this.promociones.add(promocion);
			}
			if (tipo.equals("descuento")) {
				PromocionDescuento promocion = new PromocionDescuento(codigo,fechaInicio,fechaVencimiento,SKUproductoAplicable);
				promocion.setDescuento(descuento);
				this.promociones.add(promocion);
			}
			if (tipo.equals("puntos")) {
				PromocionPuntos promocion = new PromocionPuntos(codigo,fechaInicio,fechaVencimiento,SKUproductoAplicable);
				promocion.setMultiplicador(multiplicador);
				this.promociones.add(promocion);
			}
			if (tipo.equals("regalo")) {
				PromocionRegalo promocion = new PromocionRegalo(codigo,fechaInicio,fechaVencimiento,SKUproductoAplicable);
				promocion.setPagueNumero(pagueNumero);
				promocion.setRecibaNumero(recibaNumero);
				this.promociones.add(promocion);
			}
			
			
		}
		
		return promociones;
	}
	
}
