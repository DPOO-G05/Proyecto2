package interfaz.interfazInventario;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {

	public PanelInformacion()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Productos(s): ");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lblNewLabel);
		
		JLabel lblXxxxxxxx = new JLabel("XXXXXXXX ");
		lblXxxxxxxx.setFont(new Font("SansSerif", Font.PLAIN, 20));
		add(lblXxxxxxxx);
		//
	}
}
