package avfranco_br;

// import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class arrayStack {
  ArrayList<String> arrayOfItems;
  String top;
  int length = 0;

  public arrayStack(String value) {
    arrayOfItems = new ArrayList<String>();
    top = null;
    length=0;
  }

  public String pop() {
    if (arrayOfItems.isEmpty()) return null;    
    length--;
    String deletedItem = arrayOfItems.remove(length);
    if (length > 0) {
      top = arrayOfItems.get(length-1);
    } else {
      top = null;
    }
    return deletedItem;
  }

  public String peek() {
    return arrayOfItems.isEmpty() ? null : top;
  }

  public void push (String value) {
    arrayOfItems.add(value);
    top = value;
    length++;  
  }

  public void showArrayStack() {
    for (String item: arrayOfItems) {
      System.out.println (item);
    }
  }
}
