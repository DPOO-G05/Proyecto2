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

public class VentanaEstadisticasRef extends JFrame {  
	  
	  private static final long serialVersionUID = 5L;  
	  
	  private Referencia referencia;
	  
	  public VentanaEstadisticasRef(Referencia referencia)
	  {  
		  this.referencia = referencia;
		this.setTitle("Comportamiento del Inventario en el Tiempo");
	    // Crear la informaci�n 
	    DefaultCategoryDataset dataset = createDataset();  
	    //Crear el grafico
	    JFreeChart chart = ChartFactory.createBarChart(  
	        "Comportamiento del Inventario de  " + this.referencia.getNombre(), //Titulo 
	        "Fecha", // Eje x  
	        "Cantidad", // Eje y  
	        dataset  
	        );  
	  
	    ChartPanel panel = new ChartPanel(chart);  
	    setContentPane(panel);  
	    this.setVisible(true);

	  }  
	  
	  private DefaultCategoryDataset createDataset() 
	  {  

	    String series1 = "Cantidad";  
	  
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

	    ArrayList<String> dataCantidades = this.referencia.getDataInventario();
	    
	    for (String entrada: dataCantidades)
	    {

	    	String[] informacion = entrada.split(",");
	    	String fecha = informacion[0];
	    	String cantidad = informacion[1];
	    	int cantidadInt = Integer.parseInt(cantidad);
	    	dataset.addValue(cantidadInt, series1, fecha);
	    }
    
	   	 	    return dataset;  
	  }  
	  
}