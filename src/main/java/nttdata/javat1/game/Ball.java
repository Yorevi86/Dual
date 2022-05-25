/**
 * 
 */
package nttdata.javat1.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jonatan Carrera Viera
 * Clase para el objeto bola
 */
public class Ball {
	
	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(Ball.class);
	
	// Atributo para contar la puntuación de la bola
	private int score;

	/**
	 * @param score
	 */
	public Ball(int score) {
		
		LOG.debug("Created object Ball with score: {}.", score);
		
		this.score = score;
	}

	/**
	 * empty constructor
	 */
	public Ball() {
		
		LOG.debug("Created object Ball without params.");
		
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Ball [score=" + score + "]";
	}
	
}
