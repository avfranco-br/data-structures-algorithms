package avfranco_br;

import java.util.Random;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DataStructuresAlgorithms {
 private static void findNemo(String[] array) {
    // Create a Logger 
    Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 

    for (int index=0; index < array.length; index++) {
      if (array[index].equalsIgnoreCase("nemo")) {
        logger.log(Level.INFO,"Found NEMO!!!");
      }
    }
  }
  
  // BIG O Linear Time function O(n)
  // Not efficient
  private static void findNumber(int[] arrayOfNumbers, int myNumber) {
    // Create a Logger 
    Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 
  
    for (int index=0; index < arrayOfNumbers.length; index++) {
      if (arrayOfNumbers[index] == myNumber) {
        logger.log(Level.INFO,"My number " + myNumber + " was found at position " + index);
      }
    }
  }
  
  // Log all pairs of array [1,2,3,4,5] - BIG O (n^2)
  // Nested arrays
  
  // Sum all pairs of array [1,2,3,4,5] - BIG O (n^2)
  // Nested arrays
  private static void sumAllPairsOfArray(int[] arrayOfNumbers) {
    // Create a Logger 
    Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 

    for (int number1 : arrayOfNumbers) {
      for (int number2 : arrayOfNumbers) {
          logger.log(Level.INFO,number1 + "," + number2 + " = " + (number1+number2));
      }
    } 
  }

  // Check if there are same values in two arrays
  // Do we have any limit size or the Arrays may get very large?
  // Arrays are sorted?
  // IF we have duplicated entries, should only return true or amount of times the same letter were found?
  // Can we assume always the two parameters are given?
  // Not Time Complexity efficient
  // Nested Arrays - BIG O(array1 * array2)
  // Readable code always - variable names, function names etc.
  // Can this code be improved? Replace for by for each structure
  // Modular & Clean code - small bits and pieces
  private static boolean findEqualEntriesOnArray(String[] array1, String[] array2) {  
    // Create a Logger 
    Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 

    // Nested Arrays - O(n^2) - time consuming once arrays get bigger
    // Space Complexity - O(1) - no new variable created, only the function
    
    // Time complexity O(array1*array2) - better than O(n^2)
    // Space complexity O(n) - newArray as a copye of Array1 - consume more memory
    // Faster solution but heavier 
    // Separate below code out and create a new function mapArrayToHashMap(arg1)
    HashMap<String,Integer> newArray = new HashMap<>();

    Integer keyValue = Integer.valueOf(1);

    for (String letra : array1) {
      // Don't need to check if property already exist
      // HashMap.put cares on benhind
      newArray.put(letra, keyValue); 
    }
    logger.log(Level.INFO,newArray.toString());

    // Create a new function CompareTwoArrays(arg1, arg2)
    for (String letra : array2) {
      if (newArray.containsKey(letra)) {
        return true;
      }
    }
    return false;
  }

  // Asking - check in a given array has pairs with the sum provided
  // [1,2,3,4] - sum 8 
  // [1,2,3,4,4] - sum 8
  // Are the inputs always the Array and the Sum? 
  // What need to be returned, true if found, false if not, or the pairs of numbers?
  // The array contains only integer numbers?
  // Will be the array already sorted?
  // Can the array become very large
  // Is there any priority in terms of time or space complexity?
  // Can I sum up each item with itself
  // Can we have duplicated entries?
  private static boolean hasPairsWithSums(int[] arrayOfNumbers, int sum) {
    // FIRST Option would a nested loop
      // add to the current value of the outer loop + with the subsequent values until find the desired sum or end of the Array 
      // follow this above steps until outer.length - 2
      // It solves the problem but it's not efficient, time consuming (O^2), mainly in case the array becomes very large
      // ArrayOfNumbers [1,2,3,4,4] = i + (i+1)
      
    // SECOND Option
      // First loop convert the Array to HashMap where each value as a Key
      // Second loop to look for the complements
      // Same time complexity than the nested loop - O(ArrayOfNumber*newArrayOfNumbers)
      // ArrayOfNumbers [1,2,3,4,4] --> HashMap [1,2,3,4,4]
      
    // THIRD Option
      // ArrayOfNumbers [1,2,3,4,4]
      // SUM fist + last == sum?
      // More time complexity efficient - O(n)
    
    if ((arrayOfNumbers[0]+arrayOfNumbers[arrayOfNumbers.length-1]) == sum) {
      return true;
    }
   
    // ArrayOfComplements[7,6,5,4]
    var arrayComplements = new HashMap<Integer, Integer>();

    // Walk-through each ArrayOfNumbers elements and look for its complement (sum - value)
    for (int value : arrayOfNumbers) {
      // sum 9
      // value [1,2,3,4,4]
      // ArrayOfComplements [7,6,5,4]
      if (arrayComplements.containsKey(sum-value)) {
        return true;
      }
      else {
        arrayComplements.put(Integer.valueOf(value), Integer.valueOf(1));
      }
    }

    return false;
  }
    
  private static void tryArrayOperations(ArrayList<Integer> array) {
    // Create a Logger 
    Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 
 
    // Show original array
    logger.log(Level.INFO,array.toString());
    //Add a new item
    array.add(10);
    // Show new array
    logger.log(Level.INFO,array.toString());
    // Sort the Array
    Collections.sort(array);
    // Show Sorted array
    logger.log(Level.INFO,array.toString());
  }
    
  public static void main(String[] args) {

    // Create a Logger 
    Logger logger = System.getLogger(DataStructuresAlgorithms.class.getName()); 

    String[] nemo = {"nemo", "flora", "eva"};
    findNemo(nemo);
    
    Random randomInts = new Random();
    int[] arrayOfNumbers = randomInts.ints(5,0,5).toArray();
    
    findNumber(arrayOfNumbers, 8);

    int[] arrayOfInts = {1,2,3,4};
    sumAllPairsOfArray(arrayOfInts);

    String[] strArray1 = {"a", "1", "c", "d", "e"};
    String[] strArray2 = {"x", "1", "v", "t", "p"};
    
    if (findEqualEntriesOnArray(strArray1, strArray2)) {
      logger.log(Level.INFO,"Same letter found!");
    }
    else {
      logger.log(Level.INFO,"Not found!");
    }
    
    //Google Interview Example
    int[] arrayNumbers = {1,2,3,4,4};
    if (hasPairsWithSums(arrayNumbers, 5)) {
      logger.log(Level.INFO,"Pairs of Sum FOUND!");
    }
    else {
      logger.log(Level.INFO,"Pairs of Sum NOT FOUND!");
    } 

    // Try different Array TryArrayOperations
    ArrayList<Integer> listOfNumbers = new ArrayList<>();
    listOfNumbers.add(1);
    listOfNumbers.add(4);
    listOfNumbers.add(7);
    listOfNumbers.add(2);
    listOfNumbers.add(3);
    tryArrayOperations(listOfNumbers);

    // Try Object Reference, Scope, Instanciation
    ReferenceContentScope object1 = new ReferenceContentScope(10);
    ReferenceContentScope object2 = object1;
    ReferenceContentScope object3 = new ReferenceContentScope(); 
    object3.value = object1.value;
    object1.value = 15;

    // logger.log(Level.INFO,"Outside constructor " + this); Error - cannot be used in a static context
    logger.log(Level.INFO,object1.value + "," + object2.value + "," + object3.value);
    logger.log(Level.INFO,object1==object2);

    //Class Instanciation
    Wizard player1 = new Wizard("Alexandre", "Healer");
    player1.Introduce(); player1.Play();

    ReverseString myString = new ReverseString("I L GOOGLE");
    logger.log(Level.INFO," Reversed I L GOOGLE: " + myString);

    //Merged sorted arrays
    int[] arrayOfNumbers1 = {0,3,4,31};
    int[] arrayOfNumbers2 = {3,4,6,30};

    var mergedSortedArrays = new MergeSortedArrays(arrayOfNumbers1,arrayOfNumbers2);
    logger.log(Level.INFO,"New merged array: " + mergedSortedArrays.toString());
  
    // My own code o HashTable
    HashTable myBucket = new HashTable(10);

    myBucket.set("Grapes", 100);
    myBucket.set("Strawberry", 50);
    myBucket.set("Apples",9);

    logger.log(Level.INFO,myBucket.get("Apples"));
    myBucket.keys();
  
    // FirstRecurring Character using my own HashTable class
    int[] arrayNumbers3 = {1,4,4,1,3,6,0,9,2};
    
    FirstRecurringCharacter lookForRecurringCharacter = new FirstRecurringCharacter(arrayNumbers3);
    lookForRecurringCharacter.mapOfRecurringCharacters.keys();

    //Using Java HashMapMap
    HashMap<Integer,Integer> map = new HashMap<>();

    for (int i = 0; i < arrayNumbers3.length; i++) {
      if (map.get(arrayNumbers3[i]) != null) {
        logger.log(Level.INFO,arrayNumbers3[i]);
        break;
      }
      else {
        logger.log(Level.INFO,arrayNumbers3[i] + "," + i);
        map.put(arrayNumbers3[i],i);  
      }
    }
    
    // Using Java HashMap
    var firstRecurrencyEntry = new FirstRecurrencyEntry();

    int recurrencyEntry = firstRecurrencyEntry.findFirstRecurrencyEntry(arrayNumbers3);

    if (recurrencyEntry != -1) {
      logger.log(Level.INFO,arrayNumbers3[recurrencyEntry]);
    } else {  
      logger.log(Level.INFO,"NO Recurring Entries found!");
    }
  
    // JAVA LinkedList Class 
    LinkedListCustom myLinkedList = new LinkedListCustom();
    myLinkedList.addItemLinkedList(10, 0);
    myLinkedList.addItemLinkedList(20, 1);
    myLinkedList.myLinkedList.offerFirst(50);
    myLinkedList.myLinkedList.add(30);
    myLinkedList.myLinkedList.offer(40);
    myLinkedList.myLinkedList.offerLast(60);
    myLinkedList.myLinkedList.set(3, 5);
    myLinkedList.printLinkedList();
    logger.log(Level.INFO,"Pick items in the LinkedList");
    logger.log(Level.INFO,myLinkedList.myLinkedList.element());
    logger.log(Level.INFO,myLinkedList.myLinkedList.getFirst());
    logger.log(Level.INFO,myLinkedList.myLinkedList.peek());
    logger.log(Level.INFO,myLinkedList.myLinkedList.peekFirst());
    logger.log(Level.INFO,myLinkedList.myLinkedList.getLast());
  
    // DEMO LinkedList / DoubleLinkedList Class
    demoLinkedList myDemoLinkedList = new demoLinkedList(5);
    myDemoLinkedList.append(10);
    myDemoLinkedList.append(16);
    myDemoLinkedList.append(20);
    myDemoLinkedList.append(30);
    myDemoLinkedList.preappend(1);
    myDemoLinkedList.preappend(0);
    myDemoLinkedList.append(40);
    myDemoLinkedList.insert(4, 8);
    myDemoLinkedList.remove(7);
    myDemoLinkedList.showDemoLinkList();
    myDemoLinkedList.reverse();

    // DEMO Stack Class
    demoStack myStack = new demoStack();
    myStack.push(10);
    myStack.push(20);
    myStack.push(30);
    myStack.pop();
    myStack.push(40);
    myStack.pop();
    logger.log(Level.INFO," Top of stack: " + myStack.peek());
    myStack.showStack();

    // DEMO Queue using Stack
    queueStack myQueue = new queueStack();
    myQueue.push(10);
    myQueue.push(20);
    myQueue.push(30);
    myQueue.push(40);
    myQueue.pop();
    logger.log(Level.INFO,myQueue.peek());

    // DEMO Stack using Array
    ArrayStack myArrayStack = new ArrayStack();
    myArrayStack.push("BBC");
    logger.log(Level.INFO,"Top: " + myArrayStack.peek());
    myArrayStack.push("Udemy");
    myArrayStack.showArrayStack();
    logger.log(Level.INFO,"Removed: " + myArrayStack.pop());
    logger.log(Level.INFO,"Top: " + myArrayStack.peek());

    // DEMO Binary Search Tree
    BinarySearchTree myBST = new BinarySearchTree();

    logger.log(Level.INFO,myBST.insert(9).value);
    logger.log(Level.INFO,myBST.insert(4).value);
    logger.log(Level.INFO,myBST.insert(1).value);
    logger.log(Level.INFO,myBST.insert(6).value);
    logger.log(Level.INFO,myBST.insert(20).value);
    logger.log(Level.INFO,myBST.insert(15).value);
    logger.log(Level.INFO,myBST.insert(170).value);
    logger.log(Level.INFO,myBST.insert(70).value);
    logger.log(Level.INFO,myBST.insert(181).value);
    logger.log(Level.INFO,myBST.insert(69).value);
    logger.log(Level.INFO,myBST.insert(75).value);
    logger.log(Level.INFO,myBST.insert(73).value);
    logger.log(Level.INFO,myBST.insert(81).value);
    logger.log(Level.INFO,myBST.insert(72).value);
    logger.log(Level.INFO,myBST.insert(74).value);
    logger.log(Level.INFO,myBST.insert(78).value);
  
    BinarySearchTree.Node nodeFound = myBST.lookup(20);
    logger.log(Level.INFO," Value: " + nodeFound.value + " Left: " + nodeFound.left.value + " Right: " + nodeFound.right.value);

    //REMOVE a vertex
    BinarySearchTree.Node vertex;
    vertex = myBST.remove(9);

    if (vertex == null) {
      logger.log(Level.INFO,"Tree is Empty or Vertex not found!");
    } else {
      logger.log(Level.INFO," Vertex " + vertex.value + " deleted!");
    }

    myBST.stringfy(); // vertex 20 not being printed after vertex 9 deleted
 }  
}
