package interfaz.interfazPOS;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import appPOS.Cliente;
import appPOS.Venta;
import interfaz.UI;

import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class UIPos extends JFrame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4286689125664218341L;
	private VentanaProductos productos;
	private PanelBotonesPOS panelBotones;
	private PanelInformacionPOS panelInformacion;
	private UI principal;
	private Cliente clienteActual;
	private FormularioRegistro formularioRegistro;
	private VentanaRecibo ventanaRecibo;
	private VentanaEstadisticas ventanaEstadisticas;
	private boolean ventaPuntos;

	
	public UIPos(UI principal)
	{
		//Configuración de la ventana
		this.setTitle("Aplicación POS");
		this.setSize(1200,700);
		this.setResizable(false);
		this.getContentPane().setLayout(new GridLayout(1,2));
		
		//Crear los atributos
		this.principal = principal;
		this.panelBotones = new PanelBotonesPOS(this);
		this.panelInformacion = new PanelInformacionPOS(this);
		
		//Agregar
		this.add(panelBotones);
		this.add(this.panelInformacion);
		
		//Mostrar el JDiaglog para construir el cliente
		//Capturar la información y dependiendo de eso abrir la ventana 
		

	}
	
	public void iniciarPOS()
	{
		this.setVisible(true);
		cambiarClienteActual();
	}
	
	public void cambiarClienteActual()
	{
		String cedula = consultarCedula();
		autenticar(cedula);
		iniciarVenta();
	}
	
	private void iniciarVenta()
	{
		this.principal.getCoordinador().iniciarVenta(this.clienteActual);
	}

	private void autenticar(String cedula)
	{
		boolean existe = this.principal.getCoordinador().existeCliente(cedula);
		if(existe)
		{
			this.clienteActual = this.principal.getCoordinador().buscarCliente(cedula);

		}
		else
		{
			this.clienteActual = crearCliente(cedula);
		}

		//Validar si es afiliado
		boolean afiliado = esAfiliado(cedula);
		if(!afiliado)
		{
			int afiliar =  consultarAfiliar(cedula);
			if (afiliar == JOptionPane.YES_OPTION)
			{
				afiliarCliente();
			}
			else
			{
				actualizarUsuario();
			}
		
		}
		else
		{
			actualizarUsuario();
		}
	}
	
	private int consultarAfiliar(String cedula)
	{
		Object[] opciones = {"Afiliar", "No Afiliar"};
		Object opcionDefault = opciones[0];
		int seleccion = JOptionPane.showOptionDialog(this,
	            "¿Desea afiliar al cliente al Sistema de Puntos?" ,
	            "Afiliar",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opcionDefault);
		
		return seleccion;
	}

	public void afiliarCliente()
	{
		if(!esAfiliado(this.clienteActual.getCedula()))
		{
			this.formularioRegistro = new FormularioRegistro(this);
		}
		else
		{
			JOptionPane.showMessageDialog(this.getContentPane(),"El cliente ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void afiliarClienteInfo(ArrayList<String> atributos, String cedula)
	{
		this.principal.getCoordinador().afiliarCliente(atributos, cedula);
	}

	public void actualizarUsuario()
	{
		//this.panelBotones.actualizarUI();
		this.panelInformacion.actualizarUsuario();
	}
	
	public void actualizarProducto()
	{
		this.panelInformacion.actualizarProducto();
		this.panelInformacion.actualizarTotal();
	}
	
	private Cliente crearCliente(String cedula)
	{
		return this.principal.getCoordinador().crearCliente(cedula);
	}
	
	private String consultarCedula()
	{
		String cedula;
		do
		{
			cedula = JOptionPane.showInputDialog("Introduzca la cédula del cliente","Cédula");
			if(cedula == null)
			{
				if (this.clienteActual == null)
				{
					this.dispose();
				}
				cedula = "";
			}
			else
			{

				Object[] opciones = {"Confirmar", "Corregir"};
				Object opcionDefault = opciones[0];
				int seleccion = JOptionPane.showOptionDialog(this,
		             "Usted ingresó el siguiente documento: " + cedula,
		             "Confirmación",
		             JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE,
		             null,
		             opciones,
		             opcionDefault);
				
				if (seleccion == JOptionPane.YES_OPTION)
				{
					
				}
				
				else
				{
					cedula = "Cédula";
				}

			}
		}
		while(cedula.equals("Cédula") || cedula.equals(""));
		
		return cedula;
	}
	
	public Cliente getClienteActual()
	{
		return this.clienteActual;
	}
	
	public void darPuntos()
	{
		if (this.principal.getCoordinador().esAfiliado(this.clienteActual.getCedula()))
		{
			int puntos = this.getClienteActual().getPuntos();
			String nombre = this.getClienteActual().getNombre();
			JOptionPane.showMessageDialog(this.getContentPane(),
					"El número de puntos de: " + nombre + " es " + Integer.toString(puntos), "Puntos",
					JOptionPane.INFORMATION_MESSAGE);
		}	
		else
		{
			JOptionPane.showMessageDialog(this.getContentPane(),
				"El cliente no se encuentra afiliado ", "Error",
				JOptionPane.ERROR_MESSAGE);

		}

	}

	public void ventanaProductos()
	{
		this.productos = new VentanaProductos(this);
	}

	public void popularProductos(DefaultListModel model) {

		this.principal.getCoordinador().popularProductos(model);
		
	}

	public void agregarProducto(String SKU) { 
		this.productos.dispose();
		String reciboModel = this.panelInformacion.getModel().toString();
		String recibo = "";
		String[] productos = reciboModel.split(",");
		for(String producto: productos)
		{
			recibo += (producto + "\n");
		}
		this.principal.getCoordinador().agregarProductoVenta(SKU, recibo);
		actualizarProducto();
	}

	public ArrayList<String> getProductosActuales() {

		return principal.getCoordinador().getProductosActuales();

	}
	
	public double getTotalVenta()
	{

		return this.principal.getCoordinador().getTotalVenta();
		
	}

	public void cerrarCompra() {
		//1. Guardar compra y mostrar recibo
		Venta ventaActual = this.principal.getCoordinador().getVentaActual();
		this.clienteActual.agregarVenta(ventaActual, false);
		this.principal.getCoordinador().agregarVentaHistorico(ventaActual);
		this.imprimirRecibo();
		//2. 
		this.principal.getCoordinador().iniciarVenta(clienteActual);
		this.actualizarProducto();
		this.actualizarUsuario();
	}

	public void imprimirRecibo() 
	{

		Venta actual = this.principal.getCoordinador().getVentaActual();
		if (actual == null)
		{
			JOptionPane.showMessageDialog(this.getContentPane(), "Debe tener una compra abierta para ver el recibo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//TODO: Terminar recibo
			this.ventanaRecibo = new VentanaRecibo(this.getVentaActual().toString());
		}

	}
	
	public boolean esAfiliado(String cedula)
	{
		return this.principal.getCoordinador().esAfiliado(cedula);
	}
	
	public Venta getVentaActual()
	{
		return this.principal.getCoordinador().getVentaActual();
	}
	
	public VentanaProductos getVentanaProductos()
	{
		return this.productos;
	}

	public void mostrarEstadisticas() {
			this.ventanaEstadisticas = new VentanaEstadisticas(this.clienteActual);
	}
	
	public void Ventapuntos (boolean ventapuntos)
	{
		ventaPuntos=ventapuntos;
		darPuntos();
		cerrarCompra();
	}
	
	
}
