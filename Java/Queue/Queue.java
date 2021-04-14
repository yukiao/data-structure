class Queue {
    int size;
    int [] container;

    Queue(){
        this.size = 0;
        this.container = new int[10];
    }
    Queue(int capacity){
        this.size = 0;
        this.container = new int[capacity];
    }

    void enqueue(int data){
        if(size == container.length){
            System.out.println("Queue is overflow");
            System.exit(1);
        }
        container[size] = data;
        size++;
    }

    int dequeue(){
        int [] newContainer = new int[container.length];
        int item = container[0];

        for (int i = 1; i< size; i++){
            newContainer[i-1] = container[i];
        }
        container = newContainer;
        size--;
        return item;
    }

    void printElements(){
        for (int i=0; i<size -1; i++){
            System.out.print(container[i]);
            System.out.print("<-");
        }

        System.out.println(container[size-1]);
    }

    public int peek(){
        return container[0];
    }

    public static void main(String args []){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.printElements();

    }
}