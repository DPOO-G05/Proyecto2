package appPOS;
import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

import appInventario.Producto;
import appInventario.Referencia;


public class Venta implements Serializable {
	
	private Cliente cliente;
	private int puntos;
	private String id;
	private String recibo;
	private float monto;
	private LocalDate fecha;
	private HashMap<String,Integer> listaReferencias; 
	
	public Venta(Cliente cliente,LocalDate fecha)
	{
		this.fecha = fecha;
		this.cliente = cliente;
		this.id = fecha.toString() + "," + cliente.getCedula();
		this.listaReferencias = new HashMap<>();
		this.monto = 0;
		this.puntos = 0;
	}

	public void agregarProducto(SistemaPOS sisPOS, Referencia ref, boolean acumulaPuntos, String recibo) {
		
		int unidades; 
		if (!listaReferencias.containsKey(ref.getSKU()))
		{
			this.listaReferencias.put(ref.getSKU(),1);
			unidades = this.listaReferencias.get(ref.getSKU());
		}
		else
		{
			unidades = this.listaReferencias.get(ref.getSKU());
			unidades += 1;
			this.listaReferencias.put(ref.getSKU(),unidades);
		}
		
		agregarMonto(sisPOS, ref);
		//this.monto += ref.getPrecioVenta();

		if (acumulaPuntos)
		{
			agregarPuntos(sisPOS,ref);
			
		}
		
		revisarRegalo(sisPOS,ref);
		
		this.recibo = recibo;
		
		
	}
	
	
	public void agregarMonto(SistemaPOS sisPOS, Referencia ref) {
		String SKU = ref.getSKU();
		if (sisPOS.getPromociones().containsKey(SKU)) {
			var listaPromociones = sisPOS.getPromociones().get(SKU);
			var promocion = listaPromociones.get(0);
			if(promocion.getClass()==PromocionDescuento.class || promocion.getClass() == PromocionCombo.class) {
				promocion.setPrecio(-ref.getPrecioVenta()*promocion.getBeneficio());
				if (listaReferencias.containsKey(promocion.getCodigo())) {
					var num = this.listaReferencias.get(promocion.getCodigo());
					num += 1;
					this.listaReferencias.put(promocion.getCodigo(),num);
				}
				else {
					this.listaReferencias.put(promocion.getCodigo(), 1);
				}
				
				this.monto += ref.getPrecioVenta()*(1.0-promocion.getBeneficio());
			}
			else {
				this.monto += ref.getPrecioVenta();
			}
			
		}
		else {
			this.monto += ref.getPrecioVenta();
		}
	}
	
	public void revisarRegalo(SistemaPOS sisPOS, Referencia ref) {
		String SKU = ref.getSKU();
		
		if (sisPOS.getPromociones().containsKey(SKU)) {
			var listaPromociones = sisPOS.getPromociones().get(SKU);
			var promocion = listaPromociones.get(0);
			if(promocion.getClass()==PromocionRegalo.class) {
				PromocionRegalo prom = (PromocionRegalo) promocion;
				int pagueNumero = (int) prom.getPagueNumero();
				int recibaNumero = (int) prom.getRecibaNumero();
				int comprados = listaReferencias.get(SKU);
				
				if (comprados!=0 && comprados%pagueNumero == 0) {
					int regalos = recibaNumero;
					int unidades = this.listaReferencias.get(ref.getSKU());
					unidades = unidades + regalos;
					this.listaReferencias.put(ref.getSKU(),unidades);
					
					promocion.setPrecio(-regalos*ref.getPrecioVenta());
					if (listaReferencias.containsKey(promocion.getCodigo())) {
						var num = this.listaReferencias.get(promocion.getCodigo());
						num += 1;
						this.listaReferencias.put(promocion.getCodigo(),num);
					}
					else {
						this.listaReferencias.put(promocion.getCodigo(), 1);
					}
				}		
			}	
		}
	}
	
	public void agregarPuntos(SistemaPOS sisPOS, Referencia ref) {
		String SKU = ref.getSKU();
		
		if (sisPOS.getPromociones().containsKey(SKU)) {
			var listaPromociones = sisPOS.getPromociones().get(SKU);
			var promocion = listaPromociones.get(0);
			promocion.setPrecio(0);
			if(promocion.getClass()==PromocionPuntos.class) {
				this.puntos += (int) (ref.getPrecioVenta()/1000)*(promocion.getBeneficio());
				this.listaReferencias.put(promocion.getCodigo(), 1);
			}
			else {
				this.puntos += (int) ref.getPrecioVenta()/1000;
			}
			
		}
		else {
			this.puntos += (int) ref.getPrecioVenta()/1000;
		}
		    
	}
	
	public double calcularTotal()
	{
		return this.monto;
	}

	public HashMap<String, Integer> getProductos() {
		return this.listaReferencias;
	}

	public String getId() {

		return this.id;
	}
	
	public void cerrarVenta()
	{
		this.puntos = (int) (this.monto/1000);
	}
	
	public int getPuntos()
	{
		return this.puntos;
	}
	
	public void setRecibo(String recibo)
	{
		this.recibo = recibo;
	}
	
	public Cliente getCliente()
	{
		return this.cliente;
	}
	
	@Override
	public String toString()
	{
		return this.recibo;
	}
	
	public double getMonto()
	{
		return this.monto;
	}
	
	public void  ventaPuntos( int puntosC)
	
	{
		this.puntos=0;
		PuntosMonto(puntosC);
		
		
		
	} 
	public void PuntosMonto(int puntosC)
	{
		int pesosPuntos=puntosC*15;
		if (pesosPuntos >= monto)
		{
			monto=0;
		}
		else
		{
			monto=(monto-pesosPuntos);
		}

public void ventaPuntos( int puntosC, int numero)
	
	{
		this.puntos=0;
		 boolean alcanza =PuntosMonto(puntosC,numero);
		 
		
		
	} 
	public boolean PuntosMonto(int puntosC, int numero)
	{
		boolean alcanza=false;
		int pesosPuntos=numero*15;
		if (numero<puntosC) {
			alcanza=true;
		if (pesosPuntos >= monto)
		{
			monto=0;
			
			
		}
		else
		{
			monto=(monto-pesosPuntos);
		}}
		
		return alcanza;
	}
}
