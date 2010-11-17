package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;

import model.Mellemvare;

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
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.gridx = 1;
		gridBagConstraints31.anchor = GridBagConstraints.EAST;
		gridBagConstraints31.insets = new Insets(0, 0, 0, 5);
		gridBagConstraints31.gridy = 4;
		taellerLabel = new JLabel();
		taellerLabel.setText("15");
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.fill = GridBagConstraints.BOTH;
		gridBagConstraints21.gridy = 5;
		gridBagConstraints21.weightx = 1.0;
		gridBagConstraints21.anchor = GridBagConstraints.WEST;
		gridBagConstraints21.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints21.gridwidth = 2;
		gridBagConstraints21.gridx = 0;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.gridx = 0;
		gridBagConstraints11.anchor = GridBagConstraints.WEST;
		gridBagConstraints11.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints11.gridy = 4;
		antalTimerTilMaxToerringNåetLabel = new JLabel();
		antalTimerTilMaxToerringNåetLabel.setText("Antal timer til max er nået : ");
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridy = 3;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.weighty = 1.0;
		gridBagConstraints3.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints3.gridwidth = 2;
		gridBagConstraints3.gridx = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints2.gridy = 2;
		nærOverskredetLabel = new JLabel();
		nærOverskredetLabel.setText("Nær maksimal tørringstid : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.weighty = 1.0;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints1.gridwidth = 2;
		gridBagConstraints1.gridx = 0;
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
		this.add(getKlarList(), gridBagConstraints1);
		this.add(nærOverskredetLabel, gridBagConstraints2);
		this.add(getNærOverskredetList(), gridBagConstraints3);
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
			klarList.setBorder(MainFrame.getBorder());
			klarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							haandterMellemvarePanel.setBatchnummerText(((Mellemvare)getKlarList().getSelectedValue()).getBatchNummer()+"");
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
			nærOverskredetList.setBorder(MainFrame.getBorder());
			nærOverskredetList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							if(getNærOverskredetList().getSelectedValue() != null)
							{
								haandterMellemvarePanel.setBatchnummerText(((Mellemvare)getNærOverskredetList().getSelectedValue()).getBatchNummer()+"");
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
						}
					});
		}
		return antalTimerFraMaxToerringsSlider;
	}

	public void setHaandterMellemvarePanel(
			HaandterMellemvarePanel håndterMellemvarePanel) {
		this.haandterMellemvarePanel = håndterMellemvarePanel;
	}

}  //  @jve:decl-index=0:visual-constraint="-11,7"
