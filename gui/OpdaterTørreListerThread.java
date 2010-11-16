/**
 * 
 */
package gui;

import javax.swing.JList;
import javax.swing.JSlider;

import model.Service;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class OpdaterTørreListerThread extends Thread {
	private JList klarList;
	private JList nærOverskredetList;
	private JSlider antalTimerFraMaxToerringsSlider;
	
	public OpdaterTørreListerThread(JList klarList, JList nærOverskredetList, JSlider antalTimerFraMaxToerringsSlider) {
		super();
		this.klarList = klarList;
		this.nærOverskredetList = nærOverskredetList;
		this.antalTimerFraMaxToerringsSlider = antalTimerFraMaxToerringsSlider;
	}
	
	public void opdaterLister() {
		System.out.println("Opdater lister");
		int timerFraMaks = antalTimerFraMaxToerringsSlider.getValue();
		klarList.setListData(Service.getInstance().getKlar(timerFraMaks).toArray());
		nærOverskredetList.setListData(Service.getInstance().getNærOverskredet(timerFraMaks).toArray());
	}
	
	public void run() {
		while (true) {
			try {
				opdaterLister();
				sleep(60*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
