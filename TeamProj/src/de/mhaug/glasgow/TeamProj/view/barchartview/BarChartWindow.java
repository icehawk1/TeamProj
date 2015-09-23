package de.mhaug.glasgow.TeamProj.view.barchartview;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import de.mhaug.glasgow.TeamProj.model.Referee;
import de.mhaug.glasgow.TeamProj.model.RefereeList;

public class BarChartWindow extends JFrame {
	private final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private ChartPanel chartPanel;

	public BarChartWindow() {
		JFrame frame = new JFrame("Charts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		updateDataset();
		JFreeChart chart = ChartFactory.createBarChart("Test Chart", "Name of Referee", "Number of Allocations",
				dataset, PlotOrientation.VERTICAL, false, false, false);
		chartPanel = new ChartPanel(chart);

		frame.add(chartPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public void updateDataset() {
		dataset.clear();
		for (Referee ref : RefereeList.getReadOnlySet()) {
			dataset.addValue(ref.getNumberOfAllocations(), "Referee", ref.getName());
		}

		ChartChangeEvent event = new ChartChangeEvent(dataset);
		event.setType(ChartChangeEventType.DATASET_UPDATED);
		chartPanel.chartChanged(event);
	}
}
