/**
 * 
 */
package nttdata.javat1.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jonatan Carrera Viera
 * Clase que define el juego del pinball
 *
 */
public abstract class Game {
	
	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(Game.class);
	
	public static void launchAndStart() {

		LOG.debug("Entering method launchAndStart.");
		
		int option = 0;// Variable para primer menu
		Scanner scMainMenu = new Scanner(System.in);
		Scanner scPlayerName = new Scanner(System.in);
		Scanner scPlayAgain = new Scanner(System.in);
		String playerName = "";
		ArrayList<Ranking> ranking = new ArrayList<>();
		
		Utilities.delayText("Welcome to your (maybe not) favorite pinball machine!!", 50);
		
		do {
			option = 0;
			Utilities.delayText("Please, select one of the next options:", 25);
			System.out.println("1. Enter player name\n2. Start playing\n3. Show ranking\n4. Exit");
			if (scMainMenu.hasNextInt()) {
				option = scMainMenu.nextInt();
				switch (option) {
					case 1:{
				 		System.out.println("Choose your name");
				 		playerName = scPlayerName.nextLine();	
				 		break;
				 	}
				 	case 2:{
				 		playPinball(scPlayAgain, playerName, ranking);
				 		break;
				 	}
				 	case 3:{
				 		showRanking(ranking);
				 		break;
					}
				}
			}else {
				LOG.error("Tried to enter {} into a do while in method [launchAndStart()]", option);
				
				scMainMenu.next();
				System.out.println("That's not a valid option.");
			}
		}while (option != 4);
			
		scMainMenu.close();
		scPlayerName.close();
		scPlayAgain.close();
	}

	/**Metodo para mostrar la clasificación final de jugadores
	 * 
	 * @param ranking
	 */
	public static void showRanking(ArrayList<Ranking> ranking) {
		
		LOG.debug("Entering method showRanking.");
		
		Collections.sort(ranking);
		Collections.reverse(ranking);
		System.out.println("Here is the ranking!!\n---------------------------------");
		for(int i = 0; i < ranking.size(); i++) {
			StringBuilder scoreBoard = new StringBuilder("");
			scoreBoard.append("|| ").append(i + 1).append("- ");
			scoreBoard.append(ranking.get(i).getName()).append(" || ");
			scoreBoard.append(ranking.get(i).getScore()).append(" ||");
			scoreBoard.toString();
			System.out.println(scoreBoard + "\n---------------------------------");
		}
	}

	/**Método con el codigo del juego de pinball
	 * 
	 * @param scPlayAgain
	 * @param playerName
	 * @param ranking
	 */
	public static void playPinball(Scanner scPlayAgain, String playerName, ArrayList<Ranking> ranking) {
		
		LOG.debug("Entering method playPinball.");
		
		if (playerName != "") {
			String again = "";
			
			while(!again.equalsIgnoreCase("y")) {
				// Sería más correcto usar un do-while, pero usamos while para cubrir todos los requisitos del cliente
				Ranking rank = new Ranking();
				ArrayList<Ball> balls = new ArrayList<>();
				rank.setName(playerName);
				int score = 0;
				
				for (int i = 0; i<3;i++) {
					Ball bola = new Ball();
					bola.setScore(launch());
					score += bola.getScore();
					balls.add(bola);
				}
				
				rank.setBallsScores(balls);
				rank.setScore(score);
				ranking.add(rank);
				System.out.println("Do you want to quit? Y/N");
				again = scPlayAgain.nextLine();
			}
		}else {
			LOG.warn("User attempted to play without setting a name.");
			
			System.out.println("Insert a name on option 1 first, please");
		}
	}
	
