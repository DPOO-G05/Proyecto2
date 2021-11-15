package interfaz.interfazInventario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.SortedMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;

import appInventario.Lote;
import appInventario.Producto;
import appInventario.Referencia;

import java.awt.Color;

public class PanelProducto extends JPanel {
	
	private UIInventario principalInventario;
	
	private JLabel lbl2Lote;
	
	private JLabel lbl2Vencimiento;
	
	private JLabel lbl2Unidades;
	
	private JLabel lbl2Precio;
	
	private JLabel lbl2PrecioUnidad;

	private JLabel lbl2Marca;
	
	public PanelProducto(UIInventario principalInventario) 
	{
		
		//Inicializar referencias
		
		this.principalInventario = principalInventario;
		
		//Configuraci�n par�metros
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
		JButton btnSKU = new JButton("Buscar por SKU o Lote");
		btnSKU.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSKU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSKU.setBounds(69, 11, 763, 32);
		add(btnSKU);
		
		JLabel lbl1Lote = new JLabel("Lote: ");
		lbl1Lote.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Lote.setBounds(69, 87, 47, 19);
		add(lbl1Lote);
		
		JLabel lbl1Unidades = new JLabel("Unidades: ");
		lbl1Unidades.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Unidades.setBounds(399, 87, 77, 19);
		add(lbl1Unidades);
		
		JLabel lbl1Vencimiento = new JLabel("Vencimiento: ");
		lbl1Vencimiento.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Vencimiento.setBounds(676, 87, 105, 19);
		add(lbl1Vencimiento);
		
		this.lbl2Lote = new JLabel("XXXXXXXXX");
		lbl2Lote.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Lote.setBounds(115, 91, 112, 14);
		add(lbl2Lote);
		
		this.lbl2Unidades = new JLabel("XXXXXXXXX");
		lbl2Unidades.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Unidades.setBounds(479, 91, 77, 14);
		add(lbl2Unidades);
		
		this.lbl2Vencimiento = new JLabel("XXXXXXXXX");
		lbl2Vencimiento.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Vencimiento.setBounds(778, 91, 112, 14);
		add(lbl2Vencimiento);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBounds(241, 140, 407, 211);
		add(panelImagen);
		
		JLabel lbl1Precio = new JLabel("Precio:  ");
		lbl1Precio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Precio.setBounds(69, 365, 63, 19);
		add(lbl1Precio);
		
		JLabel lbl1Preciounidad = new JLabel("Precio (unidad):  ");
		lbl1Preciounidad.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Preciounidad.setBounds(202, 365, 120, 19);
		add(lbl1Preciounidad);
		
		JLabel lblMarca = new JLabel("Marca:   ");
		lblMarca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblMarca.setBounds(396, 365, 63, 19);
		add(lblMarca);
		
		JLabel lbl1Empacado = new JLabel("Empacado:   ");
		lbl1Empacado.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Empacado.setBounds(528, 365, 120, 19);
		add(lbl1Empacado);
		
		JLabel lbl1Categoria = new JLabel("Categoria:   ");
		lbl1Categoria.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Categoria.setBounds(694, 365, 120, 19);
		add(lbl1Categoria);
		
		JLabel lbl1Gondola = new JLabel("G\u00F3ndola:  ");
		lbl1Gondola.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Gondola.setBounds(69, 411, 82, 19);
		add(lbl1Gondola);
		
		JLabel lbl1SKU = new JLabel("SKU:  ");
		lbl1SKU.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1SKU.setBounds(220, 411, 47, 19);
		add(lbl1SKU);
		
		JLabel lbl1Peso = new JLabel("Peso:  ");
		lbl1Peso.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1Peso.setBounds(397, 411, 82, 19);
		add(lbl1Peso);
		
		JLabel lbl1FechaIngreso = new JLabel("Fecha Ingreso:  ");
		lbl1FechaIngreso.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl1FechaIngreso.setBounds(528, 411, 120, 19);
		add(lbl1FechaIngreso);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnAnterior.setBounds(138, 483, 105, 23);
		add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSiguiente.setBounds(676, 484, 105, 23);
		add(btnSiguiente);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(96, 527, 736, 2);
		add(separador);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnModificar.setBounds(290, 551, 105, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnEliminar.setBounds(421, 552, 105, 23);
		add(btnEliminar);
		
		JButton btnGanancias = new JButton("Ganancias");
		btnGanancias.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnGanancias.setBounds(557, 552, 105, 23);
		add(btnGanancias);
		
		this.lbl2Precio = new JLabel("XXXXXXXXX");
		lbl2Precio.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Precio.setBounds(127, 369, 77, 14);
		add(lbl2Precio);
		
		this.lbl2PrecioUnidad = new JLabel("XXXXXXXXX");
		lbl2PrecioUnidad.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2PrecioUnidad.setBounds(318, 369, 77, 14);
		add(lbl2PrecioUnidad);
		
		lbl2Marca = new JLabel("XXXXXXXXX");
		lbl2Marca.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Marca.setBounds(451, 368, 77, 14);
		add(lbl2Marca);
		
		JLabel lbl2Empacado = new JLabel("XXXXXXXXX");
		lbl2Empacado.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Empacado.setBounds(614, 369, 77, 14);
		add(lbl2Empacado);
		
		JLabel lbl2Categoria = new JLabel("XXXXXXXXX");
		lbl2Categoria.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Categoria.setBounds(770, 369, 77, 14);
		add(lbl2Categoria);
		
		JLabel lbl2Gondola = new JLabel("XXXXXXXXX");
		lbl2Gondola.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Gondola.setBounds(138, 415, 77, 14);
		add(lbl2Gondola);
		
		JLabel lbl2SKU = new JLabel("XXXXXXXXX");
		lbl2SKU.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2SKU.setBounds(265, 415, 77, 14);
		add(lbl2SKU);
		
		JLabel lbl2Peso = new JLabel("XXXXXXXXX");
		lbl2Peso.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Peso.setBounds(440, 415, 77, 14);
		add(lbl2Peso);
		
		JLabel lbl2FechaIngreso = new JLabel("XXXXXXXXX");
		lbl2FechaIngreso.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2FechaIngreso.setBounds(638, 415, 77, 14);
		add(lbl2FechaIngreso);
	}
	
	
	
	public void actualizar()
	{
		//1. Recuperar referencia
		Referencia referencia = principalInventario.getReferencia();
	
		//2. Actualizar informaci�n Panel Principal
		actualizarBanner(referencia);
		//3. Actualizar informaci�n Lote
		actualizarInfoLote(referencia);
		
		//4. Actualizar Imagen
		
		//5. Actualizar Informaci�n General
		actualizarInfoGen(referencia);
	}
	
	private void actualizarInfoLote(Referencia referencia)
	{
		SortedMap<LocalDate, Producto> productos = referencia.getProductos();
		Producto primerProd = productos.get(productos.firstKey());
		
		Lote lote = primerProd.getLote();
		String id = lote.getId();
		String vencimiento = lote.getVencimiento();
		String unidades = Double.toString(lote.getUnidades());
		
		//Cambiar informaci�n
		
		this.lbl2Lote.setText(id);
		this.lbl2Unidades.setText(unidades);
		this.lbl2Vencimiento.setText(vencimiento);
		
		
	}
	
	private void actualizarBanner(Referencia referencia)
	{
		SortedMap<LocalDate, Producto> productos = referencia.getProductos();
		Producto primerProd = productos.get(productos.firstKey());
		String titulo = primerProd.getNombre();
		this.principalInventario.actualizarBanner(titulo);
		
	}
	
	private void actualizarImagen(Referencia referencia)
	{
		
	}
	
	private void actualizarInfoGen(Referencia referencia) 
	{
		SortedMap<LocalDate, Producto> productos = referencia.getProductos();
		Producto primerProd = productos.get(productos.firstKey());

		//1. Precio
		this.lbl2Precio.setText(Double.toString(primerProd.getPrecioUnidad()));

		//2. Marca
		this.lbl2Marca.setText(primerProd.getMarca());

	}
	
	
	
	
	
}
