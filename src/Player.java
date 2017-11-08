
public abstract class Player {
	Roshambo choice;
	String name;

	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;

	public abstract Roshambo generateRoshambo();

	Player(String name) {
		this.name = name;
		this.gamesWon = 0;
		this.gamesLost = 0;
		this.gamesDrawn = 0;

	}

	public void incrementGamesWon() {
		this.gamesWon++;
	}

	public void incrementGamesLost() {
		this.gamesLost++;
	}

	public void incrementGamesDrawn() {
		this.gamesDrawn++;
	}

	/**
	 * Prints who the winner is. Returns -1 if player1 loses, 0 if Draw, 1 if
	 * player1 wins
	 * 
	 * @param player1
	 * @param player1Choice
	 * @param player2
	 * @param player2Choice
	 * @return
	 */
	public static int winnerIs(Player player1, Roshambo player1Choice, Player player2, Roshambo player2Choice) {

		System.out.println(player1.getName() + " throws " + player1Choice + "...");
		System.out.println(player2.getName() + " throws " + player2Choice + "...");
		
		
		if (player1Choice.equals(Roshambo.ROCK) && player2Choice.equals(Roshambo.SCISSORS)) {
			System.out.println(player1.name + " wins!");
			return 1;
		} else if (player1Choice.equals(Roshambo.SCISSORS) && player2Choice.equals(Roshambo.PAPER)) {
			System.out.println(player1.name + " wins!");
			return 1;
		} else if (player1Choice.equals(Roshambo.PAPER) && player2Choice.equals(Roshambo.ROCK)) {
			System.out.println(player1.name + " wins!");
			return 1;
		} else if (player1Choice.equals(player2Choice)) {
			System.out.println("Draw!");
			return 0;
		} else {
			System.out.println(player2.name + " win!");
			return -1;
		}

	}

	public Roshambo getChoice() {
		return choice;
	}

	public void setChoice(Roshambo choice) {
		this.choice = choice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	public int getGamesDrawn() {
		return gamesDrawn;
	}

	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}

}