	/**Método para realizar una partida
	 * 
	 * @return
	 */
	public static int launch () {
		
		LOG.debug("Entering method launch.");
		
		 int score = 0;
		 int route;
		 
		 do {
			 route=Random(10);
			 switch (route) {
			 	case 0:{
			 		score += bouncing();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 1:{
			 		score += specialBouncing();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 2:{
			 		score += lateralBounce();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 3:{
			 		score += upperLateralBounce();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;				 
			 	}
			 	case 4:{
			 		score += halfTunnel();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 5:{
			 		score += fullTunnel();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 6:{
			 		score += splitBridge();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 7:{
			 		score += completeBridge();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 	case 8:{
			 		score += volcano();
			 		LOG.info("Actual score of the ball: {}", score);
			 		break;
			 	}
			 }
		 } while (route != 9);
		 
		 LOG.info("Game finished with final score of the ball: {}", score);
		 System.out.println("Your ball got "+ score +" points.");
		 
		 return score;
	}
	
	private static int volcano() {
		// TODO Auto-generated method stub
		return 50000;
	}

	private static int completeBridge() {
		
		LOG.debug("Entering method completeBridge.");
		
		int score;

		Utilities.delayText("CARE!! COLLAPSING BRIDGE AHEAD!!!", 25);
		Utilities.delayText("Wow! I have never seen someone running so fast over a bridge collapsing... Did you know the pirate who was right behind you?\nYou keep the 30.000 points of the pirate", 15);
		score = 30000;
		
		return score;
	}

	private static int splitBridge() {
		
		LOG.debug("Entering method splitBridge.");
		
		int score;
		
		Utilities.delayText("CARE!! COLLAPSING BRIDGE AHEAD!!!", 25);
		Utilities.delayText("Oh, you nearly get to the other side of the bridge, but you had to turn back because you are slacking hard.\nBut not all is lost, you found a crushed chest with 2.500 points at the bottom in hands of what seems a pirate skeleton.", 15);
		score = 2500;
		
		return score;
	}

	private static int fullTunnel() {
		
		LOG.debug("Entering method fullTunnel.");
		
		int score = 0;
		
		Utilities.delayText("WOW!!! A casino inside of a cave on an island in the middle of nowhere... Island Roulette time!!!", 25);
		
		switch (Random(6)) {
			case 0:{
				LOG.debug("Entering method fullTunnel, case 0.");
				System.out.println("Oooh! Bad luck, see you next time~... Now, get out of here!");
				score += 0;
				break;
			}
			case 1:{
				LOG.debug("Entering method fullTunnel, case 1.");
				System.out.println("Not bad, but you can do it better! Take your 500 points~");
				score += 500;
				break;
			}
			case 2:{
				LOG.debug("Entering method fullTunnel, case 2.");
				System.out.println("Hey! Take these 1.000 points and don't let anyone know");
				score += 1000;
				break;
			}
			case 3:{
				LOG.debug("Entering method fullTunnel, case 3.");
				System.out.println("Uuuuh! You are getting good at this, enjoy your 2.000 points!");
				score += 2000;
				break;
			}
			case 4:{
				LOG.debug("Entering method fullTunnel, case 4.");
				System.out.println("Let's goooo! Now we are talking! Pick your 5.000 points and don't waste them too fast!!");
				score = 5000;
				break;
			}	
			case 5:{
				LOG.debug("Entering method fullTunnel, case 5.");
				Utilities.delayText("JACKPOT!!!!", 50);
				System.out.println("25.000 points for you!!!");
				score = 25000;
				break;
			}
		}
	
	return score;
	
	}

	private static int halfTunnel() {
		
		LOG.debug("Entering method halfTunnel.");
		
		System.out.println("You nearly got lost inside this massive cave, but hey, you found a gold coin worth 100 points on the floor.");
		
		return 100;
	}

	private static int upperLateralBounce() {
		
		LOG.debug("Entering method upperLateralBounce.");
		
		int pointsPerBounce = 30;
		
		System.out.println("Clunk!");
		
		return (Random(2)+1)*pointsPerBounce;
	}

	private static int lateralBounce() {
		
		LOG.debug("Entering method upperLateralBounce.");
		
		int pointsPerBounce = 20;
		
		System.out.println("Blank!");
		
		return (Random(3)+1)*pointsPerBounce;
	}

	private static int specialBouncing() {
		
		LOG.debug("Entering method upperLateralBounce.");
		
		int pointsPerBounce = 50;
		
		System.out.println("BOM BOM BENG BOM!!");
		
		return (Random(10)+1)*pointsPerBounce;
	}

	private static int bouncing() {
		
		LOG.debug("Entering method upperLateralBounce.");
		
		int pointsPerBounce = 10;
		
		System.out.println("PLIN PLIN CLIN BLIN!!");
		
		return (Random(15)+1)*pointsPerBounce;
	}
	
	/**Método para calcular un random para un rápido uso, el valor recibido es el máximo sin incluir
	 *
	 * @param maxValueNotIncluded
	 * @return
	 */
	public static int Random (int maxValueNotIncluded) {
		
		LOG.debug("Entering method Random.");
		
		Random r = new Random();
		
		LOG.debug("Number generated: {}", r);
		
		return r.nextInt(maxValueNotIncluded);
	}
}
