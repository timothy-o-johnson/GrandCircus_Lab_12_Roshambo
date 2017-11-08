
public class PlayerRock extends Player {

	PlayerRock(String name) {
		super(name);
	
	}

	@Override
	public Roshambo generateRoshambo() {		
		return Roshambo.ROCK;
	}

}
