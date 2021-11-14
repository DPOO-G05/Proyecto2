package interfaz.interfazInventario;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {

	public PanelInformacion()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl1Titulo = new JLabel("Productos(s): ");
		lbl1Titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lbl1Titulo);
		
		JLabel lbl2Titulo= new JLabel("XXXXXXX");
		lbl2Titulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		add(lbl2Titulo);
		//
	}
}
