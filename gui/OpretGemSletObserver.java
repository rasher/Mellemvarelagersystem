/**
 * 
 */
package gui;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public interface OpretGemSletObserver {
	/**
	 * Kaldt når brugeren trykker på opret
	 */
	public void opret();
	/**
	 * Kaldt når brugeren trykker på gem
	 */
	public void gem();
	/**
	 * Kaldt når brugeren trykker på slet
	 */
	public void slet();
}
