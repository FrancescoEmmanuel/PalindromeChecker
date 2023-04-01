
import java.util.*;
//created a stack class using nodes 
public class MyStack<Type> {
    private Node<Type> top;
    private int size;

    private static class Node<Type> {
        private Type element;
        private Node<Type> next;

        private Node(Type element) {
            this.element = element;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Type element) {
        Node<Type> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Type peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.element;
    }

    public Type pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Type element = top.element;
        top = top.next;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}

//i have also provided the way to do it using an array list...
// class MyStack<Type> {
//     ArrayList<Type> stack;
//     int topObject;
//     int size;

//     public MyStack() {
//         topObject = -1;
//         this.stack = new ArrayList<Type>();
//         size = 0;
        
//     }

//     public void push(Type element) {
//         topObject++;
//         stack.add(topObject, element);
//         size++;
//     }

//     public Type peek() {
//         if (stack.isEmpty()) {
//             throw new IllegalStateException("Stack is empty");
//         }
//         else{
//             return stack.get(topObject);
//         }
//     }

//     public Type pop() {
//         if (stack.isEmpty()) {
//             throw new IllegalStateException("Stack is empty");
//         }
//         else{
//             Type element = stack.get(topObject);
//             stack.remove(topObject);
//             topObject--;
//             size--;
//             return element;
//         }
//     }

//     public boolean isEmpty() {
//         return stack.isEmpty();
//     }

//     public int size() {
//         return size;
//     }
// }


