package gui;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import model.Test;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar CarlettiMenuBar = null;
	private JMenu LagerMenu = null;
	private JMenu AdministrationMenu = null;
	private JMenuItem DagligLagerHåndteringMenuItem = null;
	private JMenuItem OpretNyeProdukterMenuItem = null;
	private JMenuItem StatistikMenuItem = null;
	private LagerPanel lagerPanel = null;  //  @jve:decl-index=0:visual-constraint="342,13"//  @jve:decl-index=0:
	private AdministrationPanel administrationPanel = null;  //  @jve:decl-index=0:visual-constraint="339,226"
	private OpdaterToerreListerThread opdaterTørreListerThread = new OpdaterToerreListerThread();
	private JMenu testMenu = null;
	private JMenuItem testMenuOpretTestData = null;
	private JMenuItem testMenuSletAltData = null;
	private JMenuItem testMenuSætAlleVarerKlar = null;
	private JMenuItem testMenuSætEnVareOverskredet = null;
	
	/**
	 * This method initializes CarlettiMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getCarlettiMenuBar() {
		if (CarlettiMenuBar == null) {
			CarlettiMenuBar = new JMenuBar();
			CarlettiMenuBar.add(getLagerMenu());
			CarlettiMenuBar.add(getAdministrationMenu());
			CarlettiMenuBar.add(getTestMenu());
		}
		return CarlettiMenuBar;
	}

	/**
	 * This method initializes LagerMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getLagerMenu() {
		if (LagerMenu == null) {
			LagerMenu = new JMenu();
			LagerMenu.setText("Lager");
			LagerMenu.add(getDagligLagerHåndteringMenuItem());
		}
		return LagerMenu;
	}

	/**
	 * This method initializes AdministrationMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getAdministrationMenu() {
		if (AdministrationMenu == null) {
			AdministrationMenu = new JMenu();
			AdministrationMenu.setText("Administration");
			AdministrationMenu.add(getOpretNyeProdukterMenuItem());
			AdministrationMenu.add(getStatistikMenuItem());
		}
		return AdministrationMenu;
	}

	/**
	 * This method initializes DagligLagerHåndteringMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDagligLagerHåndteringMenuItem() {
		if (DagligLagerHåndteringMenuItem == null) {
			DagligLagerHåndteringMenuItem = new JMenuItem();
			DagligLagerHåndteringMenuItem.setText("Daglig Lager Håndtering");
			DagligLagerHåndteringMenuItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
						MainFrame.this.setSize(920,500);
						setContentPane(getLagerPanel());
						MainFrame.this.setVisible(true);
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return DagligLagerHåndteringMenuItem;
	}

	/**
	 * This method initializes OpretNyeProdukterMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getOpretNyeProdukterMenuItem() {
		if (OpretNyeProdukterMenuItem == null) {
			OpretNyeProdukterMenuItem = new JMenuItem();
			OpretNyeProdukterMenuItem.setText("Opret Nye Produkter");
			OpretNyeProdukterMenuItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							MainFrame.this.setSize(920,500);
							setContentPane(getAdministrationPanel());
							MainFrame.this.setVisible(true);
						}
					});
		}
		return OpretNyeProdukterMenuItem;
	}

	/**
	 * This method initializes StatistikMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getStatistikMenuItem() {
		if (StatistikMenuItem == null) {
			StatistikMenuItem = new JMenuItem();
			StatistikMenuItem.setText("Statistik");
		}
		return StatistikMenuItem;
	}

	/**
	 * This method initializes lagerPanel	
	 * 	
	 * @return gui.LagerPanel	
	 */
	private LagerPanel getLagerPanel() {
		if (lagerPanel == null) {
			lagerPanel = new LagerPanel();
			lagerPanel.setSize(920, 500);
			lagerPanel.setMainFrame(this);
		}
		return lagerPanel;
	}

	/**
	 * This method initializes administrationPanel	
	 * 	
	 * @return gui.AdministrationPanel	
	 */
	private AdministrationPanel getAdministrationPanel() {
		if (administrationPanel == null) {
			administrationPanel = new AdministrationPanel();
			administrationPanel.setSize(920,500);
		}
		return administrationPanel;
	}

	/**
	 * This method initializes testMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getTestMenu() {
		if (testMenu == null) {
			testMenu = new JMenu();
			testMenu.setText("Test");
			testMenu.add(getTestMenuOpretTestData());
			testMenu.add(getTestMenuSletAltData());
			testMenu.add(getTestMenuSætAlleVarerKlar());
			testMenu.add(getTestMenuSætEnVareOverskredet());
		}
		return testMenu;
	}

	/**
	 * This method initializes testMenuOpretTestData	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTestMenuOpretTestData() {
		if (testMenuOpretTestData == null) {
			testMenuOpretTestData = new JMenuItem();
			testMenuOpretTestData.setText("Opret testdata");
			testMenuOpretTestData.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Test.getInstance().opretTestData();
					JOptionPane.showMessageDialog(null, "Test data oprettet", "Oprettet", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return testMenuOpretTestData;
	}

	/**
	 * This method initializes testMenuSletAltData	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTestMenuSletAltData() {
		if (testMenuSletAltData == null) {
			testMenuSletAltData = new JMenuItem();
			testMenuSletAltData.setText("Slet alt data");
			testMenuSletAltData.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (JOptionPane.showConfirmDialog(null, "Vil du slette alt data?", "Pas på", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Test.getInstance().sletAlt();
						JOptionPane.showMessageDialog(null, "Alt data slettet", "Slettet", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
		return testMenuSletAltData;
	}

	/**
	 * This method initializes testMenuSætAlleVarerKlar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTestMenuSætAlleVarerKlar() {
		if (testMenuSætAlleVarerKlar == null) {
			testMenuSætAlleVarerKlar = new JMenuItem();
			testMenuSætAlleVarerKlar.setEnabled(false);
			testMenuSætAlleVarerKlar.setText("Sæt alle varer klar");
		}
		return testMenuSætAlleVarerKlar;
	}

	/**
	 * This method initializes testMenuSætEnVareOverskredet	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTestMenuSætEnVareOverskredet() {
		if (testMenuSætEnVareOverskredet == null) {
			testMenuSætEnVareOverskredet = new JMenuItem();
			testMenuSætEnVareOverskredet.setEnabled(false);
			testMenuSætEnVareOverskredet.setText("Sæt en vare overskredet");
		}
		return testMenuSætEnVareOverskredet;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

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
		this.setSize(920, 500);
		this.setJMenuBar(getCarlettiMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Mellemvarelager");
		VisListPanel visListPanel = getLagerPanel().getVisListPanel();
		opdaterTørreListerThread.setKlarList(visListPanel.getKlarList());
		opdaterTørreListerThread.setNærOverskredetList(visListPanel.getNærOverskredetList());
		opdaterTørreListerThread.setAntalTimerFraMaxToerringsSlider(visListPanel.getAntalTimerFraMaxToerringsSlider());
		opdaterTørreListerThread.start();
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
	
	public static Border getBorder(){
		return BorderFactory.createLineBorder(Color.GRAY);
	}
	
	public OpdaterToerreListerThread getOpdaterToerreListerThread(){
		return opdaterTørreListerThread;
	}

}
