package interfaz.interfazPOS;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import appInventario.Referencia;

import java.awt.event.*;
public class VentanaCompraPuntos extends JFrame  {

	private DefaultListModel model = new DefaultListModel();
	private UIPos principal;
	JTextField puntos= new JTextField(10); 
	String numero;

	public VentanaCompraPuntos(UIPos principal)
	{
		this.principal = principal;
		this.setTitle("Compra Con Puntos");
		this.setSize(700,1200);
		Action action = new AbstractAction()
		{ @Override
    public void actionPerformed(ActionEvent e)
	    {
			numero=puntos.getText();
			int numeroo=  Integer.parseInt(numero);
			principal.Ventapuntos(true,numeroo);
	        dispose();
	        
	        
	    }
	};

	    this.puntos.addActionListener(action);
		this.getContentPane().add(this.puntos);
		this.setVisible(true);
	}
	
	
}