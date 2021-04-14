class DoubleLinkedList{
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }

    }

    public void insertHead(int newData){
        Node new_Node = new Node(newData);

        new_Node.next = head;
        new_Node.prev = null;

        if(head != null){
            head.prev = new_Node;
        }

        head = new_Node;
    }

    public void insertAfter(Node prevNode, int data) throws IllegalArgumentException{
        if(prevNode == null){
            throw new IllegalArgumentException("Prev node cannot be null");
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        if(newNode.next != null){
            newNode.next.prev = newNode;
        }
    }

    public void insertBefore(Node nextNode, int data) throws IllegalArgumentException{
        if(nextNode == null){
            throw new IllegalArgumentException("Next node cannot be null");
        }
        Node newNode = new Node(data);
        newNode.next = nextNode;
        newNode.prev = nextNode.prev;
        nextNode.prev = newNode;
        head = newNode;

        if(newNode.prev !=null){
            newNode.prev.next = newNode;
        }
    }

    public void insertTail(int data){
        Node newNode = new Node(data);
        newNode.next = null;

        Node current = head;

        if(head == null){
            newNode.prev = null;
            head = newNode;
            return;
        }

        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    public void display(){
        Node current = head;
   
        if(current == null){
            System.out.println("null");
            return;
        }
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void deleteHead() throws NullPointerException{
        if(head == null){
            throw new NullPointerException("Head is null");
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node current = head;
        current.next.prev = null;
        head = current.next;
    }

    public void deleteMiddle(int position){
        if(head == null){
            throw new NullPointerException("Head is null");
        }
        if(position == 0){
            deleteHead();
            return;
        }
        
        Node current = head;

        for(int i=0; i<position-1; i++){
            if(current.next.next == null){
                throw new ArrayIndexOutOfBoundsException("Target is not exist");
            }
            current = current.next;
        }

        current.next = current.next.next;
        current.next.next.prev = current;
    }

    public void deleteTail() throws NullPointerException{
        if(head == null){
            throw new NullPointerException("Head is null");
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node current = head;

        while(current.next.next != null){
            current = current.next;
        }

        current.next = null;
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        try{
            dll.insertTail(2);
            dll.insertHead(0);
            dll.insertAfter(dll.head, 1);
            dll.insertTail(3);
            dll.insertTail(4);
            dll.insertTail(5);
            dll.deleteMiddle(3);
            dll.deleteMiddle(2);
            dll.display();
            
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }catch(NullPointerException npe) {
            System.out.println(npe.getMessage());
        }catch(ArrayIndexOutOfBoundsException aiob){
            System.out.println(aiob.getMessage());
        }
    }
}