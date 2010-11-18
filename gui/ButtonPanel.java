package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton opretButton = null;
	private JButton gemButton = null;
	private JButton sletButton = null;
	private List<OpretGemSletObserver> opretGemSletObservers = new ArrayList<OpretGemSletObserver>();

	/**
	 * This is the default constructor
	 */
	public ButtonPanel() {
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
		gridBagConstraints2.gridx = 2;
		gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints2.anchor = GridBagConstraints.EAST;
		gridBagConstraints2.gridy = 0;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints1.insets = new Insets(5, 5, 5, 0);
		gridBagConstraints1.gridy = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 0);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.gridy = 0;
		this.setLayout(new GridBagLayout());
		this.setSize(202, 36);
		this.add(getOpretButton(), gridBagConstraints);
		this.add(getGemButton(), gridBagConstraints1);
		this.add(getSletButton(), gridBagConstraints2);
	}

	/**
	 * This method initializes opretButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOpretButton() {
		if (opretButton == null) {
			opretButton = new JButton();
			opretButton.setText("Opret");
			opretButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					for (OpretGemSletObserver observer: opretGemSletObservers) {
						observer.opret();
					}
				}
			});
		}
		return opretButton;
	}

	/**
	 * This method initializes gemButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getGemButton() {
		if (gemButton == null) {
			gemButton = new JButton();
			gemButton.setText("Gem");
			gemButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					for (OpretGemSletObserver observer: opretGemSletObservers) {
						observer.gem();
					}
				}
			});
		}
		return gemButton;
	}

	/**
	 * This method initializes sletButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSletButton() {
		if (sletButton == null) {
			sletButton = new JButton();
			sletButton.setText("Slet");
			sletButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					for (OpretGemSletObserver observer: opretGemSletObservers) {
						observer.slet();
					}
				}
			});
		}
		return sletButton;
	}

	/**
	 * @param opretBehandlingPanel
	 */
	public void registerOpretGemSletObserver(
			OpretGemSletObserver observer) {
		opretGemSletObservers.add(observer);
	}
	
	public void enableSletButton(boolean enable)
	{
		getSletButton().setEnabled(enable);
	}
	
	public void enableGemButton(boolean enable)
	{
		getGemButton().setEnabled(enable);
	}
	
	public void enableOpretButton(boolean enable)
	{
		getOpretButton().setEnabled(enable);
	} 

}  //  @jve:decl-index=0:visual-constraint="10,10"
