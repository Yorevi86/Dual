package nttdata.javat1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.javat1.game.Game;
/**
 * @author Jonatan Carrera Viera
 *
 */
public class T1MainJCV {
	
	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(T1MainJCV.class);
	
	/** Método main para la ejecución del juego
	 * 
	 * @param args
	 */
    public static void main( String[] args ){
    	
    	LOG.debug("Method main initiated.");
    	
        Game.launchAndStart();
    }
}