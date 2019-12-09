package avfranco_br;

import java.time.LocalTime;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class DataStructuresAlgorithms {
 private static void findNemo(String[] array) {
    for (int index=0; index < array.length; index++) {
      if (array[index] == "nemo") {
        System.out.print("Found NEMO!!!");
      }
    }
  }
  
  // BIG O Linear Time function O(n)
  // Not efficient
  private static void findNumber(int[] arrayOfNumbers, int myNumber) {
    for (int index=0; index < arrayOfNumbers.length; index++) {
      //System.out.println(arrayOfNumbers[index]);
      if (arrayOfNumbers[index] == myNumber) {
        System.out.println("My number " + myNumber + " was found at position " + index);
      }
    }
  }
  
  // Log all pairs of array [1,2,3,4,5] - BIG O (n^2)
  // Nested arrays
  private static void logAllPairsOfArray(int[] arrayOfNumbers) {
    int sizeArray = arrayOfNumbers.length;
    for (int index=0; index < sizeArray; index++) {
      for (int index1=0; index1 < sizeArray; index1++) {
          System.out.println(arrayOfNumbers[index] + "," + arrayOfNumbers[index1]);
      }
    }
  }

  // Sum all pairs of array [1,2,3,4,5] - BIG O (n^2)
  // Nested arrays
  private static void sumAllPairsOfArray(int[] arrayOfNumbers) {
    for (int number1 : arrayOfNumbers) {
      for (int number2 : arrayOfNumbers) {
          System.out.println(number1 + "," + number2 + " = " + (number1+number2));
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
    // Nested Arrays - O(n^2) - time consuming once arrays get bigger
    // Space Complexity - O(1) - no new variable created, only the function
    /*
    for (char value1 : array1) {
      for (char value2 : array2) {
        if (value1 == value2) return true;
      }
    }
    */

    // Time complexity O(array1*array2) - better than O(n^2)
    // Space complexity O(n) - newArray as a copye of Array1 - consume more memory
    // Faster solution but heavier 
    // Separate below code out and create a new function mapArrayToHashMap(arg1)
    HashMap<String,Integer> newArray = new HashMap<String,Integer>();

    for (String letra : array1) {
      // Don't need to check if property already exist
      // HashMap.put cares on benhind
      newArray.put(letra, new Integer(1)); 
    }
    System.out.println(newArray.toString());

    // Create a new function CompareTwoArrays(arg1, arg2)
    for (String letra : array2) {
      if (newArray.containsKey(letra) == true) {
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
  private static boolean hasPairsWithSums(int[] ArrayOfNumbers, int sum) {
    // FIRST Option would a nested loop
      // add to the current value of the outer loop + with the subsequent values until find the desired sum or end of the Array 
      // follow this above steps until outer.length - 2
      // It solves the problem but it's not efficient, time consuming (O^2), mainly in case the array becomes very large
      // ArrayOfNumbers [1,2,3,4,4] = i + (i+1)
      /* for (int i=0; i < ArrayOfNumbers.length-1; i++) {
        for (int j=i+1; j < ArrayOfNumbers.length; j++) {
          System.out.println (ArrayOfNumbers[i] + "," + ArrayOfNumbers[j]);
          if ((ArrayOfNumbers[i]+ArrayOfNumbers[j]) == sum) {
            return true;
          }
        }
      } 
      return false; */

    // SECOND Option
      // First loop convert the Array to HashMap where each value as a Key
      // Second loop to look for the complements
      // Same time complexity than the nested loop - O(ArrayOfNumber*newArrayOfNumbers)
      // ArrayOfNumbers [1,2,3,4,4] --> HashMap [1,2,3,4,4]
      /*
      HashMap <Integer,Integer>newArrayOfNumbers = new HashMap<Integer,Integer>();
      for (int value : ArrayOfNumbers) {
        newArrayOfNumbers.put (new Integer(value),new Integer(1));
      }

      for (int value: ArrayOfNumbers) {
        if (value != (sum - value)) {
          if (newArrayOfNumbers.containsKey(sum-value)) {
              return true;
          }
        }
      }
      return false;
      */

    // THIRD Option
    // ArrayOfNumbers [1,2,3,4,4]
    // SUM fist + last == sum?
    // More time complexity efficient - O(n)
    if ((ArrayOfNumbers[0]+ArrayOfNumbers[ArrayOfNumbers.length-1]) == sum) {
      return true;
    }
   
    // ArrayOfComplements[7,6,5,4]
    HashMap <Integer,Integer> ArrayOfComplements = new HashMap<Integer,Integer>();

    // Walk-through each ArrayOfNumbers elements and look for its complement (sum - value)
    for (int value : ArrayOfNumbers) {
      // sum 9
      // value [1,2,3,4,4]
      // ArrayOfComplements [7,6,5,4]
      if (ArrayOfComplements.containsKey(sum-value)) {
        return true;
      }
      else {
        ArrayOfComplements.put(new Integer(value), new Integer(1));
      }
    }

    return false;
  }
    
  private static void TryArrayOperations(ArrayList array) {
    // Show original array
    System.out.println(array.toString());
    //Add a new item
    array.add(10);
    // Show new array
    System.out.println(array.toString());
    // Sort the Array
    Collections.sort(array);
    // Show Sorted array
    System.out.println(array.toString());
  }
    
  public static void main(String[] args) {
    String[] nemo = {"nemo", "flora", "eva"};
    findNemo(nemo);
    
    Random randomInts = new Random();
    int[] arrayOfNumbers = randomInts.ints(5,0,5).toArray();
    
    findNumber(arrayOfNumbers, 8);

    //System.out.print("Function started: " + t0.toString() + " and finished at: " + t1.toString() + ". It took in total ...");
    int[] arrayOfInts = {1,2,3,4};
    sumAllPairsOfArray(arrayOfInts);

    String[] Array1 = {"a", "1", "c", "d", "e"};
    String[] Array2 = {"x", "1", "v", "t", "p"};
    
    if (findEqualEntriesOnArray(Array1, Array2)) {
      System.out.println("Same letter found!");
    }
    else {
      System.out.println("Not found!");
    }
    
    //Google Interview Example
    int[] ArrayOfNumbers = {1,2,3,4,4};
    if (hasPairsWithSums(ArrayOfNumbers, 5)) {
      System.out.println ("Pairs of Sum FOUND!");
    }
    else {
      System.out.println ("Pairs of Sum NOT FOUND!");
    } 

    // Try different Array TryArrayOperations
    ArrayList<Integer> ListOfNumbers = new ArrayList<Integer>();
    ListOfNumbers.add(1);
    ListOfNumbers.add(4);
    ListOfNumbers.add(7);
    ListOfNumbers.add(2);
    ListOfNumbers.add(3);
    TryArrayOperations(ListOfNumbers);

    // Try Object Reference, Scope, Instanciation
    ReferenceContentScope object1 = new ReferenceContentScope(10);
    ReferenceContentScope object2 = object1;
    ReferenceContentScope object3 = new ReferenceContentScope(); 
    object3.value = object1.value;
    object1.value = 15;

    // System.out.println("Outside constructor " + this); Error - cannot be used in a static context
    System.out.println(object1.value + "," + object2.value + "," + object3.value);
    System.out.println(object1==object2);

    //Class Instanciation
    Wizard player1 = new Wizard("Alexandre", "Healer");
    player1.Introduce(); player1.Play();

    ReverseString myString = new ReverseString("I L GOOGLE");

    //Merged sorted arrays
    int[] ArrayOfNumbers1 = {0,3,4,31};
    int[] ArrayOfNumbers2 = {3,4,6,30};

    MergeSortedArrays MergedSortedArrays = new MergeSortedArrays(ArrayOfNumbers1,ArrayOfNumbers2);
  
    // My own code o HashTable
    HashTable myBucket = new HashTable(10);

    myBucket.set("Grapes", 100);
    myBucket.set("Strawberry", 50);
    myBucket.set("Apples",9);

    System.out.print(myBucket.get("Apples"));
    myBucket.keys();
  
    // FirstRecurring Character using my own HashTable class
    int[] ArrayOfNumbers3 = {1,4,4,1,3,6,0,9,2};
    
    FirstRecurringCharacter lookForRecurringCharacter = new FirstRecurringCharacter(ArrayOfNumbers3);
    lookForRecurringCharacter.mapOfRecurringCharacters.keys();

    //Using Java HashMapMap
    HashMap map = new HashMap<Integer, Integer>();
    boolean recurringEntryFound = false;
    for (int i = 0; i < ArrayOfNumbers3.length; i++) {
      //System.out.println(map.get(i));
      if (map.get(ArrayOfNumbers3[i]) != null) {
        System.out.println(ArrayOfNumbers3[i]);
        recurringEntryFound = true;
        break;
      }
      else {
        System.out.println(ArrayOfNumbers3[i] + "," + i);
        map.put(ArrayOfNumbers3[i],i);  
      }
    }
    
    // Using Java HashMap
    FirstRecurrencyEntry firstRecurrencyEntry = new FirstRecurrencyEntry();

    int recurrencyEntry = firstRecurrencyEntry.findFirstRecurrencyEntry(ArrayOfNumbers3);

    if (recurrencyEntry != -1) {
      System.out.println(ArrayOfNumbers3[recurrencyEntry]);
    } else {  
      System.out.println("NO Recurring Entries found!");
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
    System.out.println("Pick items in the LinkedList");
    System.out.println(myLinkedList.myLinkedList.element());
    System.out.println(myLinkedList.myLinkedList.getFirst());
    System.out.println(myLinkedList.myLinkedList.peek());
    System.out.println(myLinkedList.myLinkedList.peekFirst());
    System.out.println(myLinkedList.myLinkedList.getLast());
  
    // DEMO LinkedList / DoubleLinkedList Class
    // demoDoubleLinkedList myDemoLinkedList = new demoDoubleLinkedList(5);
    demoLinkedList myDemoLinkedList = new demoLinkedList(5);
    myDemoLinkedList.append(10);
    myDemoLinkedList.append(16);
    myDemoLinkedList.append(20);
    myDemoLinkedList.append(30);
    myDemoLinkedList.preappend(1);
    myDemoLinkedList.preappend(0);
    myDemoLinkedList.append(40);
    myDemoLinkedList.insert(4, 8);
    System.out.println(myDemoLinkedList.remove(7).value);
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
    System.out.println(" Top of stack: " + myStack.peek());
    myStack.showStack();

    // DEMO Queue using Stack
    queueStack myQueue = new queueStack();
    myQueue.push(10);
    myQueue.push(20);
    myQueue.push(30);
    myQueue.push(40);
    myQueue.pop();
    System.out.println(myQueue.peek());

    // DEMO Stack using Array
    arrayStack myArrayStack = new arrayStack("Google");
    myArrayStack.push("BBC");
    System.out.println("Top: " + myArrayStack.peek());
    myArrayStack.push("Udemy");
    myArrayStack.showArrayStack();
    System.out.println("Removed: " + myArrayStack.pop());
    System.out.println("Top: " + myArrayStack.peek());

    // DEMO Binary Search Tree
    BinarySearchTree myBST = new BinarySearchTree();

    System.out.println(myBST.insert(9).value);
    System.out.println(myBST.insert(4).value);
    System.out.println(myBST.insert(1).value);
    System.out.println(myBST.insert(6).value);
    System.out.println(myBST.insert(20).value);
    System.out.println(myBST.insert(15).value);
    System.out.println(myBST.insert(170).value);
    System.out.println(myBST.insert(70).value);
    System.out.println(myBST.insert(181).value);
    System.out.println(myBST.insert(69).value);
    System.out.println(myBST.insert(75).value);
    System.out.println(myBST.insert(73).value);
    System.out.println(myBST.insert(81).value);
    System.out.println(myBST.insert(72).value);
    System.out.println(myBST.insert(74).value);
    System.out.println(myBST.insert(78).value);
  
    BinarySearchTree.Node nodeFound = myBST.lookup(20);
    System.out.println(" Value: " + nodeFound.value + " Left: " + nodeFound.left.value + " Right: " + nodeFound.right.value);

    //REMOVE a vertex
    BinarySearchTree.Node vertex;
    vertex = myBST.remove(9);

    if (vertex == null) {
      System.out.println("Tree is Empty or Vertex not found!");
    } else {
      System.out.println(" Vertex " + vertex.value + " deleted!");
    }

    myBST.stringfy(); // vertex 20 not being printed after vertex 9 deleted
 }  
}
