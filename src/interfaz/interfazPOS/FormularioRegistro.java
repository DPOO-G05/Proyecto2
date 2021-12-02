package interfaz.interfazPOS;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FormularioRegistro extends JFrame implements ActionListener {

	private static final String ENVIAR = "ENVIAR";
	private static final String HOMBRE = "HOMBRE";
	private static final String MUJER = "MUJER";
	private static final String OTRO = "OTRO";
	private UIPos principal;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtEstCivil;
	private JTextField txtSitLaboral;
	private JComboBox boxSexo;


	public FormularioRegistro(UIPos principal)
	{
		this.principal = principal;
		setTitle("Registrar Cliente");
		this.setSize(400,550);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(24, 33, 84, 13);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 32, 227, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdad.setBounds(24, 100, 75, 13);
		panel.add(lblEdad);
		
		this.txtEdad= new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(119, 99, 227, 19);
		panel.add(txtNombre);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSexo.setBounds(24, 181, 113, 13);
		panel.add(lblSexo);
		
		this.boxSexo = new JComboBox();
		boxSexo.setModel(new DefaultComboBoxModel(new String[] {HOMBRE,MUJER,OTRO}));
		boxSexo.setSelectedIndex(0);
		boxSexo.setBounds(124, 179, 222, 21);
		panel.add(boxSexo);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil: ");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEstadoCivil.setBounds(24, 261, 113, 13);
		panel.add(lblEstadoCivil);
		
		this.txtEstCivil = new JTextField();
		txtEstCivil.setColumns(10);
		txtEstCivil.setBounds(158, 260, 188, 19);
		panel.add(txtEstCivil);
		
		JLabel lblSituacinLaboral = new JLabel("Situaci\u00F3n Laboral: ");
		lblSituacinLaboral.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSituacinLaboral.setBounds(24, 345, 166, 13);
		panel.add(lblSituacinLaboral);
		
		this.txtSitLaboral= new JTextField();
		txtSitLaboral.setColumns(10);
		txtSitLaboral.setBounds(185, 344, 161, 19);
		panel.add(txtSitLaboral);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviar.setBounds(139, 433, 113, 41);
		btnEnviar.addActionListener(this);
		btnEnviar.setActionCommand(ENVIAR);
		panel.add(btnEnviar);
		
		this.txtEdad = new JTextField();
		txtEdad.setBounds(119, 99, 227, 19);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String comando = e.getActionCommand();
		
		if(comando.equals(ENVIAR))
		{
			ArrayList<String> atributos = new ArrayList<>();
			String nombre = this.txtNombre.getText().strip().toUpperCase();
			atributos.add(nombre);
			String edad = this.txtEdad.getText().strip().toUpperCase(); 
			atributos.add(edad);
			String sitLaboral = this.txtSitLaboral.getText().strip().toUpperCase();  
			atributos.add(sitLaboral);
			String estCivil = this.txtEstCivil.getText().strip().toUpperCase();
			atributos.add(estCivil);
			String sexoSelec = this.boxSexo.getSelectedItem().toString();
			atributos.add(sexoSelec);
			String cedula = principal.getClienteActual().getCedula();
			principal.afiliarClienteInfo(atributos, cedula);
			System.out.println(principal.getClienteActual().getNombre());
			principal.actualizarUsuario();
		}
		
	}
}
