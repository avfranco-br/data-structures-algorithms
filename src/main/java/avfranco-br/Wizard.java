package avfranco_br;

public class Wizard extends Player {
  
  public Wizard (String PlayerName, String PlayerType) {
     super(PlayerName,PlayerType);
  }

  public void Play() {
    System.out.println("Hey I am a " + this.PlayerType + " this " + this);
  }
}
