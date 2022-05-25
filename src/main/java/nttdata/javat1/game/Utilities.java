/**
 * 
 */
package nttdata.javat1.game;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jonatan Carrera Viera
 *
 */
public class Utilities {
	
	private static final Logger LOG = LoggerFactory.getLogger(Game.class);
	
	/**Método para mostrar texto con delay personalizable en milisegundos
	 * 
	 * @param text
	 * @param delay
	 * @throws InterruptedException
	 */
	public static void delayText (String text, long delay) {
		
		LOG.debug("Entering method delayText.");
		System.out.println("\n");
	    for (char ch : text.toCharArray()) {
	        System.out.print(ch);
	        try {
				TimeUnit.MILLISECONDS.sleep(delay);
			} catch (InterruptedException e) {
				LOG.error("Error de interrupción: {} .", e);
				e.printStackTrace();
			}
	    }
	    System.out.println("");
	}
}
