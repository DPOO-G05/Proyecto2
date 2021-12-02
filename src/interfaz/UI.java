package interfaz;

import javax.swing.*;
import java.awt.event.*;

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

		this.coordinador = new CoordinadorUI(this);
		this.UIinventario = new UIInventario(this);
		this.UIpos = new UIPos(this);
	
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
		
		this.UIpos.iniciarPOS();
	
	}
	
	public CoordinadorUI getCoordinador()
	{
		return this.coordinador;
	}
	
	public void actualizarInventario()
	{
		coordinador.guardarInformacion();
		this.UIinventario.setVisible(false);
		this.UIinventario.dispose();
		this.UIinventario = new UIInventario(this);
		this.UIinventario.setVisible(true);
	}
	
}
