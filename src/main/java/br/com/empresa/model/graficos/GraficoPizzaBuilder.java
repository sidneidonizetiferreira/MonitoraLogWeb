package br.com.empresa.model.graficos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import be.ceau.chart.PieChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.PieData;
import be.ceau.chart.dataset.PieDataset;


public class GraficoPizzaBuilder {
	
	private PieChart piechart = new PieChart();
	private PieDataset pieDataset = new PieDataset(); 
	private PieData pieData = new PieData();
	private Map<String,Integer> map;
	
	public GraficoPizzaBuilder(Map<String,Integer> map){
		this.map = map;
	}
	
	public String getGraficoTipoErros() {

		Collection<String> labels = this.map.keySet();
		
		List<Integer> values = new ArrayList<Integer>(this.map.values());
		
		Object[] array = values.toArray();
		int [] valores = new int[array.length];

		for(int i = 0 ; i < array.length ; i++){
			Integer integer = (Integer) array[i];
			valores[i] = integer.intValue();
		}

		pieData.setLabels(labels);
		pieDataset.setData(valores).addBackgroundColors(Color.GRAY).setBorderWidth(1);

		pieData.addDataset(pieDataset);
		piechart.setData(pieData);
		return piechart.toJson();
	}

}
