class CircularLinkedList{
    Node head;
    Node tail;

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertHead(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    public void insertTail(int data){
        if(head == null){
            insertHead(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertMiddle(int position, int data){
        if(position == 0){
            insertHead(data);
            return;
        }
        Node current = head;
        for (int i=0; i<position-1; i++){
            if(current.next == head){
                throw new ArrayIndexOutOfBoundsException("Position out of bound");
            }
            current = current.next;
        }
    }

    public void display(){
        Node current = head;

        if(current == null){
            System.out.println("Null");
            return;
        }
        if(current.next == null){
            System.out.println(current.data + " -> " + current.data+"(head)");
            return;
        }
        while(current != null ){
            if(current == tail && current.next != null){
                System.out.print(current.data + " -> " + current.next.data + "(head)");
                return;
            }
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }

    public static void main(String [] args){
        CircularLinkedList cLinkedList = new CircularLinkedList();
        cLinkedList.insertHead(10);
        cLinkedList.insertHead(9);
        cLinkedList.insertHead(8);
        cLinkedList.insertHead(7);
        cLinkedList.insertTail(11);
        cLinkedList.display();
    }
}