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

import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.Legend;
import be.ceau.chart.options.scales.BarScale;
import be.ceau.chart.options.scales.GridLines;
import be.ceau.chart.options.scales.YAxis;
import be.ceau.chart.options.ticks.LinearTicks;;

public class GraficoBarraBuilder {
	
	private List<BarDataset>  datasets = new ArrayList<>();
	private BarData barData = new BarData();
	private BarChart barChart = new BarChart();
	private Map<String,Integer> map;
	private ObjectMapper mapper = new ObjectMapper();
	
	
	public GraficoBarraBuilder(final String json) {
		TypeReference<HashMap<String, Integer>> typeRef   = new TypeReference<HashMap<String, Integer>>() {};
		try {
			this.map = mapper.readValue(json, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getGraficoBarras() {
		barChart.isHorizontal();
		Collection<String> labels = this.map.keySet();
		
		List<Integer> values = new ArrayList<Integer>(this.map.values());
		
		Object[] array = values.toArray();
		int [] valores = new int[array.length];

		for(int i = 0 ; i < array.length ; i++){
			Integer integer = (Integer) array[i];
			valores[i] = integer.intValue();
		}

		BarDataset barDataSet = new BarDataset();

		barDataSet.setLabel("Classes Exceções");
		barDataSet.setData(valores);
		barDataSet.addBorderColor(new Color(75,192,192,1));
		barDataSet.setBorderWidth(2);
		barDataSet.addBackgroundColor(new Color(75,192,192,1));
//		new Color(75,4,140,1)

		datasets.add(barDataSet);

		barData.setLabels(labels);
		barData.setDatasets(datasets);
		
		Legend legend = new Legend();
		legend.setDisplay(false);
		
		LinearTicks linearTicks = new LinearTicks();
		linearTicks.setFontColor(Color.WHITE);
		linearTicks.setFontSize(new BigDecimal(15));
		
		List<Color> listaColor = new ArrayList<Color>();
		listaColor.add(Color.WHITE);
		
		GridLines gridLine = new GridLines();
		gridLine.setZeroLineColor(Color.WHITE);
		gridLine.setColor(listaColor);
		gridLine.setDisplay(true);
		
		YAxis<LinearTicks> yAxis = new YAxis<LinearTicks>();
		yAxis.setTicks(linearTicks);
		
		BarScale barscale = new BarScale();
		barscale.setGridLines(gridLine);
		barscale.setDisplay(true);
		barscale.addyAxes(yAxis);
		
		BarOptions options = new BarOptions();
		options.setScales(barscale);
		options.setLegend(legend);
		
		
		barChart.setHorizontal();
		barChart.setOptions(options);
		barChart.setData(barData);
		
		
		return barChart.toJson();
	}

}
