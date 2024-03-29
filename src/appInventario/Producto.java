package appInventario;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2233162813984939567L;
	private Referencia referencia;
	private final String SKU;
	private final LocalDate fechaVenc; 
	private String nombre;
	private String marca;
	private String pesoNeto;
	private String unidadMedida;
	private double costoUnidad;
	private double precioUnidad;
	private LocalDate fechaIngreso;
	private int unidadesRestantes;
	private boolean empacado;
	private boolean disponibleVenta;
	private Lote lote;

	public LocalDate getFechaVenc() {
		return fechaVenc;
	}


	public Producto(String codigo, String fechaVenc,String[] charac,Referencia referencia, LocalDate fechaIngreso)
	{
		this.SKU= codigo; 
		this.referencia = referencia;
		LocalDate fecha = LocalDate.parse(fechaVenc);
		this.fechaVenc = fecha;
		this.nombre = charac[0];
		this.marca = charac[1];
		this.empacado = charac[2].equals("Y"); 
		this.unidadesRestantes = Integer.parseInt(charac[3]);
		this.costoUnidad = Double.parseDouble(charac[4]);
		this.precioUnidad = Double.parseDouble(charac[5]);
		this.fechaIngreso = fechaIngreso;
		this.pesoNeto = charac[6];
		this.unidadMedida = charac[7];
		this.fechaIngreso = fechaIngreso;
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPesoNeto() {
		return pesoNeto;
	}

	public void setPesoNeto(String pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getUnidadesRestantes() {
		return unidadesRestantes;
	}


	public boolean isEmpacado() {
		return empacado;
	}

	public double getCostoUnidad() {
		return costoUnidad;
	}

	public void setCostoUnidad(double costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public void setEmpacado(boolean empacado) {
		this.empacado = empacado;
	}

	public boolean isDisponibleVenta() {
		return disponibleVenta;
	}

	public void setDisponibleVenta(boolean disponibleVenta) {
		this.disponibleVenta = disponibleVenta;
	}

	public String getCodigoProducto() {
		return this.SKU;
	}
	
	public void modificarRestantes(int unidades)
	{
		//Incrementa o decrementa el n�mero de unidades restantes
		this.unidadesRestantes += unidades;
	}


	public void setLote(Lote lote) {
		this.lote = lote;
	}
	
	public Lote getLote()
	{
		return this.lote;
	}
	
	public Referencia getReferencia()
	{
		return this.referencia;
	}


	public int disminuirCantidad(int cantidadDisminuir)
	{
		int respuesta;

		if (cantidadDisminuir == this.unidadesRestantes)
		{
			this.unidadesRestantes = 0;
			respuesta = 0;
		}
		else if (cantidadDisminuir < unidadesRestantes)
		{
			this.unidadesRestantes -= cantidadDisminuir;
			respuesta = 0;
		}
		else
		{
			this.unidadesRestantes = 0;
			respuesta = cantidadDisminuir - this.unidadesRestantes;
		}
		
		this.lote.setUnidades(this.unidadesRestantes);
		
		return respuesta;

	}


}
