import java.util.LinkedList;

public class LinkedListCustom {
  // MyLinkedList
  public LinkedList<Integer> myLinkedList;    
  
  // Construct an empty linked list
  public LinkedListCustom() {
    myLinkedList = new LinkedList();
  }

  // Add a new item at Head, Tail, 
  public void addItemLinkedList(Integer value, int position) {
    if (position == 0) {
      myLinkedList.addFirst(value);
     } else {
       myLinkedList.addLast(value);
     }
  }

  public void getItemLinkedList() {
      //System.out.println(myLinkedList.size());
  }

  public void printLinkedList() {
    for (Integer item : myLinkedList) {
      System.out.println(item);
    }
  }
}