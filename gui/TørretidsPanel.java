package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class TørretidsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel minimalTørretidLabel = null;
	private JTextField minimalTørretidTextField = null;
	private JLabel optimalTørretidLabel = null;
	private JTextField optimalTørretidTextField = null;
	private JLabel maksimalTørretidLabel = null;
	private JTextField maksimalTørretidTextField = null;

	/**
	 * This is the default constructor
	 */
	public TørretidsPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		gridBagConstraints5.gridy = 0;
		gridBagConstraints5.weightx = 1.0;
		gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints5.gridx = 5;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 4;
		gridBagConstraints4.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints4.gridy = 0;
		maksimalTørretidLabel = new JLabel();
		maksimalTørretidLabel.setText("Max");
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridy = 0;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints3.gridx = 3;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 2;
		gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints2.gridy = 0;
		optimalTørretidLabel = new JLabel();
		optimalTørretidLabel.setText("Opt");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints1.gridx = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints.gridy = 0;
		minimalTørretidLabel = new JLabel();
		minimalTørretidLabel.setText("Min");
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
		this.add(minimalTørretidLabel, gridBagConstraints);
		this.add(getMinimalTørretidTextField(), gridBagConstraints1);
		this.add(optimalTørretidLabel, gridBagConstraints2);
		this.add(getOptimalTørretidTextField(), gridBagConstraints3);
		this.add(maksimalTørretidLabel, gridBagConstraints4);
		this.add(getMaksimalTørretidTextField(), gridBagConstraints5);
	}

	/**
	 * This method initializes minimalTørretidTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMinimalTørretidTextField() {
		if (minimalTørretidTextField == null) {
			minimalTørretidTextField = new JTextField();
		}
		return minimalTørretidTextField;
	}

	/**
	 * This method initializes optimalTørretidTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOptimalTørretidTextField() {
		if (optimalTørretidTextField == null) {
			optimalTørretidTextField = new JTextField();
		}
		return optimalTørretidTextField;
	}

	/**
	 * This method initializes maksimalTørretidTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMaksimalTørretidTextField() {
		if (maksimalTørretidTextField == null) {
			maksimalTørretidTextField = new JTextField();
		}
		return maksimalTørretidTextField;
	}

}
