package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar carlettiMenuBar = null;
	private JMenu lagerMenu = null;
	private JMenu administrationMenu = null;
	private JMenuItem dagligLagerHåndteringMenuItem = null;
	private JMenuItem opretNyeProdukterMenuItem = null;
	private LagerPanel lagerPanel = null;  //  @jve:decl-index=0:visual-constraint="323,8"

	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getCarlettiMenuBar());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	/**
	 * This method initializes carlettiMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getCarlettiMenuBar() {
		if (carlettiMenuBar == null) {
			carlettiMenuBar = new JMenuBar();
			carlettiMenuBar.add(getLagerMenu());
			carlettiMenuBar.add(getAdministrationMenu());
		}
		return carlettiMenuBar;
	}

	/**
	 * This method initializes lagerMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getLagerMenu() {
		if (lagerMenu == null) {
			lagerMenu = new JMenu();
			lagerMenu.setText("Lager");
			lagerMenu.add(getDagligLagerHåndteringMenuItem());
		}
		return lagerMenu;
	}

	/**
	 * This method initializes administrationMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getAdministrationMenu() {
		if (administrationMenu == null) {
			administrationMenu = new JMenu();
			administrationMenu.setText("Administration");
			administrationMenu.add(getOpretNyeProdukterMenuItem());
		}
		return administrationMenu;
	}

	/**
	 * This method initializes dagligLagerHåndteringMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDagligLagerHåndteringMenuItem() {
		if (dagligLagerHåndteringMenuItem == null) {
			dagligLagerHåndteringMenuItem = new JMenuItem();
			dagligLagerHåndteringMenuItem.setText("Daglig Lager Håndtering");
			dagligLagerHåndteringMenuItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							MainFrame.this.setContentPane(getLagerPanel());
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return dagligLagerHåndteringMenuItem;
	}

	/**
	 * This method initializes opretNyeProdukterMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getOpretNyeProdukterMenuItem() {
		if (opretNyeProdukterMenuItem == null) {
			opretNyeProdukterMenuItem = new JMenuItem();
			opretNyeProdukterMenuItem.setText("Opret Nye Produkter");
		}
		return opretNyeProdukterMenuItem;
	}

	/**
	 * This method initializes lagerPanel	
	 * 	
	 * @return gui.LagerPanel	
	 */
	private LagerPanel getLagerPanel() {
		if (lagerPanel == null) {
			lagerPanel = new LagerPanel();
			lagerPanel.setSize(new Dimension(318, 155));
		}
		return lagerPanel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
}
