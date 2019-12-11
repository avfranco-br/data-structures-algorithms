package avfranco_br;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// Can the string become very large?
// Or is there any limit size?
// The input will be always a String?
// Should the solution return the reversed String 
// or just print out?
// Should I reverse only or any other change is expected?
// String is basically an linear list, Array
// Is there any priority in terms of Time or Space Complexity?
// String   - I L GOOGLE
//            0123456789
// Reversed - ELGOOG L I
// OPTION 1 
  // STEP.1 - Create a new String
  // STEP.2 - Use a FOR to traverse from end to begin
  // STEP.3 - Copy to new String
  // STEP.4 - Return Reversed String
  // Space Complexity O(1)
  // Time Complexity O(N)

// OPTION 2
  // STEP 1 - Copy then input String to StringBuffer
  // STEP 2 - Use the method Reverse

public class ReverseString {

  // OPTION 1
  // Loop to traverse the String backwords
  /* public ReverseString (String sContent) {
    String strReversedString = "";
    for (int i=sContent.length(); i > 0; i--) {
      strReversedString += sContent.charAt(i-1);
    }
    System.out.print(strReversedString);
  } */


// OPTION 2
  public ReverseString (String sContent) {
    // Cleaner, readable, O(1)
    StringBuffer strReversedString = new StringBuffer(sContent);
    System.out.print(strReversedString.reverse());
  }
}
