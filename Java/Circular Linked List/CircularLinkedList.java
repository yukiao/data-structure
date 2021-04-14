class CircularLinkedList {
  Node head;
  Node tail;

  // Node Class
  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Menambahkan Node diHead
  public void insertHead(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      tail = newNode;
      return;
    }

    newNode.next = head;
    tail.next = newNode;
    head = newNode;
  }

  // Menambahkan Node diTail
  public void insertTail(int data) {
    if (head == null) {
      insertHead(data);
      return;
    }
    Node newNode = new Node(data);
    newNode.next = head;
    tail.next = newNode;
    tail = newNode;
  }

  // Menambahkan Node DiTengah
  public void insertMiddle(int position, int data) {
    if (position == 0) {
      insertHead(data);
      return;
    }
    Node current = head;
    Node newNode = new Node(data);
    for (int i = 0; i < position - 1; i++) {
      if (current.next == head) {
        throw new ArrayIndexOutOfBoundsException("Position out of bound");
      }
      current = current.next;
      newNode.next = current.next;
      current.next = newNode;
    }
  }

  // Menampilkan CircularLinkedList
  public void print() {
    Node current = head;
    // Jika CLL Kosong
    if (current == null) {
      System.out.println("Null");
      return;
    }
    // Print From Head
    if (current.next == null) {
      System.out.println(current.data + " -> " + current.data + "(Head | circle)");
      return;
    }
    while (current != null) {
      if (current == tail && current.next != null) {
        System.out.println(current.data + " -> " + current.next.data + "(Head | Circle)");
        return;
      }
      System.out.print(current.data + " -> ");
      current = current.next;
    }
  }

  // Delete Head
  public void deleteHead() {
    if (head == null) {
      return;
    }
    Node temp = head.next;
    head = temp;
    tail.next = head;
  }

  public void deleteTail() {
    if (head == null) {
      return;
    }
    if (head.next == null) {
      head = null;
      return;
    }
    Node temp = head;
    while (temp.next.next != head) {
      temp = temp.next;
    }
    tail = temp;
    tail.next = head;
  }

  // Delete Middle
  public void deleteMiddle(int position) {
    if (position == 0) {
      deleteHead();
      return;
    }
    Node previous = head;
    if (previous == null) {
      System.out.println("List Null");
      return;
    }
    for (int i = 0; i < position - 1; i++) {
      previous = previous.next;
    }
    previous.next = previous.next.next;
  }

  // max Value
  public void maksValue() {
    Node temp = head;
    int max = temp.data;
    while (temp.next != head) {
      temp = temp.next;
      max = max < temp.data ? temp.data : max;
    }
    System.out.println("Value Maximum adalah " + max);
  }

  public static void main(String[] args) {
    CircularLinkedList cLinkedList = new CircularLinkedList();
    cLinkedList.insertHead(10);
    cLinkedList.insertHead(15);
    cLinkedList.insertHead(12);
    cLinkedList.insertHead(16);
    cLinkedList.insertHead(19);
    cLinkedList.insertHead(22);
    cLinkedList.insertTail(20);
    cLinkedList.print();
    cLinkedList.deleteHead();
    System.out.println("Delete Head");
    cLinkedList.print();
    cLinkedList.maksValue();
    cLinkedList.deleteTail();
    System.out.println("Delete Tail");
    cLinkedList.print();
    cLinkedList.insertMiddle(2, 13);
    System.out.println("Insert Middle");
    cLinkedList.print();
    cLinkedList.deleteMiddle(3);
    cLinkedList.print();

  }
}