package br.com.empresa.model.graficos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;

public class GraficoLineBuilder {
	
	private LineData lineData = new LineData();
	private LineChart lineChart = new LineChart();
	private List<LineDataset> lineDatasets = new ArrayList<>();
	private List<String> periodos ;
	private Map<String,List<Integer>> lines;
	
	
	public GraficoLineBuilder(List<String> periodos, Map<String, List<Integer>> lines) {
		this.periodos = periodos;
		this.lines = lines;
		
	}


	public String getTotalErrosPorPeriodo() {
		
		Set<Entry<String,List<Integer>>> entrySet = lines.entrySet();
		for (Entry<String, List<Integer>> entry : entrySet) {
			
			List<Integer> valores = entry.getValue();
			Object[] array = valores.toArray();
			int [] valoresArray = new int[array.length];

			for(int i = 0 ; i < array.length ; i++){
				Integer integer = (Integer) array[i];
				valoresArray[i] = integer.intValue();
			}
			LineDataset lineDataSet = new LineDataset();lineDataSet.setLabel(entry.getKey())
			.setData(valoresArray).setBorderColor(Color.AQUA);
			lineDatasets.add(lineDataSet);
		}
		
		
		String [] legendaPeriodoArray = new String[periodos.size()];
		
		for(int i = 0 ; i < periodos.size() ; i++){
			String periodo = periodos.get(i);
			legendaPeriodoArray[i] = periodo;
		}
		
		lineData.addLabels(legendaPeriodoArray).setDatasets(lineDatasets);
		lineChart.setData(lineData);
		return lineChart.toJson();
	}

}
