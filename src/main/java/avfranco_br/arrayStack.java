package avfranco_br;

import java.util.ArrayList;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;


public class ArrayStack {
  ArrayList<String> arrayOfItems;
  String top;
  int length = 0;

  public ArrayStack() {
    arrayOfItems = new ArrayList<>();
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
  Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 
 
    for (String item: arrayOfItems) {
        logger.log(Level.INFO,item);
    }
  }
}