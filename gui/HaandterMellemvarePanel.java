package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.BehandlingsTrin;
import model.Mellemvare;
import model.Service;

import java.awt.Insets;

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
			batchnummerTextField = new JTextField();
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
						for(Mellemvare m : Service.getInstance().getMellemvarer())
						{
							if((m.getBatchNummer() + "").equals(getBatchnummerTextField().getText()))
							{
								getBatchInfoTextArea().setText("Produkttype: \t" + m.getProdukttype().getNavn() + "\r\n\n"
																+ "Delbehandlinger: \n\n");
								for(BehandlingsTrin trin : m.getBehandlingsTrin())
								{
									if(trin.getSlut() != null){
										getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "(Afsluttet)\n");
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
										getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "(Tørrer)\n");
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
										getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "(Behandler)\n");
										getStartTørringButton().setEnabled(true);
										getSendTilDelbehandlingButton().setEnabled(false);
										getSendTilPakningButton().setEnabled(false);
									}
									else{
										getBatchInfoTextArea().append(trin.getDelbehandling().getNavn() + "\n");
										getStartTørringButton().setEnabled(true);
										getSendTilDelbehandlingButton().setEnabled(true);
										getSendTilPakningButton().setEnabled(false);
									}
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
		}
		return sendTilPakningButton;
	}
	
	public void setBatchnummerText(String batchnummer){
		getBatchnummerTextField().setText(batchnummer);
	}

}
