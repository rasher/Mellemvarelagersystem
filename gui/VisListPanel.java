package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;

import model.Mellemvare;
import javax.swing.JScrollPane;

public class VisListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList klarList = null;
	private JList nærOverskredetList = null;
	private JLabel klarListLabel = null;
	private JLabel nærOverskredetLabel = null;
	private JLabel antalTimerTilMaxToerringNåetLabel = null;
	private JSlider antalTimerFraMaxToerringsSlider = null;
	private JLabel taellerLabel = null;
	private HaandterMellemvarePanel haandterMellemvarePanel;
	private OpdaterToerreListerThread thread;  //  @jve:decl-index=0:
	private JScrollPane klarListScrollPane = null;
	private JScrollPane nærOverskredetListScrollPane = null;
	/**
	 * This is the default constructor
	 */
	public VisListPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = GridBagConstraints.BOTH;
		gridBagConstraints4.gridy = 4;
		gridBagConstraints4.weightx = 1.0;
		gridBagConstraints4.weighty = 1.0;
		gridBagConstraints4.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints4.gridwidth = 2;
		gridBagConstraints4.gridx = 0;
		GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
		gridBagConstraints32.fill = GridBagConstraints.BOTH;
		gridBagConstraints32.gridy = 1;
		gridBagConstraints32.weightx = 1.0;
		gridBagConstraints32.weighty = 1.0;
		gridBagConstraints32.gridwidth = 2;
		gridBagConstraints32.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints32.gridx = 0;
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.gridx = 1;
		gridBagConstraints31.anchor = GridBagConstraints.EAST;
		gridBagConstraints31.insets = new Insets(0, 0, 0, 5);
		gridBagConstraints31.gridy = 6;
		taellerLabel = new JLabel();
		taellerLabel.setText("15");
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.fill = GridBagConstraints.BOTH;
		gridBagConstraints21.gridy = 7;
		gridBagConstraints21.weightx = 1.0;
		gridBagConstraints21.anchor = GridBagConstraints.WEST;
		gridBagConstraints21.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints21.gridwidth = 2;
		gridBagConstraints21.gridx = 0;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.gridx = 0;
		gridBagConstraints11.anchor = GridBagConstraints.WEST;
		gridBagConstraints11.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints11.gridy = 6;
		antalTimerTilMaxToerringNåetLabel = new JLabel();
		antalTimerTilMaxToerringNåetLabel.setText("Antal timer til max er nået : ");
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints2.gridy = 3;
		nærOverskredetLabel = new JLabel();
		nærOverskredetLabel.setText("Nær maksimal tørringstid : ");
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints.gridy = 0;
		klarListLabel = new JLabel();
		klarListLabel.setText("Klar til delbehandling : ");
		this.setLayout(new GridBagLayout());
		this.setSize(300, 200);
		this.add(klarListLabel, gridBagConstraints);
		this.add(getKlarListScrollPane(), gridBagConstraints32);
		this.add(nærOverskredetLabel, gridBagConstraints2);
		this.add(getNærOverskredetListScrollPane(), gridBagConstraints4);
		this.add(antalTimerTilMaxToerringNåetLabel, gridBagConstraints11);
		this.add(getAntalTimerFraMaxToerringsSlider(), gridBagConstraints21);
		this.add(taellerLabel, gridBagConstraints31);
	}

	/**
	 * This method initializes klarList	
	 * 	
	 * @return javax.swing.JList	
	 */
	public JList getKlarList() {
		if (klarList == null) {
			klarList = new JList();
			klarList.setCellRenderer(new MellemvareOvervaagningCellRenderer());
			klarList.setBorder(MainFrame.getBorder());
			klarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							Mellemvare mellemvare = (Mellemvare)getKlarList().getSelectedValue();
							if (mellemvare != null) {
								haandterMellemvarePanel.setBatchnummerText(""+mellemvare.getBatchNummer());
							}
						}
					});
		}
		return klarList;
	}

	/**
	 * This method initializes nærOverskredetList	
	 * 	
	 * @return javax.swing.JList	
	 */
	public JList getNærOverskredetList() {
		if (nærOverskredetList == null) {
			nærOverskredetList = new JList();
			nærOverskredetList.setCellRenderer(new MellemvareOvervaagningCellRenderer());
			nærOverskredetList.setBorder(MainFrame.getBorder());
			nærOverskredetList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							if(getNærOverskredetList().getSelectedValue() != null)
							{
								Mellemvare mellemvare = (Mellemvare)getNærOverskredetList().getSelectedValue();
								if (mellemvare != null) {
									haandterMellemvarePanel.setBatchnummerText(mellemvare.getBatchNummer()+"");
								}
							}
						}
					});
		}
		return nærOverskredetList;
	}

	/**
	 * This method initializes antalTimerFraMaxToerringsSlider	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	public JSlider getAntalTimerFraMaxToerringsSlider() {
		if (antalTimerFraMaxToerringsSlider == null) {
			antalTimerFraMaxToerringsSlider = new JSlider();
			antalTimerFraMaxToerringsSlider.setMaximum(15);
			antalTimerFraMaxToerringsSlider.setMinorTickSpacing(1);
			antalTimerFraMaxToerringsSlider.setPaintTicks(true);
			antalTimerFraMaxToerringsSlider.setSnapToTicks(true);
			antalTimerFraMaxToerringsSlider.setMinimum(1);
			antalTimerFraMaxToerringsSlider
					.addChangeListener(new javax.swing.event.ChangeListener() {
						public void stateChanged(javax.swing.event.ChangeEvent e) {
							taellerLabel.setText(antalTimerFraMaxToerringsSlider.getValue() + "");
							if(thread != null){
							thread.opdaterLister();
							}
						}
					});
		}
		return antalTimerFraMaxToerringsSlider;
	}

	public void setHaandterMellemvarePanel(
			HaandterMellemvarePanel håndterMellemvarePanel) {
		this.haandterMellemvarePanel = håndterMellemvarePanel;
	}
	
	public void setThread(OpdaterToerreListerThread thread){
		this.thread = thread;
	}

	/**
	 * This method initializes klarListScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getKlarListScrollPane() {
		if (klarListScrollPane == null) {
			klarListScrollPane = new JScrollPane();
			klarListScrollPane.setViewportView(getKlarList());
		}
		return klarListScrollPane;
	}

	/**
	 * This method initializes nærOverskredetListScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getNærOverskredetListScrollPane() {
		if (nærOverskredetListScrollPane == null) {
			nærOverskredetListScrollPane = new JScrollPane();
			nærOverskredetListScrollPane.setViewportView(getNærOverskredetList());
		}
		return nærOverskredetListScrollPane;
	}

}  //  @jve:decl-index=0:visual-constraint="-11,7"
