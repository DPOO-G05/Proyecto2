package interfaz.interfazInventario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.SortedMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;

import appInventario.Categoria;
import appInventario.Gondola;
import appInventario.Lote;
import appInventario.Producto;
import appInventario.Referencia;
import interfaz.CoordinadorUI;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class PanelProducto extends JPanel implements ActionListener {
	
	private UIInventario principalInventario;
	
	private JLabel lbl2Lote;
	
	private JLabel lbl2Vencimiento;
	
	private JLabel lbl2Unidades;
	
	private JLabel lbl2Precio;
	
	private JLabel lbl2PrecioUnidad;

	private JLabel lbl2Marca;

	private JLabel lbl2Empacado;

	private JLabel lbl2Categoria;
	
	private JLabel lbl2Gondola;

	private JLabel lbl2SKU;

	private JLabel lbl2Peso;

	private JLabel lbl2FechaIngreso;
	
	private final static String BUSQUEDA_SKU = "BUSQUEDA_SKU";
	
	private final static String CAMBIAR_IMAGEN = "CAMBIAR_IMAGEN";
	
	private final static  String  GRAFICO_COMPORTAMIENTO = "GRAFICO_COMPORTAMIENTO";

	private final static  String  DESEMPENO = "DESEMPENO";

	private JPanel panelImagen;

	public PanelProducto(UIInventario principalInventario) 
	{
		
		//Inicializar referencias
		
		this.principalInventario = principalInventario;
		
		//Configuraci�n par�metros
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
		JButton btnSKU = new JButton("Buscar por SKU o Lote");
		btnSKU.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSKU.addActionListener(this);
		btnSKU.setActionCommand(BUSQUEDA_SKU);
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
		
		this.panelImagen = new JPanel();
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
		
		JLabel lblMarca = new JLabel("Marca:");
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
		
		JSeparator separador = new JSeparator();
		separador.setBounds(96, 527, 736, 2);
		add(separador);
		
		JButton btnGanancias = new JButton("Ganancias");
		btnGanancias.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnGanancias.setBounds(516, 545, 105, 23);
		btnGanancias.setActionCommand(DESEMPENO);
		btnGanancias.addActionListener(this);
		add(btnGanancias);
		
		this.lbl2Precio = new JLabel("XXXXXXXXX");
		lbl2Precio.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Precio.setBounds(127, 369, 77, 14);
		add(lbl2Precio);
		
		this.lbl2PrecioUnidad = new JLabel("XXXXXXXXX");
		lbl2PrecioUnidad.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2PrecioUnidad.setBounds(318, 369, 77, 14);
		add(lbl2PrecioUnidad);
		
		this.lbl2Marca = new JLabel("XXXXXXXXX");
		lbl2Marca.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Marca.setBounds(451, 368, 77, 14);
		add(lbl2Marca);
		
		this.lbl2Empacado = new JLabel("XXXXXXXXX");
		lbl2Empacado.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Empacado.setBounds(614, 369, 77, 14);
		add(lbl2Empacado);
		
		this.lbl2Categoria = new JLabel("XXXXXXXXX");
		lbl2Categoria.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Categoria.setBounds(770, 369, 120, 14);
		add(lbl2Categoria);
		
		this.lbl2Gondola = new JLabel("XXXXXXXXX");
		lbl2Gondola.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Gondola.setBounds(138, 415, 77, 14);
		add(lbl2Gondola);
		
		this.lbl2SKU = new JLabel("XXXXXXXXX");
		lbl2SKU.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2SKU.setBounds(265, 415, 77, 14);
		add(lbl2SKU);
		
		this.lbl2Peso = new JLabel("XXXXXXXXX");
		lbl2Peso.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2Peso.setBounds(440, 415, 77, 14);
		add(lbl2Peso);
		
		this.lbl2FechaIngreso = new JLabel("XXXXXXXXX");
		lbl2FechaIngreso.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lbl2FechaIngreso.setBounds(638, 415, 77, 14);
		add(lbl2FechaIngreso);
		
		JButton btnCambiarImagen= new JButton("Cambiar Imagen");
		btnCambiarImagen.addActionListener(this);
		btnCambiarImagen.setActionCommand(CAMBIAR_IMAGEN);
		btnCambiarImagen.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnCambiarImagen.setBounds(252, 546, 143, 23);
		add(btnCambiarImagen);
		
		JButton btnGraficoComportamiento = new JButton("GRAFICO COMPORTAMIENTO");
		btnGraficoComportamiento.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnGraficoComportamiento.setActionCommand(GRAFICO_COMPORTAMIENTO);
		btnGraficoComportamiento.setBounds(230, 453, 453, 36);
		btnGraficoComportamiento.addActionListener(this);
		add(btnGraficoComportamiento);
	}
	
	
	
	public void actualizar(String tipo)
	{
		//params
		/*
		 * Recibe como parámetro el tipo de actualizacioń que va a hacer: 1) "referencia"
		 * o 2) "lote" 
		 * Esto depende de la interacción del usuario
		 */
		//1. Recuperar referencia
		Referencia referencia = principalInventario.getReferencia();
		Producto prod = principalInventario.getProducto();
		if (tipo.equals("agotado"))
		{
			actualizarAgotado(referencia);
		}
		else if (tipo.equals("referencia"))
		{
			String unidades = Integer.toString(referencia.getRestantes());
			this.lbl2Unidades.setText(unidades);
			actualizarNoAgotado(referencia, prod);
		}
		else if (tipo.equals("lote"))
		{
			String unidades = Double.toString(prod.getLote().getUnidades());
			this.lbl2Unidades.setText(unidades);
			actualizarNoAgotado(referencia, prod);
		}
	
	}
	
	private void actualizarAgotado(Referencia ref)
	{
		actualizarImagen(ref);
		String titulo = ref.getSKU() + " - " + "AGOTADO";
		this.principalInventario.actualizarBanner(titulo);
		this.resetLabels();
	}
	
	private void resetLabels()
	{
		this.lbl2Lote.setText("");
		this.lbl2Vencimiento.setText("");
		this.lbl2Precio.setText("");
		this.lbl2PrecioUnidad.setText("");
		this.lbl2Marca.setText("");
		this.lbl2Empacado.setText("");
		this.lbl2Categoria.setText("");			
		this.lbl2Gondola.setText("");
		this.lbl2SKU.setText("");
		this.lbl2Peso.setText("");
		this.lbl2FechaIngreso.setText("");
	}



	private void actualizarNoAgotado(Referencia referencia, Producto prod)
	{

		//2. Actualizar informaci�n Panel Principal
		actualizarBanner(referencia, prod);
		//3. Actualizar informaci�n Lote
		actualizarInfoLote(referencia, prod);
		//4. Actualizar Informaci�n General
		actualizarInfoGen(referencia, prod);
		//5. Actualizar Imagen
		actualizarImagen(referencia);

	}



	private void actualizarInfoLote(Referencia referencia, Producto producto)
	{
		Producto primerProd = producto; 
		
		Lote lote = primerProd.getLote();
		String id = lote.getId();
		String vencimiento = lote.getVencimiento();
		
		//Cambiar informaci�n
		
		this.lbl2Lote.setText(id);
		this.lbl2Vencimiento.setText(vencimiento);
		
		
	}
	
	private void actualizarBanner(Referencia referencia, Producto producto)
	{
		Producto primerProd = producto; 
		String titulo = primerProd.getNombre();
		this.principalInventario.actualizarBanner(titulo);
		
	}
	
	public void actualizarImagen(Referencia referencia)
	{
		if (!(referencia.getImagen() == null))
		{
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(referencia.getImagen());
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				this.panelImagen.removeAll();
				this.panelImagen.revalidate();
				this.panelImagen.add(picLabel);
				this.panelImagen.repaint();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		else
		{
			this.panelImagen.removeAll();
			this.panelImagen.revalidate();
			this.panelImagen.add(new JLabel("Imagen no disponible"));
			this.panelImagen.repaint();
		}
		
	}
	
	private void actualizarInfoGen(Referencia referencia, Producto producto) 
	{
		Producto primerProd = producto; 

		
		//1. Precio
		this.lbl2Precio.setText(Double.toString(primerProd.getPrecioUnidad()));
		this.lbl2PrecioUnidad.setText(Double.toString(primerProd.getPrecioUnidad()));

		//2. Marca
		this.lbl2Marca.setText(primerProd.getMarca());

		//3. Empacado
		this.lbl2Empacado.setText(primerProd.isEmpacado()? "Si": "No");

		//4. Categoria y Góndola
			//1. Obtener la góndola
		Gondola gondola = referencia.getGondola();
		Categoria cat = gondola.getCategoria();

			//2. Cambiar información 
		this.lbl2Categoria.setText(cat.getNombre());			
		this.lbl2Gondola.setText(gondola.getNombre());

		//5. SKU
		this.lbl2SKU.setText(referencia.getSKU());

		//6. Peso
		this.lbl2Peso.setText(primerProd.getPesoNeto());

		//7. FechaIngreso
		this.lbl2FechaIngreso.setText(primerProd.getFechaIngreso().toString());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if (comando.equals(BUSQUEDA_SKU))
		{
			buscarPorSKU();

		}
		else if(comando.equals(CAMBIAR_IMAGEN))
		{
			this.principalInventario.actualizarImagen();
		}
		else if(comando.equals(GRAFICO_COMPORTAMIENTO))
		{
			this.principalInventario.graficoComportamiento();
		}
		else if (comando.equals(DESEMPENO))
		{
			this.principalInventario.mostrarDesempeno();
		}
		
	}
	
	private void buscarPorSKU()
	{
		Object[] opciones = {"SKU", "Lote"};
		Object opcionDefault = opciones[0];
		int seleccion = JOptionPane.showOptionDialog(this,
		             "�Quiere buscar por SKU o ID de Lote?",
		             "Busqueda",
		             JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE,
		             null,
		             opciones,
		             opcionDefault);

		//Recuperar el coordinador

		CoordinadorUI coordinador = this.principalInventario.getPrincipal().getCoordinador();
		//Leer la informaci�n
		if (seleccion == JOptionPane.YES_OPTION) {
				//Solicitar el SKU
			String SKU = JOptionPane.showInputDialog("Introduzca el SKU","SKU...");
			if (SKU != null)
			{
				SKU = SKU.strip().toUpperCase();
				HashMap<String, Referencia> referencias = coordinador.getSistemaInventario().getReferencias();
				Referencia ref = referencias.get(SKU);
				Producto prod = ref.getProductos().get(ref.getProductos().firstKey());
				this.principalInventario.actualizarReferencia(ref, prod, "referencia");
				System.out.println(SKU);
			}

		}
		else if (seleccion == JOptionPane.NO_OPTION) {
				//Solicitar el Id Panel
			String idLote = JOptionPane.showInputDialog("Introduzca el ID del Lote","ID...");
			if (idLote != null)
			{
				idLote = idLote.strip().toUpperCase();
				//Recuperar el Lote
				HashMap<String, Lote> lotes = coordinador.getSistemaInventario().getLotes();
				Lote lote = lotes.get(idLote);
				//Actualizar informaci�n
				Producto producto = lote.getProducto();
				Referencia referencia = producto.getReferencia();
				this.principalInventario.actualizarReferencia(referencia, producto,"lote");
			}
		}
		else {
			
			//Warning: No seleccion� nada
			
		    JOptionPane.showMessageDialog(this, "Debe seleccionar una opci�n", "Advertencia",JOptionPane.WARNING_MESSAGE);	
			
		}
			
			
			
			
	
	}
}
