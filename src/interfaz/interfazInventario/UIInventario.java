package interfaz.interfazInventario;

import javax.swing.*;

import java.awt.*;

public class UIInventario extends JFrame {

	public UIInventario()
	{
		//Configuracion de la Ventana
		this.setTitle("Gestión Supermercado");
		this.setSize(1200,700);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		this.add(new JLabel("Hola"));
	

	}
}
