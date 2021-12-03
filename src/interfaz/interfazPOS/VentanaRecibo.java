package interfaz.interfazPOS;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

import appPOS.Venta;
import interfaz.interfazInventario.PanelInformacion;


public class VentanaRecibo extends JFrame {
	
	
	DefaultListModel model;
	public VentanaRecibo(String string)
	{
		this.model = new DefaultListModel();
		String[] productos = string.split("\n");
		for(String producto: productos)
		{
			model.addElement(producto);
		}
		JList lista = new JList(model);
		JScrollPane pane = new JScrollPane(lista);
		this.getContentPane().add(pane);
		
		this.setVisible(true);

	}
	
	public void cerrarVentana()
	{
		this.dispose();
	}
}
