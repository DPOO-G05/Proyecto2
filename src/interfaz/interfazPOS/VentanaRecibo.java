package interfaz.interfazPOS;

import javax.swing.JFrame;

import appPOS.Recibo;

public class VentanaRecibo extends JFrame {
	
	Recibo recibo;
	public VentanaRecibo(Recibo recibo)
	{
		this.recibo = recibo;
		this.setTitle("Recibo");
		this.setSize(800,400);
		this.setResizable(false);
		this.setVisible(true);
	}
}
