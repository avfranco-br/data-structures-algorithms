package avfranco_br;

public class demoLinkedList {
  private class nodeLinkedList {
    int value;
    nodeLinkedList next;
  }

  private nodeLinkedList head;
  private nodeLinkedList tail;
  //private nodeLinkedList nodeItems;
  //private nodeLinkedList newNodes;
  private int size=0;

  public demoLinkedList(int value) {
    this.head = new nodeLinkedList();
    this.head.value = value;
    this.head.next = null;
    this.tail = this.head;
    this.size = 1;
  }

  public void append(int value) {
    // 10 (Head & Tail)
    // 10 (Head) --> 5 (Tail)
    // 10 (Head) --> 5 (Node) --> 16 (Tail)
    // 10 (Head) --> 5 (Node) --> 16 (Node) --> 20 (Tail)
    // 10 (Head) --> 5 (Node) --> 16 (Node) --> 20 (Tail) newnode
    // 10 (Head) --> 5 (Node) --> 16 (Node) --> newnode(20) --> Tail=30,null

    /*
    if (this.head == this.tail) {
      this.tail = new nodeLinkedList();
      this.tail.next = null;
      this.tail.value = value;
      this.head.next = this.tail;
      this.size++;
    } else {     
      this.newNodes = new nodeLinkedList();
      this.newNodes.value = value;
      this.newNodes.next = null;
      this.tail.next = this.newNodes;
      this.tail = this.newNodes;
      this.size++;
    }*/

    nodeLinkedList newNodes = new nodeLinkedList();
    newNodes.value = value;
    newNodes.next = null;
    this.tail.next = newNodes;
    this.tail = newNodes;
    this.size++;
  }

  public void preappend(int value) {
    nodeLinkedList newNodes = new nodeLinkedList();

    newNodes.value = value;
    newNodes.next = this.head;
    this.head = newNodes;
    this.size++;

  }

  private nodeLinkedList traverseToIndex(int index) {
    nodeLinkedList pointerLinkedList;
    pointerLinkedList = head;
    for (int i=1; i < index; i++) {
      pointerLinkedList = pointerLinkedList.next;
    }
    return pointerLinkedList;
  }

// 10 (Head) --> 5 (Node) --> 16 (Node) --> 20 (Node) --> Tail=30,null
// 10 (Head) --> 5 (Node) 15 (NewNode) 16 (Node) --> ....
  public void insert(int index, int value) {
    // Pointer to the previous Item 
    nodeLinkedList pointerLinkedList;
    //Newnode to be inserted
    nodeLinkedList newNodes = new nodeLinkedList();
    // Assign its value
    newNodes.value = value;
    // Traverse the linked list up to index - 1
    // Readable tip --> Create a new method to return the pointer to index-1
    // pointerLinkedList = head;
    // for (int i=0; i < index-1; i++) {
    //  pointerLinkedList = pointerLinkedList.next;
    //}
    pointerLinkedList = traverseToIndex(index-1);

    // Assign newnode to current pointer at index 2
    newNodes.next = pointerLinkedList.next;
    pointerLinkedList.next = newNodes;
    this.size++;
  }

  public void remove(int index) {
    nodeLinkedList pointerLinkedList;

    pointerLinkedList = traverseToIndex(index-1);

    //Remove next object
    pointerLinkedList.next = pointerLinkedList.next.next;
    this.size--;
  }
  
  // 0 > 1 > 5 > 10 > 16 > 20  > 30 > 40
  // head = 0
  // first = 0
  // second = 1
  // temp = 5
  // second.next = first 1 > 0
  // first.next = temp.next 0 > 10
  // temp.next = head.next 5 > 1
  // first = temp
  // 5 > 1 > 0 > 10 > 16 > 20 > 30 > 30
  // second = first.next
  // temp = second.next
  public void reverse() {
    /* Create a new list
    demoLinkedList reverseList = new demoLinkedList(this.head.value);
    nodeLinkedList nodes = this.head.next;
  
    while (nodes != null) {
      reverseList.preappend(nodes.value);
      nodes = nodes.next;
    }
    
    reverseList.showDemoLinkList(); */

    // Reverse existent list
    nodeLinkedList first = this.head;
    this.tail = this.head;
    nodeLinkedList second = this.head.next;

    while (second != null) {
      nodeLinkedList temp = second.next;
      second.next = first;
      first = second;
      second = temp;
    }
    this.head.next = null;
    this.head = first;

    showDemoLinkList();
  }

  // Traverse forward the Linked List and print each pointer
  public void showDemoLinkList() {
    nodeLinkedList nodeItems;

    System.out.println(" Head: " + this.head.value);
    nodeItems = this.head.next;
    while (nodeItems != this.tail && nodeItems != null) {
      System.out.println(" Nodes: " + 
      nodeItems.value);
      nodeItems = nodeItems.next;   
    }
    System.out.println(" Tail: " + this.tail.value);
    System.out.println(" Linked List size: " + this.size);
  }
}
