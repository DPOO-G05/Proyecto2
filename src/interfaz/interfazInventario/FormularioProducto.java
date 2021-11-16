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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JFileChooser imageChooser;
	private final static String ESCOGER_IMAGEN = "ESCOGER_IMAGEN";
	private final static String AGREGAR_PRODUCTO = "AGREGAR_PRODUCTO";
	private File imagenProducto;
	private JTextField lblRutaImagen;

	public FormularioProducto(UIInventario principalInventario) {
		
		//Inicializar referencias
		
		this.principalInventario = principalInventario;
		//Tamaño de la ventana
		
		this.setSize(350,700);
		this.setResizable(false);
	
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(20, 11, 79, 17);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(109, 8, 164, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSku = new JLabel("SKU:");
		lblSku.setBounds(20, 46, 30, 14);
		panel.add(lblSku);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 43, 197, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(20, 94, 60, 14);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 93, 183, 73);
		panel.add(scrollPane);
		
		JTree tree = new JTree();
		popularCategorias();
		scrollPane.setViewportView(tree);
		
		JLabel lblNewLabel_2 = new JLabel("Otra / Seleccion: ");
		lblNewLabel_2.setBounds(20, 194, 113, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 191, 130, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gondola");
		lblNewLabel_1_1.setBounds(20, 247, 60, 14);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(90, 261, 183, 73);
		panel.add(scrollPane_1);
		
		JTree tree_1 = new JTree();
		popularGondolas();
		scrollPane_1.setViewportView(tree_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Otra / Seleccion: ");
		lblNewLabel_2_1.setBounds(20, 363, 113, 14);
		panel.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 360, 130, 20);
		panel.add(textField_3);
		
		panel.setPreferredSize(new Dimension(350, 1500));	
		
		JLabel lblNewLabel_3 = new JLabel("Marca:");
		lblNewLabel_3.setBounds(20, 421, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(76, 418, 197, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Empacado:");
		lblNewLabel_3_1.setBounds(20, 470, 78, 14);
		panel.add(lblNewLabel_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBox.setBounds(108, 466, 165, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad (Unidad Medida):");
		lblNewLabel_4.setBounds(20, 521, 185, 14);
		panel.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(215, 518, 125, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Costo (por unidad medida):");
		lblNewLabel_4_1.setBounds(20, 559, 185, 14);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Precio Venta (por unidad medida):");
		lblNewLabel_4_1_1.setBounds(20, 600, 185, 14);
		panel.add(lblNewLabel_4_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(215, 556, 125, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(215, 597, 125, 20);
		panel.add(textField_7);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Peso Neto (en unidad medida):");
		lblNewLabel_4_1_1_1.setBounds(20, 641, 185, 14);
		panel.add(lblNewLabel_4_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(215, 638, 125, 20);
		panel.add(textField_8);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Unidad Venta (kg, g, paquete...):");
		lblNewLabel_4_1_1_1_1.setBounds(20, 684, 185, 14);
		panel.add(lblNewLabel_4_1_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(215, 681, 125, 20);
		panel.add(textField_9);
		
		JLabel lblNewLabel_5 = new JLabel("Temp Refrigerado:  ");
		lblNewLabel_5.setBounds(20, 715, 165, 14);
		panel.add(lblNewLabel_5);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(215, 712, 125, 20);
		panel.add(textField_10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Temp Congelado:  ");
		lblNewLabel_5_1.setBounds(20, 750, 165, 14);
		panel.add(lblNewLabel_5_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(215, 747, 125, 20);
		panel.add(textField_11);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("N\u00FAmero Lote:   ");
		lblNewLabel_5_1_1.setBounds(20, 803, 108, 14);
		panel.add(lblNewLabel_5_1_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(117, 800, 156, 20);
		panel.add(textField_12);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Fecha Vencimiento: ");
		lblNewLabel_5_1_1_1.setBounds(20, 848, 149, 14);
		panel.add(lblNewLabel_5_1_1_1);
		
		textField_13 = new JTextField();
		textField_13.setBounds(179, 845, 46, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("A\u00F1o");
		lblNewLabel_6.setBounds(179, 865, 46, 14);
		panel.add(lblNewLabel_6);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(235, 845, 46, 20);
		panel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(294, 845, 46, 20);
		panel.add(textField_15);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mes");
		lblNewLabel_6_1.setBounds(235, 865, 46, 14);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Dia");
		lblNewLabel_6_1_1.setBounds(294, 865, 46, 14);
		panel.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Imagen:");
		lblNewLabel_3_1_1.setBounds(20, 900, 60, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBox_1.setBounds(76, 896, 197, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Imagen:");
		lblNewLabel_3_1_1_1.setBounds(20, 943, 60, 14);
		panel.add(lblNewLabel_3_1_1_1);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setBounds(117, 939, 125, 23);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand(ESCOGER_IMAGEN);
		panel.add(btnNewButton);
		
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
//		
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
			Producto producto = this.crearProducto();
			principalInventario.agregarProducto(producto);
		}
		
	}
	
	private Producto crearProducto()
	{
		return this.principalInventario.getProducto();
	}
	
	private void popularCategorias()
	{
		
	}
	
	private void popularGondolas()
	{
		
	}
	
	
	
	
	
}
