public class Player {
  protected String PlayerName;
  protected String PlayerType;

  public Player(String PlayerName, String PlayerType) {
    this.PlayerName = PlayerName;
    this.PlayerType = PlayerType;
  }

  public void Introduce() {
    System.out.println("Hi, I am " + this.PlayerName + ", am a " + this.PlayerType + " this " + this);
  }
}
