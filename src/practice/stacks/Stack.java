package practice.stacks;

public class Stack {

    private static final int CAPACITY = 100;
    int[] array = new int[CAPACITY];

    int top;

    public Stack(){
        top = -1;
    }

    public boolean push(int data){

        if(top >= CAPACITY -1) {
            return false;
        }else{
            array[++top] = data;
            return true;
        }
    }

    public int pop(){

        if(top < 0){

            return 0;
        }else {
            int x = array[top--];
            return x;
        }

    }


    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop() + " Popped from stack");

    }
}
