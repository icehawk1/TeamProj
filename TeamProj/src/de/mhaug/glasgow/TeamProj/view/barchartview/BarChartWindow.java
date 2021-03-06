package de.mhaug.glasgow.TeamProj.view.barchartview;

import java.util.Set;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import de.mhaug.glasgow.TeamProj.controller.UtilController;
import de.mhaug.glasgow.TeamProj.model.Referee;

public class BarChartWindow extends JFrame {
	private final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private static volatile BarChartWindow instance;

	private BarChartWindow() {
		super("Chart of Allocations per Referee");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		for (Referee ref : UtilController.getAvailableReferees()) {
			dataset.addValue(ref.getNumberOfAllocations(), "Referee", ref.getName());
		}

		chart = ChartFactory.createBarChart("Allocations per Referee", "Name of Referee", "Number of Allocations",
				dataset, PlotOrientation.VERTICAL, false, false, false);
		chartPanel = new ChartPanel(chart);

		this.getContentPane().add(chartPanel);
		this.pack();
	}

	public static synchronized BarChartWindow getInstance() {
		if (instance == null) {
			instance = new BarChartWindow();
		}

		return instance;
	}

	public void updateView() {
		updateDataset(UtilController.getAvailableReferees());
	}

	private void updateDataset(Set<Referee> referees) {
		// TODO: Method does not update Barchart
		assert referees != null;

		dataset.clear();

		for (Referee ref : referees) {
			dataset.addValue(ref.getNumberOfAllocations(), "Referee", ref.getName());
		}

		ChartChangeEvent event = new ChartChangeEvent(dataset);
		event.setType(ChartChangeEventType.DATASET_UPDATED);

		assert event != null;
		assert chartPanel != null;
		chartPanel.chartChanged(event);
		chart.fireChartChanged();
	}
}
