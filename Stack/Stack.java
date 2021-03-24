import java.util.EmptyStackException;

class Stack{
    //Stack using array
    int length;
    int [] data;
    int top = -1;

    public Stack(){
        length = 10;
        data = new int [length];
    }

    public Stack(int length){
        this.length = length;
        data = new int [length];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == length-1;
    }

    public void push(int data){
        if(isFull()) throw new StackOverflowError("Stack overflow");
        top = top+1;
        this.data[top] = data;
    }

    public int pop(){
        if(isEmpty()) throw new EmptyStackException();
        int pop_data = data[top];
        top -= 1;
        return pop_data;
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return data[top];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i=0; i<=top;i++){
            System.out.print(data[i] + " ");
        }
    }

    public static void main(String [] args){
        Stack stack = new Stack();
        try{
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.pop();
            stack.display();
        }catch(EmptyStackException ese){
            System.out.println(ese.getMessage());
        }catch(StackOverflowError soe){
            System.out.println(soe.getMessage());
        }
    }
}