public class LinkedList {
    Node head;
    static class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
            next = null;
        }
    }

    public void insertHead (int value){
        if(head != null){
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        } else {
            head = new Node(value);
        }
    }

    public void insertTail(int value){
        Node tail = new Node(value);
        if(head == null){
            head = tail;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = tail;
    }

    public void insertMiddle(int data, int position){
        if (position == 0){
            insertHead(data);
            return;
        }
        Node current = head;
        for(int i =0; i<position-1; i++){
            if(current == null){
                System.out.println("Target position is not exist");
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteMiddle(int position){
        if(position == 0){
            deleteHead();
        }
        Node current = head;

        for(int i = 0; i < position -1; i++){
            if(current == null){
                System.out.println("Target position is not exist");
                return;
            }
            current = current.next;
        }
        if(current.next == null){
            System.out.println("Target postion is not exist");
            return;
        }
        current.next = current.next.next;
    }

    public void printNode(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public void deleteHead(){
        if(head == null){
            return;
        }
        head = head.next;
    }
    public void deleteLast(){
        if(head == null){
            return;
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
    public static void main (String [] args) {
        LinkedList sLinkedList = new LinkedList();
        sLinkedList.insertHead(5);
        sLinkedList.insertHead(4);
        sLinkedList.insertHead(3);
        sLinkedList.insertTail(6);
        sLinkedList.insertMiddle(3, 3);
        sLinkedList.deleteMiddle(3);
        sLinkedList.printNode();
    }
}