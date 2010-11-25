package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.BehandlingsTrin;
import model.Mellemvare;
import model.Service;

import java.awt.Insets;
import java.text.NumberFormat;

public class HaandterMellemvarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel batchnummerLabel = null;
	private JTextField batchnummerTextField = null;
	private JLabel batchInfoLabel = null;
	private JTextArea batchInfoTextArea = null;
	private JButton startTørringButton = null;
	private JButton sendTilDelbehandlingButton = null;
	private JButton sendTilPakningButton = null;

	/**
	 * This is the default constructor
	 */
	public HaandterMellemvarePanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 0;
		gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints7.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints7.gridy = 6;
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 0;
		gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints6.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints6.gridy = 5;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints5.gridy = 4;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = GridBagConstraints.BOTH;
		gridBagConstraints4.gridy = 3;
		gridBagConstraints4.weightx = 1.0;
		gridBagConstraints4.weighty = 1.0;
		gridBagConstraints4.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints4.gridx = 0;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.anchor = GridBagConstraints.WEST;
		gridBagConstraints3.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints3.gridy = 2;
		batchInfoLabel = new JLabel();
		batchInfoLabel.setText("Batch Info : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints1.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints.gridy = 0;
		batchnummerLabel = new JLabel();
		batchnummerLabel.setText("Batchnummer : ");
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
		this.add(batchnummerLabel, gridBagConstraints);
		this.add(getBatchnummerTextField(), gridBagConstraints1);
		this.add(batchInfoLabel, gridBagConstraints3);
		this.add(getBatchInfoTextArea(), gridBagConstraints4);
		this.add(getStartTørringButton(), gridBagConstraints5);
		this.add(getSendTilDelbehandlingButton(), gridBagConstraints6);
		this.add(getSendTilPakningButton(), gridBagConstraints7);
	}

	/**
	 * This method initializes batchnummerTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	protected JTextField getBatchnummerTextField() {
		if (batchnummerTextField == null) {
			batchnummerTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
				batchnummerTextField.getDocument().addDocumentListener(new DocumentListener(){

					@Override
					public void changedUpdate(DocumentEvent arg0) {
						updateBatchnummerTextField();
					}

					@Override
					public void insertUpdate(DocumentEvent arg0) {
						updateBatchnummerTextField();
					}

					@Override
					public void removeUpdate(DocumentEvent arg0) {
						updateBatchnummerTextField();
					}
					
					private void updateBatchnummerTextField(){
						int input;
						try {
							input = Integer.parseInt(getBatchnummerTextField().getText());
						}
						catch (NumberFormatException e) {
							input = -1;
						}
						Mellemvare m = Service.getInstance().søgMellemvare(input);
						if(m == null){
							if(!getBatchnummerTextField().getText().isEmpty())
								getBatchInfoTextArea().setText("Batchnummer findes ikke!");
							else
								getBatchInfoTextArea().setText("");
							}
						else
						{
							;
							getBatchInfoTextArea().setText("Produkttype: \t" + m.getProdukttype().getNavn() + "\r\n\n"
															+ String.format("Minimums Tørring nået: \t %1$td-%1$tm-%1$tY  %1$tR\r\n", m.getMinimumTørringNået())
															+ String.format("Optimal Tørring nået: \t %1$td-%1$tm-%1$tY  %1$tR\r\n", m.getOptimalTørringNået())
															+ String.format("Maksimal Tørring nået: \t %1$td-%1$tm-%1$tY  %1$tR\r\n\n", m.getMaksimumTørringNået())
															+ "Delbehandlinger: \n\n");
							for(BehandlingsTrin trin : m.getBehandlingsTrin()){
								setBatchInfoTextArea(trin);
								if(trin.getStart() != null){
									setButtonStatus(trin, m);
								}
							}
						}
					}
				});
		}
		return batchnummerTextField;
	}

	/**
	 * This method initializes batchInfoTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getBatchInfoTextArea() {
		if (batchInfoTextArea == null) {
			batchInfoTextArea = new JTextArea();
			batchInfoTextArea.setBorder(MainFrame.getBorder());
		}
		return batchInfoTextArea;
	}

	/**
	 * This method initializes startTørringButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getStartTørringButton() {
		if (startTørringButton == null) {
			startTørringButton = new JButton();
			startTørringButton.setText("Start Tørring");
			startTørringButton.setEnabled(false);
			startTørringButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Mellemvare aktuelmellemvare = Service.getInstance().søgMellemvare(Integer.parseInt(getBatchnummerTextField().getText()));
					aktuelmellemvare.startTørring();
					getBatchnummerTextField().setText(aktuelmellemvare.getBatchNummer() + "");
				}
			});
		}
		return startTørringButton;
	}

	/**
	 * This method initializes sendTilDelbehandlingButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSendTilDelbehandlingButton() {
		if (sendTilDelbehandlingButton == null) {
			sendTilDelbehandlingButton = new JButton();
			sendTilDelbehandlingButton.setText("Send Til Delbehandling");
			sendTilDelbehandlingButton.setEnabled(false);
			sendTilDelbehandlingButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							Mellemvare aktuelmellemvare = Service.getInstance().søgMellemvare(Integer.parseInt(getBatchnummerTextField().getText()));
							try {
								aktuelmellemvare.startDelbehandling();
								getBatchnummerTextField().setText(aktuelmellemvare.getBatchNummer() + "");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
		}
		return sendTilDelbehandlingButton;
	}

	/**
	 * This method initializes sendTilPakningButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSendTilPakningButton() {
		if (sendTilPakningButton == null) {
			sendTilPakningButton = new JButton();
			sendTilPakningButton.setText("Send Til Pakning");
			sendTilPakningButton.setEnabled(false);
			sendTilPakningButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Mellemvare aktuelmellemvare = Service.getInstance().søgMellemvare(Integer.parseInt(getBatchnummerTextField().getText()));
					aktuelmellemvare.sendTilPakning();
					getBatchnummerTextField().setText(aktuelmellemvare.getBatchNummer() + "");
				}
			});
		}
		return sendTilPakningButton;
	}
	
	public void setBatchnummerText(String batchnummer){
		getBatchnummerTextField().setText(batchnummer);
	}
	
	private void setBatchInfoTextArea(BehandlingsTrin trin){
		if(trin.getSlut() != null){
			getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "(Afsluttet)\n");
		}
		else if(trin.getTørringStart() != null){
			getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "(Tørrer)\n");
		}
		else if(trin.getStart() != null){
			getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "(Behandler)\n");
		}
		else{
			getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "\n");
		}
	}
	
	private void setButtonStatus(BehandlingsTrin trin, Mellemvare m){
		if(trin.getSlut() != null){
			getStartTørringButton().setEnabled(false);
			getSendTilDelbehandlingButton().setEnabled(true);
			getSendTilPakningButton().setEnabled(false);
			if(m.getBehandlingsTrin().get(m.getBehandlingsTrin().size()-1).getSlut() != null){
				getStartTørringButton().setEnabled(false);
				getSendTilDelbehandlingButton().setEnabled(false);
				getSendTilPakningButton().setEnabled(true);
			}
		}
		else if(trin.getTørringStart() != null){
			getStartTørringButton().setEnabled(false);
			getSendTilDelbehandlingButton().setEnabled(true);
			getSendTilPakningButton().setEnabled(false);
			if(m.getBehandlingsTrin().get(m.getBehandlingsTrin().size()-1).getTørringStart() != null){
				getStartTørringButton().setEnabled(false);
				getSendTilDelbehandlingButton().setEnabled(false);
				getSendTilPakningButton().setEnabled(true);
			}
		}
		else if(trin.getStart() != null){
			getStartTørringButton().setEnabled(true);
			getSendTilDelbehandlingButton().setEnabled(false);
			getSendTilPakningButton().setEnabled(false);
		}
		else{
			getStartTørringButton().setEnabled(true);
			getSendTilDelbehandlingButton().setEnabled(true);
			getSendTilPakningButton().setEnabled(false);
		}
	}
}
