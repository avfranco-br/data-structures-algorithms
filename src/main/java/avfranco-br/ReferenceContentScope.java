package avfranco_br;

// Play with reference, content and scope
public class ReferenceContentScope {
    int value;

    public ReferenceContentScope() {
      this.value = 0;
      System.out.println("Inside constructor " + this);
    }

    public ReferenceContentScope(int number) {
      this.value = number;
      System.out.println("Inside constructor " + this);
    }
}
