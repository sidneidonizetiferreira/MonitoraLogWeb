package br.com.empresa.model.graficos;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import be.ceau.chart.PieChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.PieData;
import be.ceau.chart.dataset.PieDataset;
import be.ceau.chart.options.Legend;
import be.ceau.chart.options.LegendLabels;
import be.ceau.chart.options.Legend.Position;
import be.ceau.chart.options.PieOptions;


public class GraficoPizzaBuilder {
	
	private PieChart piechart = new PieChart();
	private PieDataset pieDataset = new PieDataset(); 
	private PieData pieData = new PieData();
	private Map<String,Integer> map;
	private ObjectMapper mapper = new ObjectMapper();
	
	
	public GraficoPizzaBuilder(final String json){
		TypeReference<HashMap<String, Integer>> typeRef   = new TypeReference<HashMap<String, Integer>>() {};
		try {
			this.map = mapper.readValue(json, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		pieDataset
		.setData(valores)
		.setBorderWidth(1)
		.addBackgroundColors(	new Color(104,162,160, 0.95), 
								new Color(26, 82, 115, 0.95), 
								new Color(25, 45, 115, 0.95),
								new Color(100,70,120,  0.95), 
								new Color(69, 66, 119, 0.95));
		
		pieData.addDataset(pieDataset);
		
		
		
		LegendLabels legendLabel = new LegendLabels();
		legendLabel.setFontColor(Color.WHITE);
		legendLabel.setFontSize(15);
		
		Legend legend = new Legend();
//		legend.setPosition(Position.RIGHT);
		legend.setDisplay(true);
		legend.setLabels(legendLabel);

	
		PieOptions pieOptions = new PieOptions();
		pieOptions.setLegend(legend);
		
		piechart.setOptions(pieOptions);
		piechart.setData(pieData);
		return piechart.toJson();
	}

}
