import java.util.Scanner;

public class PlayerHuman extends Player {

	PlayerHuman(String name) {
		super(name);
	}

	Scanner sc = new Scanner(System.in);

	@Override
	public Roshambo generateRoshambo() {
		String choice = Validator.getChar(sc, "\nWhat your choice? (r/ p/ s) ", "r", "s", "p");
		
		switch(choice.toLowerCase()) {
		case "r":
			return Roshambo.ROCK;
		case "p":
			return Roshambo.PAPER;
		case "s":
			return Roshambo.SCISSORS;
		default:
			return Roshambo.ERROR;
		}
	}

}
