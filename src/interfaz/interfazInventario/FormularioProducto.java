package interfaz.interfazInventario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ScrollPaneConstants;

import appInventario.Producto;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JFileChooser;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.System.Logger;
import java.awt.Font;

public class FormularioProducto extends JFrame implements ActionListener {
	
	private UIInventario principalInventario;
	private JTextField txtNombre;
	private JTextField txtSKU;
	private JTextField txtCat;
	private JTextField txtGond;
	private JTextField txtMarca;
	private JTextField txtCantidad;
	private JTextField txtCosto;
	private JTextField txtPrecio;
	private JTextField txtPeso;
	private JTextField txtUnidadVenta;
	private JTextField txtRefrigerado;
	private JTextField txtCongelado;
	private JTextField txtLote;
	private JTextField txtAnio;
	private JTextField txtMes;
	private JTextField txtDia;
	private JFileChooser imageChooser;
	private final static String ESCOGER_IMAGEN = "ESCOGER_IMAGEN";
	private final static String AGREGAR_PRODUCTO = "AGREGAR_PRODUCTO";
	private File imagenProducto;
	private JTextField lblRutaImagen;
	private JComboBox opEmpacado;

	public FormularioProducto(UIInventario principalInventario) {
		
		//Inicializar referencias
		
		this.principalInventario = principalInventario;
		//Tamaño de la ventana
		this.setTitle("Agregar Producto");
		this.setSize(350,700);
		this.setResizable(false);
	
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl1Nombre = new JLabel("Nombre:");
		lbl1Nombre.setBounds(20, 11, 79, 17);
		panel.add(lbl1Nombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(109, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSku = new JLabel("SKU:");
		lblSku.setBounds(20, 46, 30, 14);
		panel.add(lblSku);
		
		txtSKU = new JTextField();
		txtSKU.setColumns(10);
		txtSKU.setBounds(76, 43, 197, 20);
		panel.add(txtSKU);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(20, 94, 60, 14);
		panel.add(lblNewLabel_1);
		popularCategorias();
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		txtCat.setBounds(90, 91, 183, 20);
		panel.add(txtCat);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gondola");
		lblNewLabel_1_1.setBounds(20, 152, 60, 14);
		panel.add(lblNewLabel_1_1);
		popularGondolas();
		
		txtGond = new JTextField();
		txtGond.setColumns(10);
		txtGond.setBounds(90, 149, 183, 20);
		panel.add(txtGond);
		
		panel.setPreferredSize(new Dimension(350, 1500));	
		
		JLabel lblNewLabel_3 = new JLabel("Marca:");
		lblNewLabel_3.setBounds(20, 421, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(76, 418, 197, 20);
		panel.add(txtMarca);
		
		JLabel lblNewLabel_3_1 = new JLabel("Empacado:");
		lblNewLabel_3_1.setBounds(20, 470, 78, 14);
		panel.add(lblNewLabel_3_1);
		
		this.opEmpacado = new JComboBox();
		opEmpacado.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		opEmpacado.setBounds(108, 466, 165, 22);
		panel.add(opEmpacado);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad (Unidad Medida):");
		lblNewLabel_4.setBounds(20, 521, 185, 14);
		panel.add(lblNewLabel_4);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(215, 518, 125, 20);
		panel.add(txtCantidad);
		
		JLabel lblNewLabel_4_1 = new JLabel("Costo (por unidad medida):");
		lblNewLabel_4_1.setBounds(20, 559, 185, 14);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Precio Venta (por unidad medida):");
		lblNewLabel_4_1_1.setBounds(20, 600, 185, 14);
		panel.add(lblNewLabel_4_1_1);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(10);
		txtCosto.setBounds(215, 556, 125, 20);
		panel.add(txtCosto);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(215, 597, 125, 20);
		panel.add(txtPrecio);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Peso Neto (en unidad medida):");
		lblNewLabel_4_1_1_1.setBounds(20, 641, 185, 14);
		panel.add(lblNewLabel_4_1_1_1);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(215, 638, 125, 20);
		panel.add(txtPeso);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Unidad Venta (kg, g, paquete...):");
		lblNewLabel_4_1_1_1_1.setBounds(20, 684, 185, 14);
		panel.add(lblNewLabel_4_1_1_1_1);
		
		txtUnidadVenta = new JTextField();
		txtUnidadVenta.setColumns(10);
		txtUnidadVenta.setBounds(215, 681, 125, 20);
		panel.add(txtUnidadVenta);
		
		JLabel lblNewLabel_5 = new JLabel("Temp Refrigerado:  ");
		lblNewLabel_5.setBounds(20, 715, 165, 14);
		panel.add(lblNewLabel_5);
		
		txtRefrigerado = new JTextField();
		txtRefrigerado.setColumns(10);
		txtRefrigerado.setBounds(215, 712, 125, 20);
		panel.add(txtRefrigerado);
		
		JLabel lblNewLabel_5_1 = new JLabel("Temp Congelado:  ");
		lblNewLabel_5_1.setBounds(20, 750, 165, 14);
		panel.add(lblNewLabel_5_1);
		
		txtCongelado = new JTextField();
		txtCongelado.setColumns(10);
		txtCongelado.setBounds(215, 747, 125, 20);
		panel.add(txtCongelado);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("N\u00FAmero Lote:   ");
		lblNewLabel_5_1_1.setBounds(20, 803, 108, 14);
		panel.add(lblNewLabel_5_1_1);
		
		txtLote = new JTextField();
		txtLote.setColumns(10);
		txtLote.setBounds(117, 800, 156, 20);
		panel.add(txtLote);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Fecha Vencimiento: ");
		lblNewLabel_5_1_1_1.setBounds(20, 848, 149, 14);
		panel.add(lblNewLabel_5_1_1_1);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(179, 845, 46, 20);
		panel.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblAnio = new JLabel("A\u00F1o");
		lblAnio.setBounds(179, 865, 46, 14);
		panel.add(lblAnio);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(235, 845, 46, 20);
		panel.add(txtMes);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(294, 845, 46, 20);
		panel.add(txtDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(235, 865, 46, 14);
		panel.add(lblMes);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(294, 865, 46, 14);
		panel.add(lblDia);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Imagen:");
		lblNewLabel_3_1_1.setBounds(20, 900, 60, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JComboBox opImagen = new JComboBox();
		opImagen.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		opImagen.setBounds(76, 896, 197, 22);
		panel.add(opImagen);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Imagen:");
		lblNewLabel_3_1_1_1.setBounds(20, 943, 60, 14);
		panel.add(lblNewLabel_3_1_1_1);
		
		JButton btnSelecImagen = new JButton("Seleccionar");
		btnSelecImagen.setBounds(117, 939, 125, 23);
		btnSelecImagen.addActionListener(this);
		btnSelecImagen.setActionCommand(ESCOGER_IMAGEN);
		panel.add(btnSelecImagen);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Ruta Imagen:");
		lblNewLabel_3_1_1_1_1.setBounds(20, 981, 93, 14);
		panel.add(lblNewLabel_3_1_1_1_1);
		
		lblRutaImagen = new JTextField();
		lblRutaImagen.setEnabled(false);
		lblRutaImagen.setColumns(10);
		lblRutaImagen.setBounds(117, 978, 223, 20);
		panel.add(lblRutaImagen);
		
		JButton btnAgregarProducto = new JButton("Agregar");
		btnAgregarProducto.addActionListener(this);
		btnAgregarProducto.setActionCommand(AGREGAR_PRODUCTO);
		btnAgregarProducto.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAgregarProducto.setBounds(90, 1027, 183, 23);
		panel.add(btnAgregarProducto);


		
		//Scroller 
		JScrollPane scroller = new JScrollPane(panel);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroller, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(ESCOGER_IMAGEN))
		{
			this.imageChooser = new JFileChooser(); 
			int valor = this.imageChooser.showOpenDialog(this);
			
			if(valor == JFileChooser.APPROVE_OPTION)
			{
				File file = imageChooser.getSelectedFile();
				this.imagenProducto = file;
				this.lblRutaImagen.setText(file.getPath());


			}
			else
			{
				System.out.println("Abrir cancelado por el usuario");
			}
		}
		
		else if(comando.equals(AGREGAR_PRODUCTO))
		{
			ArrayList<String> caracteristicas = this.crearProducto();
			principalInventario.agregarProducto(caracteristicas, this);
		}
		
	}
	
	private ArrayList<String> crearProducto()
	{
		ArrayList<String> caracteristicas = new ArrayList<>();
		String nombre = this.txtNombre.getText().strip().toUpperCase();
		caracteristicas.add(nombre);
		String SKU = this.txtSKU.getText().strip().toUpperCase();
		caracteristicas.add(SKU);
		String categoria = this.txtCat.getText().strip().toUpperCase();
		caracteristicas.add(categoria);
		String gondola = this.txtGond.getText().strip().toUpperCase();
		caracteristicas.add(gondola);
		String marca = this.txtMarca.getText().strip().toUpperCase();
		caracteristicas.add(marca);
		String empacado = this.opEmpacado.getSelectedIndex() == 0 ? "Y" : "N";
		caracteristicas.add(empacado);
		String cantidad = this.txtCantidad.getText().strip().toUpperCase();
		caracteristicas.add(cantidad);
		String costo = this.txtCosto.getText().strip().toUpperCase();
		caracteristicas.add(costo);
		String precio = this.txtPrecio.getText().strip().toUpperCase();
		caracteristicas.add(precio);
		String pesoNeto = this.txtPeso.getText().strip().toUpperCase();
		caracteristicas.add(pesoNeto);
		String unidad = this.txtUnidadVenta.getText().strip().toUpperCase();
		caracteristicas.add(unidad);
		String tempRef = this.txtUnidadVenta.getText().strip().toUpperCase();
		caracteristicas.add(tempRef);
		String tempCongelado = this.txtCongelado.getText().strip().toUpperCase();
		caracteristicas.add(tempCongelado);
		String idLote = this.txtLote.getText().strip().toUpperCase(); 
		caracteristicas.add(idLote);
		String vencimiento = this.txtAnio.getText().strip().toUpperCase() + "-" + this.txtMes.getText().strip().toUpperCase() + "-" + this.txtDia.getText().strip().toUpperCase();
		caracteristicas.add(vencimiento);
		String tieneImagen = this.imagenProducto == null ? "NO" : "SI";
		caracteristicas.add(tieneImagen);
		return caracteristicas;

		
	}
	
	private void popularCategorias()
	{
		
	}
	
	private void popularGondolas()
	{
		
	}
	
	public File getImagen()
	{
		return this.imagenProducto;
	}
	
	
	
	
	
}
