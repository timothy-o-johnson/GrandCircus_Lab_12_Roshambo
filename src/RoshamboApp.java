import java.util.Scanner;

/*
 * Tim Johnson
 * Grand Circus
 * 11/6/17
 */

/*This app will 
 * (1) prompt the player to enter a name and select an opponent  
 * (2) prompt the player to select rock, paper, or scissors. 
 * Then display the player's choice, the opponent's choice, 
 * and the result of the match. 
 * (3) Continue until the user doesn't want to play anymore. 
 * (4) If the user makes an invalid selection, display an appropriate
 *  error message and prompt the user again until the user makes a valid selection.
 */

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opponentChoice = null;
		boolean repeat = true;

		int gameOutcome = 0;
		

		
		System.out.println("Welcome to Rock Paper Scissor-- the best game... in the WORLD.");

		Player player1 = new PlayerHuman(Validator.getString(sc, "\nWhat's YOUR name, suga'? ;-) "));
		Player player2 = new PlayerRock("The Jets");
		Player player3 = new PlayerRandom("The Sharks");

		// choose opponent
		opponentChoice = Validator.getChar(sc, "Would you like to play against The Jets or The Sharks? (j/s) ", "j", "s");

		while (repeat) {
			// start game with appropriate opponent
			if (opponentChoice.equalsIgnoreCase("j")) { // if the jets play against jets
				gameOutcome = Player.winnerIs(player1, player1.generateRoshambo(), player2, player2.generateRoshambo());
				updateScores(gameOutcome, player1, player2);
				printScores(player1, player2);
			} else { //otherwise play against the Sharks
				gameOutcome = Player.winnerIs(player1, player1.generateRoshambo(), player2, player2.generateRoshambo());
				updateScores(gameOutcome, player1, player3);
				printScores(player1, player3);
			}
  
			// keep playing/
			if (Validator.getChar(sc, "\nPlay again? (y/n) ", "y", "n").equalsIgnoreCase("y")) {
				repeat = true;
			} else {
				repeat = false;
			}

		}
		System.out.println("Okay thanks for playing! G'bye!");
		sc.close();

	}

	/**
	 * @param player1
	 * @param player2
	 */
	private static void printScores(Player player1, Player player2) {
		System.out.println();
		System.out.println(player1.name + ": " + player1.getGamesWon());
		System.out.println(player2.name + ": " + player2.getGamesWon());
		System.out.println("Draws: " + player2.getGamesDrawn());
	}

	/**
	 * 
	 * @param outcome
	 * @param firstPlayer
	 * @param secondPlayer
	 */
	private static void updateScores(int outcome, Player firstPlayer, Player secondPlayer) {
		if (outcome == 1) { // player1 is winner
			firstPlayer.incrementGamesWon();
			secondPlayer.incrementGamesLost();
		} else if (outcome == -1) { // player2 is winner
			firstPlayer.incrementGamesLost();
			secondPlayer.incrementGamesWon();
		} else {
			firstPlayer.incrementGamesDrawn();
			secondPlayer.incrementGamesDrawn();
		}
	}

	public static Roshambo generateRoshambo() {
		int random = (int) (Math.random() * 3 + 1);

		switch (random) {
		case 1:
			return Roshambo.ROCK;
		case 2:
			return Roshambo.PAPER;
		case 3:
			return Roshambo.SCISSORS;
		default:
			return Roshambo.ERROR;
		}

	}

}
