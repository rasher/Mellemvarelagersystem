/**
 * 
 */
package gui;

import javax.swing.JList;

import model.Service;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class OpdaterTørreListerThread extends Thread {
	private JList klarList;
	private JList nærOverskredetList;
	
	public OpdaterTørreListerThread(JList klarList, JList nærOverskredetList) {
		super();
		this.klarList = klarList;
		this.nærOverskredetList = nærOverskredetList;
	}
	
	public void opdaterLister() {
		int timerFraMaks = 8;
		klarList.setListData(Service.getInstance().getKlar(timerFraMaks).toArray());
		nærOverskredetList.setListData(Service.getInstance().getNærOverskredet(timerFraMaks).toArray());
	}
	
	public void run() {
		opdaterLister();
		try {
			sleep(60*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
