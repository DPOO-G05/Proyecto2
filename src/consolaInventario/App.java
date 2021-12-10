package consolaInventario;
import java.io.*;
import java.util.*;

import appInventario.*;
import interfaz.UI;

public class App {

	
	//private SistemaInventario sistemaInventario;
	private UI ui;

	public App() 
	{

		this.ui = new UI();
		//cargarInformacion();
		//desplegarInformacion();
	}

	
	public static void main(String[] args) {
		System.out.println("Aplicaci�n Iniciada");
		
		
		App app = new App();

	}

	
	private void cargarCSV()
	{
		//this.sistemaInventario.leerCSV();
		System.out.println("Informaci�n Cargada Exitosamente");
	}
	
	
}
