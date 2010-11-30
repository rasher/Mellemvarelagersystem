package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.Produkttype;
import model.Service;

public class StatistikPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JDateChooser jFraDateChooser = null;
	private JDateChooser jTilDateChooser = null;
	private JPanel statistikVælgPanel = null;
	private JPanel statistikVisPanel = null;
	private JLabel fraDatoLabel = null;
	private JLabel tilDatoLabel = null;
	private JList statistikVælgProdukter = null;
	private JLabel vælgProdukterLabel = null;
	private JButton statistikHentButton = null;
	private JLabel statistikLabel = null;
	private JButton resetButton = null;
	private JScrollPane statistikScroll = null;
	private JTable statistikTable = null;
	private Service service = Service.getInstance();
	private GregorianCalendar fraDato = new GregorianCalendar();
	private String[] columnNames = {"Produkttype","Antal mellemvarer produceret","Gennemsnitstid på lager","spild %"};
	/**
	 * This is the default constructor
	 */
	public StatistikPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints2.gridy = 1;
		this.setLayout(new BorderLayout());
		this.setSize(300, 200);
		this.add(getStatistikVælgPanel(), BorderLayout.WEST);
		this.add(getStatistikVisPanel(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes jFraDateChooser	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJFraDateChooser() {
		if (jFraDateChooser == null) {
			jFraDateChooser = new JDateChooser();
			fraDato.add(Calendar.DATE, -10);
			jFraDateChooser.setCalendar(fraDato);
		}
		return jFraDateChooser;
	}

	/**
	 * This method initializes jTilDateChooser	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJTilDateChooser() {
		if (jTilDateChooser == null) {
			jTilDateChooser = new JDateChooser();
			jTilDateChooser.setCalendar(new GregorianCalendar());
		}
		return jTilDateChooser;
	}

	/**
	 * This method initializes statistikVælgPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getStatistikVælgPanel() {
		if (statistikVælgPanel == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints31.gridy = 6;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.insets = new Insets(0, 5, 1, 0);
			gridBagConstraints21.gridy = 4;
			vælgProdukterLabel = new JLabel();
			vælgProdukterLabel.setText("Vælg Produkter :");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 5;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints11.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(0, 5, 1, 0);
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridy = 2;
			tilDatoLabel = new JLabel();
			tilDatoLabel.setText("Til dato :");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(5, 5, 1, 0);
			gridBagConstraints3.gridy = 0;
			fraDatoLabel = new JLabel();
			fraDatoLabel.setText("Fra dato :");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 5, 5, 0);
			gridBagConstraints1.anchor = GridBagConstraints.CENTER;
			gridBagConstraints1.gridy = 3;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 5, 5, 0);
			gridBagConstraints.gridy = 1;
			statistikVælgPanel = new JPanel();
			statistikVælgPanel.setBorder(MainFrame.getBorder());
			statistikVælgPanel.setLayout(new GridBagLayout());
			statistikVælgPanel.add(getJFraDateChooser(), gridBagConstraints);
			statistikVælgPanel.add(getJTilDateChooser(), gridBagConstraints1);
			statistikVælgPanel.add(fraDatoLabel, gridBagConstraints3);
			statistikVælgPanel.add(tilDatoLabel, gridBagConstraints4);
			statistikVælgPanel.add(getStatistikVælgProdukter(), gridBagConstraints11);
			statistikVælgPanel.add(vælgProdukterLabel, gridBagConstraints21);
			statistikVælgPanel.add(getStatistikHentButton(), gridBagConstraints31);
		}
		return statistikVælgPanel;
	}

	/**
	 * This method initializes statistikVisPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getStatistikVisPanel() {
		if (statistikVisPanel == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridy = 1;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.weighty = 1.0;
			gridBagConstraints7.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.fill = GridBagConstraints.NONE;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.insets = new Insets(0, 0, 5, 5);
			gridBagConstraints6.gridy = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.insets = new Insets(5, 5, 1, 0);
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridy = 0;
			statistikLabel = new JLabel();
			statistikLabel.setText("Statistik :");
			statistikVisPanel = new JPanel();
			statistikVisPanel.setBorder(MainFrame.getBorder());
			statistikVisPanel.setLayout(new GridBagLayout());
			statistikVisPanel.add(statistikLabel, gridBagConstraints5);
			statistikVisPanel.add(getResetButton(), gridBagConstraints6);
			statistikVisPanel.add(getStatistikScroll(), gridBagConstraints7);
		}
		return statistikVisPanel;
	}

	/**
	 * This method initializes statistikVælgProdukter	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getStatistikVælgProdukter() {
		if (statistikVælgProdukter == null) {
			statistikVælgProdukter = new JList();
			statistikVælgProdukter.setListData(service.getProdukttyper().toArray());
			statistikVælgProdukter.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			statistikVælgProdukter.setBorder(MainFrame.getBorder());
		}
		return statistikVælgProdukter;
	}

	/**
	 * This method initializes statistikHentButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getStatistikHentButton() {
		if (statistikHentButton == null) {
			statistikHentButton = new JButton();
			statistikHentButton.setText("Hent Statistik");
			statistikHentButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[] produkter = getStatistikVælgProdukter().getSelectedValues();
					Calendar fraDato = jFraDateChooser.getCalendar();
					Calendar tilDato = jTilDateChooser.getCalendar();
					Object[][] statistik = service.createStatistik(fraDato, tilDato, produkter);
					getStatistikTable().setModel(new DefaultTableModel(statistik, columnNames));
					getStatistikVælgProdukter().clearSelection();
				}
			});
		}
		return statistikHentButton;
	}

	/**
	 * This method initializes resetButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getResetButton() {
		if (resetButton == null) {
			resetButton = new JButton();
			resetButton.setText("Ryd Tabel");
			resetButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getStatistikTable().setModel(new DefaultTableModel(columnNames,0));
					getStatistikVælgProdukter().clearSelection();
				}
			});
		}
		return resetButton;
	}

	/**
	 * This method initializes statistikScroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getStatistikScroll() {
		if (statistikScroll == null) {
			statistikScroll = new JScrollPane();
			statistikScroll.setViewportView(getStatistikTable());
		}
		return statistikScroll;
	}

	/**
	 * This method initializes statistikTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getStatistikTable() {
		if (statistikTable == null) {
			statistikTable = new JTable();
			statistikTable.setModel(new DefaultTableModel(columnNames, 0));
		}
		return statistikTable;
	}

}  //  @jve:decl-index=0:visual-constraint="27,10"
