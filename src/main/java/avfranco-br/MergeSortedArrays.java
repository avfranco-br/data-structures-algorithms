package avfranco_br;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class MergeSortedArrays {
  // Array1 [0,3,4,7,31] Array2[4,6,30]
  // Result [0,3,4,4,6,7,30,31]

  // Are the Input always collection of numbers?
  // Are they always sorted?
  // What about size, is there any limit or they can become very large?
  // In case of the output, should be the merged array and also sorted?
  // In case of the solution, any preference for time or memory efficience?

  //OPTION 1
    // STEP.1 - Create a new Array1
    // STEP.2 - Nested loop
      // Comparing the position+1 of last merged item of Array1 with the position+1 of the last merged item of Array2
      // When items are equal both are added into the merged array
    // It works but not time efficient (O^2)
    // Not readable

  //OPTION 2
    // Copy both arrays to a List
    // Sort the List using Collections
  
  public MergeSortedArrays(int[] ArrayOfNumbers1, int[] ArrayOfNumbers2) {
      // Array1 [0,3,4,31] Array2[4,6,30]
      // Result [0,3,4,4,6,30,31]

      // OPTION 1 - Copy both arrays to a new ArrayList using LOOP - O(N+N)
      //ArrayList <Integer> MergedArrayList = new ArrayList<Integer>();
      //for (int number : ArrayOfNumbers1) {
      //  MergedArrayList.add(number);
      //}
      //for (int number : ArrayOfNumbers2) {
       // MergedArrayList.add(number);
      //}      
      
      // OPTION 2 - Merge Copy Arrays to a list - O(N+N), Readable
      /*
      List<Integer> MergedArrayList = Arrays.stream(ArrayOfNumbers1) //convert Array to a sequnce of stream
                                        .boxed() // Box each element of th stream to an Integer
                                        .collect(Collectors.toList()); // Accumulate the input elements into a new list

      MergedArrayList.addAll(Arrays.stream(ArrayOfNumbers2)
                                   .boxed()
                                   .collect(Collectors.toList()));;
      Collections.sort(MergedArrayList);
      */

      //OPTION 1 - Compare items on both arrays and add to the merged sorted array
      // Array1 [0,3,4,31] Array2[3,4,6,30]
      int indArray1 = 0;
      int indArray2 = 0;
      Integer itemArray1 = ArrayOfNumbers1[0];
      Integer itemArray2 = ArrayOfNumbers2[0];
      ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

      while (itemArray1 != null || itemArray2 != null) {  
        if (itemArray2==null || itemArray1 < itemArray2) {
          mergedSortedArray.add(itemArray1);
          indArray1++;
          try {
            itemArray1 = ArrayOfNumbers1[indArray1];
          }
          catch (ArrayIndexOutOfBoundsException e) {
            itemArray1 = null;
          }
        } else {
          mergedSortedArray.add(itemArray2);
          indArray2++;
          try {
           itemArray2 = ArrayOfNumbers2[indArray2]; 
          }
          catch (ArrayIndexOutOfBoundsException e) {
            itemArray2 = null;
          }    
        }
        System.out.println(itemArray1 + "," + itemArray2);
      }
      System.out.print(mergedSortedArray);
  }
}
