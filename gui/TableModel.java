package gui;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import model.Mellemvare;

public class TableModel extends AbstractTableModel {

	private ArrayList<Mellemvare> mellemvare = new ArrayList<Mellemvare>();
	String[] column = {"Produkttype", "antal mellemvarer produceret", "gennemsnitstid på lager", "varer der er forældet"};
	 protected Class[] columnClasses = {String.class, Integer.class, Long.class, Integer.class};
	
	public TableModel(ArrayList<Mellemvare> mellemvare)
	{
		this.mellemvare = mellemvare;
	}
	
	public void updateList(ArrayList<Mellemvare> mellemvare)
	{
		this.mellemvare = mellemvare;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		super.addTableModelListener(l);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClasses[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return column.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return column[columnIndex];
	}

	@Override
	public int getRowCount() {
		return personer.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex > -1){
		switch(columnIndex){
		case 0:
			return mellemvare.get(rowIndex).getProdukttype().getNavn();
		case 1:
			mellemvare.get(rowIndex)
		case 2:
			return mellemvare.get(rowIndex)
		default:
			return null;
		}}
		else
			return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		super.removeTableModelListener(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
		case 0:
			personer.get(rowIndex).setNavn(aValue.toString());
		case 1:
			personer.get(rowIndex).setMobil((Integer)aValue);
		case 2:
			personer.get(rowIndex).setEmail(aValue.toString());
		default:
		}
	}
}

}
