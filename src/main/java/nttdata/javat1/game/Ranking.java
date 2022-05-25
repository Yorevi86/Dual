package nttdata.javat1.game;

import java.util.ArrayList;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**Clase que ayudará a montar un ranking de jugadores para el pinball
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class Ranking implements Comparable<Ranking> {
	
	private String name;
	private ArrayList<Ball> ballsScores;//ArrayList para guardar también las puntuaciones de la bola por si se necesitase en un futuro
	int score;
	
	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(Ranking.class);
	
	/**
	 * @param name
	 * @param score
	 */
	public Ranking(String name, int score) {
		
		LOG.debug("Created object Ranking with params: ", name , " and ",score, ".");
		
		this.name = name;
		this.setBallsScores(ballsScores);
		this.score = score;
	}
	/**
	 * 
	 */
	public Ranking() {
		
		LOG.debug("Created object Ranking without params.");
		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	/**
	 * @return the ballsScores
	 */
	public ArrayList<Ball> getBallsScores() {
		return ballsScores;
	}
	/**
	 * @param ballsScores the ballsScores to set
	 */
	public void setBallsScores(ArrayList<Ball> ballsScores) {
		this.ballsScores = ballsScores;
	}

	/**
	 * Comparador de clase
	 */
	public int compareTo(Ranking r1) {
		return Integer.compare(this.score, r1.getScore());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ballsScores, name, score);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ranking other = (Ranking) obj;
		return Objects.equals(score, other.score) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Name=" + name + "|| Score=" + score + "\n";
	}
	
}
