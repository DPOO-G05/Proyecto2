package appInventario;

import java.io.Serializable;

public class DesempenoFinanciero implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581817901358844432L;
	double perdidas;
	double ventas;
	double utilidades;

	public DesempenoFinanciero()
	{
		this.perdidas = 0;
		this.ventas = 0;
		this.utilidades = 0;
	}
	public void registrarPerdida(double perdida) throws Exception
	{
		if (perdida < 0)
		{
			throw  new Exception("Las perdidas no pueden ser negativas");
		}
		else
		{
			this.perdidas += perdida;
			calcularGanancias();
		}
	}

	public void generarVentas(double ventas)
	{
		this.ventas += ventas;
		calcularGanancias();
	}

	private void calcularGanancias() 
	{
		this.utilidades = this.ventas - this.perdidas;
	}

	public double getUtilidades() {
		return this.utilidades;
	}

	public double getVentas() {
		return this.ventas;
	}

	public double getPerdidas() {
		return this.perdidas;
	}
	

}
