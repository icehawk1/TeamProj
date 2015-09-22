package de.mhaug.glasgow.TeamProj.gui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import de.mhaug.glasgow.TeamProj.data.Referee;

public class BarChartCreator {
	public void showBarChart(final List<Referee> refereeList) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Charts");

				frame.setSize(600, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

				CategoryDataset ds = createDataset(refereeList);
				JFreeChart chart = ChartFactory.createBarChart("Test Chart", "Name of Referee",
						"Number of Allocations", ds, PlotOrientation.VERTICAL, false, false, false);

				ChartPanel cp = new ChartPanel(chart);
				frame.getContentPane().add(cp);
			}
		});
	}

	private static CategoryDataset createDataset(List<Referee> refereeList) {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Referee ref : refereeList) {
			dataset.addValue(ref.getAllocations().size(), "Referee", ref.getName());
		}

		final String heinz = "Heinz Müller";
		final String hans = "Hans Wurst";
		final String fritz = "Fritz Piepe";

		dataset.addValue(2, "Referee", heinz);
		dataset.addValue(8, "Referee", hans);
		dataset.addValue(1, "Referee", fritz);

		return dataset;
	}
}
