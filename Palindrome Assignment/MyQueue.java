//created a queue class using nodes

import java.util.*;

public class MyQueue<Type> {
    private Node<Type> front;
    private Node<Type> back;
    private int size;

    private static class Node<Type> {
        private Type element;
        private Node<Type> next;

        public Node(Type element) {
            this.element = element;
            this.next = null;
        }
    }

    public MyQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void enqueue(Type element) {
        Node<Type> newNode = new Node<>(element);
        if (back == null) {
            front = newNode;
            back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    public Type dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        Type element = front.element;
        front = front.next;
        if (front == null) {
            back = null;
        }
        size--;
        return element;
    }

    public Type peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.element;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}


//i have also provided the way to do it using an array list...
// class MyQueue<Type> {
//     private ArrayList<Type> queue;
//     private int frontIndex;
//     private int backIndex;
//     private int size;

//     public MyQueue() {
//         this.queue = new ArrayList<Type>();
//         this.frontIndex = 0;
//         this.backIndex = 0;
//         this.size = 0;
//     }

//     public void enqueue(Type element) {
//         queue.add(backIndex, element);
//         backIndex++;
//         size++;
//     }

//     public Type dequeue() {
//         if (queue.isEmpty()) {
//             throw new IllegalStateException("Queue is empty");
//         }
//         Type element = queue.get(frontIndex);
//         frontIndex++;
//         size--;
//         return element;
//     }

//     public Type peek() {
//         if (queue.isEmpty()) {
//             throw new IllegalStateException("Queue is empty");
//         }
//         return queue.get(frontIndex);
//     }

//     public boolean isEmpty() {
//         return queue.isEmpty();
//     }

//     public int size() {
//         return size;
//     }
// }
