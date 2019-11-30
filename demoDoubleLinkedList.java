public class demoDoubleLinkedList {
  public class Node {
    int value;
    Node previous;
    Node next;
  }
  private Node head;
  private Node tail;
  private int size=0;

public demoDoubleLinkedList (int value) {
  this.head = createNode(value);
  this.tail = this.head;
  }
  
 public boolean isEmpty() {
   if (this.size == 0) return true;
   
   return false;
  
 }

 private Node createNode(int value) {
    Node newNode = new Node();
    newNode.previous = null;
    newNode.next = null;
    newNode.value = value;
    this.size++;
    return newNode;
  }

  public void append(int value) {
    Node newNode = createNode(value);
    newNode.previous = this.tail;
    newNode.next = null;
    this.tail.next = newNode;
    this.tail = newNode;
  }

  public void preappend(int value) {
    Node newNode = createNode(value);

    newNode.next = this.head;
    this.head.previous = newNode;
    this.head = newNode;
  }

  public void insert (int position, int value) {
    //Node newNode = createNode(value); increase size before finding right pointer
    
    Node leader = traverseDoubleLinkedList(position-1);
    Node newNode = createNode(value);
    
    newNode.previous = leader.previous;
    leader.previous.next = newNode;
    newNode.next = leader;
    leader.previous = newNode;
  }
  
  public Node remove(int index) {
    Node deleted;
    
    if (index == 1) {
      deleted = this.head;
      this.head = this.head.next;
      this.head.previous = null;
    } else if (index == this.size) {
      deleted = this.tail;
      this.tail = this.tail.previous;
      this.tail.next = null;
    } else {
      deleted = traverseDoubleLinkedList(index-1);
      deleted.previous.next = deleted.next;
      deleted.next.previous = deleted.previous;
    }
    this.size--;
    return deleted;
  }

  private Node traverseForward(int index) {
    Node leader = this.head;

    for (int i=0; i < index; i++) {
      leader = leader.next;
    }

    return leader;
  }

  private Node traverseBackwards(int index) {
    Node leader = this.tail;
    
    index = this.size - index - 1;
    //System.out.println(index); amount of backward steps


    for (int i=0; i < index; i++) {
      leader = leader.previous;
    }

    return leader;
  }
  
  // 0 (0) <> 1 (1) <> 5 (2) <> 10 (3) <> 16 (4) <> 20 (5) <> 30 (6) <> 40 (7)
  // 8 nodes
  private Node traverseDoubleLinkedList(int index) {  
    Node leader;

    if (this.size / 2 > index) {
      leader = traverseForward(index);
    } else {
      leader = traverseBackwards(index);
    }

    return leader;
  }



  public void printDoubleLinkedList() {
    Node pointer = this.tail;
    while (pointer != null) {
      System.out.println(" Node: " + pointer.value);
      pointer = pointer.previous;
    }
  }

}