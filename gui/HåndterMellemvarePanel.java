package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Insets;

public class HåndterMellemvarePanel extends JPanel {

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
	public HåndterMellemvarePanel() {
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
	private JTextField getBatchnummerTextField() {
		if (batchnummerTextField == null) {
			batchnummerTextField = new JTextField();
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
		}
		return sendTilPakningButton;
	}

}
