package interfaz.interfazInventario;

import javax.swing.*;

import appInventario.Producto;
import appInventario.Referencia;
import interfaz.UI;

import java.awt.*;

import java.awt.event.*;

public class UIInventario extends JFrame implements ActionListener {

	private UI principal;
	
	private FormularioProducto formulario;
	
	private PanelInformacion panelInformacion;
	
	private PanelCategorias panelCategorias;
	
	private PanelProducto panelProducto;
	
	private PanelLotes panelLotes;
	
	private JMenuBar menuBarra;

	private JMenu menuProd, menuLotes, menuApp, menuInfo;
	
	private JMenuItem mu11, mu21, mu22, mu23, mu31, mu41;
	
	private Referencia referenciaActual;
	
	private Producto productoActual;
	
	private static final String NUEVO_PRODUCTO = "NUEVO_PRODUCTO";
	
	private static final String NUEVO_LOTE = "NUEVO_LOTE";
	
	private static final String CARGAR_LOTE = "CARGAR_LOTE";

	private static final String ELIMINAR_VENCIDOS = "ELIMINAR_VENCIDOS";
	
	private static final String CERRAR_APLICACION = "CERRAR_APLICACION"; 
	
	private static final String MOSTRAR_INFO = "MOSTRAR_INFO";
	

	public UIInventario(UI principal)
	{
		//Inicializar
		this.principal = principal;
		
		
		//Configuracion de la Ventana
		this.setTitle("Gestión Inventario");
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
		this.menuApp = new JMenu("Aplicación");
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
		this.mu21 = new JMenuItem("Nuevo Lote");
		this.mu21.addActionListener(ventana);
		this.mu21.setActionCommand(NUEVO_LOTE);
		this.menuLotes.add(mu21);

		this.mu22 = new JMenuItem("Cargar Lotes");
		this.mu22.addActionListener(ventana);
		this.mu22.setActionCommand(CARGAR_LOTE);
		this.menuLotes.add(mu22);

		this.mu23 = new JMenuItem("Eliminar Lotes Vencidos");
		this.mu23.addActionListener(ventana);
		this.mu23.setActionCommand(ELIMINAR_VENCIDOS);
		this.menuLotes.add(mu23);

		//Submenus de Aplicacion 
		this.mu31 = new JMenuItem("Cerrar Aplicación");
		this.mu31.addActionListener(ventana);
		this.mu31.setActionCommand(CERRAR_APLICACION);
		this.menuApp.add(mu31);

		//Submenus Información
		this.mu41 = new JMenuItem("Información Aplicación");
		this.mu41.addActionListener(ventana);
		this.mu41.setActionCommand(MOSTRAR_INFO);
		this.menuInfo.add(mu41);
		

	}
	
	public UI getPrincipal()
	{
		return this.principal;
	}
	
	public void actualizarReferencia(Referencia referencia, Producto producto)
	{
		this.referenciaActual = referencia; 
		this.productoActual = producto;
		this.panelProducto.actualizar();
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
			//1. Crear el nuevo producto
			Producto prod = crearNuevoProducto();
			
			//2. Agregar el nuevo producto
			this.principal.getCoordinador().agregarNuevoProducto(prod);

		}
	}
	
	private Producto crearNuevoProducto()
	{
		//1. Recolectar información necesaria
		this.formulario = new FormularioProducto();

		return productoActual;
	}

}