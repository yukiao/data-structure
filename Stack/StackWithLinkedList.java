class StackWithLinkedList{
    /**
     * InnerStackWithLinkedList
     */
    int container;
    Node top;
    Node base;
    int size;

    public class Node {
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }


    StackWithLinkedList(){
        top = null;
        container = 10;
        size = 0;
    }

    StackWithLinkedList(int container){
        top = null;
        this.container = container;
        size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return size == container;
    }

    public void push(int data){
        if(size == 0){
            top = new Node(data);
            base = top;
            size++;
            return;
        }else if(isFull()){
            System.out.print("Stack overflow");
            System.exit(1);
        }
        Node newNode = new Node(data);
        newNode.prev = top;
        top.next = newNode;
        top = newNode;
        size++;
    }

    public void display(){
        Node current = base;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public Node pop(){
        if(size == 0){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        if(size == 1){
            Node temp = top;
            top = null;
            size--;
            return temp;
        }
        Node temp = top;
        top = top.prev;
        top.next = null;
        temp.prev = null;
        size--;
        return temp;
    }

    public static void main(String args []){
        StackWithLinkedList sLinkedList = new StackWithLinkedList();
        sLinkedList.push(1);
        sLinkedList.push(2);
        sLinkedList.push(3);
        sLinkedList.push(5);
        sLinkedList.pop();
        sLinkedList.push(4);
        sLinkedList.display();
        sLinkedList.pop();
        sLinkedList.display();
    }
}