package datastructures.stack;

/**
 * Created by paulberesuita on 9/7/15.
 */
public class QueueLinkedList {

    Node first, last;

    public void enqueue(Object item) {

        if(first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public Object dequeue() {

        if(first != null) {
            Object item = first.data;
            first = first.next;

            if (first == null) {
                last = null;
            }
            return item;
        }

        return null;

    }

    private class Node {

        Node next;
        Object data;

        //Creating new node and pointing nowhere
        public Node(Object _data) {
            next = null;
            data = _data;
        }

        //Creating new node and point to another node
        public Node(Object _data, Node _next) {
            next = _next;
            data = _data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object _data) {
            data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }
    }
}
