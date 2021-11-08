package interfaz.interfazInventario;

import javax.swing.*;

import interfaz.UI;

import java.awt.Dimension;
import java.awt.event.*;

public class PanelPrincipal extends JPanel implements ActionListener {

	private static final String EJECUTAR = "EJECUTAR";
	
	private static final String INVENTARIO = "INVENTARIO";
	
	private static final String POS = "POS";
	
	private JComboBox opciones;
	
	private UI principal;

	public PanelPrincipal(UI principal)
	{
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		//Crear Label, Dropdown y Botón
		JLabel titulo = new JLabel("Seleccione la Aplicación");
		this.opciones = new JComboBox();
		opciones.setPreferredSize(new Dimension(100,20));
		JButton btnEnviar = new JButton("Ejecutar");
		btnEnviar.setActionCommand(EJECUTAR);
		btnEnviar.addActionListener(this);
		
		opciones.addItem(INVENTARIO);
		opciones.addItem(POS); 

		this.add(titulo);
		this.add(opciones);
		this.add(btnEnviar);

		//Asignar las propiedades 
		this.principal = principal;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(EJECUTAR)) 
		{
			String item = (String) this.opciones.getSelectedItem().toString();
			if(item.equals(INVENTARIO))
			{
				principal.iniciarInventario();
			}
			
			else if(item.equals(POS))
			{
				principal.iniciarPOS();
			}
			
			
		}

	}
}
