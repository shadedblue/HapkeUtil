package ca.hapke.util.ui;

import java.util.Comparator;

import javax.swing.table.TableColumnModel;

import ca.odell.glazedlists.impl.sort.ComparableComparator;

/**
 * @author Nathan Hapke
 */
public abstract class NamedWidthedTableFormat {
	protected final String[] labels;
	protected final int[] widths;

	public NamedWidthedTableFormat(String[] labels, int[] widths) {
		this.labels = labels;
		this.widths = widths;
	}

	@SuppressWarnings("rawtypes")
	protected Comparator<Comparable> comp = new ComparableComparator();

	public int[] getWidths() {
		return widths;
	}

	public int getColumnCount() {
		return labels.length;
	}

	public String getColumnName(int column) {
		try {
			return labels[column];
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalStateException();
		}
	}

	@SuppressWarnings("rawtypes")
	public Comparator getColumnComparator(int column) {
		if (column >= 0 && column < getColumnCount())
			return comp;
		throw new IllegalStateException();
	}

	public void setTableWidths(TableColumnModel model) {
		for (int i = 0; i < widths.length; i++) {
			model.getColumn(i).setPreferredWidth(widths[i]);
		}
	}
}
