package br.com.empresa.model.graficos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;

public class GraficoBarraBuilder {
	
	private List<BarDataset>  datasets = new ArrayList<>();
	private BarData barData = new BarData();
	private BarChart barChart = new BarChart();
	private Map<String,Integer> map;
	
	public GraficoBarraBuilder(Map<String, Integer> map) {
		this.map = map;
	}
	
	public String getGraficoBarras() {
		
		Collection<String> labels = this.map.keySet();
		
		List<Integer> values = new ArrayList<Integer>(this.map.values());
		
		Object[] array = values.toArray();
		int [] valores = new int[array.length];

		for(int i = 0 ; i < array.length ; i++){
			Integer integer = (Integer) array[i];
			valores[i] = integer.intValue();
		}

		BarDataset barDataSet = new BarDataset();
		barDataSet.setLabel("Classes Excessoes");
		barDataSet.setData(valores);
		barDataSet.addBorderColor(Color.WHITE);
		barDataSet.setBorderWidth(2);
		barDataSet.addBackgroundColor(Color.BLUE);
		datasets.add(barDataSet);

		barData.setLabels(labels);
		barData.setDatasets(datasets);

		
		barChart.setData(barData);
		return barChart.toJson();
	}

}
