package de.mhaug.glasgow.TeamProj.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.mhaug.glasgow.TeamProj.WindowClosingListener;
import de.mhaug.glasgow.TeamProj.data.Area;
import de.mhaug.glasgow.TeamProj.data.Qualification;
import de.mhaug.glasgow.TeamProj.data.Referee;

public class GuiCreator {
	private ArrayList<Referee> refereeList;

	public GuiCreator(ArrayList<Referee> refereeList) {
		this.refereeList = refereeList;
		assert !refereeList.isEmpty();
	}

	public void createGui() {
		JFrame mainWindow = createMainWindow();
		mainWindow.pack();
		mainWindow.validate();
		mainWindow.setVisible(true);
	}

	private JFrame createMainWindow() {
		JFrame result = new JFrame("Referee Manager");
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result.addWindowListener(new WindowClosingListener(refereeList));

		result.setLayout(new BorderLayout());

		JComponent refereeListComponent = createListComponent();
		result.add(refereeListComponent, BorderLayout.NORTH);

		JComponent refereeSearchComponent = createSearchComponent();
		result.add(refereeSearchComponent, BorderLayout.CENTER);

		JComponent refereeEditorComponent = createEditorComponent();
		result.add(refereeEditorComponent, BorderLayout.SOUTH);

		return result;
	}

	private JComponent createSearchComponent() {
		JComponent result = createGeneralComponent();

		result.add(new JLabel("Forename:"));
		final JTextField forenameField = new JTextField(10);
		result.add(forenameField);

		result.add(new JLabel("Lastname:"));
		final JTextField lastnameField = new JTextField(10);
		result.add(lastnameField);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Search button pressed: " + forenameField.getText());
			}
		});
		result.add(searchButton);

		return result;
	}

	private JComponent createListComponent() {
		final DefaultListModel<Referee> refereeListModel = new DefaultListModel<>();
		JList<Referee> refereeList = new JList<>(refereeListModel);
		JScrollPane result = new JScrollPane(refereeList);

		for (Referee toAdd : this.refereeList)
			refereeListModel.addElement(toAdd);

		return result;
	}

	private JComponent createEditorComponent() {
		JComponent result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

		result.add(createPersonalInformation());
		result.add(createBoxes());
		result.add(createAcceptableTravelAreasComponent());
		result.add(createActionComponent());

		return result;
	}

	private Component createActionComponent() {
		JPanel result = createGeneralComponent();

		result.add(new JButton("Update Referee"));
		result.add(new JButton("Delete Referee"));

		return result;
	}

	private JPanel createGeneralComponent() {
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout(FlowLayout.CENTER));
		return result;
	}

	private Component createBoxes() {
		JPanel result = createGeneralComponent();

		result.add(new JLabel("Qualification: "));
		JComboBox<Qualification> qualification = new JComboBox<>(Qualification.getPossibleQualifications());
		result.add(qualification);

		result.add(new JLabel("Home Area: "));
		JComboBox<Area> homeArea = new JComboBox<>(Area.values());
		result.add(homeArea);

		return result;
	}

	private Component createPersonalInformation() {
		JPanel result = createGeneralComponent();

		result.add(new JLabel("id"));
		result.add(new JLabel("forename lastname"));
		result.add(new JLabel("Number of allocated matches: " + 12));

		return result;
	}

	private JComponent createAcceptableTravelAreasComponent() {
		JPanel result = createGeneralComponent();

		JLabel description = new JLabel("Travels to: ");
		result.add(description);

		for (Area elem : Area.values()) {
			result.add(new JCheckBox(elem.name(), true));
		}

		return result;
	}
}
