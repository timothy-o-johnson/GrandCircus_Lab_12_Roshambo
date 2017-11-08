
public class PlayerRandom extends Player {

	PlayerRandom(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		int random = (int) (Math.random()* 3 + 1);
		
		switch(random) {
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
