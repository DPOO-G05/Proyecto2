package interfaz.interfazInventario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PanelProducto extends JPanel {
	public PanelProducto() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Buscar por SKU o Lote");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(69, 11, 763, 32);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Lote: ");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(69, 87, 47, 19);
		add(lblNewLabel);
		
		JLabel lblUnidades = new JLabel("Unidades: ");
		lblUnidades.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblUnidades.setBounds(399, 87, 77, 19);
		add(lblUnidades);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vencimiento: ");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(676, 87, 105, 19);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("XXXXXXXXX");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(115, 91, 112, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("XXXXXXXXX");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(479, 91, 112, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("XXXXXXXXX");
		lblNewLabel_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(778, 91, 112, 14);
		add(lblNewLabel_1_2_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(241, 140, 407, 211);
		add(panel);
		
		JLabel lblPrecio = new JLabel("Precio:  ");
		lblPrecio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblPrecio.setBounds(69, 365, 63, 19);
		add(lblPrecio);
		
		JLabel lblPreciounidad = new JLabel("Precio (unidad):  ");
		lblPreciounidad.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblPreciounidad.setBounds(202, 365, 120, 19);
		add(lblPreciounidad);
		
		JLabel lblMarca = new JLabel("Marca:   ");
		lblMarca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblMarca.setBounds(397, 365, 120, 19);
		add(lblMarca);
		
		JLabel lblEmpacado = new JLabel("Empacado:   ");
		lblEmpacado.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblEmpacado.setBounds(528, 365, 120, 19);
		add(lblEmpacado);
		
		JLabel lblCategoria = new JLabel("Categoria:   ");
		lblCategoria.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblCategoria.setBounds(694, 365, 120, 19);
		add(lblCategoria);
		
		JLabel lblGndola = new JLabel("G\u00F3ndola:  ");
		lblGndola.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblGndola.setBounds(69, 411, 82, 19);
		add(lblGndola);
		
		JLabel lblSku = new JLabel("SKU:  ");
		lblSku.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblSku.setBounds(202, 411, 82, 19);
		add(lblSku);
		
		JLabel lblPeso = new JLabel("Peso:  ");
		lblPeso.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblPeso.setBounds(397, 411, 82, 19);
		add(lblPeso);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:  ");
		lblFechaIngreso.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblFechaIngreso.setBounds(528, 411, 120, 19);
		add(lblFechaIngreso);
		
		JButton btnNewButton_1 = new JButton("Anterior");
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_1.setBounds(138, 483, 105, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Siguiente");
		btnNewButton_1_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(676, 484, 105, 23);
		add(btnNewButton_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(96, 527, 736, 2);
		add(separator);
		
		JButton btnNewButton_1_2 = new JButton("Modificar");
		btnNewButton_1_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(290, 551, 105, 23);
		add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Eliminar");
		btnNewButton_1_2_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_1_2_1.setBounds(421, 552, 105, 23);
		add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Ganancias");
		btnNewButton_1_2_1_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton_1_2_1_1.setBounds(557, 552, 105, 23);
		add(btnNewButton_1_2_1_1);
	}
}
