package interfaz.interfazPOS;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBotonesPOS extends JPanel implements ActionListener
{ 

	private UIPos principal;
	
	private final String CAMBIAR_CLIENTE= "CAMBIAR_CLIENTE";

	private final String AFILIAR_CLIENTE = "AFILIAR_CLIENTE";

	private final String CONSULTAR_PUNTOS = "CONSULTAR_PUNTOS";

	private final String CERRAR_COMPRA = "CERRAR_COMPRA";

	private final String IMPRIMIR_RECIBO = "IMPRIMIR_RECIBO";
	
	private final String AGREGAR_PRODUCTO = "AGREGAR_PRODUCTO";

	public PanelBotonesPOS(UIPos principal)
	{
		this.principal = principal;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estad\u00EDsticas: ");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel.setBounds(239, 11, 153, 29);
		add(lblNewLabel);
		
		JButton btnCambiarCliente = new JButton("Cambiar Cliente");
		btnCambiarCliente.addActionListener(this);
		btnCambiarCliente.setActionCommand(CAMBIAR_CLIENTE);
		btnCambiarCliente.setBounds(75, 228, 461, 38);
		add(btnCambiarCliente);
		
		JButton btnRegistrarCliente = new JButton("Afiliar Cliente Actual");
		btnRegistrarCliente.addActionListener(this);
		btnRegistrarCliente.setActionCommand(AFILIAR_CLIENTE);
		btnRegistrarCliente.setBounds(75, 293, 461, 38);
		add(btnRegistrarCliente);
		
		JButton btnConsultarPuntos = new JButton("Consultar Puntos");
		btnConsultarPuntos.setBounds(75, 367, 461, 38);
		btnConsultarPuntos.addActionListener(this);
		btnConsultarPuntos.setActionCommand(CONSULTAR_PUNTOS);
		add(btnConsultarPuntos);
		
		JButton btnCerrarCompra = new JButton("Cerrar Compra");
		btnCerrarCompra.setBounds(75, 438, 461, 38);
		btnCerrarCompra.setActionCommand(CERRAR_COMPRA);
		btnCerrarCompra.addActionListener(this);
		add(btnCerrarCompra);
		
		JButton btnImprimirRecibo = new JButton("Imprimir Recibo");
		btnImprimirRecibo.setBounds(75, 503, 461, 38);
		btnImprimirRecibo.addActionListener(this);
		btnImprimirRecibo.setActionCommand(IMPRIMIR_RECIBO);
		add(btnImprimirRecibo);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(75, 558, 461, 64);
		btnAgregarProducto.addActionListener(this);
		btnAgregarProducto.setActionCommand(AGREGAR_PRODUCTO);
		add(btnAgregarProducto);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if (CAMBIAR_CLIENTE.equals(comando))
		{
			this.principal.cambiarClienteActual();
		}
		else if (AFILIAR_CLIENTE.equals(comando))
		{
			this.principal.afiliarCliente();
		}
		else if (CONSULTAR_PUNTOS.equals(comando))
		{
			this.principal.darPuntos();
		}
		else if (AGREGAR_PRODUCTO.equals(comando))
		{
			this.principal.ventanaProductos();
		}
		else if (CERRAR_COMPRA.equals(comando))
		{
			this.principal.cerrarCompra();
		}
		else if (IMPRIMIR_RECIBO.equals(comando))
		{
			this.principal.imprimirRecibo();
		}
		
		
	}
}
