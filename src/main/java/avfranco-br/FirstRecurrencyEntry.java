package avfranco_br;

import java.util.HashMap;

class FirstRecurrencyEntry {

  public int findFirstRecurrencyEntry(int[] ArrayOfNumbers) {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    for (int i=0; i < ArrayOfNumbers.length; i++) {
      if (map.get(ArrayOfNumbers[i]) != null) {
        return i;
      } else {
        map.put(ArrayOfNumbers[i], i);
      }
    }
    return -1;
  }
}
