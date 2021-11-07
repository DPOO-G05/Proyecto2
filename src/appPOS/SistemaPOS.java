package appPOS;

import java.util.ArrayList;

public class SistemaPOS {
	private ControladorCliente controladorCliente;
	private ArrayList<String> listaProd;
	
	
	
	
	public void inicializarSistema() {
		ControladorCliente contCliente = new ControladorCliente();
	}
	
	public void iniciarListaProductos() {
		this.listaProd = new ArrayList<>();
	}

	
	//metodo constructor  y hacer this."" segun necesario
}
