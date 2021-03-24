public class QueueWithLinkedList {
    Node front;
    Node rear;
    int size;
    int container;

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
        }
    }
    QueueWithLinkedList(){
        this.container = 10;
        this.size = 0;
    }

    QueueWithLinkedList(int container){
        this.container = container;
        this.size = 0;
    }

    boolean isEmpty(){
        return size == 0;
    }

    boolean isFull(){
        return size == container;
    }

    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is overflow");
            System.exit(1);
        }
        Node newNode = new Node(data);

        if(front == null){
            front = newNode;
            rear = newNode;
            size++;
            return;
        }

        if(front == rear){
            newNode.prev = front;
            front.next = newNode;
            rear = newNode;
            size++;
            return;
        }

        newNode.prev = rear;
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    Node dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        Node temp = front;
        
        if(temp.next == null){
            front = null;
            rear = null;
            size --;
            return temp;
        }
        front = front.next;
        front.prev = null;
        size--;

        return temp;
    }

    Node peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            System.exit(1);
        }

        return front;
    }

    void display(){
        if(isEmpty()){
            System.out.println("null");
            return;
        }

        Node current = front;

        while(true){
            System.out.print(current.data + " ");
            if(current == rear){
                return;
            }
            current = current.next;
        }
    }

    public static void main(String [] args){
        QueueWithLinkedList qList = new QueueWithLinkedList();
        qList.enqueue(1);
        qList.enqueue(2);
        qList.enqueue(3);
        qList.enqueue(4);
        qList.enqueue(5);
        qList.enqueue(6);
        qList.enqueue(7);
        qList.enqueue(8);
        qList.enqueue(9);
        qList.enqueue(10);
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.dequeue();
        qList.display();
    }
}
