package interfaz.interfazInventario;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;

import appInventario.Referencia;
import appPOS.Cliente;  
import appPOS.Venta;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import appInventario.DesempenoFinanciero;

public class VentanaFinanciera extends JFrame {  
	  
	  private static final long serialVersionUID = 5L;  
	  
	  private Referencia referencia;
	  
	  public VentanaFinanciera(Referencia referencia)
	  {  
		  this.referencia = referencia;
		this.setTitle("Desempeño Financiero del Producto");
	    // Crear la informaci�n 
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try 
		{
			String nombre;
			if (referencia.getProductos().isEmpty())
			{
				nombre = referencia.getSKU();
			}
			else
			{
				nombre = referencia.getNombre();
			}
			dataset = createDataset();
			//Crear el grafico
			JFreeChart chart = ChartFactory.createBarChart(  
	        "Desempeño financiero de " + nombre, //Titulo 
	        "Desempeño", // Eje x  
	        "Monto (pesos)", // Eje y  
	        dataset  
	        );  
			ChartPanel panel = new ChartPanel(chart);  
			setContentPane(panel);  
			this.setVisible(true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}  
	    
	  }  
	  
	  private DefaultCategoryDataset createDataset() throws Exception 
	  {  

	    String series1 = "Desempeño financiero";  
	  
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

	    DesempenoFinanciero financiero = this.referencia.getDesempenio();
	    
	    double utilidades = financiero.getUtilidades(); 
	    double ventas = financiero.getVentas(); 
	    double perdidas = financiero.getPerdidas(); 
	    
	   if (referencia == null)
	   {
		   throw new Exception("Asegurese de que seleccionó una Referencia o Lote y no una Categoria o Gondola");
	   }
	   else
	   {
		   dataset.addValue(ventas, series1, "Ventas");
		   dataset.addValue(utilidades, series1, "Utilidades");
		   dataset.addValue(perdidas, series1, "Perdidas");
	   }

	   	 return dataset;  
	  }  
	  
}