package interfaz.interfazInventario;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class UIInventario extends JFrame implements ActionListener {

	
	private PanelInformacion panelInformacion;
	
	private PanelCategorias panelCategorias;
	
	private PanelProducto panelProducto;
	
	private PanelLotes panelLotes;
	
	private JMenuBar menuBarra;

	private JMenu menuProd, menuLotes, menuApp, menuInfo;
	
	private JMenuItem mu11, mu21, mu22, mu23, mu31, mu41;
	
	
	public UIInventario()
	{
		//Configuracion de la Ventana
		this.setTitle("Gestión Inventario");
		this.setSize(1200,700);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		//Crear los paneles
		this.panelInformacion = new PanelInformacion();
	
		this.panelCategorias = new PanelCategorias();
	
		this.panelProducto= new PanelProducto();
	
		this.panelLotes = new PanelLotes();
		
		//Agregar los paneles
		
		add(panelInformacion, BorderLayout.NORTH);

		add(panelCategorias, BorderLayout.WEST);
		
		add(panelProducto, BorderLayout.CENTER);
		
		add(panelLotes, BorderLayout.EAST);
		
		//Crear Menu
		crearMenu();
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void crearMenu()
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
		this.mu11 = new JMenu("Nuevo Producto");
		this.menuProd.add(mu11);
		//Submenus de Lotes 
		this.mu21 = new JMenu("Nuevo Lote");
		this.menuLotes.add(mu21);
		this.mu22 = new JMenu("Cargar Lotes");
		this.menuLotes.add(mu22);
		this.mu23 = new JMenu("Eliminar Lotes Vencidos");
		this.menuLotes.add(mu23);
		//Submenus de Aplicacion 
		this.mu31 = new JMenu("Cerrar Aplicación");
		this.menuApp.add(mu31);
		//Submenus Información
		this.mu41 = new JMenu("Información Aplicación");
		this.menuInfo.add(mu41);
		

	}
	
}
