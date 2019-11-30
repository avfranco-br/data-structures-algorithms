public class demoStack {
  private class Node {
    int value;
    Node next;
  }

  Node top;
  Node bottom;
  int lenght = 0;

  public demoStack() {
    this.top=null;
    this.bottom=null;
    this.lenght=0;
  }

  private Node createNode(int value) {
    Node newNode = new Node();
    newNode.value = value;
    newNode.next = null;

    this.lenght++;

    return newNode;
  }

  public void pop() {
    
    if (this.bottom == this.top) {
      this.bottom=null;
    } 
    else {
      //Node leader = this.bottom;
      //for (int i=1; i < this.lenght-1; i++) {
      //  leader = leader.next;
      //}
      //this.top = leader;
      //this.top.next = null;
    }
    this.top = this.top.next;
    this.lenght--;
  }

  public void push(int value) {
    Node newNode = createNode(value); 
    
    if (this.bottom == null) { 
      this.bottom = newNode; 
      this.top = bottom;
    } else {
      Node holdingPointer = this.top;
      this.top = newNode;
      this.top.next = holdingPointer;
    }
  }

  public int peek() {
    return (this.lenght==0) ? 0 : top.value;
  }

  public int size() {
    return this.lenght;
  }

  public void showStack() {
    Node nodeItems;
    nodeItems = this.top;
    while (nodeItems != null) {
      System.out.println(" Nodes: " + 
      nodeItems.value);
      nodeItems = nodeItems.next;   
    }
    System.out.println(" Stack List size: " + this.lenght);
  }
}