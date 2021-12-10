package interfaz.interfazPOS;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import appInventario.Referencia;

import java.awt.event.*;

public class VentanaProductos extends JFrame {
	
	private DefaultListModel model = new DefaultListModel();
	private UIPos principal;
	private JList jList = new JList();

	public VentanaProductos(UIPos principal)
	{
		this.principal = principal;
		this.setTitle("Agregar Producto");
		this.setSize(700,1200);
		popular();
		MouseListener ml = new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            if(e.getClickCount() == 2) {
	            	Referencia ref = (Referencia) jList.getSelectedValue();
	            	principal.agregarProducto(ref.getSKU(), ref);
	            	dispose();
	            }
	        }
	    };
	    this.jList.addMouseListener(ml);
		this.getContentPane().add(new JScrollPane(this.jList));
		this.setVisible(true);
	}
	
	private void popular()
	{
		this.model.clear();
		this.principal.popularProductos(model);
		jList.setCellRenderer(new Renderer());
		jList.setModel(model);
	}
	
	
}
