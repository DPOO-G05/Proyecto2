package interfaz.interfazPOS;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

public class PanelInformacionPOS extends JPanel {
	
	private UIPos principal;
	
	private JLabel lblNombre;
	
	private JList productos = new JList();
	
	private JScrollPane scrollPane;
	
	private JLabel lblMontoTotal;
	
	private DefaultListModel<String> model = new DefaultListModel();
	
	public PanelInformacionPOS(UIPos principal)
	{
		this.principal = principal;
		setLayout(null);
		
		JLabel lblBienvenida = new JLabel("Bienvenido/a: ");
		lblBienvenida.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblBienvenida.setBounds(33, 11, 175, 46);
		add(lblBienvenida);
		
		this.lblNombre = new JLabel("");
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNombre.setBounds(255, 11, 175, 46);
		add(lblNombre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 121, 432, 1);
		add(separator);

		this.scrollPane = new JScrollPane(this.productos);
		scrollPane.setBounds(33, 237, 484, 302);
		add(scrollPane);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblTotal.setBounds(33, 200, 102, 30);
		add(lblTotal);
		
		this.lblMontoTotal = new JLabel("0$");
		lblMontoTotal.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblMontoTotal.setBounds(145, 200, 432, 30);
		add(lblMontoTotal);
		
	}
	
	public void actualizarProducto()
	{
		//Recibe un array de String en el que cada String tiene la forma: "nombre,cantidad,total" 
		this.model.clear();
		this.productos.setModel(this.model);
		String header = "NOMBRE-----------CANTIDAD-----------TOTAL";
		model.addElement(header);
		ArrayList<String> productos = this.principal.getProductosActuales();
		for (String str: productos)
		{
			String[] caracteristicas = str.split(",");
			String nombre = caracteristicas[0].strip().toUpperCase();
			String cantidad = caracteristicas[1].strip().toUpperCase();
			String totalItem = caracteristicas[2].strip().toUpperCase();
			String row = nombre + "-----------" + cantidad +"-----------" + totalItem;
			model.addElement(row);
			
		}
		
		String puntosActual = Integer.toString(principal.getVentaActual().getPuntos());
		model.addElement("PUNTOS ACUMULADOS: " + puntosActual);

	}
	
	public void actualizarTotal()
	{
		double total = principal.getTotalVenta();
		String totalStr = Double.toString(total);
		this.lblMontoTotal.setText(totalStr + "$");
	}
	
	public void actualizarUsuario()
	{
		String nombre = principal.getClienteActual().getNombre();
		
		if(nombre == null)
		{
			this.lblNombre.setText(principal.getClienteActual().getCedula());
		}
		else
		{
			this.lblNombre.setText(nombre);
		}

	}
	
	public DefaultListModel<String> getModel()
	{
		return this.model;
	}
	
	public JScrollPane getScrollPane()
	{
		return this.scrollPane;
	}
	
	public JLabel getTotal()
	{
		return this.lblMontoTotal;
	}
}
