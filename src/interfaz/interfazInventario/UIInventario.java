package interfaz.interfazInventario;

import javax.swing.*;

import appInventario.Producto;
import appInventario.Referencia;
import interfaz.UI;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class UIInventario extends JFrame implements ActionListener {

	private UI principal;
	
	private FormularioProducto formulario;
	
	private PanelInformacion panelInformacion;
	
	private PanelCategorias panelCategorias;
	
	private PanelProducto panelProducto;
	
	private PanelLotes panelLotes;
	
	private JMenuBar menuBarra;

	private JMenu menuProd, menuLotes, menuApp, menuInfo;
	
	private JMenuItem mu11, mu22, mu23, mu31, mu41;
	
	private Referencia referenciaActual;
	
	private Producto productoActual;
	
	private JFileChooser chooserLote;
	
	private JFileChooser chooserImagen;

	private VentanaEstadisticasRef graficoComportamiento;

	private VentanaFinanciera financiera;
	
	private static final String NUEVO_PRODUCTO = "NUEVO_PRODUCTO";
	
	private static final String CARGAR_LOTE = "CARGAR_LOTE";

	private static final String ELIMINAR_VENCIDOS = "ELIMINAR_VENCIDOS";
	
	private static final String CERRAR_APLICACION = "CERRAR_APLICACION"; 
	
	private static final String MOSTRAR_INFO = "MOSTRAR_INFO";
	

	public UIInventario(UI principal)
	{
		//Inicializar
		this.principal = principal;
		
		
		//Configuracion de la Ventana
		this.setTitle("Gesti�n Inventario");
		this.setSize(1200,700);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		//Crear los paneles
		this.panelInformacion = new PanelInformacion();
	
		this.panelCategorias = new PanelCategorias(this);
	
		this.panelProducto= new PanelProducto(this);
	
		this.panelLotes = new PanelLotes(this);
		
		//Agregar los paneles
		
		add(panelInformacion, BorderLayout.NORTH);

		add(panelCategorias, BorderLayout.WEST);
		
		add(panelProducto, BorderLayout.CENTER);
		
		add(panelLotes, BorderLayout.EAST);
		
		//Crear Menu
		crearMenu(this);
	
	}


	private void crearMenu(UIInventario ventana)
	{
				
		//Agregar la barra de Menu a la ventana
		
		this.menuBarra = new JMenuBar();
		this.setJMenuBar(menuBarra);
		
		//Crear Menus del Menu Barra 
		this.menuProd = new JMenu("Producto");
		this.menuApp = new JMenu("Aplicaci�n");
		this.menuLotes = new JMenu("Lotes");
		this.menuInfo = new JMenu("Info");
		
		//Agregar los items 
		this.menuBarra.add(menuProd);
		this.menuBarra.add(menuLotes);
		this.menuBarra.add(menuApp);
		this.menuBarra.add(menuInfo);

		//Submenus de Producto
		this.mu11 = new JMenuItem("Nuevo Producto");
		this.mu11.addActionListener(ventana);
		this.mu11.setActionCommand(NUEVO_PRODUCTO);
		this.menuProd.add(mu11);
		//Submenus de Lotes 
		this.mu22 = new JMenuItem("Cargar Lotes (CSV)");
		this.mu22.addActionListener(ventana);
		this.mu22.setActionCommand(CARGAR_LOTE);
		this.menuLotes.add(mu22);

		this.mu23 = new JMenuItem("Eliminar Lotes Vencidos");
		this.mu23.addActionListener(ventana);
		this.mu23.setActionCommand(ELIMINAR_VENCIDOS);
		this.menuLotes.add(mu23);

		//Submenus de Aplicacion 
		this.mu31 = new JMenuItem("Cerrar Aplicaci�n");
		this.mu31.addActionListener(ventana);
		this.mu31.setActionCommand(CERRAR_APLICACION);
		this.menuApp.add(mu31);

		//Submenus Informaci�n
		this.mu41 = new JMenuItem("Informaci�n Aplicaci�n");
		this.mu41.addActionListener(ventana);
		this.mu41.setActionCommand(MOSTRAR_INFO);
		this.menuInfo.add(mu41);
		

	}
	
	public UI getPrincipal()
	{
		return this.principal;
	}
	
	public void actualizarReferencia(Referencia referencia, Producto producto, String tipoInteraccion)
	{
		this.referenciaActual = referencia; 
		this.productoActual = producto;
		this.panelProducto.actualizar(tipoInteraccion);
	}
	
	public Referencia getReferencia()
	{
		return this.referenciaActual;
	}
	
	public void actualizarBanner(String titulo)
	{
		this.panelInformacion.actualizarTitulo(titulo);
	}
	
	public Producto getProducto()
	{
		return this.productoActual;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand(); 
			
		if (comando.equals(NUEVO_PRODUCTO))
		{
			crearNuevoFormulario();
		}
		
		else if (comando.equals(CARGAR_LOTE))
		{
			cargarLote();
		}
		
		else if (comando.equals(this.ELIMINAR_VENCIDOS))
		{
			eliminarVencidos();
		}
	}
	
	private void crearNuevoFormulario()
	{
		//1. Recolectar informaci�n necesaria
		this.formulario = new FormularioProducto(this);

	}
	
	public void agregarProducto(ArrayList<String> caracteristicas, FormularioProducto formulario)
	{
		//Agrega el producto
		this.principal.getCoordinador().agregarNuevoProducto(caracteristicas, formulario);
	}
	
	public void cargarLote()
	{
		this.chooserLote = new JFileChooser();
		int valor = chooserLote.showDialog(this, "Seleccionar CSV");
		if(valor == JFileChooser.APPROVE_OPTION)
			{
				File file = chooserLote.getSelectedFile();
				this.principal.getCoordinador().leerCSV(file);
				principal.actualizarInventario();
			}
			else
			{
				System.out.println("Abrir cancelado por el usuario");
			}
	}
	
	public void actualizarImagen()
	{
		this.chooserImagen = new JFileChooser();
		int valor = chooserImagen.showDialog(this, "Seleccionar Imagen");
		if(valor == JFileChooser.APPROVE_OPTION)
			{
				File file = chooserImagen.getSelectedFile();
				this.referenciaActual.setImagen(file);
				this.panelProducto.actualizarImagen(referenciaActual);
			}
			else
			{
				System.out.println("Abrir cancelado por el usuario");
			}
	}
	
	private void eliminarVencidos()
	{
		this.principal.getCoordinador().eliminarVencidos();
		this.principal.actualizarInventario();
		JOptionPane.showInternalMessageDialog(this, "Lotes Vencidos Eliminados Exitosamente", "Depuración Lotes", JOptionPane.INFORMATION_MESSAGE);
	}


	public void graficoComportamiento()
	{
		this.graficoComportamiento = new VentanaEstadisticasRef(this.referenciaActual);
	}


	public void mostrarDesempeno() {
		this.financiera = new VentanaFinanciera(this.referenciaActual);
		
	}


	public void actualizarAgotado(Referencia referencia)
	{
		this.referenciaActual = referencia;
		this.productoActual = null;
		this.panelProducto.actualizar("agotado");
	}

}