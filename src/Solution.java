import java.util.LinkedList;

public class Solution {

    private static class Node {
        public int data;
        public Node link;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Queue {
        public Node head;
        public Node tail;
    }

    public Solution() {

    }

    public static void enQueue(Queue q, int data) {
        Node temp = new Node(data);
        if (q.head == null) {
            q.head = temp;

        } else {
            q.tail.link = temp;

        }
        q.tail = temp;
        q.tail.link = q.head;


    }

    public static Node deQueue(Queue q) {
        if (q.head == null) {
            return null;
        }
        Node temp = q.head;
        q.head = q.head.link;
        q.tail.link = q.head;
        if (q.head.link == null) {
            q.tail = null;
        }
        return temp;
    }

    public static void displayQueue(Queue q) {
        Node temp = q.head;
        System.out.printf(" Elements in Circular Queue are: ");
        while (temp.link != q.head) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }

    public static void main(String args[]) {
        // Create a queue and initialize front and rear
        Queue q = new Queue();
        q.head = q.tail = null;

        // Inserting elements in Circular Queue
        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);

        // Display elements present in Circular Queue
        displayQueue(q);

        // Deleting elements from Circular Queue
        System.out.printf(" Deleted value = %d", deQueue(q).data);
        System.out.printf(" Deleted value = %d", deQueue(q).data);

        // Remaining elements in Circular Queue
        displayQueue(q);

        enQueue(q, 9);
        enQueue(q, 20);
        displayQueue(q);

    }
}

