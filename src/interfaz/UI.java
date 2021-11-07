package interfaz;

import javax.swing.*;
import java.awt.event.*;

import interfaz.interfazInventario.PanelPrincipal;
import interfaz.interfazInventario.UIInventario;
import interfaz.interfazPOS.UIPos;
import java.awt.*;

public class UI extends JFrame implements ActionListener {

	private UIInventario UIinventario;
	private UIPos UIpos;
	private PanelPrincipal panelPrincipal;
	
	
	private CoordinadorUI coordinador;
	
	public UI()
	{
		//Configuracion de la Ventana
		this.setTitle("Gestión Supermercado");
		this.setSize(1200,700);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
	
		//Configurar guardar la información
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		@Override
	    public void windowClosing(WindowEvent e) {
				terminar();
			}
		});	
		
		
		//Crear atributos
		this.UIinventario = new UIInventario();
		this.UIpos = new UIPos();
		this.coordinador = new CoordinadorUI(this);
	
		//Crear el Panel y agregar opciones
		this.panelPrincipal = new PanelPrincipal(this);
		
		//Agregar panel
		this.add(panelPrincipal);
		this.setVisible(true);
		
		
		
	}
	
	private void terminar()
	{
		this.coordinador.guardarInformacion();
		this.UIinventario.dispose();
		this.UIpos.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void iniciarInventario()
	{
		this.UIinventario.setVisible(true);
	}
	
	public void iniciarPOS()
	{
		
		this.UIpos.setVisible(true);
	
	}
	
}
