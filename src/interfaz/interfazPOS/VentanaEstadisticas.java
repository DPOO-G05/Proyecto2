package interfaz.interfazPOS;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;

import appPOS.Cliente;  
import appPOS.Venta;

import java.time.*;
import java.util.HashMap;
import java.util.TreeMap;

public class VentanaEstadisticas extends JFrame {  
	  
	  private static final long serialVersionUID = 5L;  
	  
	  private Cliente cliente;
	  
	  public VentanaEstadisticas(Cliente cliente)
	  {  

		this.cliente = cliente;
		this.setTitle("Estadisticas de compra");
	    // Crear la información 
	    DefaultCategoryDataset dataset = createDataset();  
	    //Crear el gráfico
	    JFreeChart chart = ChartFactory.createBarChart(  
	        "Compras de " + this.cliente.getNombre(), //Titulo 
	        "Fecha", // Eje x  
	        "Monto", // Eje y  
	        dataset  
	        );  
	  
	    ChartPanel panel = new ChartPanel(chart);  
	    setContentPane(panel);  
	    this.setVisible(true);
	  }  
	  
	  private DefaultCategoryDataset createDataset() {  
	  
	    String series1 = "Compras";  
	  
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
	    
	    TreeMap<LocalDate, Double> compras = new TreeMap<>();
	    
	    HashMap<String, Venta> ventas = this.cliente.getCompras();
	    
	    for(String llave: ventas.keySet())
	    {
	    	Venta venta = ventas.get(llave);
	    	String id = venta.getId();
	    	String[] partes = id.split(",");
	    	LocalDate fecha = LocalDate.parse(partes[0]);
	    	compras.put(fecha,venta.getMonto());
	    }
	    
	    for(LocalDate fecha: compras.keySet())
	    {
	    	String label = fecha.toString();
	    	double valor = compras.get(fecha);
	    	dataset.addValue(valor, series1, label);
	    }
	    
	   	 	    return dataset;  
	  }  
	  
}