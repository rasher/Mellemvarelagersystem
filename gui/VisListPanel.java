package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class VisListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList klarList = null;
	private JList n�rOverskredetList = null;
	private JLabel klarListLabel = null;
	private JLabel n�rOverskredetLabel = null;
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
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridy = 3;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.weighty = 1.0;
		gridBagConstraints3.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints3.gridx = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints2.gridy = 2;
		n�rOverskredetLabel = new JLabel();
		n�rOverskredetLabel.setText("N�r maksimal t�rringstid : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.weighty = 1.0;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
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
		this.add(n�rOverskredetLabel, gridBagConstraints2);
		this.add(getN�rOverskredetList(), gridBagConstraints3);
	}

	/**
	 * This method initializes klarList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getKlarList() {
		if (klarList == null) {
			klarList = new JList();
			klarList.setBorder(MainFrame.getBorder());
		}
		return klarList;
	}

	/**
	 * This method initializes n�rOverskredetList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getN�rOverskredetList() {
		if (n�rOverskredetList == null) {
			n�rOverskredetList = new JList();
			n�rOverskredetList.setBorder(MainFrame.getBorder());
		}
		return n�rOverskredetList;
	}

}  //  @jve:decl-index=0:visual-constraint="-11,7"
