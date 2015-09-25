package de.mhaug.glasgow.TeamProj.view.mainview;

import java.util.Iterator;

import javax.swing.ListModel;

import de.mhaug.glasgow.TeamProj.model.Referee;

public class RefereeListIterator implements Iterator<Referee> {
	private int i;
	private ListModel<Referee> toIterate;

	RefereeListIterator(ListModel<Referee> listModel) {
		this.toIterate = listModel;
		this.i = 0;
	}

	@Override
	public boolean hasNext() {
		return i < toIterate.getSize();
	}

	@Override
	public Referee next() {
		return toIterate.getElementAt(i);
	}

}
