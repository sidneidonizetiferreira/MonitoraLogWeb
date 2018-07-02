package br.com.empresa.model.graficos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;
import be.ceau.chart.enums.BorderCapStyle;
import be.ceau.chart.enums.BorderJoinStyle;
import be.ceau.chart.options.Legend;
import be.ceau.chart.options.LegendLabels;
import be.ceau.chart.options.LineOptions;
import be.ceau.chart.options.scales.GridLines;
import be.ceau.chart.options.scales.LinearScale;
import be.ceau.chart.options.scales.LinearScales;
import be.ceau.chart.options.scales.ScaleLabel;
import be.ceau.chart.options.ticks.LinearTicks;

public class GraficoLineBuilder {
	
	private LineData lineData = new LineData();
	private LineChart lineChart;
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
			
			
			LineDataset lineDataSet = new LineDataset();
			lineDataSet.setLabel(entry.getKey())
			.setData(valoresArray)
			.setBorderWidth(1)
			.setFill(true)
			.setLineTension(0.1f)
			.setBackgroundColor(new Color(75, 192, 192, 0.4))
			.setBorderColor(new Color(75,192,192,1))
			.setBorderCapStyle(BorderCapStyle.ROUND)
			.setBorderDashOffset(0.1f)
			.setBorderJoinStyle(BorderJoinStyle.MITER)
			.addPointBorderColor(new Color(75, 192, 192, 1))					
			.addPointBackgroundColor(new Color(255, 255, 255, 1))
			.addPointBorderWidth(1)
			.addPointHoverRadius(5)
            .addPointHoverBackgroundColor(new Color(75,192,192,1))
            .addPointHoverBorderColor(new Color(220,220,220,1))
            .addPointHoverBorderWidth(2)
            .addPointRadius(3)
            .addPointHitRadius(10)
            .setSpanGaps(false);
			
			lineDatasets.add(lineDataSet);
		}
		
		
		String [] legendaPeriodoArray = new String[periodos.size()];
		
		for(int i = 0 ; i < periodos.size() ; i++){
			String periodo = periodos.get(i);
			legendaPeriodoArray[i] = periodo;
		}
		

		LineOptions linearOptions = LineChart.options();
		lineData.addLabels(legendaPeriodoArray).setDatasets(lineDatasets);
		
		LinearScales linearScales = new LinearScales();
		LinearScale yLinearScale = new LinearScale();
		
		List<Color> listaColor = new ArrayList<Color>();
		listaColor.add(new Color(57,57,57,1));
		
		GridLines gridLine = new GridLines();
		gridLine.setZeroLineColor(Color.WHITE);
		gridLine.setColor(listaColor);
		gridLine.setTickMarkLength(10);
		
		ScaleLabel scaleLabel = new ScaleLabel();
		scaleLabel.setDisplay(true);
		scaleLabel.setLabelString("Erros");
		scaleLabel.setFontColor(Color.WHITE);
		scaleLabel.setFontSize(new BigDecimal(18.00));
		
		LegendLabels legendLabel = new LegendLabels();
		legendLabel.setFontColor(Color.WHITE);
		
		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setLabels(legendLabel);
		
		LinearTicks linearTicks = new LinearTicks();
		linearTicks.setFontColor(Color.WHITE);
		linearTicks.setFontSize(new BigDecimal(15));
		
		yLinearScale.setGridLines(gridLine);
		yLinearScale.setTicks(linearTicks);
		yLinearScale.setScaleLabel(scaleLabel);
		
		linearScales.addyAxis(yLinearScale);
		
		linearOptions.setScales(linearScales);
		linearOptions.setLegend(legend);
				
		lineChart = new LineChart();

		lineChart.setOptions(linearOptions);
		lineChart.setData(lineData);
						
		return lineChart.toJson();
	}

}
