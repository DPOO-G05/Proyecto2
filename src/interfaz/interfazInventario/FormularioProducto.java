package interfaz.interfazInventario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSlider;

public class FormularioProducto extends JFrame {
	
	public FormularioProducto()
	{
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JSlider slider = new JSlider();
		panel.add(slider);
		
		this.setVisible(true);
	}

}
