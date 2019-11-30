// Array1 [2,5,1,8,3,5,1,2,4]
// 
// OPTION.1
  // TRAVERSE THE ARRAY 
  // COMPARING each item with the next 
  // THEN next item with the next and backwords
  // Time Expensive, Complex logic

// OPTION.2
  // Copy the Array [2,5,1,8,3,5,1,2,4] to a HashTable
  // {2,0,2,7}, {5,1,5,5}, {1,3,1,6}, {8,3}, {3,4}, {4,8}
  // Traverse the Array looking for the key

public class FirstRecurringCharacter {
  HashTable mapOfRecurringCharacters;

  public FirstRecurringCharacter(int[] arrayOfNumbers) {
      mapOfRecurringCharacters = new HashTable(arrayOfNumbers.length);
      mapOfRecurringCharacters.set(arrayOfNumbers);
      int firstCharacter=0;
      int indexCharacter=0;
      boolean recurringCharacterFound = false;

      for (int i=0; i < arrayOfNumbers.length; i++) {
        String key = Integer.toString(arrayOfNumbers[i]);
        int[] pairsOfCollisions  = mapOfRecurringCharacters.getRecurringCharacters(key);

        if (pairsOfCollisions != null) {
          if (i == 0) {
            firstCharacter = pairsOfCollisions[0];
            indexCharacter = pairsOfCollisions[1];
            recurringCharacterFound = true;
          } else {
            if (pairsOfCollisions[1] < indexCharacter) {
              firstCharacter = pairsOfCollisions[0];
              indexCharacter = pairsOfCollisions[1];
            }
          }
        } 
      }
      if (recurringCharacterFound) {
        System.out.println("First recurring character is: " + firstCharacter);
      }
      else {
        System.out.println("There is not recurring entries at the given array!");
      }
  }
}